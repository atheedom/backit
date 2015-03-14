package je.backit.entity;

import java.math.BigDecimal;

public class Fund extends BaseEntity{

  private BigDecimal amount;
  private Integer campaignId;
  private Integer donorId;


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

  public Integer getDonorId() {
    return donorId;
  }

  public void setDonorId(Integer donorId) {
    this.donorId = donorId;
  }


}
