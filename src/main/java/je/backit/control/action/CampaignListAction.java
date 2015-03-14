package je.backit.control.action;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import je.backit.entity.Campaign;
import je.backit.service.Service;

@RequestScoped
public class CampaignListAction implements Action {

  @Inject
  Service<Campaign, Integer> campaignService;

  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    // Retrieve data from database
    request.setAttribute("campaigns", campaignService.getAll());

//    List<Campaign> campaigns = new ArrayList<>();
//
//    Campaign campaign = new Campaign();
//    campaign.setTitle("Local Arts Project");
//
//    campaigns.add(campaign);
    
//    request.setAttribute("campaigns", campaigns);
    
    return "ShowCampaignsList";

  }

}
