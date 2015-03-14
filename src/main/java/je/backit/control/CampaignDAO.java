package je.backit.control;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.emptyList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import static java.util.stream.Collectors.toList;
import javax.inject.Inject;

import je.backit.entity.Campaign;
import je.backit.entity.Category;
import je.backit.jooq.JooqProvider;
import je.backit.jooq.Tables;
import static je.backit.jooq.Tables.CAMPAIGN;
import static je.backit.jooq.Tables.CAMPAIGN_TAG;
import static je.backit.jooq.Tables.CATEGORY;
import je.backit.jooq.tables.records.AppUserRecord;

import org.jooq.Configuration;
import org.jooq.DAO;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record10;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Record9;
import org.jooq.RecordMapper;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.conf.Settings;
import org.jooq.exception.DataAccessException;

public class CampaignDAO implements DAO<AppUserRecord, Campaign, UUID> {

  @Inject JooqProvider jooq;

  @Override
  public Configuration configuration() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Settings settings() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SQLDialect dialect() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SQLDialect family() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RecordMapper<AppUserRecord, Campaign> mapper() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void insert(Campaign object) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void insert(Campaign... objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void insert(Collection<Campaign> objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Campaign object) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Campaign... objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Collection<Campaign> objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Campaign... objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Collection<Campaign> objects) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteById(UUID... ids) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteById(Collection<UUID> ids) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean exists(Campaign object) throws DataAccessException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean existsById(UUID id) throws DataAccessException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public long count() throws DataAccessException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Campaign> findAll() throws DataAccessException {
    DSLContext sql = jooq.sql();
    Result<Record10<Integer, Timestamp, Timestamp, String, String, String, BigDecimal, String, String, String>> result = sql
            .select(CAMPAIGN.ID, CAMPAIGN.CREATION_DATE, CAMPAIGN.EXPIRATION_DATE, CAMPAIGN.HASHTAG, CAMPAIGN.IMAGEURI, CAMPAIGN.SUMMARY,
                    CAMPAIGN.TARGET_FUNDING, CAMPAIGN.TITLE, CAMPAIGN.VIDEOURI, CAMPAIGN.HTML)
            .from(CAMPAIGN)
            .fetch();

    List<Campaign> campaigns = result.stream()
            .map(CampaignDAO::mapRecordToCampaign)
            .collect(toList());

    Map<Integer, List<String>> tagsPerCampaign = sql.select(CAMPAIGN_TAG.CAMPAIGN_ID, CATEGORY.CATEGORY_)
                    .from(CAMPAIGN_TAG)
                    .join(CATEGORY).on(CATEGORY.ID.eq(CAMPAIGN_TAG.CATEGORY_ID))
                    .fetchGroups(CAMPAIGN_TAG.CAMPAIGN_ID, CATEGORY.CATEGORY_);

    for (Campaign c : campaigns) {
      List<String> categories = tagsPerCampaign.getOrDefault(c.getId(), emptyList());
      c.setCategories(categories);
    }

    return campaigns;
  }

  private static Campaign mapRecordToCampaign(Record r) {
    Campaign c = new Campaign();
    c.setId(r.getValue(CAMPAIGN.ID));
    c.setStartDate(ZonedDateTime.ofInstant(r.getValue(CAMPAIGN.CREATION_DATE).toInstant(), ZoneOffset.UTC));
    c.setEndDate(ZonedDateTime.ofInstant(r.getValue(CAMPAIGN.EXPIRATION_DATE).toInstant(), ZoneOffset.UTC));
    c.setHashtag(r.getValue(CAMPAIGN.HASHTAG));
    c.setImageURI(r.getValue(CAMPAIGN.IMAGEURI));
    c.setSummary(r.getValue(CAMPAIGN.SUMMARY));
    c.setTargetFunding(r.getValue(CAMPAIGN.TARGET_FUNDING));
    c.setTitle(r.getValue(CAMPAIGN.TITLE));
    c.setVideoURI(r.getValue(CAMPAIGN.VIDEOURI));
    c.setDescription(r.getValue(CAMPAIGN.HTML));
    return c;
  }

  @Override
  public Campaign findById(UUID id) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <Z> List<Campaign> fetch(Field<Z> field, Z... values)
          throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <Z> Campaign fetchOne(Field<Z> field, Z value)
          throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Table<AppUserRecord> getTable() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Class<Campaign> getType() {
    // TODO Auto-generated method stub
    return null;
  }

}
