public class Review {
  private long userId;
  private String review;
  private long rating;

  public Review(long userId, String review, long rating) {
    this.userId = userId;
    this.review = review;
    this.rating = rating;
  }

  /**
   * @return the userId
   */
  public long getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
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
  public void setRating(int rating) {
    this.rating = rating;
  }


}
