public class Review {
  private String leaseeId;
  private String review;
  private long rating;

  public Review(String leaseeId, String review, long rating) {
	this.leaseeId = leaseeId;
    this.review = review;
    this.rating = rating;
  }

  /**
   * @return the userId
   */
  public String getLeaseeId() {
    return leaseeId;
  }

  /**
   * @param userId the userId to set
   */
  public void setLeaseeId(String leaseeId) {
    this.leaseeId = leaseeId;
  }

  /**
   * @return the review
   */
  public String getReview() {
    return review;
  }

  /**
   * @param review the review to set
   */
  public void setReview(String review) {
    this.review = review;
  }

  /**
   * @return the rating
   */
  public long getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(long rating) {
    this.rating = rating;
  }


}
