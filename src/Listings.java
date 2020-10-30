import java.util.ArrayList;

public class Listings {
  private static Listings listings = null;
  private static ArrayList<Listing> listingList = new ArrayList<Listing>();

  private Listings() {
    listingList = DataReader.loadListings();
  }

  public static Listings getInstance() {
    if (listings == null) {
      listings = new Listings();
    }

    return listings;
  }

  public ArrayList<Listing> getListings() {
    return listingList;
  }

  public void addListing(int listingId, String address, String description,
      double distanceFromRussellHouse, boolean available, String landlordId,
      boolean amenitiesWasher, boolean amenitiesAC, boolean amenitiesFurniture,
      boolean amenitiesPatio, boolean amenitiesDishwasher, boolean amenitiesFireplace,
      boolean amenitiesWifi, boolean amenitiesPool) {
    listingList.add(new Listing(listingId, address, description, distanceFromRussellHouse,
        available, landlordId, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
        amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool));
    DataWriter.saveListings();
  }
}
