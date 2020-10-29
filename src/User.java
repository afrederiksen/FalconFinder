import java.util.ArrayList;

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
  private ArrayList<Messages> messages = new ArrayList<Messages>();
  private ArrayList<Lease> leases = new ArrayList<Lease>();

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

  public void logout() {
    System.out.println("Logging out.");
    
  }

  public void deleteAccount(String terminateConfirmation) {
    if (terminateConfirmation.equals("TERMINATE")) {
	firstName = null;
	lastName = null;;
	address = null;
	email = null;
	password = null;
	studentId = null;
	type = null;
	suspended = false;
	favoriteListings = null;
	messages = null;
	leases = null;
        System.out.println("Your account has been terminated.");
      
    }

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

  /**
   * @return the messages
   */
  public ArrayList<Messages> getMessages() {
    return messages;
  }

  /**
   * @param messages the messages to set
   */
  public void setMessages(ArrayList<Messages> messages) {
    this.messages = messages;
  }

  /**
   * @return the leases
   */
  public ArrayList<Lease> getLeases() {
    return leases;
  }

  /**
   * @param leases the leases to set
   */
  public void setLeases(ArrayList<Lease> leases) {
    this.leases = leases;
  }

}
