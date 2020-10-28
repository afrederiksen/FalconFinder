import java.util.Scanner;

public class Platform {
	//Login user????
	User user = new User(null, null, null, false, null);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	public void mainStage() {
		Scanner scan = new Scanner(System.in);
		if(user == null) {
			System.out.println("Guest View:\n" + 
					"1. Login\n" + 
					"2. Register\n" + 
					"3. Search Listings");
			switch(scan.nextInt()) {
			case 1:
				this.login();
				break;
			case 2:
				this.register();
				break;
			case 3:
				this.searchListings();
				break;
			default:
				System.out.println("Sorry, the choice you answered was not correct. Please try again.");
			
		}
		if(user.getUserType().equalsIgnoreCase("Leasee")) {
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
		else if(user.getUserType().equalsIgnoreCase("Landlord")) {
			System.out.println("Leasee View:\n" + 
					"1. View listings\n" + 
					"2. Post listings\n" + 
					"3. View messages\n" + 
					"4. Manage Account\n" + 
					"9. Logout\n");
		switch(scan.nextInt()) {
		case 1:
			this.viewListings();
			break;
		case 2:
			this.postListings();
			break;
		case 3:
			this.viewMessages();
			break;
		case 4:
			this.manageAccount();
			break;
		case 9:
			user.logout();
			break;
		}
		}
		if(user.getUserType().equalsIgnoreCase("Admin")) {
			System.out.println("Leasee View:\n" + 
					"1. User Administration\n" + 
					"2. Listing Management\n" + 
					"3. Manage Account\n" + 
					"9. Logout\n");
		switch(scan.nextInt()) {
		case 1:
			this.userAdministration();
			break;
		case 2:
			this.listingManagement();
			break;
		case 3:
			this.manageAccount();
			break;
		case 9:
			user.logout();
			break;
		}
		}
	}
	}
		public void login() {
			Scanner scan = new Scanner(System.in);
			if(this.isGuest()) {
				System.out.println("Username:");
				String username = scan.nextLine();
				System.out.println("Password");
				String password = scan.nextLine();
				//HANDLE LOGIN
			}
			else {
				System.out.println("You are already logged in!");
			}
		}
		public void register() {
			boolean notDone = true;
			if(this.isGuest()) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Username:");
			String username = scan.nextLine();
			System.out.println("Email");
			String email = scan.nextLine();
			System.out.println("Landlord or Leasee?:");
			String type = scan.nextLine();
			if(type.equalsIgnoreCase("leasee")) {
				System.out.println("USCID:");
				String USCID = scan.nextLine();
			}
			while(notDone) {
				System.out.println("Password");
				String password = scan.nextLine();
				System.out.println("Confirm password");
				String confirmPassword = scan.nextLine();
			if(password.equals(confirmPassword)) {
				//USER CREATION PASS
				notDone = false;
				System.out.println("Welcome to FalconFinder " + user + "!");
			}
			else {
				System.out.println("Error passwords did not match! Try again");
			}
			}
			//Return to main stage
			this.mainStage();
		}
			else {
				System.out.println("You are already logged in!");
			}
		}
		public void searchListings() {
			Scanner scan = new Scanner(System.in);
				System.out.println("Search Listings:\n" + 
						"1. Search by title\n" + 
						"2. Seach by ammenties\n" + 
						"3. Search by price\n" + 
						"4. Search by distance\n" + 
						"9. Return to main menu\n");
			switch(scan.nextInt()) {
			case 1:
				//Search by Title
				break;
			case 2:
				//Search by amenities
				break;
			case 3:
				//Search by price;
				break;
			case 4:
				//Search by distance
				break;
			case 9:
				this.mainStage();
				break;
			}
			}
			
		public void viewMessages() {
			Scanner scan = new Scanner(System.in);
			if(!(user.getUserType() == "Leasee") || !(user.getUserType() == "Landlord")) {
				System.out.println("Error: You don't have permission to do this. Maybe try logging in again?");
			}
			int messageWindow = 0;
			int startingWindow = 0;
			if(user.getMessages().size() >= 6) {
				messageWindow = 6;
			}
			else {
				messageWindow = user.getMessages().size();
			}
			if(messageWindow == 0) {
				System.out.println("No new mail... Returning to main menu.");
				mainStage();
			}
			else {
				if(user.getMessages().size() >= 6) {
					fetchMessages(startingWindow, 6);
				}
				else {
					fetchMessages(startingWindow, user.getMessages().size());

				}
				//starting how many...
				System.out.println("7. Back a page.\n"
						+ "8. Foward a page.\n9.Return to main menu");
				int userInput = scan.nextInt();
				if(userInput >= 1 && userInput <= 6) {
				System.out.println("Title: " + user.getMessages().get(startingWindow).getTitle());
				System.out.println("Sender: " + user.getMessages().get(startingWindow).getSender());
				System.out.println("Data: " + user.getMessages().get(startingWindow));
			}
				//Go back a packge so decrecase starting window by 6 and display 6...
				else if(userInput == 7) {
					if(startingWindow>6) {
						startingWindow-=6;
						fetchMessages(startingWindow, 6);
					}
					else {
						System.out.println("Error! You don't have that many messages. You aren't thattt popular.");
					}
				}
				else if(userInput == 8) {
					if(startingWindow<messageWindow) {
						if((messageWindow-startingWindow)<6) {
							startingWindow+=(messageWindow-startingWindow);
						}
						else {
							startingWindow+=6;
						}
						fetchMessages(startingWindow, messageWindow-startingWindow);
					}
					else {
						System.out.println("Error! You don't have that many messages. You aren't thattt popular.");
					}
				}
				else if(userInput == 9) {
					mainStage();
				}
			}

			
		}
		
		private void fetchMessages(int windowStart, int howMany) {
			for(int i = 0; i<howMany; i++) {
				System.out.println((i+1)+ ". " + user.getMessages().get(windowStart+i).getSender() + " | " + user.getMessages().get(windowStart+i).getTitle());
			}
		}
//Leases
			public void viewLeases() {
				Scanner scan = new Scanner(System.in);
				if(!(user.getUserType().equalsIgnoreCase("leasee") ||  !(user.getUserType().equalsIgnoreCase("landlord")))) {
					System.out.println("Error: You don't have permission to do this. Maybe try logging in again?");
				}
				int messageWindow = 0;
				int startingWindow = 0;
				if(user.getLeases().size() >= 6) {
					messageWindow = 6;
				}
				else {
					messageWindow = user.getLeases().size();
				}
				if(messageWindow == 0) {
					System.out.println("No new mail... Returning to main menu.");
					mainStage();
				}
				else {
					if(user.getLeases().size() >= 6) {
						fetchMessages(startingWindow, 6);
					}
					else {
						fetchMessages(startingWindow, user.getLeases().size());

					}
					System.out.println("7. Back a page.\n"
							+ "8. Foward a page.\n9.Return to main menu");
					int userInput = scan.nextInt();
					if(userInput >= 1 && userInput <= 6) {
					System.out.println("Property: " + user.getLeases().get(startingWindow).getProperty());
					System.out.println("Duration: " + user.getLeases().get(startingWindow).getDuration());
					System.out.println("Landlord ID: " + user.getLeases().get(startingWindow).getLandlordUUID());
					System.out.println("Date Signed: " + user.getLeases().get(startingWindow).getDateSigned());
				}
					else if(userInput == 7) {
						if(startingWindow>6) {
							startingWindow-=6;
							fetchLeases(startingWindow, 6);
						}
						else {
							System.out.println("Error! You don't have that many leases. You aren't Trump.");
						}
					}
					else if(userInput == 8) {
						if(startingWindow<messageWindow) {
							if((messageWindow-startingWindow)<6) {
								startingWindow+=(messageWindow-startingWindow);
							}
							else {
								startingWindow+=6;
							}
							fetchLeases(startingWindow, messageWindow-startingWindow);
						}
						else {
							System.out.println("Error! You don't have that many leases. You aren't Trump.");
						}
					}
					else if(userInput == 9) {
						mainStage();
					}
				}

				
			}
			
			private void fetchLeases(int windowStart, int howMany) {
				for(int i = 0; i<howMany; i++) {
					System.out.println((i+1)+ ". " + user.getLeases().get(windowStart+i).getProperty() + " | " + user.getLeases().get(windowStart + i).getDuration());
				}
}
}
