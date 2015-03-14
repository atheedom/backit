package je.backit.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import static java.util.Collections.emptyList;
import java.util.List;
import je.backit.jooq.tables.records.RewardRecord;
import je.backit.utils.TimeLeft;

public class Campaign extends BaseEntity {

  private Integer id;
  private String title;
  private String summary;
  private String description;
  private List<String> categories;
  private String hashtag;
  private String videoURI;
  private String imageURI;
  private String type;
  private ZonedDateTime startDate;
  private ZonedDateTime endDate;
  private BigDecimal targetFunding;

  private String timeRemaining;
  private BigDecimal backed;
  private Integer noBackers;

  private List<RewardRecord> rewards;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getTargetFunding() {
    return targetFunding;
  }

  public void setTargetFunding(BigDecimal targetFunding) {
    this.targetFunding = targetFunding;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getCategories() {
    return categories == null ? emptyList() : categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public String getHashtag() {
    return hashtag;
  }

  public void setHashtag(String hashtag) {
    this.hashtag = hashtag;
  }

  public String getVideoURI() {
    return videoURI;
  }

  public void setVideoURI(String videoURI) {
    this.videoURI = videoURI;
  }

  public String getImageURI() {
    return imageURI;
  }

  public void setImageURI(String imageURI) {
    this.imageURI = imageURI;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setStartDate(ZonedDateTime startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(ZonedDateTime endDate) {
    this.endDate = endDate;
  }

  public ZonedDateTime getStartDate() {
    return startDate;
  }

  public ZonedDateTime getEndDate() {
    return endDate;
  }



  public String getTimeRemaining() {
    return timeRemaining;
  }

  public void setTimeRemaining(String timeRemaining) {
    this.timeRemaining = timeRemaining;
  }

  public BigDecimal getBacked() {
    return backed;
  }

  public void setBacked(BigDecimal backed) {
    this.backed = backed;
  }

  public Integer getNoBackers() {
    return noBackers;
  }

  public void setNoBackers(Integer noBackers) {
    this.noBackers = noBackers;
  }


  public TimeLeft getTimeLeft() {
    return new TimeLeft(ZonedDateTime.now(), endDate);
  }

  public List<RewardRecord> getRewards() {
    return rewards == null ? emptyList() : rewards;
  }

  public void setRewards(List<RewardRecord> rewards) {
    this.rewards = rewards;
  }


}
