import java.util.Scanner;

public class Platform {
	User user = login(String entry, String password);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	public void mainStage() {
		Scanner scan = new Scanner(System.in);
		if(!user) {
			System.out.println("Guest View:\n" + 
					"1. Login\n" + 
					"2. Register\n" + 
					"3. Search Listings");
			
		}
		if(user.getUserType(user.getUUID()) == "Leasee") {
			System.out.println("Leasee View:\n" + 
					"1. Search Listings\n" + 
					"2. View messages\n" + 
					"3. View leases\n" + 
					"4. View favorite listings\n" + 
					"5. Review Listings\n" + 
					"6. Post Sublease/Lease takeover\n" + 
					"7. View subleases\n" + 
					"8. Manage Account\n" + 
					"9. Logout\n");
		switch(scan.nextInt()) {
		case 1:
			this.searchListings();
			break;
		case 2:
			this.viewMessages();
			break;
		case 3:
			this.viewLeases();
			break;
		case 4:
			this.viewFavoriteList();
			break;
		case 5:
			this.reviewListings();
			break;
		case 6:
			this.postLease();
			break;
		case 7:
			this.viewSubleases();
			break;
		case 8:
			this.manageAccount();
			break;
		case 9:
			user.logout();
			break;
		}
		}
		
		public void viewMessages() {
			if(this.isGuest() || !(user.getUserType(user.getUUID()) == "Leasee") || !(user.getUserType(user.getUUID()) == "Landlord")) {
				System.out.println("Error: You don't have permission to do this. Maybe try logging in again?")
			}
		}
	}

}
