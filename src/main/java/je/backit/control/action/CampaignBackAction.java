package je.backit.control.action;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import je.backit.entity.Campaign;
import je.backit.service.Service;

@RequestScoped
public class CampaignBackAction implements Action {

  @Inject
  Service<Campaign, Integer> campaignService;

  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    // TODO extract and validate the Campaign object
    
    Campaign campaign = campaignService.persist(new Campaign());

    // persist data to database and return persisted data
    request.setAttribute("campaign", campaign);

    return "ShowCampaignDetails";

  }

}