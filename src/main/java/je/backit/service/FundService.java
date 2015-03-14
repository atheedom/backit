package je.backit.service;

import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import je.backit.control.FundDAO;
import je.backit.entity.Fund;

public class FundService implements Service<Fund, Integer> {

  @Inject
  FundDAO fundDAO;

  @Override
  public List<Fund> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Fund getDetails(Integer I) {
    // TODO Auto-generated method stub
    return null;
  }


  public Fund addFunds(Integer campaignId, Integer donorId, BigDecimal amount) {


    // Get campaign with given id
    // get fund associated with campaign
    // add amount
    // persist

    return fundDAO.fundCampaign(campaignId, donorId, amount);
  }



}
