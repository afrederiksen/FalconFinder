public class User {
  private String id;
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private String password;
  private String type;

  public User(String id, String firstName, String lastName, String address, String email,
      String password, String type) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.password = password;
    this.type = type;
  }

  public void resetPassword(String oldPassword, String newPassword) {
    if (oldPassword.equals(this.password)) {
      this.password = newPassword;
      System.out.println("Sucessfully changed password.");
    } else {
      System.out.println("Error! Old password was incorrect.");
    }
  }

  public void changeEmail(String newEmail) {
    if (newEmail.contains("@")) {
      this.setEmail(newEmail);
    } else {
      System.out.println("Error! Please enter a valid email.");
    }
  }

  public void setUserType(String type) {
    if (type.equalsIgnoreCase("leasee")) {
      this.type = "Leasee";
    } else if (type.equalsIgnoreCase("landlord")) {
      this.type = "Landlord";
    } else if (type.equalsIgnoreCase("admin")) {
      this.type = "Admin";
    } else {
      System.out.println("Incorrect type!");
      {
      }
    }
  }


  public void deleteAccount(String terminateConfirmation) {
    if (terminateConfirmation.equals("TERMINATE")) {
      id = null;
      firstName = null;
      lastName = null;;
      address = null;
      email = null;
      password = null;
      type = null;
      System.out.println("Your account has been terminated.");

    }

  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
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

}
