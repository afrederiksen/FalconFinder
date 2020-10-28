public class Review {
  private int userId;
  private String review;
  private int rating;

  public Review(int userId, String review, int rating) {
    this.userId = userId;
    this.review = review;
    this.rating = rating;
  }

  /**
   * @return the userId
   */
  public int getUserId() {
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
  public int getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(int rating) {
    this.rating = rating;
  }


}
