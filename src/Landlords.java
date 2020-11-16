import java.util.ArrayList;

public class Landlords {
  private static Landlords landlords = null;
  private static ArrayList<Landlord> landlordList = new ArrayList<Landlord>();


  private Landlords() {
    landlordList = DataReader.loadLandlords();
  }

  /**
   *returns instance of Landlords
  */
  public static Landlords getInstance() {
    if (landlords == null) {
      landlords = new Landlords();
    }

    return landlords;
  }

  /**
   *returns the arrayList of type Landlord
  */
  public ArrayList<Landlord> getLandlords() {
    return landlordList;
  }

  /**
   *adds type Landlord to landlordList
  */
  public static void addLandlord(String id, String firstName, String lastName, String address,
      String email, String password, String type) {
    landlordList
        .add(new Landlord(id, firstName, lastName, address, email, password, type));
    DataWriter.saveLandlords();
  }
}
