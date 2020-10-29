import java.util.ArrayList;
import java.util.Random;

public class Leasee extends User {

	ArrayList<Lease> leases = new ArrayList<Lease>();
	ArrayList<String> favoriteProperties = new ArrayList<String>();
	Landlord l1 = new Landlord(0, "test", "gmail", "password", "none", "none", "none", false);
	ArrayList<Listing> listings = l1.copyList();
	String USCID = "";

	public Leasee(int id, String firstName, String lastName, String address, String email,
		      String password, String studentId, String type, boolean suspended, String favoriteListings) {
		super(id, firstName, lastName, address, email, password, studentId, type, suspended, favoriteListings);
		leases = new ArrayList<Lease>();
		favoriteProperties = new ArrayList<String>();
	}

	public boolean isValidUSCID(String USCID) {
		if((Character.isLetter(USCID.charAt(0))) && (USCID.length() == 9))
				return true;
		else
			return false;
	}

	public String getClassStanding(String USCID) {
		Random rand = new Random();
		int rank = rand.nextInt(5848)+1; //amount of total freshman enrolled
		return "Currently #"+rank;
	}

	public void contactLandlord(String landlord, String message) {
		//Approach: get user origin and write a message to their messages array.
	}

	public void signLease(boolean signed, String date) {
		// java.time.LocalDateTime.now()
	}

	public void reviewListing(int listingID, String review, int rating) {
		for(int i = 0; i < listings.size(); i++) {
			if(listings.get(i).getListingId() == listingID) {
				listings.get(i).addReview(review);
				listings.get(i).addRating(rating);
				return;
			}
		}
	}

	public void addFavoriteProperty(String listingID) {
		for(int i = 0; i < favoriteProperties.size(); i++) {
			if(favoriteProperties.get(i) == null) {
				favoriteProperties.add(i, listingID);
				return;
			}
		}
	}

	public void deleteFavoriteProperty(String listingID) {
		for(int i = 0; i < favoriteProperties.size(); i++) {
			if(favoriteProperties.get(i) == listingID) {
				favoriteProperties.remove(i);
				return;
			}
		}
	}
}