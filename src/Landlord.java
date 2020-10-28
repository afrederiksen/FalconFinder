import java.util.ArrayList;
import java.util.Random;

public class Landlord extends User{
	private ArrayList<Lease> Leases;
	private Listing[] listings;
	private int numListings;
	public final double russLat = 33.9969; //Russell House Latitude
	public final double russLong = 81.0272; //Russell House Longitude
	public final int R = 6371; // Radius of the earth

	public Landlord(String UUID, String Email, String Password, boolean Suspended, String type) {
		super(UUID, Email, Password, Suspended, type);
		this.numListings = listings.length;
	}

	protected void postListing(String title, String description, double price, double Latitude, double Longitude, double DistanceFromCampus, String type, String PictureID) {
		Listing listing = new Listing(title, description, price, Latitude, Longitude, DistanceFromCampus, type, PictureID, "none", 0);
		for(int i = 0; i < getnumListings(); i++) {
			if(listings[i] == null) {
				listings[i] = listing;
				return;
			}
		}
		numListings++;
		
		Random rand = new Random();
		int ID = rand.nextInt(1000)+1;
		listing.setListingID(ID);
	}

	public int getnumListings() {
		return this.numListings;
	}
	
	protected void removeListing(int listingID) {
		for(int i = 0; i < getnumListings(); i++) {
			if(listings[i].getListingID() == listingID) {
				listings[i] = null;
				return;
			}
		}
		numListings--;
	}

	public double distance(double lat, double lon) {

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

	protected void contactLeasee(String Leasee, String Message) {
		
	}

	protected String getLease(String LeaseID) {
		return LeaseID;
	}

	protected void postSublease(String title, String description, double price, boolean availability, ArrayList amenities, String sublease) {

	}
}
