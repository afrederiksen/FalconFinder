import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

public class ListingTest {
/*(long listingId, String address, long beds, long bathrooms, double distanceFromRussellHouse,
	double price, long available, String landlordId, boolean amenitiesWasher, boolean amenitiesAC,
	boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher,
	boolean allowsPets, boolean amenitiesWifi, boolean amenitiesPool)*/

	public static Listings listings = new Listings();

	@BeforeClass
	public static void oneTimeSetup() {
		listings.addListing(0, "123 Baker Street", 0, 0, 0, 0, -400, null, false, false, false, false, false, false, false, false);
		assertEquals(6, listings.getListings().size());
	}
	@AfterClass
	public static void onTimeTearDown() {
		for(Listing list : listings.getListings()) {
			listings.getListings().remove(list);
		}
		assertEquals(0, listings.getListings().size());
	}
	
	@Test
	public void noAmenititesAddReview() {
		listings.getListings().get(0).addReview("0/10, there's nothing here! Just a cardboard box");
		assertEquals(1, listings.getListings().get(0).getReviewList().size());
	}
	@Test
	public void zeroOrNegativePrice() {
		boolean legitPrice;
		if (listings.getListings().get(0).getPrice()>0) {
			legitPrice = true;
		}
		else {
			legitPrice= false;
		}
		assertTrue(legitPrice);
	}
	@Test
	public void streetIsValid() {
		assertNotNull(listings.getListings().get(0).getAddress());
	}
	
/* allFalse
 * allTrue
 * 
 * 
 */
}
