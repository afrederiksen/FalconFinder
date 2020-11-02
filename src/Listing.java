import java.util.ArrayList;

public class Listing {
	private long listingId;
	private String address;
	private long beds;
	private long bathrooms;
	private double distanceFromRussellHouse;
	private double price;
	private long available;
	private String landlordId;
	private boolean amenitiesWasher;
	private boolean amenitiesAC;
	private boolean amenitiesFurniture;
	private boolean amenitiesPatio;
	private boolean amenitiesDishwasher;
	private boolean allowsPets;
	private boolean amenitiesWifi;
	private boolean amenitiesPool;
	private ArrayList<String> ReviewList = new ArrayList<String>();
	private ArrayList<Integer> Rating = new ArrayList<Integer>();

	public Listing(long listingId, String address, long beds, long bathrooms, double distanceFromRussellHouse,
			double price, long available, String landlordId, boolean amenitiesWasher, boolean amenitiesAC,
			boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher,
			boolean allowsPets, boolean amenitiesWifi, boolean amenitiesPool) {
		this.listingId = listingId;
		this.address = address;
		this.beds = beds;
		this.bathrooms = bathrooms;
		this.distanceFromRussellHouse = distanceFromRussellHouse;
		this.price = price;
		this.available = available;
		this.landlordId = landlordId;
		this.amenitiesWasher = amenitiesWasher;
		this.amenitiesAC = amenitiesAC;
		this.amenitiesFurniture = amenitiesFurniture;
		this.amenitiesPatio = amenitiesPatio;
		this.amenitiesDishwasher = amenitiesDishwasher;
		this.allowsPets = allowsPets;
		this.amenitiesWifi = amenitiesWifi;
		this.amenitiesPool = amenitiesPool;
	}

	public void addReview(String review) {
		for (int i = 0; i < ReviewList.size(); i++) {
			if (ReviewList.get(i) == null)
				ReviewList.add(review);
		}
	}

	public void addRating(int rating) {
		for (int i = 0; i < Rating.size(); i++) {
			if (Rating.get(i) == null)
				Rating.add(rating);
		}
	}

	public double getRating() {
		double total = 0;
		for (int i = 0; i < Rating.size(); i++) {
			if (Rating.get(i) != null)
				total += Rating.get(i);
		}
		total = total / (Rating.size() + 1);
		return total;
	}

	/**
	 * @return the listingId
	 */
	 public long getListingId() {
		return listingId;
	}

	 /**
	  * @param listingId the listingId to set
	  */
	 public void setListingId(int listingId) {
		 this.listingId = listingId;
	 }

	 /**
	  * @return the address
	  */
	 public String getAddress() {
		 return address;
	 }
	 
	 public double getPrice() {
		 return price;
	 }

	 /**
	  * @param address the address to set
	  */
	 public void setAddress(String address) {
		 this.address = address;
	 }

	 /**
	  * @return the description
	  */
	 public long getBeds() {
		 return beds;
	 }

	 /**
	  * @param description the description to set
	  */
	 public void setBeds(long Beds) {
		 this.beds = Beds;
	 }

	 /**
	  * @return the distanceFromRussellHouse
	  */
	 public double getDistanceFromRussellHouse() {
		 return distanceFromRussellHouse;
	 }

	 /**
	  * @param distanceFromRussellHouse the distanceFromRussellHouse to set
	  */
	 public void setDistanceFromRussellHouse(double distanceFromRussellHouse) {
		 this.distanceFromRussellHouse = distanceFromRussellHouse;
	 }

	 /**
	  * @return the available
	  */
	 public long isAvailable() {
		 return available;
	 }

	 /**
	  * @param available the available to set
	  */
	 public void setAvailable(long available) {
		 this.available = available;
	 }

	 /**
	  * @return the landlordId
	  */
	 public String getLandlordId() {
		 return landlordId;
	 }

	 /**
	  * @param landlordId the landlordId to set
	  */
	 public void setLandlordId(String landlordId) {
		 this.landlordId = landlordId;
	 }

	 /**
	  * @return the amenitiesWasher
	  */
	 public boolean isAmenitiesWasher() {
		 return amenitiesWasher;
	 }

	 /**
	  * @param amenitiesWasher the amenitiesWasher to set
	  */
	 public void setAmenitiesWasher(boolean amenitiesWasher) {
		 this.amenitiesWasher = amenitiesWasher;
	 }

	 /**
	  * @return the amenitiesAC
	  */
	 public boolean isAmenitiesAC() {
		 return amenitiesAC;
	 }

	 /**
	  * @param amenitiesAC the amenitiesAC to set
	  */
	 public void setAmenitiesAC(boolean amenitiesAC) {
		 this.amenitiesAC = amenitiesAC;
	 }

	 /**
	  * @return the amenitiesFurniture
	  */
	 public boolean isAmenitiesFurniture() {
		 return amenitiesFurniture;
	 }

	 /**
	  * @param amenitiesFurniture the amenitiesFurniture to set
	  */
	 public void setAmenitiesFurniture(boolean amenitiesFurniture) {
		 this.amenitiesFurniture = amenitiesFurniture;
	 }

	 /**
	  * @return the amenitiesPatio
	  */
	 public boolean isAmenitiesPatio() {
		 return amenitiesPatio;
	 }

	 /**
	  * @param amenitiesPatio the amenitiesPatio to set
	  */
	 public void setAmenitiesPatio(boolean amenitiesPatio) {
		 this.amenitiesPatio = amenitiesPatio;
	 }

	 /**
	  * @return the amenitiesDishwasher
	  */
	 public boolean isAmenitiesDishwasher() {
		 return amenitiesDishwasher;
	 }

	 /**
	  * @param amenitiesDishwasher the amenitiesDishwasher to set
	  */
	 public void setAmenitiesDishwasher(boolean amenitiesDishwasher) {
		 this.amenitiesDishwasher = amenitiesDishwasher;
	 }

	 /**
	  * @return the amenitiesFireplace
	  */
	 public boolean doesAllowPets() {
		 return allowsPets;
	 }

	 /**
	  * @param amenitiesFireplace the amenitiesFireplace to set
	  */
	 public void setAllowPets(boolean allowsPets) {
		 this.allowsPets = allowsPets;
	 }

	 /**
	  * @return the amenitiesWifi
	  */
	 public boolean isAmenitiesWifi() {
		 return amenitiesWifi;
	 }

	 /**
	  * @param amenitiesWifi the amenitiesWifi to set
	  */
	 public void setAmenitiesWifi(boolean amenitiesWifi) {
		 this.amenitiesWifi = amenitiesWifi;
	 }

	 /**
	  * @return the amenitiesPool
	  */
	 public boolean isAmenitiesPool() {
		 return amenitiesPool;
	 }

	 /**
	  * @param amenitiesPool the amenitiesPool to set
	  */
	 public void setAmenitiesPool(boolean amenitiesPool) {
		 this.amenitiesPool = amenitiesPool;
	 }

	 /**
	  * @return the reviewList
	  */
	 public ArrayList<String> getReviewList() {
		 return ReviewList;
	 }

	 /**
	  * @param reviewList the reviewList to set
	  */
	 public void setReviewList(ArrayList<String> reviewList) {
		 ReviewList = reviewList;
	 }

	 /**
	  * @param rating the rating to set
	  */
	 public void setRating(ArrayList<Integer> rating) {
		 Rating = rating;
	 }
	 
	 public long getBathrooms() {
		 return bathrooms;
	 }
	 
	 public void setBathrooms(long Bathrooms) {
		 bathrooms = Bathrooms;
	 }
	 
	 public void printListing() {
			System.out.println("Listing ID: " +getListingId());
			System.out.println("Address: " +getAddress());
			System.out.println("Beds: " +getBeds());
			System.out.println("Bathrooms: " +getBathrooms());
			System.out.println("Distance from Russell House: " +getDistanceFromRussellHouse() + " miles");
			System.out.println("Price: $" +getPrice() + " per month");
			System.out.println("Available: " +isAvailable());
			System.out.println("Has Washer and Dryer: " +isAmenitiesWasher());
			System.out.println("Allows pets: " +doesAllowPets());
			System.out.println("Has WiFi: " +isAmenitiesWifi());
			System.out.println("Has Pool: " +isAmenitiesPool());
			System.out.println();
	 }
}
