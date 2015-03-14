package je.backit.service;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.jooq.DAO;

import je.backit.control.FundDAO;
import je.backit.entity.Fund;
import je.backit.jooq.tables.records.AppUserRecord;
import je.backit.jooq.tables.records.FundingRecord;

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

  
  public Fund addFunds(Integer campaignId, BigDecimal amount) {
    
    
    // Get campaign with given id
    // get fund associated with campaign
    // add amount
    // persist
    
    Fund fund = fundDAO.findFundByCampaignId(campaignId);
    
    BigDecimal newAmount = fund.getAmount().add(amount);
    fund.setAmount(newAmount);
    
    
    fundDAO.update(fund);
    
    return fund;
  }



}
