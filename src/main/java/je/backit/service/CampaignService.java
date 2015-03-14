package je.backit.service;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import je.backit.entity.Campaign;

import org.jooq.DAO;

@ManagedBean
public class CampaignService implements Service<Campaign> {

  @Inject
  DAO<?, Campaign, ?> CampaignDAO;

  public List<Campaign> getAll() {

    return CampaignDAO.findAll();

  }

}
