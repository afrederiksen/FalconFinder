import java.util.ArrayList;

public class Leasee extends User {
	ArrayList<Lease> leases = new ArrayList<Lease>();
	ArrayList<String> favoriteProperties = new ArrayList<String>();
	String USCID = "";

	private boolean isValidUSCID(String USCID) {
		return true;
	}

	private String getClassStanding(String USCID) {
		return "";
	}

	private void contactLandlord(String landlord, String message) {
	}

	private void signLease(boolean signed, String date) {
		// java.time.LocalDateTime.now()
	}

	private void postSublease() {
		// Parameters must be updated...
	}

	private void removeListing(String listingID) {
	}

	private void reviewListing(String listingID, String review, int rating) {
	}

	private void addFavoriteProperty(String ListingID) {

	}

	private void deleteFavoriteProperty(String listindID) {
	}
}