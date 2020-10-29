
import java.util.Scanner;

public class Platform {
	 //Login user????
	static User user;
	static Leasee leasee;
	static Landlord landlord;
	static boolean guest = true;
	public static void main(String[] args) {
		mainStage();
	}
	public static void mainStage() {
		Scanner scan = new Scanner(System.in);
		if(user == null) {
			System.out.println("Guest View:\n" + 
					"1. Login\n" + 
					"2. Register\n" + 
					"3. Search Listings");
			switch(scan.nextInt()) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				searchListings();
				break;
			default:
				System.out.println("Sorry, the choice you answered was not correct. Please try again.");
			
		}
		if(user.getType().equalsIgnoreCase("Leasee")) {
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
			searchListings();
			break;
		case 2:
			viewMessages();
			break;
		case 3:
			viewLeases();
			break;
		case 4:
			viewFavoriteList();
			break;
		case 5:
			reviewListings();
			break;
		case 6:
			postListing();
			break;
		case 7:
			viewListings();
			break;
		case 8:
			manageAccount();
			break;
		case 9:
			user.logout();
			break;
		}
		}
		else if(user.getType().equalsIgnoreCase("Landlord")) {
			System.out.println("Leasee View:\n" + 
					"1. View listings\n" + 
					"2. Post listings\n" + 
					"3. View messages\n" + 
					"4. Manage Account\n" + 
					"9. Logout\n");
		switch(scan.nextInt()) {
		case 1:
			viewListings();
			break;
		case 2:
			postListing();
			break;
		case 3:
			viewMessages();
			break;
		case 4:
			manageAccount();
			break;
		case 9:
			user.logout();
			break;
		}
		}
		if(user.getType().equalsIgnoreCase("Admin")) {
			System.out.println("Leasee View:\n" + 
					"1. User Administration\n" + 
					"2. Listing Management\n" + 
					"3. Manage Account\n" + 
					"9. Logout\n");
		switch(scan.nextInt()) {
		case 1:
			userAdministration();
			break;
		case 2:
			listingManagement();
			break;
		case 3:
			manageAccount();
			break;
		case 9:
			user.logout();
			break;
		}
		}
	}
	}
		public static void login() {
			Scanner scan = new Scanner(System.in);
			if(guest) {
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
		public static void register() {
			boolean notDone = true;
			if(guest) {
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
				System.out.println("Welcome to FalconFinder " + user.getFirstName() + "!");
			}
			else {
				System.out.println("Error passwords did not match! Try again");
			}
			}
			//Return to main stage
			mainStage();
		}
			else {
				System.out.println("You are already logged in!");
			}
		}
		public static void searchListings() {
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
				mainStage();
				break;
			}
			}
		public static void viewFavoriteList() {
			for(String fav : leasee.favoriteProperties) {
				System.out.println(fav);
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter any key to return back to the main page");
			if(!scan.nextLine().equalsIgnoreCase(null)) {
				mainStage();
			}
		}
		public static void viewListings() {
			for(Listing listing : landlord.listings) {
				System.out.println(listing);
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter any key to return back to the main page");
			if(!scan.nextLine().equalsIgnoreCase(null)) {
				mainStage();
			}
		}
		public static void userAdministration() {
			System.out.println("Enter USER ID or type exit\r\n" + 
					"	1. Change role\r\n" + 
					"	2. Suspend account\r\n" + 
					"	3. Delete account\r\n" + 
					"	4. View leases\r\n" + 
					"	5. View user data\r\n" + 
					"	9. Back to main menu");
		}
		public static void listingManagement() {
			System.out.println("1. Modify listing\n2. Create listing");
		}
		public static void reviewListings() {
			System.out.println("Which of the following properties do you wish to review?");
				fetchLeases(0, user.getLeases().size());
				//Implement user menu
				}
		public static void manageAccount() {
			{
				Scanner scan = new Scanner(System.in);
					System.out.println("Manage Account:\r\n" + 
							"	1. Edit email" + user.getEmail() + "\r\n"  +
							"	2. Change password\r\n" + 
							"	3. Terminate account\r\n" + 
							"	9. Return to main menu");
				switch(scan.nextInt()) {
				case 1:
					System.out.println("What do you want the new email to be? Send \"exit\" to quit");
					String newEmail = scan.nextLine();
					if(!newEmail.equalsIgnoreCase("exit")) {
						user.changeEmail(newEmail);
					}
					else {
						Platform.mainStage();
					}
					break;
				case 2:
					System.out.println("What is your old password? Send \"exit\" to quit");
					String oldPassword = scan.nextLine();
					if(!oldPassword.equalsIgnoreCase("exit")) {
							boolean notDone = true;
							while(notDone) {
								System.out.println("Password");
								String password = scan.nextLine();
								System.out.println("Confirm password");
								String confirmPassword = scan.nextLine();
							if(password.equals(confirmPassword)) {
								user.resetPassword(oldPassword, confirmPassword);
								notDone = false;
								System.out.println("Password was sucessfully changed !");
							}
							else {
								System.out.println("Error passwords did not match! Try again");
							}
							}
					}
					else {
						Platform.mainStage();
					}					break;
				case 3:
					System.out.println("If you wish to terminate your account please write the following\n" + 
							"\"DELETE MY ACCOUNT\"\nAny other input will bring you back to the main menu.");
					if(scan.nextLine().equals("DELETE MY ACCOUNT")) {
						System.out.println("User account terminate. Goodbye.");
						user.deleteAccount("TERMINATE");
						System.exit(0);
					}
					break;
				case 9:
					Platform.mainStage();
					break;
				}
				}
			
		}
		public static void postListing() {
			//Implement post listing based on other files...
		}
		public static void viewMessages() {
			Scanner scan = new Scanner(System.in);
			if(!(user.getType() == "Leasee") || !(user.getType() == "Landlord")) {
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
				System.out.println("Title: " + user.getMessages().get(startingWindow+(userInput-1)).getTitle());
				System.out.println("Sender: " + user.getMessages().get(startingWindow+(userInput-1)).getSender());
				System.out.println("Data: " + user.getMessages().get(startingWindow+(userInput-1)).getData());
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
		
		private static void fetchMessages(int windowStart, int howMany) {
			for(int i = 0; i<howMany; i++) {
				System.out.println((i+1)+ ". " + user.getMessages().get(windowStart+i).getSender() + " | " + user.getMessages().get(windowStart+i).getTitle());
			}
		}
//Leases
			public static void viewLeases() {
				Scanner scan = new Scanner(System.in);
				if(!(user.getType().equalsIgnoreCase("leasee") ||  !(user.getType().equalsIgnoreCase("landlord")))) {
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
					System.out.println("No leases... Returning to main menu.");
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
					System.out.println("Property: " + user.getLeases().get(startingWindow+(userInput-1)).getAddress());
					System.out.println("Duration: " + user.getLeases().get(startingWindow+(userInput-1)).getDuration());
					System.out.println("Landlord ID: " + user.getLeases().get(startingWindow+(userInput-1)).getLandlordId());
					System.out.println("Date Signed: " + user.getLeases().get(startingWindow+(userInput-1)).getDate());
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
			
			private static void fetchLeases(int windowStart, int howMany) {
				for(int i = 0; i<howMany; i++) {
					System.out.println((i+1)+ ". " + user.getLeases().get(windowStart+i).getAddress() + " | " + user.getLeases().get(windowStart + i).getDuration());
				}
}
}
