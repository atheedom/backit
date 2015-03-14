package je.backit.entity;

public class Campaign extends BaseEntity {

  private String title;
  private String summary;
  private String description;
  private CATEGORY categories;
  private String hashtag;
  private String videoURI;
  private String imageURI;
  private String type;
  private Integer duration;

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

  public CATEGORY getCategories() {
    return categories;
  }

  public void setCategories(CATEGORY categories) {
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

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

}
