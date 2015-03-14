package je.backit.service;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import je.backit.entity.Campaign;
import je.backit.jooq.tables.records.AppUserRecord;

import org.jooq.DAO;

@RequestScoped
public class CampaignService implements Service<Campaign, Integer> {

  @Inject
  DAO<AppUserRecord, Campaign, Integer> campaignDAO;

  @Override
  public List<Campaign> getAll() {
    return campaignDAO.findAll();
  }

  @Override
  public Campaign getDetails(Integer id) {
    return new Campaign();
    //return campaignDAO.findById(id);
  }

}
