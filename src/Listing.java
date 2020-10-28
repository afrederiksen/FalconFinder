import java.util.*;

public class Listing {
	private String ListingID;
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
	
	public String getReviews(String ListingID) {
		return "";
	}
	
	public void setAvailability(boolean available) {
		
	}
	
}
