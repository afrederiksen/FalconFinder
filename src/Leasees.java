import java.util.ArrayList;

public class Leasees {
  private static Leasees leasees = null;
  private static ArrayList<Leasee> leaseeList = new ArrayList<Leasee>();

  private Leasees() {
    leaseeList = DataReader.loadLeasees();
  }

  public static Leasees getInstance() {
    if (leasees == null) {
      leasees = new Leasees();
    }

    return leasees;
  }

  public ArrayList<Leasee> getLeasees() {
    return leaseeList;
  }

  public static void addLeasee(String leaseeId, String firstName, String lastName, String address,
      String email, String password, String studentId, String type,
      ArrayList<Listing> favoriteListings) {
    leaseeList.add(new Leasee(leaseeId, firstName, lastName, address, email, password, type,
        favoriteListings));
    DataWriter.saveLeasees();
  }
}
