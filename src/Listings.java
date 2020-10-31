import java.util.ArrayList;

public class Listings {
	private static Listings listings = null;
	private static ArrayList<Listing> listingList = new ArrayList<Listing>();

	public Listings() {
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

	public void addListing(long listingId, String address, String description,
			double distanceFromRussellHouse, double price, boolean available, String landlordId,
			boolean amenitiesWasher, boolean amenitiesAC, boolean amenitiesFurniture,
			boolean amenitiesPatio, boolean amenitiesDishwasher, boolean amenitiesFireplace,
			boolean amenitiesWifi, boolean amenitiesPool) {
		listingList.add(new Listing(listingId, address, description, distanceFromRussellHouse, price,
				available, landlordId, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
				amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool));
		DataWriter.saveListings();
	}

	public void printListings() {
		for(int i = 0; i < listingList.size(); i++) {
			System.out.println("Listing " + (i+1) + ":\n");
			System.out.println("Listing ID: " +listingList.get(i).getListingId());
			System.out.println("Address: " +listingList.get(i).getAddress());
			System.out.println("Description: " +listingList.get(i).getDescription());
			System.out.println("Distance from Russell House: " +listingList.get(i).getDistanceFromRussellHouse() + " miles");
			System.out.println("Price: $" +listingList.get(i).getPrice() + " per month");
			System.out.println("Is Available: " +listingList.get(i).isAvailable());
			System.out.println("Has Washer: " +listingList.get(i).isAmenitiesDishwasher());
			System.out.println("Has Fireplace: " +listingList.get(i).isAmenitiesFireplace());
			System.out.println("Has WiFi: " +listingList.get(i).isAmenitiesWifi());
			System.out.println("Has Pool: " +listingList.get(i).isAmenitiesPool());
			System.out.println();
		}
	}

}
