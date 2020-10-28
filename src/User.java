public class User {
  private int id;
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private String password;
  private String studentId;
  private String type;
  private boolean suspended;
  private String favoriteListings;

  public User(int id, String firstName, String lastName, String address, String email,
      String password, String studentId, String type, boolean suspended, String favoriteListings) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.password = password;
    this.studentId = studentId;
    this.type = type;
    this.suspended = suspended;
    this.favoriteListings = favoriteListings;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the studentId
   */
  public String getStudentId() {
    return studentId;
  }

  /**
   * @param studentId the studentId to set
   */
  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the suspended
   */
  public boolean isSuspended() {
    return suspended;
  }

  /**
   * @param suspended the suspended to set
   */
  public void setSuspended(boolean suspended) {
    this.suspended = suspended;
  }

  /**
   * @return the favoriteListings
   */
  public String getFavoriteListings() {
    return favoriteListings;
  }

  /**
   * @param favoriteListings the favoriteListings to set
   */
  public void setFavoriteListings(String favoriteListings) {
    this.favoriteListings = favoriteListings;
  }

}

