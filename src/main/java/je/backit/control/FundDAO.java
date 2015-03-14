package je.backit.control;

import java.util.List;
import org.jooq.exception.DataAccessException;

import je.backit.entity.Fund;
import je.backit.jooq.tables.records.FundingRecord;

public class FundDAO extends AbstractDAO<FundingRecord, Fund, Integer> {

  @Override
  public List<Fund> findAll() throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }
  
  
  public Fund findFundByCampaignId(Integer campaignId){
    
    // get fund from DB based on campaignId
    
    return new Fund();
  }


}
