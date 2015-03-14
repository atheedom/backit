package je.backit.control.action;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import je.backit.entity.Campaign;
import je.backit.service.Service;

@RequestScoped
public class CampaignDetailAction implements Action {

  @Inject
  Service<Campaign, Integer> campaignService;

  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Integer campaignId = Integer.valueOf((String) request.getParameter("campaignId"));

    // Retrieve data from database
    request.setAttribute("campaigns", campaignService.getDetails(campaignId));

    return "ShowCampaignDetails";

  }

}
