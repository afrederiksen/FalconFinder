import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

//Tests Listing, Listing, and Reviews
class ListingTest extends DataConstants {
	/*
	 * (long listingId, String address, long beds, long bathrooms, double
	 * distanceFromRussellHouse, double price, long available, String landlordId,
	 * boolean amenitiesWasher, boolean amenitiesAC, boolean amenitiesFurniture,
	 * boolean amenitiesPatio, boolean amenitiesDishwasher, boolean allowsPets,
	 * boolean amenitiesWifi, boolean amenitiesPool)
	 */
	static Listings listings = new Listings();
	static ArrayList<Listing> listingList = listings.getListings();

	/**
	 * Tests if negative prices pass
	 */
	@Test
	public void zeroOrNegativePrice() {
		boolean legitPrice = false;
		if (listings.getListings().get(0).getPrice() > 0) {
			legitPrice = true;
		}
		assertTrue(legitPrice);
	}

	/**
	 * Tests if the street is null
	 */
	@Test
	public void streetIsValid() {
		assertNotNull(listings.getListings().get(0).getAddress());
	}

	/**
	 * Tests if a listing with all amentities is accepted into the listings list
	 */
	@Test
	void addAllAmentities() {
		int size = listings.getListings().size();
		listings.addListing(76, "74 Sugar Street", 0, 0, 0, 0, 900, null, true, true, true, true, true, true, true,
				true);
		DataWriter.saveListings();
		assertEquals((size + 1), listings.getListings().size());
	}

	/**
	 * Tests if a listing with no amentities is accepted into the listings list
	 */
	@Test
	void addNoAmentities() {
		int size = listings.getListings().size();
		// System.out.println(listings.getListings().size());
		listings.addListing(79, "78 Sugar Street", 0, 0, 0, 0, 820, null, false, false, false, false, false, false,
				false, false);
		DataWriter.saveListings();
		// System.out.println(listings.getListings().size());
		assertNotNull(listings.getListings().get(listings.getListings().size() - 1));
	}

	/**
	 * Tests if listings are removable
	 */
	@Test
	void removeListing() {
		int size = listings.getListings().size();
		listings.getListings().remove(listings.getListings().size() - 1);
		assertEquals((size - 1), listings.getListings().size());
	}

	/**
	 * Tests if a large test will break the rating system Tests if bug is possible
	 */
	@Test
	void TestMassRating() {
		listings.getListings().get(2).addRating(1000000);
		// System.out.println(listings.getListings().get(2).getRating());
		assertFalse(listings.getListings().get(2).getRating() > 5);
	}

	/**
	 * Tests if listings with duplicate IDs can be adds Tests if bug is possible
	 */
	@Test
	void duplicateListingID() {
		// Same ID of 20
		listings.addListing(20, "2020 Long Drive", 0, 0, 0, 0, -400, null, false, false, false, false, false, false,
				false, false);
		listings.addListing(20, "2021 Main Street", 0, 0, 0, 0, -400, null, false, false, false, false, false, false,
				false, false);
		DataWriter.saveListings();
		ArrayList<Long> idHolding = new ArrayList<Long>();
		boolean flag = false;
		for (Listing listing : listings.getListings()) {
			idHolding.add(listing.getListingId());
			for (long item : idHolding) {
				if (listing.getListingId() == item) {
					flag = true;
				}
			}
			if (flag) {
				break;
			}
		}
		assertTrue(flag);
	}

	/**
	 * Tests if bedrooms can be recieved
	 */
	@Test
	void testBedrooms() {
		listings.addListing(50, "142 Fire Lane", 3, 0, 0, 0, 6503, null, false, false, false, false, false, false,
				false, false);
		DataWriter.saveListings();
		assertEquals(listings.getListings().get(listings.getListings().size() - 1).getBeds(), 3);
	}

	/**
	 * Tests if no Washer can be detected
	 */
	@Test
	void testNoWasher() {
		assertFalse(listings.getListings().get(listings.getListings().size() - 1).isAmenitiesDishwasher());
	}

	/**
	 * Tests if AC is in the listing
	 */
	@Test
	void testAC() {
		assertTrue(listings.getListings().get(listings.getListings().size() - 1).isAmenitiesAC());
	}

	/**
	 * Runs the print listings method
	 */
	@Test
	void printListings() {
		listings.printListings();
		assertTrue(true);
	}
}
