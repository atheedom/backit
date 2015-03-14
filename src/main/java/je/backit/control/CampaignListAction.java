package je.backit.control;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import je.backit.entity.Campaign;
import je.backit.service.Service;

public class CampaignListAction implements Action {

  @Inject
  Service<Campaign> campaignService;

  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    // Obtain data from database

    request.setAttribute("campaigns", campaignService.getAll());

    return "/showcampaigns.jsp";
  }

}
