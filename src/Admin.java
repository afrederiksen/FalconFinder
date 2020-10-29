
import java.util.ArrayList;

public class Admin extends User {
	
	Landlord l1 = new Landlord("test", "gmail", "password", false, "type");
	ArrayList<Listing> listings = l1.copyList();
	ArrayList<Lease> leases = l1.copyLeases();
	ArrayList<User> users = new ArrayList<User>();
	
	public Admin(String UUID, String Email, String Password, boolean Suspended, String type) {
		super(UUID, Email, Password, Suspended, type);
		users = new ArrayList<User>();
	}
	
	public void removeListing(int listingID) {
		for(int i = 0; i < listings.size(); i++) {
			if(listings.get(i).getListingID() == listingID) {
				listings.remove(i);
				return;
			}
		}
	}

	public void removeUser(String UUID) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUUID().equalsIgnoreCase(UUID)) {
				users.remove(i);
				return;
			}
		}
	}

	public void addUser(String UUID, String email, String password, String type) {
		User u1 = new User(UUID, email, password, false, type);
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i) == null) {
				users.add(u1);
				return;
			}
		}
	}

	public void purgeLease(String leaseUUID) {
		for(int i = 0; i < leases.size(); i++) {
			if(leases.get(i).getLeaseUUID() == leaseUUID) {
				leases.remove(i);
				return;
			}
		}
	}

	//public void getLease(String leaseUUID) {

	//}

}
