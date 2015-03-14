package je.backit.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import je.backit.entity.CATEGORY;
import je.backit.entity.Campaign;
import je.backit.jooq.tables.records.AppUserRecord;

import org.jooq.Configuration;
import org.jooq.DAO;
import org.jooq.Field;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.conf.Settings;
import org.jooq.exception.DataAccessException;

public class CampaignDAO implements DAO<AppUserRecord, Campaign, UUID>{

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
    // TODO replace with appropriate data access code
    
    List<Campaign> campaigns = new ArrayList<>();

    Campaign campaign = new Campaign();
    campaign.setTitle("Local Arts Project");
    campaign.setCategories(CATEGORY.ARTS);
    campaign
        .setDescription("A project about getting kids involve with art adn all simular related stuff. Ran by the local community for the local kids. We need some cash to buy paint and soap cuase the kids make a big mess with paint as they dont know hope paint.");
    campaign.setDuration(10);
    campaign.setHashtag("#localarts");
    campaign.setImageURI("/img/localarts.jpg");
    campaign
        .setSummary("A project about getting kids involve with art and stuff");
    campaign.setVideoURI("/video/localartsvideo.mov");
    
    campaigns.add(campaign);
    
    return campaigns;
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
