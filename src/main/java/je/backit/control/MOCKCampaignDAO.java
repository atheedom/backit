package je.backit.control;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import je.backit.entity.Campaign;
import je.backit.jooq.JooqProvider;
import static je.backit.jooq.Tables.CAMPAIGN;
import je.backit.jooq.tables.records.CampaignRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.exception.DataAccessException;
import static org.jooq.impl.DSL.trueCondition;

public class MOCKCampaignDAO extends AbstractDAO<CampaignRecord, Campaign, Integer> {

  @Inject
  JooqProvider jooq;

  public Integer getNumberOfView(Integer campaignId) {
    return 10;
  }

  public Integer getNumberOfDonors(Integer campaignId) {
    return 300;
  }

  public BigDecimal getAmountFunded(Integer campaignId) {
    return new BigDecimal(3000);
  }

  public BigDecimal getTargetFunding(Integer campaignId) {
    return new BigDecimal(30000);
  }

  public Double getPercentFunded(Integer campaignId) {
    return 30d;
  }

  @Override
  public Campaign findById(Integer campaignId) {


    Campaign campaign = new Campaign();
    List<String> cats = new ArrayList();
    cats.add("Sports");
    cats.add("Arts");
    campaign.setCategories(cats);
    campaign.setDescription("Arts project for poor kids who cant paint");
    campaign.setEndDate(ZonedDateTime.now());
    campaign.setHashtag("#arts");
    campaign.setImageURI("arts.jpg");
    campaign.setStartDate(ZonedDateTime.now());
    campaign.setSummary("Arts for poor kids");
    campaign.setTargetFunding(new BigDecimal(2000));
    campaign.setTitle("Poor Kid Art");
    campaign.setType("FUND FOR SHARE");
    campaign.setVideoURI("");
    campaign.setId(campaignId);


    return campaign;


  }

  @Override
  public List<Campaign> findAll() throws DataAccessException {


    List<Campaign> cams = new ArrayList();
    cams.add(findById(1));
    cams.add(findById(2));
    cams.add(findById(3));
    cams.add(findById(4));

    return cams;


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
