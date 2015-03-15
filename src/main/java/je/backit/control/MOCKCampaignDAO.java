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
import je.backit.jooq.tables.records.RewardRecord;

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
    return new BigDecimal(160);
  }

  public BigDecimal getTargetFunding(Integer campaignId) {
    return new BigDecimal(30000);
  }

  public Integer getPercentFunded(Integer campaignId) {
    return 225;
  }

  @Override
  public Campaign findById(Integer campaignId) {


    Campaign campaign = new Campaign();
    List<String> cats = new ArrayList<> ();
    cats.add("Sports");
    cats.add("Arts");
    campaign.setCategories(cats);
    campaign.setDescription("Arts for poor kids who cant and wont paint regardless of the times we sent them to the naughty step. I blame the parents.");
    campaign.setEndDate(ZonedDateTime.now().plusHours(6));
    campaign.setHashtag("#arts");
    campaign.setImageURI("300x300.jpg");
    campaign.setStartDate(ZonedDateTime.now());
    campaign.setSummary("Arts for poor kids who cant and wont paint regardless of the times we sent them to the naughty step. I blame the parents.");
    campaign.setTargetFunding(new BigDecimal(2000));
    campaign.setTitle("Poor Kid Art");
    campaign.setType("FUND FOR SHARE");
    campaign.setVideoURI("");
    campaign.setId(campaignId);
    
    List<RewardRecord> rewards = new ArrayList<>();
    RewardRecord reward = new RewardRecord();
    reward.setId(1);
    reward.setTitle("T-shirt");
    reward.setDescription("If you gives us cash we will give you a T-shirt");
    reward.setValue(new BigDecimal(20));
    reward.setTotalNumber(1);
    rewards.add(reward);
    
    reward.setId(2);
    reward.setTitle("Cowboy Hat");
    reward.setDescription("If you pledge we will send you a wonderful cowboy hat.");
    reward.setValue(new BigDecimal(50));
    rewards.add(reward);

    reward.setId(3);
    reward.setTitle("Spa Weekend");
    reward.setDescription("If you dish the dosh we will treat you to a spa weekend.");
    reward.setValue(new BigDecimal(150));
    rewards.add(reward);

    campaign.setRewards(rewards);

    return campaign;


  }

  @Override
  public List<Campaign> findAll() throws DataAccessException {


    List<Campaign> cams = new ArrayList<> ();
    cams.add(findById(1));
    
    Campaign campaign = new Campaign();
    List<String> cats = new ArrayList<> ();
    cats.add("Sports");
    cats.add("Arts");
    campaign.setId(2);
    campaign.setCategories(cats);
    campaign.setDescription("Arts for poor kids who cant and wont paint regardless of the times we sent them to the naughty step. I blame the parents.");
    campaign.setEndDate(ZonedDateTime.now().plusDays(7));
    campaign.setHashtag("#arts");
    campaign.setImageURI("300x300.jpg");
    campaign.setStartDate(ZonedDateTime.now().minusDays(20));
    campaign.setSummary("Arts for poor kids who cant and wont paint regardless of the times we sent them to the naughty step. I blame the parents.");
    campaign.setTargetFunding(new BigDecimal(12000));
    campaign.setTitle("Poor Kid Art");
    campaign.setType("FUND FOR SHARE");
    campaign.setVideoURI("");
    
    cams.add(campaign);
    
    campaign.setId(3);
    campaign.setEndDate(ZonedDateTime.now().minusDays(4));
    campaign.setStartDate(ZonedDateTime.now().minusDays(34));
    campaign.setTargetFunding(new BigDecimal(5000));

    cams.add(campaign);
    
    campaign.setId(4);
    campaign.setEndDate(ZonedDateTime.now().minusDays(9));
    campaign.setStartDate(ZonedDateTime.now().minusDays(34));
    campaign.setTargetFunding(new BigDecimal(55000));
    
    cams.add(campaign);

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
