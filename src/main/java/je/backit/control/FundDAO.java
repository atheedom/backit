package je.backit.control;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.inject.Inject;
import je.backit.entity.Fund;
import je.backit.jooq.JooqProvider;
import static je.backit.jooq.Tables.FUNDING;
import je.backit.jooq.tables.records.FundingRecord;
import org.jooq.Result;
import org.jooq.exception.DataAccessException;

public class FundDAO extends AbstractDAO<FundingRecord, Fund, Integer> {

  @Inject JooqProvider jooq;


  @Override
  public List<Fund> findAll() throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }


  public List<Fund> findFundByCampaignId(Integer campaignId){
    Result<FundingRecord> result = jooq.sql().selectFrom(FUNDING).where(FUNDING.CAMPAIGN_ID.eq(campaignId)).fetch();
    return result.stream().map(FundDAO::mapRecord).collect(toList());
  }


  public Fund fundCampaign(Integer campaignId, Integer donorId, BigDecimal amount) {
    FundingRecord f = new FundingRecord()
            .setCampaignId(campaignId)
            .setDonorId(donorId)
            .setFundingAmount(amount)
            .setFundingDate(Timestamp.from(Instant.now()));
    f.attach(jooq.sql().configuration());
    f.store();
    return mapRecord(f);
  }

  private static Fund mapRecord(FundingRecord r) {
    Fund f = new Fund();
    f.setCampaignId(r.getCampaignId());
    f.setAmount(r.getFundingAmount());
    f.setDonorId(r.getDonorId());
    return f;
  }

}
