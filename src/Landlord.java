import java.util.ArrayList;
import java.util.Random;

public class Landlord extends User {
	private ArrayList<Lease> Leases = new ArrayList<Lease>();
	public ArrayList<Listing> listings = new ArrayList<Listing>();
	private int numListings;

	public Landlord(String landlordId, String firstName, String lastName, String address,
			String email, String password, String type) {
		super(landlordId, firstName, lastName, address, email, password, type);
		listings = new ArrayList<Listing>();
		this.numListings = listings.size();
	}

	/**
	 * @return the leases
	 */
	public ArrayList<Lease> getLeases() {
		return Leases;
	}

	/**
	 * @param leases the leases to set
	 */
	public void setLeases(ArrayList<Lease> leases) {
		Leases = leases;
	}

	/**
	 * @return the listings
	 */
	public ArrayList<Listing> getListings() {
		return listings;
	}

	/**
	 * @param listings the listings to set
	 */
	public void setListings(ArrayList<Listing> listings) {
		this.listings = listings;
	}

	/**
	 * @return the numListings
	 */
	public int getNumListings() {
		return numListings;
	}

	/**
	 * @param numListings the numListings to set
	 */
	public void setNumListings(int numListings) {
		this.numListings = numListings;
	}

	public void postListing(int id, String address, long beds, long bathrooms, double DistanceFromRuss,
			double price, long available, String landlordID, boolean amenitiesWasher, boolean amenitiesAC,
			boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher,
			boolean amenitiesFireplace, boolean amenitiesWifi, boolean amenitiesPool) {
		Listing listing = new Listing(id, address, beds, bathrooms, DistanceFromRuss, price, available,
				landlordID, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
				amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool);
		for (int i = 0; i <= getNumListings(); i++) {
			if (getNumListings() == 0) {
				listings.add(listing);
				return;
			}
			else if(listings.get(i) == null) {
				listings.add(listing);
				return;
			}
		}
		numListings++;

		Random rand = new Random();
		int ID = rand.nextInt(1000) + 1;
		listing.setListingId(ID);
	}

	public void removeListing(int listingID) {
		for (int i = 0; i < getNumListings(); i++) {
			if (listings.get(i).getListingId() == listingID) {
				listings.remove(i);
				return;
			}
		}
		numListings--;
	}

}
