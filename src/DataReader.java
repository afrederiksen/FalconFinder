
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader extends DataConstants {
  public static ArrayList<Listing> loadListing() {
    ArrayList<Listing> listings = new ArrayList<Listing>();
    ArrayList<Review> reviews = new ArrayList<Review>();

    try {
      FileReader reader = new FileReader(LISTINGS_FILE_NAME);
      JSONArray listingsJSON = (JSONArray) new JSONParser().parse(reader);

      for (int i = 0; i < listingsJSON.size(); i++) {
        JSONObject listingJSON = (JSONObject) listingsJSON.get(i);
        int listingId = (int) listingJSON.get(LISTING_ID);
        String address = (String) listingJSON.get(LISTING_ADDRESS);
        String description = (String) listingJSON.get(LISTING_DESCRIPTION);
        double distanceFromRussell = (double) listingJSON.get(LISTING_DISTANCE_FROM_RUSSELL);
        String type = (String) listingJSON.get(LISTING_TYPE);
        boolean available = (boolean) listingJSON.get(LISTING_AVAILABLE);
        int landlordId = (int) listingJSON.get(LISTING_LANDLORD_ID);
        boolean amenitiesWasher = (boolean) listingJSON.get(LISTING_AMENITIES_WASHER);
        boolean amenitiesAC = (boolean) listingJSON.get(LISTING_AMENITIES_AC);
        boolean amenitiesFurniture = (boolean) listingJSON.get(LISTING_AMENITIES_FURNITURE);
        boolean amenitiesPatio = (boolean) listingJSON.get(LISTING_AMENITIES_PATIO);
        boolean amenitiesDishwasher = (boolean) listingJSON.get(LISTING_AMENITIES_DISHWASHER);
        boolean amenitiesFireplace = (boolean) listingJSON.get(LISTING_AMENITIES_FIREPLACE);
        boolean amenitiesWifi = (boolean) listingJSON.get(LISTING_AMENITIES_WIFI);
        boolean amenitiesPool = (boolean) listingJSON.get(LISTING_AMENITIES_POOL);
        JSONArray reviewsArray = (JSONArray) listingJSON.get(LISTING_REVIEWS);
        for (int j = 0; j < reviewsArray.size(); j++) {
          JSONObject reviewJSON = (JSONObject) reviewsArray.get(i);
          int userId = (int) reviewJSON.get(LISTING_REVIEWS_USER_ID);
          String review = (String) reviewJSON.get(LISTING_REVIEWS_REVIEW);
          int rating = (int) reviewJSON.get(LISTING_REVIEWS_RATING);
          reviews.add(new Review(userId, review, rating));
        }

        listings.add(new Listing(listingId, address, description, distanceFromRussell, type,
            available, landlordId, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
            amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool));
      }

      return listings;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;

  }

  public static ArrayList<User> loadUser() {
    ArrayList<User> users = new ArrayList<User>();

    try {
      FileReader reader = new FileReader(USERS_FILE_NAME);
      JSONArray usersJSON = (JSONArray) new JSONParser().parse(reader);

      for (int i = 0; i < usersJSON.size(); i++) {
        JSONObject userJSON = (JSONObject) usersJSON.get(i);
        int id = (int) userJSON.get(USER_ID);
        String firstName = (String) userJSON.get(USER_FIRST_NAME);
        String lastName = (String) userJSON.get(USER_LAST_NAME);
        String address = (String) userJSON.get(USER_ADDRESS);
        String email = (String) userJSON.get(USER_EMAIL);
        String password = (String) userJSON.get(USER_PASSWORD);
        String studentId = (String) userJSON.get(USER_STUDENT_ID);
        String type = (String) userJSON.get(USER_TYPE);
        boolean suspended = (boolean) userJSON.get(USER_SUSPENDED);
        String favoriteListings = (String) userJSON.get(USER_FAVORITE_LISTINGS);

        users.add(new User(id, firstName, lastName, address, email, password, studentId, type,
            suspended, favoriteListings));
      }

      return users;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;

  }

  public static ArrayList<Lease> loadLease() {
    ArrayList<Lease> leases = new ArrayList<Lease>();

    try {
      FileReader reader = new FileReader(LEASES_FILE_NAME);
      JSONArray leasesJSON = (JSONArray) new JSONParser().parse(reader);

      for (int i = 0; i < leasesJSON.size(); i++) {
        JSONObject leaseJSON = (JSONObject) leasesJSON.get(i);
        int leaseId = (int) leaseJSON.get(LEASE_ID);
        int landlordId = (int) leaseJSON.get(LEASE_LANDLORD_ID);
        int leaseeId = (int) leaseJSON.get(LEASE_LEASEE_ID);
        int cosignerId = (int) leaseJSON.get(LEASE_COSIGNER_ID);
        String date = (String) leaseJSON.get(LEASE_DATE);
        String address = (String) leaseJSON.get(LEASE_ADDRESS);
        String duration = (String) leaseJSON.get(LEASE_DURATION);

        leases.add(new Lease(leaseId, landlordId, leaseeId, cosignerId, date, address, duration));
      }

      return leases;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;

  }
}
