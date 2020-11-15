import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListingTest {
	/*(long listingId, String address, long beds, long bathrooms, double distanceFromRussellHouse,
	double price, long available, String landlordId, boolean amenitiesWasher, boolean amenitiesAC,
	boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher,
	boolean allowsPets, boolean amenitiesWifi, boolean amenitiesPool)*/

	public static Listings listings = new Listings();

	@BeforeClass
	public static void oneTimeSetup() {
		int size = listings.getListings().size();
		listings.addListing(42, "123 Baker Street", 0, 0, 0, 0, -400, null, false, false, false, false, false, false, false, false);
		assertEquals((size+1), listings.getListings().size());
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
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	@Test
//	void testListing() {
//		fail("Not yet implemented");
//	}

	@Test
	void testAddReview() {
		listings.getListings().get(1).addReview("Test");
		assertTrue(listings.getListings().get(1).getReviewList().get(listings.getListings().get(1).getReviewList().size()).contentEquals("Test"));
	}

	@Test
	void testAddRating() {
		listings.getListings().get(1).addRating(5);
		double orginRating = listings.getListings().get(1).getRating();
		listings.getListings().get(1).addRating(1);
		listings.getListings().get(1).addRating(1);
		assertFalse(listings.getListings().get(1).getRating() == orginRating);
	}
	@Test
	void TestMassRating() {
		listings.getListings().get(2).addRating(1000000);
		assertFalse(listings.getListings().get(2).getRating()>5);
	}
	
	@Test
	void duplicateListingID() {
		//Same ID of 20
		listings.addListing(20, "2020 Long Drive", 0, 0, 0, 0, -400, null, false, false, false, false, false, false, false, false);
		listings.addListing(20, "2021 Main Street", 0, 0, 0, 0, -400, null, false, false, false, false, false, false, false, false);
		ArrayList<Long> idHolding = new ArrayList<Long>();
		boolean flag = false;
		for(Listing listing : listings.getListings()) {
			idHolding.add(listing.getListingId());
			for(long item : idHolding) {
				if(listing.getListingId() == item) {
					flag = true;
				}
			}
			if(flag) {
				break;
			}
		}
		assertFalse(flag);
	}
}
