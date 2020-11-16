import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataReaderTest {
  private Users users = Users.getInstance();
  private ArrayList<User> userList = users.getUsers();
  private Listings listings = Listings.getInstance();
  private ArrayList<Listing> listingList = listings.getListings();
  private Leasees leasees = Leasees.getInstance();
  private ArrayList<Leasee> leaseeList = leasees.getLeasees();
  private Landlords landlords = Landlords.getInstance();
  private ArrayList<Landlord> landlordList = landlords.getLandlords();


  @BeforeEach
  public void setup() {
    userList.clear();
    userList.add(new User("asmith", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee"));
    userList.add(new User("jsmith", "Jordan", "Smith", "111 Street st", "jsmith@gmail.com",
        "password123", "leasee"));
    DataWriter.saveUsers();
    listingList.clear();
    listingList.add(new Listing(1, "111 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    listingList.add(new Listing(2, "112 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    DataWriter.saveListings();
    leaseeList.clear();
    leaseeList.add(new Leasee("grahammc", "Matthew", "Graham", "111 Street st",
        "grahammc@email.sc.edu", "password", "leasee", null));
    leaseeList.add(new Leasee("adam1", "Adam", "Frederikson", "111 Street st",
        "grahammc@email.sc.edu", "password", "leasee", null));
    DataWriter.saveLeasees();
    landlordList.clear();
    landlordList.add(new Landlord("landlord1", "Matthew", "Graham", "111 Street st",
        "grahammc@email.sc.edu", "password", "landlord"));
    landlordList.add(new Landlord("landlord2", "Adam", "Frederikson", "111 Street st",
        "grahammc@email.sc.edu", "password", "landlord"));
    DataWriter.saveLandlords();

  }

  @AfterEach
  public void tearDown() {
    Users.getInstance().getUsers().clear();
    Listings.getInstance().getListings().clear();
    Leasees.getInstance().getLeasees().clear();
    Landlords.getInstance().getLandlords().clear();
    DataWriter.saveUsers();
    DataWriter.saveListings();
    DataWriter.saveLeasees();
    DataWriter.saveLandlords();
  }


  @Test
  void testGetUsersSize() {
    userList = DataReader.loadUsers();
    assertEquals(2, userList.size());
  }

  @Test
  void testGetUsersSizeZero() {
    Users.getInstance().getUsers().clear();
    DataWriter.saveUsers();
    assertEquals(0, userList.size());
  }

  @Test
  void testGetUserFirstUserName() {
    userList = DataReader.loadUsers();
    assertEquals("asmith", userList.get(0).getId());
  }

  @Test
  void testGetListingsFirstAdress() {
    listingList = DataReader.loadListings();
    assertEquals("111 Street st", userList.get(0).getAddress());
  }

  @Test
  void testGetListingsSize() {
    listingList = DataReader.loadListings();
    assertEquals(2, listingList.size());
  }

  @Test
  void testGetListingsSizeZero() {
    Listings.getInstance().getListings().clear();
    DataWriter.saveListings();
    assertEquals(0, listingList.size());
  }

  @Test
  void testGetLeaseeFirstLeaseeId() {
    leaseeList = DataReader.loadLeasees();
    assertEquals("grahammc", leaseeList.get(0).getId());
  }

  @Test
  void testGetLeaseesSize() {
    leaseeList = DataReader.loadLeasees();
    assertEquals(2, leaseeList.size());
  }

  @Test
  void testGetLeaseesSizeZero() {
    Leasees.getInstance().getLeasees().clear();
    DataWriter.saveLeasees();
    assertEquals(0, leaseeList.size());
  }

  @Test
  void testGetLandlordFirstLandlordId() {
    landlordList = DataReader.loadLandlords();
    assertEquals("landlord1", landlordList.get(0).getId());
  }

  @Test
  void testGetLandlordsSize() {
    landlordList = DataReader.loadLandlords();
    assertEquals(2, landlordList.size());
  }

  @Test
  void testGetLandlordSizeZero() {
    Landlords.getInstance().getLandlords().clear();
    DataWriter.saveLandlords();
    assertEquals(0, landlordList.size());
  }
}
