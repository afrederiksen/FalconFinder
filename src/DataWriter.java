import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {


  public static void saveListings() {
    Listings listingsList = Listings.getInstance();
    ArrayList<Listing> listings = listingsList.getListings();
    JSONArray jsonListings = new JSONArray();

    // creating all the json objects
    for (int i = 0; i < listings.size(); i++) {
      jsonListings.add(getListingJSON(listings.get(i)));
    }

    // Write JSON file
    try (FileWriter file = new FileWriter(LISTINGS_FILE_NAME)) {

      file.write(jsonListings.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static JSONObject getListingJSON(Listing listing) {
    JSONObject listingDetails = new JSONObject();
    listingDetails.put(LISTING_ID, listing.getListingId());
    listingDetails.put(LISTING_ADDRESS, listing.getAddress());
    listingDetails.put(LISTING_DESCRIPTION, listing.getDescription());
    listingDetails.put(LISTING_DISTANCE_FROM_RUSSELL, listing.getDistanceFromRussellHouse());
    listingDetails.put(LISTING_TYPE, listing.getType());
    listingDetails.put(LISTING_AVAILABLE, listing.isAvailable());
    listingDetails.put(LISTING_LANDLORD_ID, listing.getLandlordId());
    listingDetails.put(LISTING_AMENITIES_WASHER, listing.isAmenitiesWasher());
    listingDetails.put(LISTING_AMENITIES_AC, listing.isAmenitiesAC());
    listingDetails.put(LISTING_AMENITIES_FURNITURE, listing.isAmenitiesFurniture());
    listingDetails.put(LISTING_AMENITIES_PATIO, listing.isAmenitiesPatio());
    listingDetails.put(LISTING_AMENITIES_DISHWASHER, listing.isAmenitiesDishwasher());
    listingDetails.put(LISTING_AMENITIES_FIREPLACE, listing.isAmenitiesFireplace());
    listingDetails.put(LISTING_AMENITIES_WIFI, listing.isAmenitiesWifi());
    listingDetails.put(LISTING_AMENITIES_POOL, listing.isAmenitiesPool());

    return listingDetails;
  }

  public static void saveUsers() {
    Users usersList = Users.getInstance();
    ArrayList<User> users = usersList.getUsers();
    JSONArray jsonUsers = new JSONArray();

    // creating all the json objects
    for (int i = 0; i < users.size(); i++) {
      jsonUsers.add(getUserJSON(users.get(i)));
    }

    // Write JSON file
    try (FileWriter file = new FileWriter(USERS_FILE_NAME)) {

      file.write(jsonUsers.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static JSONObject getUserJSON(User user) {
    JSONObject userDetails = new JSONObject();
    userDetails.put(USER_ID, user.getId());
    userDetails.put(USER_FIRST_NAME, user.getFirstName());
    userDetails.put(USER_LAST_NAME, user.getLastName());
    userDetails.put(USER_ADDRESS, user.getAddress());
    userDetails.put(USER_EMAIL, user.getEmail());
    userDetails.put(USER_PASSWORD, user.getPassword());
    //userDetails.put(USER_STUDENT_ID, user.getStudentId());
    userDetails.put(USER_TYPE, user.getType());
    //userDetails.put(USER_SUSPENDED, user.isSuspended());
    userDetails.put(USER_FAVORITE_LISTINGS, user.getFavoriteListings());

    return userDetails;
  }

  public static void saveLeases() {
    Leases leasesList = Leases.getInstance();
    ArrayList<Lease> leases = leasesList.getLeases();
    JSONArray jsonLeases = new JSONArray();

    // creating all the json objects
    for (int i = 0; i < leases.size(); i++) {
      jsonLeases.add(getLeaseJSON(leases.get(i)));
    }

    // Write JSON file
    try (FileWriter file = new FileWriter(LEASES_FILE_NAME)) {

      file.write(jsonLeases.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static JSONObject getLeaseJSON(Lease lease) {
    JSONObject leaseDetails = new JSONObject();
    leaseDetails.put(LEASE_ID, lease.getLeaseId());
    leaseDetails.put(LEASE_LANDLORD_ID, lease.getLandlordId());
    leaseDetails.put(LEASE_LEASEE_ID, lease.getLeaseeId());
    leaseDetails.put(LEASE_COSIGNER_ID, lease.getCosignerId());
    leaseDetails.put(LEASE_DATE, lease.getDate());
    leaseDetails.put(LEASE_ADDRESS, lease.getAddress());
    leaseDetails.put(LEASE_DURATION, lease.getDuration());

    return leaseDetails;
  }
}
