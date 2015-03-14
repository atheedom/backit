package je.backit.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import je.backit.control.CampaignDAO;
import je.backit.control.MOCKCampaignDAO;
import je.backit.entity.Campaign;

@RequestScoped
public class CampaignService implements Service<Campaign, Integer> {

  @Inject
  CampaignDAO campaignDAO;
  
//  @Inject
//  MOCKCampaignDAO campaignDAO;

  @Override
  public List<Campaign> getAll() {
    
    // get all data from db and create CampaignDTO
    List<Campaign> campaigns = campaignDAO.findAll();  

    for(Campaign campaign : campaigns){    
      campaign.setNoBackers(campaignDAO.getNumberOfDonors(campaign.getId()));
      campaign.setBacked(campaignDAO.getAmountFunded(campaign.getId()));     
    }     
    
    return campaigns;
  }

  @Override
  public Campaign getDetails(Integer id) {  
    return campaignDAO.findById(id);
  }

}
