package je.backit.service;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import je.backit.control.CampaignDAO;
import je.backit.control.MOCKCampaignDAO;
import je.backit.entity.Campaign;
import je.backit.utils.TimeLeft;

@RequestScoped
public class CampaignService implements Service<Campaign, Integer> {

//   @Inject
//   CampaignDAO campaignDAO;

  @Inject
  MOCKCampaignDAO campaignDAO;

  @Override
  public List<Campaign> getAll() {

    // get all data from db and create CampaignDTO
    List<Campaign> campaigns = campaignDAO.findAll();

    for (Campaign campaign : campaigns) {
      campaign.setNoBackers(campaignDAO.getNumberOfDonors(campaign.getId()));
      campaign.setPercentageFunded(campaignDAO.getPercentFunded(campaign.getId()));
           
    }

    return campaigns;
  }

  @Override
  public Campaign getDetails(Integer id) {   
    BigDecimal pledged = campaignDAO.getAmountFunded(id);
    Campaign campaign = campaignDAO.findById(id);  

    campaign.setNoBackers(campaignDAO.getNumberOfDonors(campaign.getId()));
    campaign.setPercentageFunded(campaignDAO.getPercentFunded(campaign.getId()));
    
    campaign.setPledged(pledged);  
    return campaign;
  }
  

  @Override
  public Campaign persist(Campaign T) {
    // TODO Auto-generated method stub
    return new Campaign();
  }
  

}
