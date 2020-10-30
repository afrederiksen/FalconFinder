import java.util.ArrayList;

public class Landlords {
  private static Landlords landlords = null;
  private static ArrayList<Landlord> landlordList = new ArrayList<Landlord>();

  private Landlords() {
    landlordList = DataReader.loadLandlords();
  }

  public static Landlords getInstance() {
    if (landlords == null) {
      landlords = new Landlords();
    }

    return landlords;
  }

  public ArrayList<Landlord> getLandlords() {
    return landlordList;
  }

  public static void addLandlord(String id, String firstName, String lastName, String address,
      String email, String password, String type, ArrayList<Listing> listings) {
    landlordList
        .add(new Landlord(id, firstName, lastName, address, email, password, type));
    DataWriter.saveLandlords();
  }
}
