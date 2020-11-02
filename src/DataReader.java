import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader extends DataConstants {

	/**
	 *creates 2 new arrayLists of listings and reviews
	 *adds reviews of listings to each array respectfully
	 *returns arrayList of listings
	*/
	public static ArrayList<Listing> loadListings() {
		ArrayList<Listing> listings = new ArrayList<Listing>();
		ArrayList<Review> reviews = new ArrayList<Review>();

		try {
			JSONParser parser = new JSONParser();
			FileReader reader = new FileReader(LISTINGS_FILE_NAME);
			Object obj = parser.parse(reader);
			JSONObject jsonobj = (JSONObject) obj;
			JSONArray listingsJSON = (JSONArray) jsonobj.get("listings");

			for (int i = 0; i < listingsJSON.size(); i++) {
				JSONObject listingJSON = (JSONObject) listingsJSON.get(i);
				long listingId = (long) listingJSON.get(LISTING_ID);
				String address = (String) listingJSON.get(LISTING_ADDRESS);
				long beds = (long) listingJSON.get("beds");
				long bathrooms = (long) listingJSON.get("bathrooms");
				double distanceFromRussell = (double) listingJSON.get(LISTING_DISTANCE_FROM_RUSSELL);
				// String type = (String) listingJSON.get(LISTING_TYPE);
				double price = (double) listingJSON.get("price");
				long available = (long) listingJSON.get(LISTING_AVAILABLE);
				String landlordId = (String) listingJSON.get(LISTING_LANDLORD_ID);
				boolean amenitiesWasher = (boolean) listingJSON.get("washer/dryer");
				boolean amenitiesAC = (boolean) listingJSON.get(LISTING_AMENITIES_AC);
				boolean amenitiesFurniture = (boolean) listingJSON.get(LISTING_AMENITIES_FURNITURE);
				boolean amenitiesPatio = (boolean) listingJSON.get(LISTING_AMENITIES_PATIO);
				boolean amenitiesDishwasher = (boolean) listingJSON.get(LISTING_AMENITIES_DISHWASHER);
				boolean allowsPets = (boolean) listingJSON.get("pets");
				boolean amenitiesWifi = (boolean) listingJSON.get(LISTING_AMENITIES_WIFI);
				boolean amenitiesPool = (boolean) listingJSON.get(LISTING_AMENITIES_POOL);
				/* JSONArray reviewsArray = (JSONArray) jsonobj.get(LISTING_REVIEWS);
				for (int j = 0; j < reviewsArray.size(); j++) {
					JSONObject reviewJSON = (JSONObject) reviewsArray.get(i);
					long userId = (long) reviewJSON.get(LISTING_REVIEWS_USER_ID);
					String review = (String) reviewJSON.get(LISTING_REVIEWS_REVIEW);
					long rating = (long) reviewJSON.get(LISTING_REVIEWS_RATING);
					reviews.add(new Review(userId, review, rating));
				}
*/
				listings.add(new Listing(listingId, address, beds, bathrooms, distanceFromRussell, price,
						available, landlordId, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
						amenitiesDishwasher, allowsPets, amenitiesWifi, amenitiesPool));
			}

			return listings;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	
	/**
	 *creates an arrayList of users
	 *fills arrayList with type User
	 *returns new filled arrayList of users
	*/
	public static ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<User>();

		try {
			JSONParser parser = new JSONParser();
			FileReader reader = new FileReader(USERS_FILE_NAME);
			Object obj = parser.parse(reader);
			JSONObject jsonobj = (JSONObject) obj;
			JSONArray usersJSON = (JSONArray) jsonobj.get("users");

			for (int i = 0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject) usersJSON.get(i);
				String id = (String) userJSON.get(USER_ID);
				String firstName = (String) userJSON.get(USER_FIRST_NAME);
				String lastName = (String) userJSON.get(USER_LAST_NAME);
				String address = (String) userJSON.get(USER_ADDRESS);
				String email = (String) userJSON.get(USER_EMAIL);
				String password = (String) userJSON.get(USER_PASSWORD);
				String type = (String) userJSON.get(USER_TYPE);

				users.add(new User(id, firstName, lastName, address, email, password, type));
			}

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	
	/**
	 *creates an arrayList of leasees
	 *fills arrayList with type Leasee
	 *returns new filled arrayList of leasees
	*/
	public static ArrayList<Leasee> loadLeasees() {
		ArrayList<Leasee> leasees = new ArrayList<Leasee>();

		try {
			JSONParser parser = new JSONParser();
			FileReader reader = new FileReader(LEASEES_FILE_NAME);
			Object obj = parser.parse(reader);
			JSONObject jsonobj = (JSONObject) obj;
			JSONArray leaseesJSON = (JSONArray) jsonobj.get("leasees");

			for (int i = 0; i < leaseesJSON.size(); i++) {
				JSONObject leaseeJSON = (JSONObject) leaseesJSON.get(i);
				String leaseeId = (String) leaseeJSON.get(LEASEE_ID);
				String firstName = (String) leaseeJSON.get(LEASEE_FIRST_NAME);
				String lastName = (String) leaseeJSON.get(LEASEE_LAST_NAME);
				String address = (String) leaseeJSON.get(LEASEE_ADDRESS);
				String email = (String) leaseeJSON.get(LEASEE_EMAIL);
				String password = (String) leaseeJSON.get(LEASEE_PASSWORD);
				String studentId = (String) leaseeJSON.get(LEASEE_STUDENT_ID);
				String type = (String) leaseeJSON.get(LEASEE_TYPE);
				ArrayList<Listing> favoriteListings =
						(ArrayList<Listing>) leaseeJSON.get(LEASEE_FAVORITE_LISTINGS);

				leasees.add(new Leasee(leaseeId, firstName, lastName, address, email, password, type,
						favoriteListings));
			}

			return leasees;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	
	/**
	 *creates arrayList of landlords
	 *Fills arrayList with type Landlord
	 *returns new filled arrayList of landlords
	*/
	public static ArrayList<Landlord> loadLandlords() {
		ArrayList<Landlord> landlords = new ArrayList<Landlord>();

		try {
			JSONParser parser = new JSONParser();
			FileReader reader = new FileReader(LANDLORDS_FILE_NAME);
			Object obj = parser.parse(reader);
			JSONObject jsonobj = (JSONObject) obj;
			JSONArray landlordsJSON = (JSONArray) jsonobj.get("listings");

			for (int i = 0; i < landlordsJSON.size(); i++) {
				JSONObject landlordJSON = (JSONObject) landlordsJSON.get(i);
				String landlordId = (String) landlordJSON.get(LANDLORD_ID);
				String firstName = (String) landlordJSON.get(LANDLORD_FIRST_NAME);
				String lastName = (String) landlordJSON.get(LANDLORD_LAST_NAME);
				String address = (String) landlordJSON.get(LANDLORD_ADDRESS);
				String email = (String) landlordJSON.get(LANDLORD_EMAIL);
				String password = (String) landlordJSON.get(LANDLORD_PASSWORD);
				String type = (String) landlordJSON.get(LANDLORD_TYPE);
				ArrayList<Listing> listings = (ArrayList<Listing>) landlordJSON.get(LANDLORD_LISTINGS);

				landlords.add(new Landlord(landlordId, firstName, lastName, address, email, password, type));
			}

			return landlords;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	
	/**
	 *creates arrayList of leases
	 *fills arrayList with type Lease
	 *returns new filled arrayList
	*/
	public static ArrayList<Lease> loadLeases() {
		ArrayList<Lease> leases = new ArrayList<Lease>();

		try {
			JSONParser parser = new JSONParser();
			FileReader reader = new FileReader(LEASES_FILE_NAME);
			Object obj = parser.parse(reader);
			JSONObject jsonobj = (JSONObject) obj;
			JSONArray leasesJSON = (JSONArray) jsonobj.get("leases");

			for (int i = 0; i < leasesJSON.size(); i++) {
				JSONObject leaseJSON = (JSONObject) leasesJSON.get(i);
				long leaseId = (long) leaseJSON.get(LEASE_ID);
				String landlordId = (String) leaseJSON.get(LEASE_LANDLORD_ID);
				String leaseeId = (String) leaseJSON.get(LEASE_LEASEE_ID);
				String date = (String) leaseJSON.get(LEASE_DATE);
				String address = (String) leaseJSON.get(LEASE_ADDRESS);

				leases.add(new Lease(leaseId, landlordId, leaseeId, date, address));
			}

			return leases;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
