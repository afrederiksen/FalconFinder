import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader extends DataConstants {
  public static void loadListing() {
    ArrayList<Listing> listings = new ArrayList<Listing>();

    try {
      FileReader reader = new FileReader(LISTINGS_FILE_NAME);
      JSONParser parser = new JSONParser();
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

        listings.add(new Listing(listingId, address, description, distanceFromRussell, type,
            available, landlordId, amenitiesWasher, amenitiesAC, amenitiesFurniture, amenitiesPatio,
            amenitiesDishwasher, amenitiesFireplace, amenitiesWifi, amenitiesPool));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
