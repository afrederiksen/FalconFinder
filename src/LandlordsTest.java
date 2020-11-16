import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class LandlordsTest {
	private Landlords landlords = Landlords.getInstance();
	private ArrayList<Landlord> landlordList = landlords.getLandlords();

	@BeforeEach
	public void setup() {
		landlordList.clear();
		landlordList.add(new Landlord("asmith", "Amy", "Smith", "123 main st", "asmith@gmail.com", "password123", "Landlord" ));
		landlordList.add(new Landlord("bwhite", "Bob", "White", "224 blossom st", "bwhite@gmail.com", "Password321", "Landlord" ));
		DataWriter.saveUsers();
	}

	@AfterEach
	public void tearDown() {
		Landlords.getInstance().getLandlords().clear();
		DataWriter.saveLandlords();
	}

	@Test
	void testAddValidUser() {
		landlords.addLandlord("mjones", "Mark", "Jones", "124 blossom st", "mjones@gmail.com", "mark123", "Leasee");
		assertEquals(3, landlordList.size());
	}

	@Test
	void testAddDuplicateUser() {
		landlords.addLandlord("asmith", "Amy", "Smith", "123 main st", "asmith@gmail.com", "password123", "Landlord" );
		assertEquals(3, landlordList.size());
	}

	@Test
	void testAddUserEmpty() {
		landlords.addLandlord(" ", " ", " ", " ", " ", " ", " ");
		assertEquals(3, landlordList.size());
	}

	@Test
	void testAddUserNull() {
		landlords.addLandlord(null, null, null, null, null, null, null);
		assertEquals(3, landlordList.size());
	}
}
