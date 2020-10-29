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

  public static void addLeasee(String id, String firstName, String lastName, String address,
      String email, String password, String studentId, String type, boolean suspended,
      String favoriteListings) {
    leaseeList.add(new Leasee(id, firstName, lastName, address, email, password, studentId, type,
        suspended, favoriteListings));
    DataWriter.saveLeasees();
  }
}
