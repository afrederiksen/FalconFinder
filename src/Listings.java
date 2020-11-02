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

	public void addListing(long listingId, String address, long beds, long bathrooms,
			double distanceFromRussellHouse, double price, long available, String landlordId,
			boolean amenitiesWasher, boolean amenitiesAC, boolean amenitiesFurniture,
			boolean amenitiesPatio, boolean amenitiesDishwasher, boolean amenitiesFireplace,
			boolean amenitiesWifi, boolean amenitiesPool) {
		listingList.add(new Listing(listingId, address, beds, bathrooms, distanceFromRussellHouse, price,
				available, landlordId, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
				amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool));
		DataWriter.saveListings();
	}

	public void printListings() {
		for(int i = 0; i < listingList.size(); i++) {
			System.out.println("Listing " + (i+1) + ":\n");
			System.out.println("Listing ID: " +listingList.get(i).getListingId());
			System.out.println("Address: " +listingList.get(i).getAddress());
			System.out.println("Beds: " +listingList.get(i).getBeds());
			System.out.println("Bathrooms: " +listingList.get(i).getBathrooms());
			System.out.println("Distance from Russell House: " +listingList.get(i).getDistanceFromRussellHouse() + " miles");
			System.out.println("Price: $" +listingList.get(i).getPrice() + " per month");
			System.out.println("Is Furnished: " +listingList.get(i).isAmenitiesFurniture());
			System.out.println("Has a patio: " +listingList.get(i).isAmenitiesPatio());
			System.out.println("Has a gym: " +listingList.get(i).isAmenitiesAC());
			System.out.println("Has Washer and Dryer: " +listingList.get(i).isAmenitiesWasher());
			System.out.println("Allows Pets: " +listingList.get(i).doesAllowPets());
			System.out.println("Has WiFi: " +listingList.get(i).isAmenitiesWifi());
			System.out.println("Has Pool: " +listingList.get(i).isAmenitiesPool());
			System.out.println("Available: " +listingList.get(i).isAvailable());
			System.out.println();
		}
	}

}
