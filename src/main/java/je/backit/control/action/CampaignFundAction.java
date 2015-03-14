package je.backit.control.action;

import java.math.BigDecimal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import je.backit.service.FundService;

@RequestScoped
public class CampaignFundAction implements Action {

  @Inject
  FundService fundService;


  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Integer campaignId = Integer.valueOf((String) request.getAttribute("campaignId"));
    Integer donorId = Integer.valueOf((String) request.getAttribute("donorId"));
    BigDecimal amount = new BigDecimal((String) request.getAttribute("amount"));


    // Retrieve data from database
    request.setAttribute("campaigns", fundService.addFunds(campaignId, donorId, amount));

    return "ShowCampaignFund";

  }

}
