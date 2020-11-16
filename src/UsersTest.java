import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class UsersTest {
	private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();

	@BeforeEach
	public void setup() {
		userList.clear();
		userList.add(new User("asmith", "Amy", "Smith", "123 main st", "asmith@gmail.com", "password123", "Landlord" ));
		userList.add(new User("bwhite", "Bob", "White", "224 blossom st", "bwhite@gmail.com", "Password321", "Leasee" ));
		DataWriter.saveUsers();
	}

	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}

	@Test
	void testAddValidUser() {
		users.addUser("mjones", "Mark", "Jones", "124 blossom st", "mjones@gmail.com", "mark123", "Leasee");
		assertEquals(3, userList.size());
	}

	@Test
	void testAddDuplicateUser() {
		users.addUser("asmith", "Amy", "Smith", "123 main st", "asmith@gmail.com", "password123", "Landlord" );
		assertEquals(3, userList.size());
	}

	@Test
	void testAddUserEmpty() {
		users.addUser(" ", " ", " ", " ", " ", " ", " ");
		assertEquals(3, userList.size());
	}

	@Test
	void testAddUserNull() {
		users.addUser(null, null, null, null, null, null, null);
		assertEquals(3, userList.size());
	}
}
