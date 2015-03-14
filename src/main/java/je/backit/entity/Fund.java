package je.backit.entity;

import java.math.BigDecimal;

public class Fund extends BaseEntity{

  private BigDecimal amount;
  private Integer campaignId;
  
  
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  
  public Integer getCampaignId() {
    return campaignId;
  }
  public void setCampaignId(Integer campaignId) {
    this.campaignId = campaignId;
  }
  
  
}
