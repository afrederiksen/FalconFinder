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

class LeaseeTester {
	
	public Leasee leasee = new Leasee("NG", "Nick", "Garofalo", "123 Park Avenue", "email@yahoo.com", "ABC123", "", null);
	private ArrayList<Listing> leaseeFavoriteList = leasee.getFavoriteListings();
	private ArrayList<Lease> leases = leasee.getLeases();
	
	@BeforeClass
	public static void oneTimeSetup() {
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}

	@Test
	public void testValidUSCID() {
		String USCID = "P23441743";
		assertTrue(leasee.isValidUSCID(USCID));
	}
	
	@Test
	public void testLongUSCID() {
		String USCID = "Q99093266653";
		assertFalse(leasee.isValidUSCID(USCID));
	}
	
	@Test
	public void testInvalidUSCID() {
		String USCID = "123456789";
		assertFalse(leasee.isValidUSCID(USCID));
	}
	
	@Test
	public void testAddFavoriteProperty() {
		Listing listingID = new Listing(0, null, 0, 0, 0, 0, 0, null, false, false, false, false, false, false, false, false);
		leasee.addFavoriteProperty(listingID);
		assertEquals(leasee.getFavoriteListings(), listingID);
	}
	
	@Test
	public void testDeleteFavoriteProperty() {
		Listing listingID = new Listing(0, null, 0, 0, 0, 0, 0, null, false, false, false, false, false, false, false, false);
		leasee.deleteFavoriteProperty(listingID);
		assertNotEquals(leasee.getFavoriteListings(), listingID);
	}
	
}





