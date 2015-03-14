package je.backit.control;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;

import je.backit.entity.Campaign;
import je.backit.jooq.JooqProvider;
import je.backit.jooq.tables.records.CampaignRecord;

import org.jooq.Record;
import org.jooq.Record10;
import org.jooq.Result;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static je.backit.jooq.Tables.CAMPAIGN;
import static je.backit.jooq.Tables.CAMPAIGN_TAG;
import static je.backit.jooq.Tables.CATEGORY;

public class CampaignDAO extends AbstractDAO<CampaignRecord, Campaign> {

  @Inject
  JooqProvider jooq;

  @Override
  public List<Campaign> findAll() throws DataAccessException {
    DSLContext sql = jooq.sql();
    Result<Record10<Integer, Timestamp, Timestamp, String, String, String, BigDecimal, String, String, String>> result = sql
        .select(CAMPAIGN.ID, CAMPAIGN.CREATION_DATE, CAMPAIGN.EXPIRATION_DATE,
            CAMPAIGN.HASHTAG, CAMPAIGN.IMAGEURI, CAMPAIGN.SUMMARY,
            CAMPAIGN.TARGET_FUNDING, CAMPAIGN.TITLE, CAMPAIGN.VIDEOURI,
            CAMPAIGN.HTML).from(CAMPAIGN).fetch();

    List<Campaign> campaigns = result.stream()
        .map(CampaignDAO::mapRecordToCampaign).collect(toList());

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

  private static Campaign mapRecordToCampaign(Record r) {
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

}
