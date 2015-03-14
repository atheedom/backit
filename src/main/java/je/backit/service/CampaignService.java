package je.backit.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import je.backit.control.CampaignDAO;
import je.backit.entity.Campaign;
import je.backit.entity.Fund;
import je.backit.jooq.tables.records.AppUserRecord;
import je.backit.jooq.tables.records.CampaignRecord;

import org.jooq.DAO;

@RequestScoped
public class CampaignService implements Service<Campaign, Integer> {

  @Inject
  CampaignDAO campaignDAO;

  @Override
  public List<Campaign> getAll() {
    return campaignDAO.findAll();
  }

  @Override
  public Campaign getDetails(Integer id) {
    return campaignDAO.findById(id);
  }

}
