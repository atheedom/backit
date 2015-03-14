package je.backit.control.action;

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

    return "/showcampaigns.jsp";

  }

}
