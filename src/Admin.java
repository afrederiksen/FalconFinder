
import java.util.ArrayList;

public class Admin extends User {
	
	Landlord l1 = new Landlord(0, "test", "gmail", "password", "none", "none", "none", false);
	ArrayList<Listing> listings = l1.copyList();
	ArrayList<Lease> leases = l1.copyLeases();
	ArrayList<User> users = new ArrayList<User>();
	
	public Admin(int id, String firstName, String lastName, String address, String Email, String Password, String type, boolean Suspended) {
		super(id, firstName, lastName, address, Email, Password, "none", type, Suspended, "none");
		users = new ArrayList<User>();
	}
	
	public void removeListing(int listingID) {
		for(int i = 0; i < listings.size(); i++) {
			if(listings.get(i).getListingId() == listingID) {
				listings.remove(i);
				return;
			}
		}
	}

	public void removeUser(int UUID) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getId() == UUID) {
				users.remove(i);
				return;
			}
		}
	}

	public void addUser(int id, String firstName, String lastName, String address, String email,
		      String password, String studentId, String type, boolean suspended, String favoriteListings) {
		User u1 = new User(id, firstName, lastName, address, email, password, studentId, type, suspended, favoriteListings);
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i) == null) {
				users.add(u1);
				return;
			}
		}
	}

	public void purgeLease(int leaseUUID) {
		for(int i = 0; i < leases.size(); i++) {
			if(leases.get(i).getLeaseId() == leaseUUID) {
				leases.remove(i);
				return;
			}
		}
	}

	//public void getLease(String leaseUUID) {

	//}

}
