package je.backit.control;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import static java.util.Collections.emptyList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import javax.inject.Inject;
import je.backit.entity.Campaign;
import je.backit.jooq.JooqProvider;
import static je.backit.jooq.Tables.CAMPAIGN;
import static je.backit.jooq.Tables.CAMPAIGN_TAG;
import static je.backit.jooq.Tables.CATEGORY;
import static je.backit.jooq.Tables.FUNDING;
import je.backit.jooq.tables.records.CampaignRecord;
import je.backit.jooq.tables.records.CampaignTagRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.exception.DataAccessException;
import static org.jooq.impl.DSL.sum;
import static org.jooq.impl.DSL.trueCondition;

public class CampaignDAO extends AbstractDAO<CampaignRecord, Campaign, Integer> {

  @Inject JooqProvider jooq;

  public Integer getNumberOfView(Integer campaignId) {
    return jooq.sql().selectCount().from(FUNDING).where(FUNDING.CAMPAIGN_ID.eq(campaignId)).fetchOne(0, int.class);
  }

  public Integer getNumberOfDonors(Integer campaignId) {
    DSLContext sql = jooq.sql();
    return sql.selectCount().from(
            sql.selectDistinct(FUNDING.DONOR_ID).from(FUNDING).where(FUNDING.CAMPAIGN_ID.eq(campaignId))
    ).fetchOne(0, int.class);
  }

  public BigDecimal getAmountFunded(Integer campaignId) {
    return jooq.sql().select(sum(FUNDING.FUNDING_AMOUNT)).from(FUNDING).where(FUNDING.CAMPAIGN_ID.eq(campaignId)).fetchOne(0, BigDecimal.class);
  }

  public BigDecimal getTargetFunding(Integer campaignId) {
    return jooq.sql().select(CAMPAIGN.TARGET_FUNDING).from(CAMPAIGN).where(CAMPAIGN.ID.eq(campaignId)).fetchOne(0, BigDecimal.class);
  }

  public Double getPercentFunded(Integer campaignId) {
    return getAmountFunded(campaignId).divide(getTargetFunding(campaignId)).doubleValue();
  }

  @Override
  public void insert(Campaign c) {
    DSLContext sql = jooq.sql();
    CampaignRecord r = mapToRecord(c);
    insertInto(sql, CAMPAIGN, r);

    List<String> tags = c.getCategories();
    if (tags.isEmpty()) return;

    Map<String, Integer> allTags = sql.select(CATEGORY.CATEGORY_, CATEGORY.ID).from(CATEGORY).fetchMap(CATEGORY.CATEGORY_, CATEGORY.ID);

    for (String tag : tags) {
      CampaignTagRecord t = new CampaignTagRecord(r.getId(), allTags.get(tag));
      t.attach(sql.configuration());
      t.insert();
    }
  }

  @Override
  public Campaign findById(Integer campaignId) {
    DSLContext sql = jooq.sql();

    Optional<Campaign> campaign = getCampaignsById(sql, campaignId).stream()
            .map(CampaignDAO::mapFromRecord).findAny();
    if (!campaign.isPresent()) return null;

    List<String> tags = sql
            .select(CATEGORY.CATEGORY_)
            .from(CAMPAIGN_TAG).join(CATEGORY)
            .on(CATEGORY.ID.eq(CAMPAIGN_TAG.CATEGORY_ID))
            .where(CAMPAIGN_TAG.CAMPAIGN_ID.eq(campaignId))
            .fetch(CATEGORY.CATEGORY_);

    campaign.get().setCategories(tags);

    return campaign.get();
  }

  @Override
  public List<Campaign> findAll() throws DataAccessException {
    DSLContext sql = jooq.sql();
    List<Campaign> campaigns = getCampaignsById(sql).stream()
            .map(CampaignDAO::mapFromRecord).collect(toList());

    Map<Integer, List<String>> tagsPerCampaign = sql
            .select(CAMPAIGN_TAG.CAMPAIGN_ID, CATEGORY.CATEGORY_)
            .from(CAMPAIGN_TAG).join(CATEGORY)
            .on(CATEGORY.ID.eq(CAMPAIGN_TAG.CATEGORY_ID))
            .fetchGroups(CAMPAIGN_TAG.CAMPAIGN_ID, CATEGORY.CATEGORY_);

    for (Campaign c : campaigns) {
      List<String> categories = tagsPerCampaign.getOrDefault(c.getId(),
              emptyList());
      c.setCategories(categories);
    }

    return campaigns;
  }

  private Result<? extends Record> getCampaignsById(DSLContext sql, Integer... ids) {
    Condition c = (ids.length == 0 ? trueCondition() : CAMPAIGN.ID.in(ids));
    return sql.select(CAMPAIGN.ID, CAMPAIGN.CREATION_DATE, CAMPAIGN.EXPIRATION_DATE,
            CAMPAIGN.HASHTAG, CAMPAIGN.IMAGEURI, CAMPAIGN.SUMMARY,
            CAMPAIGN.TARGET_FUNDING, CAMPAIGN.TITLE, CAMPAIGN.VIDEOURI,
            CAMPAIGN.HTML)
            .from(CAMPAIGN)
            .where(c)
            .fetch();
  }

  private static Campaign mapFromRecord(Record r) {
    Campaign c = new Campaign();
    c.setId(r.getValue(CAMPAIGN.ID));
    c.setStartDate(ZonedDateTime.ofInstant(r.getValue(CAMPAIGN.CREATION_DATE)
            .toInstant(), ZoneOffset.UTC));
    c.setEndDate(ZonedDateTime.ofInstant(r.getValue(CAMPAIGN.EXPIRATION_DATE)
            .toInstant(), ZoneOffset.UTC));
    c.setHashtag(r.getValue(CAMPAIGN.HASHTAG));
    c.setImageURI(r.getValue(CAMPAIGN.IMAGEURI));
    c.setSummary(r.getValue(CAMPAIGN.SUMMARY));
    c.setTargetFunding(r.getValue(CAMPAIGN.TARGET_FUNDING));
    c.setTitle(r.getValue(CAMPAIGN.TITLE));
    c.setVideoURI(r.getValue(CAMPAIGN.VIDEOURI));
    c.setDescription(r.getValue(CAMPAIGN.HTML));
    return c;
  }

  private static CampaignRecord mapToRecord(Campaign c) {
    CampaignRecord r = new CampaignRecord()
            .setCreationDate(new Timestamp(c.getStartDate().toInstant().toEpochMilli()))
            .setExpirationDate(new Timestamp(c.getEndDate().toInstant().toEpochMilli()))
            .setHashtag(c.getHashtag())
            .setHtml(c.getDescription())
            .setId(c.getId())
            .setImageuri(c.getImageURI())
            .setSummary(c.getSummary())
            .setTargetFunding(c.getTargetFunding())
            .setVideouri(c.getVideoURI());
    return r;
  }

}
