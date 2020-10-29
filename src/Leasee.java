
import java.util.ArrayList;
import java.util.Random;

public class Leasee extends User {
  ArrayList<Lease> leases = new ArrayList<Lease>();
  ArrayList<Listing> favoriteListings = new ArrayList<Listing>();
  String studentId = "";

  public Leasee(String leaseeId, String firstName, String lastName, String address, String email,
      String password, String type, ArrayList<Listing> favoriteListings) {
    super(leaseeId, firstName, lastName, address, email, password, type);
    this.favoriteListings = favoriteListings;
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

  /**
   * @return the favoriteListings
   */
  public ArrayList<Listing> getFavoriteListings() {
    return favoriteListings;
  }

  /**
   * @param favoriteListings the favoriteListings to set
   */
  public void setFavoriteListings(ArrayList<Listing> favoriteListings) {
    this.favoriteListings = favoriteListings;
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

  public boolean isValidUSCID(String USCID) {
    if ((Character.isLetter(USCID.charAt(0))) && (USCID.length() == 9))
      return true;
    else
      return false;
  }

  public String getClassStanding(String USCID) {
    Random rand = new Random();
    int rank = rand.nextInt(5848) + 1; // amount of total freshman enrolled
    return "Currently #" + rank;
  }

  public void contactLandlord(String landlord, String message) {
    // Approach: get user origin and write a message to their messages array.
  }

  public void signLease(boolean signed, String date) {
    // java.time.LocalDateTime.now()
  }

  public void addFavoriteProperty(Listing listingID) {
    for (int i = 0; i < favoriteListings.size(); i++) {
      if (favoriteListings.get(i) == null) {
        favoriteListings.add(i, listingID);
        return;
      }
    }
  }

  public void deleteFavoriteProperty(Listing listingID) {
    for (int i = 0; i < favoriteListings.size(); i++) {
      if (favoriteListings.get(i) == listingID) {
        favoriteListings.remove(i);
        return;
      }
    }
  }
}
