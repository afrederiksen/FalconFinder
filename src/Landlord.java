import java.util.ArrayList;
import java.util.Random;

public class Landlord extends User{
	private ArrayList<Lease> Leases;
	public ArrayList<Listing> listings;
	private int numListings;
	public final double russLat = 33.9969; //Russell House Latitude
	public final double russLong = 81.0272; //Russell House Longitude
	public final int R = 6371; // Radius of the earth

	public Landlord(String id, String firstName, String lastName, String address, String email,
		      String password, String type) {
		super(id, firstName, lastName, address, email, password, type, "none");
		this.numListings = listings.size();
	}

	public void postListing(int id, String address, String description, double DistanceFromRuss, String type, boolean available, int landlordID, boolean amenitiesWasher, boolean amenitiesAC,
			boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher,
			boolean amenitiesFireplace, boolean amenitiesWifi, boolean amenitiesPool) {
		Listing listing = new Listing(id, address, description, DistanceFromRuss, type, available, landlordID, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio, amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool);
		for(int i = 0; i < getnumListings(); i++) {
			if(listings.get(i) == null) {
				listings.add(listing);
				return;
			}
		}
		numListings++;

		Random rand = new Random();
		int ID = rand.nextInt(1000)+1;
		listing.setListingId(ID);
	}

	public int getnumListings() {
		return this.numListings;
	}

	public void removeListing(int listingID) {
		for(int i = 0; i < getnumListings(); i++) {
			if(listings.get(i).getListingId() == listingID) {
				listings.remove(i);
				return;
			}
		}
		numListings--;
	}

	/*	public double distance(double lat, double lon) {

	    double latDistance = Math.toRadians(russLat - lat);
	    double lonDistance = Math.toRadians(russLong - lon);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(russLat))
	 * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);

	    return Math.sqrt(distance);
	}
	 */
	public void contactLeasee(String Leasee, String Message) {

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
