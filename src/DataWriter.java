import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		listingDetails.put(LISTING_DESCRIPTION, listing.getBeds());
		listingDetails.put(LISTING_DISTANCE_FROM_RUSSELL, listing.getDistanceFromRussellHouse());
		listingDetails.put(LISTING_AVAILABLE, listing.isAvailable());
		listingDetails.put(LISTING_LANDLORD_ID, listing.getLandlordId());
		listingDetails.put(LISTING_AMENITIES_WASHER, listing.isAmenitiesWasher());
		listingDetails.put(LISTING_AMENITIES_AC, listing.isAmenitiesAC());
		listingDetails.put(LISTING_AMENITIES_FURNITURE, listing.isAmenitiesFurniture());
		listingDetails.put(LISTING_AMENITIES_PATIO, listing.isAmenitiesPatio());
		listingDetails.put(LISTING_AMENITIES_DISHWASHER, listing.isAmenitiesDishwasher());
		listingDetails.put(LISTING_AMENITIES_FIREPLACE, listing.doesAllowPets());
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
		userDetails.put(USER_TYPE, user.getType());

		return userDetails;
	}

	public static void saveLeasees() {
		Leasees leaseesList = Leasees.getInstance();
		ArrayList<Leasee> leasees = leaseesList.getLeasees();
		JSONArray jsonLeasees = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < leasees.size(); i++) {
			jsonLeasees.add(getLeaseeJSON(leasees.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(LEASEES_FILE_NAME)) {

			file.write(jsonLeasees.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getLeaseeJSON(Leasee leasee) {
		JSONObject leaseeDetails = new JSONObject();
		leaseeDetails.put(LEASEE_ID, leasee.getId());
		leaseeDetails.put(LEASEE_FIRST_NAME, leasee.getFirstName());
		leaseeDetails.put(LEASEE_LAST_NAME, leasee.getLastName());
		leaseeDetails.put(LEASEE_ADDRESS, leasee.getAddress());
		leaseeDetails.put(LEASEE_EMAIL, leasee.getEmail());
		leaseeDetails.put(LEASEE_PASSWORD, leasee.getPassword());
		leaseeDetails.put(LEASEE_STUDENT_ID, leasee.getStudentId());
		leaseeDetails.put(LEASEE_TYPE, leasee.getType());
		leaseeDetails.put(LEASEE_FAVORITE_LISTINGS, leasee.getFavoriteListings());

		return leaseeDetails;
	}

	public static void saveLandlords() {
		Landlords landlordsList = Landlords.getInstance();
		ArrayList<Landlord> landlords = landlordsList.getLandlords();
		JSONArray jsonLandlords = new JSONArray();

		// creating all the json objects
		for (int i = 0; i < landlords.size(); i++) {
			jsonLandlords.add(getLandlordJSON(landlords.get(i)));
		}

		// Write JSON file
		try (FileWriter file = new FileWriter(LANDLORDS_FILE_NAME)) {

			file.write(jsonLandlords.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getLandlordJSON(Landlord landlord) {
		JSONObject landlordDetails = new JSONObject();
		landlordDetails.put(LANDLORD_ID, landlord.getId());
		landlordDetails.put(LANDLORD_FIRST_NAME, landlord.getFirstName());
		landlordDetails.put(LANDLORD_LAST_NAME, landlord.getLastName());
		landlordDetails.put(LANDLORD_ADDRESS, landlord.getAddress());
		landlordDetails.put(LANDLORD_EMAIL, landlord.getEmail());
		landlordDetails.put(LANDLORD_PASSWORD, landlord.getPassword());
		landlordDetails.put(LANDLORD_TYPE, landlord.getType());
		landlordDetails.put(LANDLORD_LISTINGS, landlord.getListings());

		return landlordDetails;
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
		leaseDetails.put(LEASE_DATE, lease.getDate());
		leaseDetails.put(LEASE_ADDRESS, lease.getAddress());

		return leaseDetails;
	}

	public static void createFile(String l1) {
		try {
			File file = new File("lease.txt");

			if(!file.exists()) {
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			pw.println(l1);
			pw.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
