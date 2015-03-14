package je.backit.control.action;

import java.math.BigDecimal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.DAO;

import je.backit.entity.Campaign;
import je.backit.entity.Fund;
import je.backit.jooq.tables.records.AppUserRecord;
import je.backit.service.CampaignService;
import je.backit.service.FundService;
import je.backit.service.Service;

@RequestScoped
public class CampaignFundAction implements Action {

  @Inject
  FundService fundService;
  

  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Integer campaignId = Integer.valueOf((String) request.getAttribute("campaignId"));
    BigDecimal amount = new BigDecimal((String) request.getAttribute("amount"));
       
    
    // Retrieve data from database
    request.setAttribute("campaigns", fundService.addFunds(campaignId, amount));

    return "ShowCampaignFund";

  }

}
