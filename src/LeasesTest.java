import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LeasesTest {

	private Leases leases = Leases.getInstance();
	private ArrayList<Lease> leaseList = leases.getLeases();
	
	@BeforeClass
	public static void oneTimeSetup() {
		
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@Test
	public void testAddLease() {
		leases.addLease(0, "NICK_GAROFALO", "Nick", "Garofalo", "123 Park Avenue");
		leaseList.add(new Lease(0, "NICK_GAROFALO", "Nick", "Garofalo", "123 Park Avenue"));
		assertEquals(leases.getLeases(), leaseList);
	}
	
	@Test
	public void testPrintingOneLease() {
		leaseList.add(new Lease(0, "NICK_GAROFALO", "Nick", "Garofalo", "123 Park Avenue"));
		DataWriter.saveLeases();
		assertEquals("NICK_GAROFALO", leaseList.contains("NICK_GAROFALO"));
	}
	
	@Test
	public void testPrintingMultipleLeases() {
		leaseList.add(new Lease(0, "NICK_GAROFALO", "Nick", "Garofalo", "123 Park Avenue"));
		leaseList.add(new Lease(0, "NICK_GAROFALO", "Nick", "Garofalo", "123 Park Avenue"));
		leaseList.add(new Lease(0, "NICK_GAROFALO", "Nick", "Garofalo", "123 Park Avenue"));
		leaseList.add(new Lease(0, "NICK_GAROFALO", "Nick", "Garofalo", "123 Park Avenue"));
		DataWriter.saveLeases();
		assertEquals("NICK_GAROFALO", leaseList.contains("NICK_GAROFALO"));
	}
	

}




