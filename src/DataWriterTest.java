import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
  private Listings listings = Listings.getInstance();
  private ArrayList<Listing> listingList = listings.getListings();
  private Users users = Users.getInstance();
  private ArrayList<User> userList = users.getUsers();
  private Leasees leasees = Leasees.getInstance();
  private ArrayList<Leasee> leaseeList = leasees.getLeasees();
  private Landlords landlords = Landlords.getInstance();
  private ArrayList<Landlord> landlordList = landlords.getLandlords();

  @BeforeEach
  public void setup() {
    Users.getInstance().getUsers().clear();
    DataWriter.saveUsers();
    Listings.getInstance().getListings().clear();
    DataWriter.saveListings();
    Leasees.getInstance().getLeasees().clear();
    DataWriter.saveLeasees();
    Landlords.getInstance().getLandlords().clear();
    DataWriter.saveLandlords();
  }

  @AfterEach
  public void tearDown() {
    Users.getInstance().getUsers().clear();
    DataWriter.saveUsers();
    Listings.getInstance().getListings().clear();
    DataWriter.saveListings();
    Leasees.getInstance().getLeasees().clear();
    DataWriter.saveLeasees();
    Landlords.getInstance().getLandlords().clear();
    DataWriter.saveLandlords();
  }


  @Test
  void testWritingZeroListings() {
    listingList = DataReader.loadListings();
    assertEquals(0, listingList.size());
  }

  @Test
  void testWritingOneListing() {
    listingList.add(new Listing(1, "111 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    DataWriter.saveListings();
    assertEquals("111 Street st", DataReader.loadListings().get(0).getAddress());
  }

  @Test
  void testWritingFiveListings() {
    listingList.add(new Listing(1, "111 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    listingList.add(new Listing(2, "112 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    listingList.add(new Listing(3, "113 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    listingList.add(new Listing(4, "114 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    listingList.add(new Listing(5, "115 Street st", 3, 3, 3.5, 1200.0, 0, "esmith", true, true,
        true, true, true, true, true, true));
    DataWriter.saveListings();
    assertEquals("esmith", DataReader.loadListings().get(4).getLandlordId());
  }

  @Test
  void testWritingEmptyListing() {
    listingList.add(new Listing(0, "", 0, 0, 0.0, 0.0, 0, "", false, false, false, false, false,
        false, false, false));
    DataWriter.saveListings();
    assertEquals("", DataReader.loadListings().get(0).getAddress());
  }

  @Test
  void testWritingNullListing() {
    listingList.add(new Listing(0, null, 0, 0, 0.0, 0.0, 0, "", false, false, false, false, false,
        false, false, false));
    DataWriter.saveListings();
    assertEquals(null, DataReader.loadListings().get(0).getAddress());
  }

  @Test
  void testWritingZeroUsers() {
    userList = DataReader.loadUsers();
    assertEquals(0, userList.size());
  }

  @Test
  void testWritingOneUser() {
    userList.add(new User("asmith", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee"));
    DataWriter.saveUsers();
    assertEquals("asmith", DataReader.loadUsers().get(0).getId());
  }

  @Test
  void testWritingFiveUsers() {
    userList.add(new User("asmith", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee"));
    userList.add(new User("jsmith", "Jordan", "Smith", "111 Street st", "jsmith@gmail.com",
        "password123", "leasee"));
    userList.add(new User("rsmith", "Ryan", "Smith", "111 Street st", "rsmith@gmail.com",
        "password123", "leasee"));
    userList.add(new User("hsmith", "Heather", "Smith", "111 Street st", "hsmith@gmail.com",
        "password123", "leasee"));
    userList.add(new User("esmith", "Ernest", "Smith", "111 Street st", "esmith@gmail.com",
        "password123", "landlord"));
    DataWriter.saveUsers();
    assertEquals("esmith", DataReader.loadUsers().get(4).getId());
  }

  @Test
  void testWritingEmptyUser() {
    userList.add(new User("", "", "", "", "", "", ""));
    DataWriter.saveUsers();
    assertEquals("", DataReader.loadUsers().get(0).getId());
  }

  @Test
  void testWritingNullUser() {
    userList.add(new User(null, "", "", "", "", "", ""));
    DataWriter.saveUsers();
    assertEquals(null, DataReader.loadUsers().get(0).getId());
  }

  @Test
  void testWritingZeroLeasees() {
    leaseeList = DataReader.loadLeasees();
    assertEquals(0, leaseeList.size());
  }

  @Test
  void testWritingOneLeasee() {
    leaseeList.add(new Leasee("asmith1", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee", null));
    DataWriter.saveLeasees();
    assertEquals("asmith1", DataReader.loadLeasees().get(0).getId());
  }

  @Test
  void testWritingFiveLeasees() {
    leaseeList.add(new Leasee("asmith1", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee", null));
    leaseeList.add(new Leasee("asmith2", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee", null));
    leaseeList.add(new Leasee("asmith3", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee", null));
    leaseeList.add(new Leasee("asmith4", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee", null));
    leaseeList.add(new Leasee("asmith5", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee", null));
    DataWriter.saveLeasees();
    assertEquals("asmith5", DataReader.loadLeasees().get(4).getId());
  }

  @Test
  void testWritingEmptyLeasee() {
    leaseeList.add(new Leasee("", "", "", "", "", "", "", null));
    DataWriter.saveLeasees();
    assertEquals("", DataReader.loadLeasees().get(0).getId());
  }

  @Test
  void testWritingNullLeasee() {
    leaseeList.add(new Leasee(null, "", "", "", "", "", "", null));
    DataWriter.saveLeasees();
    assertEquals(null, DataReader.loadLeasees().get(0).getId());
  }

  @Test
  void testWritingZeroLandlords() {
    landlordList = DataReader.loadLandlords();
    assertEquals(0, landlordList.size());
  }

  @Test
  void testWritingOneLandlord() {
    landlordList.add(new Landlord("asmith", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee"));
    DataWriter.saveLandlords();
    assertEquals("asmith", DataReader.loadLandlords().get(0).getId());
  }

  @Test
  void testWritingFiveLandlords() {
    landlordList.add(new Landlord("asmith", "Amy", "Smith", "111 Street st", "asmith@gmail.com",
        "password123", "leasee"));
    landlordList.add(new Landlord("jsmith", "Jordan", "Smith", "111 Street st", "jsmith@gmail.com",
        "password123", "leasee"));
    landlordList.add(new Landlord("rsmith", "Ryan", "Smith", "111 Street st", "rsmith@gmail.com",
        "password123", "leasee"));
    landlordList.add(new Landlord("hsmith", "Heather", "Smith", "111 Street st", "hsmith@gmail.com",
        "password123", "leasee"));
    landlordList.add(new Landlord("esmith", "Ernest", "Smith", "111 Street st", "esmith@gmail.com",
        "password123", "landlord"));
    DataWriter.saveLandlords();
    assertEquals("esmith", DataReader.loadLandlords().get(4).getId());
  }

  @Test
  void testWritingEmptyLandlord() {
    landlordList.add(new Landlord("", "", "", "", "", "", ""));
    DataWriter.saveLandlords();
    assertEquals("", DataReader.loadLandlords().get(0).getId());
  }

  @Test
  void testWritingNullLandlord() {
    landlordList.add(new Landlord(null, "", "", "", "", "", ""));
    DataWriter.saveLandlords();
    assertEquals(null, DataReader.loadLandlords().get(0).getId());
  }

}
