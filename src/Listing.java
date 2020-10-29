import java.util.*;

public class Listing {
	private int ListingID;
	private String LandlordID;
	private String Description;
	private double DistanceFromRussellHouse;
	private boolean Availability;
	private String PictureID;
	private ArrayList<String> ReviewList = new ArrayList<String>();
	private ArrayList<Integer> Rating = new ArrayList<Integer>();
	private double[][] Coordinates;
	//Type: [Sublease, Lease Takeover, Lease] ?????? How to implement
	
	
	public Listing(String title, String description, double price, double Latitude, double Longitude,
			double DistanceFromCampus, String type, String PictureID, String Review, int Rating) {
		
	}

	public Listing(int listingId2, String address, String description2, double distanceFromRussell, String type,
			boolean available, int landlordId2, boolean amenitiesWasher, boolean amenitiesAC,
			boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher, boolean amenitiesFireplace,
			boolean amenitiesWifi, boolean amenitiesPool) {
		// TODO Auto-generated constructor stub
	}

	public void addReview(String review) {
		for(int i = 0; i < ReviewList.size(); i++) {
			if(ReviewList.get(i) == null)
				ReviewList.add(review);
		}
	}
	
	public void addRating(int rating) {
		for(int i = 0; i < Rating.size(); i++) {
			if(Rating.get(i) == null)
				Rating.add(rating);
		}
	}
	
	public double getRating() {
		double total = 0;
		for(int i = 0; i < Rating.size(); i++) {
			if(Rating.get(i) != null)
				total += Rating.get(i);
		}
		total = total/(Rating.size()+1);
		return total;
	}
	
	public String getReviews(String ListingID) {
		return "";
	}
	
	public void setAvailability(boolean available) {
		this.Availability = available;
	}

	public int getListingID() {
		return ListingID;
	}

	public void setListingID(int listingID) {
		ListingID = listingID;
	}
	
	
}
