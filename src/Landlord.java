import java.util.ArrayList;
import java.util.Random;

public class Landlord extends User {
  private ArrayList<Lease> Leases;
  public ArrayList<Listing> listings;
  private int numListings;

  public Landlord(String id, String firstName, String lastName, String address, String email,
      String password, String type, boolean suspended) {
    super(id, firstName, lastName, address, email, password, "none", type, suspended, "none");
    this.numListings = listings.size();
  }

  public void postListing(int id, String address, String description, double DistanceFromRuss,
      String type, boolean available, int landlordID, boolean amenitiesWasher, boolean amenitiesAC,
      boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher,
      boolean amenitiesFireplace, boolean amenitiesWifi, boolean amenitiesPool) {
    Listing listing = new Listing(id, address, description, DistanceFromRuss, type, available,
        landlordID, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
        amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool);
    for (int i = 0; i < getnumListings(); i++) {
      if (listings.get(i) == null) {
        listings.add(listing);
        return;
      }
    }
    numListings++;

    Random rand = new Random();
    int ID = rand.nextInt(1000) + 1;
    listing.setListingId(ID);
  }

  public int getnumListings() {
    return this.numListings;
  }

  public void removeListing(int listingID) {
    for (int i = 0; i < getnumListings(); i++) {
      if (listings.get(i).getListingId() == listingID) {
        listings.remove(i);
        return;
      }
    }
    numListings--;
  }

  public String getLease(String LeaseID) {
    return LeaseID;
  }

  public ArrayList<Listing> copyList() {
    return listings;
  }

  public ArrayList<Lease> copyLeases() {
    return Leases;
  }

}
