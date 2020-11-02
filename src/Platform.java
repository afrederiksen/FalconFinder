
import java.util.ArrayList;
import java.util.Scanner;

public class Platform {
	// Login user????
	static User user;
	static Leasee leasee;
	static Landlord landlord;
	static boolean guest = true;
	static Listings listings = new Listings();
	static Users users = new Users();
	static ArrayList<Listing> listingList = listings.getListings();
	static ArrayList<User> userList = users.getUsers();
/**
 * Main runner (calls mainstage)
 * @param args
 */
	public static void main(String[] args) {
		mainStage();
	}
/**
 * Mainstage uses three role based UI interactions.
 * Each feature calls another method which also uses role based calls.
 * Guest: When a user is not logged in. They can Login, Register, View Listings, and Search Listings
 * Leasee: When a user has the type "Leasee" They can Search listings, View leases, View favorite listings, Review listings, Manage account, and logout.
 * Landlord: When a user has the type "Landlord" They can view listings, view leases, manage account, and logout 
 */
	private static void mainStage() {
		Scanner scan = new Scanner(System.in);
		if (guest) {
			System.out.println("Guest view:\n" + "1. Login\n" + "2. Register\n" + "3. View listings\n" + "4. Search listings");
			switch (scan.nextInt()) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				viewListings();
				break;
			case 4:
				searchListings();
				break;
			default:
				System.out.println("Invalid entry please try again.");
				mainStage();

			}
			if (user != null && user.getType().equalsIgnoreCase("Leasee")) {
				System.out.println("Leasee view:\n" + "1. Search listings\n" + "2. View leases\n"
						+ "3. View favorite listings\n" + "4. Review listings\n"
						+ "5. Manage account\n"
						+ "9. Logout\n");
				switch (scan.nextInt()) {
				case 1:
					searchListings();
					break;
				case 2:
					viewLeases();
					break;
				case 3:
					viewFavoriteList();
					break;
				case 4:
					reviewListings();
					break;
				case 5:
					manageAccount();
					break;
				case 9:
					logout();
					break;
				default:
					System.out.println("Invalid entry please try again.");
					mainStage();
				}
			} else if (user != null && user.getType().equalsIgnoreCase("Landlord")) {
				System.out.println("Landlord view:\n" + "1. View listings\n" + "2. Post listings\n"
						+ "3. View leases\n" +  "+4. Manage account\n9. Logout\n");
				switch (scan.nextInt()) {
				case 1:
					viewListings();
					break;
				case 2:
					postListing();
					break;
				case 3:
					viewLeases();
					break;
				case 4:
					manageAccount();
					break;
				case 9:
					logout();
					break;
				default:
					System.out.println("Invalid entry please try again.");
					mainStage();
				}
			}
			else {
				mainStage();
			}
		}
	}
/**
 * Login method:
 * Checks if the user is a guest (avoid repeat logins)
 * Takes username and password and checks the user list, determines their type ands then creates the respective object (leasee/landlord)
 */
	private static void login() {
		Scanner scan = new Scanner(System.in);
		if (guest) {
			System.out.println("Username:");
			String username = scan.nextLine();
			System.out.println("Password");
			String password = scan.nextLine();
			// HANDLE LOGIN
			for (int i = 0; i < userList.size(); i++) {
				if ((userList.get(i).getId().equals(username))
						&& (userList.get(i).getPassword().equals(password))) {
					user = userList.get(i);
					if(user.getType().equalsIgnoreCase("Leasee"))
						leasee = new Leasee(user.getId(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getEmail(), user.getPassword(), user.getType(), null);
					else if(user.getType().equalsIgnoreCase("Landlord"))
						landlord = new Landlord(user.getId(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getEmail(), user.getPassword(), user.getType());
					guest = false;
				}
			}
			if(guest) {
				System.out.println("Incorrect username or password");
			}
		} else {
			System.out.println("You are already logged in!");
		}
		guest = false;
	}
/**
 * Take user information, confirms password and creates a user on the user list.
 */
	private static void register() {
		boolean notDone = true;
		if (guest) {
			Scanner scan = new Scanner(System.in);
			System.out.println("First Name:");
			String firstName = scan.nextLine();
			System.out.println("Last Name:");
			String lastName = scan.nextLine();
			System.out.println("Address:");
			String address = scan.nextLine();
			System.out.println("Username:");
			String username = scan.nextLine();
			System.out.println("Email");
			String email = scan.nextLine();
			System.out.println("Landlord or Leasee?:");
			String type = scan.nextLine();
			while (notDone) {
				System.out.println("Password");
				String password = scan.nextLine();
				System.out.println("Confirm password");
				String confirmPassword = scan.nextLine();
				if (password.equals(confirmPassword)) {
					// USER CREATION PASS
					notDone = false;
					User user1 = new User(username, firstName, lastName, address, email, password, type);
					userList.add(user1);
					System.out.println("Welcome to FalconFinder " + user1.getFirstName() + "!");
				} else {
					System.out.println("Error passwords did not match! Try again");
				}
			}
			// Return to main stage
			System.out.println("You may now log in!");
			mainStage();
		} else {
			System.out.println("You are already logged in!");
		}
	}
/**
 * Sets guest to true and sets the user object to null
 */
	private static void logout() {
		if (!guest) {
			user = null;
			guest = true;
			System.out.println("Logout Successful, Returning to Guest View...");
		}

		else {
			System.out.println("You are not logged in!");
		}
		// Return to main stage
		mainStage();
	}
/**
 * Search listings has searching by address, ammentities, price, distance from russel house, and description search
 */
	private static void searchListings() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Search Listings:\n1. Search by address\n2. Seach by ammenties\n3. Search by price\n4. Search by distance from Russel House\n5. Search by description \n9. Return to main menu\n");
		String searchTerm;
		Double searchVal;
		switch (scan.nextInt()) {
		case 1:
			// Search by title
			System.out.println("Please enter the address you wish to search for");
			scan.nextLine();
			searchTerm = scan.nextLine();
			for(int i = 0; i < listingList.size(); i++) {
				if(searchTerm.equalsIgnoreCase(listingList.get(i).getAddress()))
					listingList.get(i).printListing();
			}
			break;
		case 2:
			System.out.println("Please enter an amenitity you wish to search for");
			ArrayList<Listing> refinedListings = listings.getListings();
			System.out.println("Do you want a washer? (y/n)");
			String washerStr = scan.nextLine();
			if(!(washerStr.equalsIgnoreCase("y") || washerStr.equalsIgnoreCase("yes"))) {
				for(Listing listing : refinedListings) {
					if(listing.isAmenitiesWasher()) {
						refinedListings.remove(listing);
					}
				}
			}
			System.out.println("Do you want AC? (y/n)");
			String ACStr = scan.nextLine();
			if(!(ACStr.equalsIgnoreCase("y") || ACStr.equalsIgnoreCase("yes"))) {
				for(Listing listing : refinedListings) {
					if(listing.isAmenitiesAC()) {
						refinedListings.remove(listing);
					}
				}
			}    	
			System.out.println("Do you want furniture? (y/n)");
			String furnitureStr = scan.nextLine();
			if(!(furnitureStr.equalsIgnoreCase("y") || furnitureStr.equalsIgnoreCase("yes"))) {
			for(Listing listing : refinedListings) {
				if(listing.isAmenitiesFurniture()) {
					refinedListings.remove(listing);
				}
			}
			}
			System.out.println("Do you want a patio? (y/n)");
			String patioStr = scan.nextLine();
			if(!(patioStr.equalsIgnoreCase("y") || patioStr.equalsIgnoreCase("yes"))) {
				for(Listing listing : refinedListings) {
					if(listing.isAmenitiesPatio()) {
						refinedListings.remove(listing);
					}
				}
			}
			System.out.println("Do you want a dishwasher? (y/n)");
			String dishwasherStr = scan.nextLine();
			if(!(dishwasherStr.equalsIgnoreCase("y") || dishwasherStr.equalsIgnoreCase("yes"))) {
				for(Listing listing : refinedListings) {
					if(listing.isAmenitiesDishwasher()) {
						refinedListings.remove(listing);
					}
				}
			} 
			System.out.println("Do you want a fireplace? (y/n)");
			String FirePlaceStr = scan.nextLine();
			if(!(FirePlaceStr.equalsIgnoreCase("y") || FirePlaceStr.equalsIgnoreCase("yes"))) {
				for(Listing listing : refinedListings) {
					if(listing.isAmenitiesFireplace()) {
						refinedListings.remove(listing);
					}
				}
			} 
			System.out.println("Do you want Wi-Fi? (y/n)");
			String WiFiStr = scan.nextLine();
			if(!(WiFiStr.equalsIgnoreCase("y") || WiFiStr.equalsIgnoreCase("yes"))) {
				for(Listing listing : refinedListings) {
					if(listing.isAmenitiesFurniture()) {
						refinedListings.remove(listing);
					}
				}
			} 
			System.out.println("Do you want a pool? (y/n)");
			String poolStr = scan.nextLine();
			if(!(poolStr.equalsIgnoreCase("y") || poolStr.equalsIgnoreCase("yes"))) {
				for(Listing listing : refinedListings) {
					if(listing.isAmenitiesFurniture()) {
						refinedListings.remove(listing);
					}
				}
			}
			for(Listing listing : refinedListings) {
				listing.printListing();
			}
			break;
		case 3:
			// Search by price;
			System.out.println("Please enter the max price you wish to search by");
			scan.nextLine();
			searchVal = scan.nextDouble();
			for(int i = 0; i < listingList.size(); i++) {
				if(searchVal >= listingList.get(i).getPrice())
					listingList.get(i).printListing();
			}
			break;
		case 4:
			// Search by distance
			System.out.println("Please enter the max miles from Russ you wish to search by");
			scan.nextLine();
			searchVal = scan.nextDouble();
			for(int i = 0; i < listingList.size(); i++) {
				if(searchVal >= listingList.get(i).getDistanceFromRussellHouse())
					listingList.get(i).printListing();
			}
			break;
		case 5:
			System.out.println("Enter search terms:");
			scan.nextLine();
			String searchDesc = scan.nextLine();
			for(Listing listing : listingList) {
				if(listing.getDescription().contains(searchDesc)) {
					listing.printListing();
				}
			}
			break;
		case 9:
			mainStage();
			break;
		default:
			System.out.println("Invalid entry please try again.");
			searchListings();
		}
	}
/**
 * Calls user's favorite list and prints out information about them
 */
	private static void viewFavoriteList() {
		for (Listing listing : leasee.getFavoriteListings()) {
			listing.printListing();
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any key to return back to the main page");
		if (!scan.nextLine().equalsIgnoreCase(null)) {
			mainStage();
		}
	}
/**
 * View listing prints out information specific to the listingID call
 * @param listingId
 */
	private static void viewListing(long listingId) {
		for (Listing listing : listings.getListings()) {
			if (listing.getListingId() == listingId) {
				System.out.println("Description: " + listing.getDescription() + "\nAddress:" + listing.getAddress()
						+ "\nDistance from Russel House" + listing.getDistanceFromRussellHouse() + "Available:" + (listing.isAvailable() ? "Yes" : "No") +  "\nAmenities:");
				System.out.println("\nWasher: "+(listing.isAmenitiesWasher() ? "Yes" : "No") + "\nAir Conditioning: "+(listing.isAmenitiesAC() ? "Yes" : "No") + "\nFurniture: "+(listing.isAmenitiesFurniture() ? "Yes" : "No") + "\nPatio: "+(listing.isAmenitiesPatio() ? "Yes" : "No") + "\nDishwasher: "+(listing.isAmenitiesDishwasher() ? "Yes" : "No") + "\nFireplace: "+(listing.isAmenitiesFireplace() ? "Yes" : "No") + "\nWi-Fi: "+(listing.isAmenitiesWifi() ? "Yes" : "No") + "\nPool: "+(listing.isAmenitiesPool() ? "Yes" : "No") + "\nReviews: ");
				ArrayList<Review> reviews = listing.getReviews();
				for (int i = 0; i < reviews.size(); i++) {
					System.out.println("    Leasee: " + reviews.get(i).getLeaseeId() +"\n    Review: " + reviews.get(i).getReview() + "\n    Rating (Out of 5): " + reviews.get(i).getRating());
				}
				Scanner scan = new Scanner(System.in);
				System.out.println(
						"Type \"Lease\" if you wish to lease this property or enter any key to return back to the main page");
				if (!scan.nextLine().equalsIgnoreCase("Lease")) {
				//This is where we should execute the lease call...
					mainStage();
				}
			}
		}

	}
/**
 * View all the listings
 */
	private static void viewListings() {
		listings.printListings();
		Scanner scan = new Scanner(System.in);
		if(guest) {
			System.out.println("Note: You must login to lease.");
		}
		System.out.println("Enter any key to return back to the main page");
		if (!scan.nextLine().equalsIgnoreCase(null)) {
			mainStage();
		}
	}
/**
 * Review the listings
 */
	private static void reviewListings() {
		System.out.println("Which of the following properties do you wish to review?");
		fetchLeases(0, leasee.getLeases().size());
		// Implement user menu
	}
/**
 * Manage account allows for email and password changes and account deletion
 */
	private static void manageAccount() {
		{
			Scanner scan = new Scanner(System.in);

			if(leasee.getType().equalsIgnoreCase("leasee")) {
				System.out.println("Manage Account:\r\n" + "	1. Edit email (" + leasee.getEmail() + ")\r\n"
						+ "	2. Change password\r\n" + "	3. Terminate account\r\n"
						+ "	9. Return to main menu");
				switch (scan.nextInt()) {
				case 1:
					System.out.println("What do you want the new email to be? Send \"exit\" to quit");
					String newEmail = scan.nextLine();
					if (!newEmail.equalsIgnoreCase("exit")) {
						leasee.changeEmail(newEmail);
					} else {
						Platform.mainStage();
					}
					break;
				case 2:
					System.out.println("What is your old password? Send \"exit\" to quit");
					String oldPassword = scan.nextLine();
					if (!oldPassword.equalsIgnoreCase("exit")) {
						boolean notDone = true;
						while (notDone) {
							System.out.println("Password");
							String password = scan.nextLine();
							System.out.println("Confirm password");
							String confirmPassword = scan.nextLine();
							if (password.equals(confirmPassword)) {
								leasee.resetPassword(oldPassword, confirmPassword);
								notDone = false;
								System.out.println("Password was sucessfully changed !");
							} else {
								System.out.println("Error passwords did not match! Try again");
							}
						}
					} else {
						mainStage();
					}
					break;
				case 3:
					System.out.println("If you wish to terminate your account please write the following\n"
							+ "\"DELETE MY ACCOUNT\"\nAny other input will bring you back to the main menu.");
					if (scan.nextLine().equals("DELETE MY ACCOUNT")) {
						System.out.println("User account terminate. Goodbye.");
						leasee.deleteAccount("TERMINATE");
						System.exit(0);
					}
					break;
				case 9:
					mainStage();
					break;
				default:
					System.out.println("Invalid entry please try again.");
					manageAccount();
				}
			}
			else if(landlord.getType().equalsIgnoreCase("landlord")) {
				System.out.println("Manage Account:\r\n" + "	1. Edit email (" + landlord.getEmail() + ")\r\n"
						+ "	2. Change password\r\n" + "	3. Terminate account\r\n"
						+ "	9. Return to main menu");
				switch (scan.nextInt()) {
				case 1:
					System.out.println("What do you want the new email to be? Send \"exit\" to quit");
					String newEmail = scan.nextLine();
					if (!newEmail.equalsIgnoreCase("exit")) {
						landlord.changeEmail(newEmail);
					} else {
						Platform.mainStage();
					}
					break;
				case 2:
					System.out.println("What is your old password? Send \"exit\" to quit");
					String oldPassword = scan.nextLine();
					if (!oldPassword.equalsIgnoreCase("exit")) {
						boolean notDone = true;
						while (notDone) {
							System.out.println("Password");
							String password = scan.nextLine();
							System.out.println("Confirm password");
							String confirmPassword = scan.nextLine();
							if (password.equals(confirmPassword)) {
								landlord.resetPassword(oldPassword, confirmPassword);
								notDone = false;
								System.out.println("Password was sucessfully changed !");
							} else {
								System.out.println("Error passwords did not match! Try again");
							}
						}
					} else {
						Platform.mainStage();
					}
					break;
				case 3:
					System.out.println("If you wish to terminate your account please write the following\n"
							+ "\"DELETE MY ACCOUNT\"\nAny other input will bring you back to the main menu.");
					if (scan.nextLine().equals("DELETE MY ACCOUNT")) {
						System.out.println("User account terminate. Goodbye.");
						landlord.deleteAccount("TERMINATE");
						System.exit(0);
					}
					break;
				case 9:
					mainStage();
					break;
				default:
					System.out.println("Invalid entry please try again.");
					manageAccount();
				}
			}    	  
		}
	}
/**
 * Post a listing using address, description, distance from Russell house, monthly rent price, availability, and all of the amenities
 */


	private static void postListing() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Create a listing!\n if you wish to continue press y");
		if(scan.nextLine().equalsIgnoreCase("y")) {
			System.out.println("What is the address?");
			String address = scan.nextLine();
			System.out.println("What is the description?");
			String description = scan.nextLine();
			System.out.println("What is the distance from Russell House?");
			double distanceFromRussellHouse = scan.nextDouble();
			System.out.println("What is the monthly price?");
			double price = scan.nextDouble();
			System.out.println("Is it available? (y/n)");
			String availableStr = scan.nextLine();
			scan.nextLine();
			boolean available;
			if(availableStr.equalsIgnoreCase("y") || availableStr.equalsIgnoreCase("yes"))
				available=true;
			else {
				available=false;
			}
			System.out.println("Does the unit have a washer? (y/n)");
			String washerStr = scan.nextLine();
			boolean amenitiesWasher;
			if(washerStr.equalsIgnoreCase("y") || washerStr.equalsIgnoreCase("yes")) {
				amenitiesWasher=true;
			}
			else {
				amenitiesWasher=false;
			}
			System.out.println("Does the unit have AC? (y/n)");
			String ACStr = scan.nextLine();
			boolean amenitiesAC;
			if(ACStr.equalsIgnoreCase("y") || ACStr.equalsIgnoreCase("yes")) {
				amenitiesAC=true;
			}
			else {
				amenitiesAC=false;
			}    	
			System.out.println("Does the unit have furniture? (y/n)");
			String furnitureStr = scan.nextLine();
			boolean amenitiesFurniture;
			if(furnitureStr.equalsIgnoreCase("y") || furnitureStr.equalsIgnoreCase("yes")) {
				amenitiesFurniture=true;
			}
			else {
				amenitiesFurniture=false;
			} 
			System.out.println("Does the unit have a patio? (y/n)");
			String patioStr = scan.nextLine();
			boolean amenitiesPatio;
			if(patioStr.equalsIgnoreCase("y") || patioStr.equalsIgnoreCase("yes")) {
				amenitiesPatio=true;
			}
			else {
				amenitiesPatio=false;
			} 
			System.out.println("Does the unit have a dishwasher? (y/n)");
			String dishwasherStr = scan.nextLine();
			boolean amenitiesDishwasher;
			if(dishwasherStr.equalsIgnoreCase("y") || dishwasherStr.equalsIgnoreCase("yes")) {
				amenitiesDishwasher=true;
			}
			else {
				amenitiesDishwasher=false;
			} 
			System.out.println("Does the unit have a fireplace? (y/n)");
			String FirePlaceStr = scan.nextLine();
			boolean amenitiesFireplace;
			if(FirePlaceStr.equalsIgnoreCase("y") || FirePlaceStr.equalsIgnoreCase("yes")) {
				amenitiesFireplace=true;
			}
			else {
				amenitiesFireplace=false;
			} 
			System.out.println("Does the unit have Wi-Fi? (y/n)");
			String WiFiStr = scan.nextLine();
			boolean amenitiesWifi;
			if(WiFiStr.equalsIgnoreCase("y") || WiFiStr.equalsIgnoreCase("yes")) {
				amenitiesWifi=true;
			}
			else {
				amenitiesWifi=false;
			} 
			System.out.println("Does the unit have a pool? (y/n)");
			String poolStr = scan.nextLine();
			boolean amenitiesPool;
			if(poolStr.equalsIgnoreCase("y") || poolStr.equalsIgnoreCase("yes")) {
				amenitiesPool=true;
			}
			else {
				amenitiesPool=false;
			} 
			ArrayList<Review> reviews = new ArrayList<Review>();
			//Listings.getInstance();
			landlord.postListing(0,  address,  description,  distanceFromRussellHouse, price, available,  landlord.getId(),  amenitiesWasher,  amenitiesAC,
					amenitiesFurniture,  amenitiesPatio,  amenitiesDishwasher,
					amenitiesFireplace,  amenitiesWifi,  amenitiesPool, reviews);  
		}
	}

	/**
	 * View leases method, prints it in user friendly pagination
	 */
	private static void viewLeases() {
		Scanner scan = new Scanner(System.in);
		if (guest) {
			System.out.println("Error: You don't have permission to do this. Maybe try logging in again?");
		}
		if(leasee.getType().equalsIgnoreCase("leasee")) {
			int messageWindow = 0;
			int startingWindow = 0;
			if (leasee.getLeases().size() >= 6) {
				messageWindow = 6;
			} else {
				messageWindow = leasee.getLeases().size();
			}
			if (messageWindow == 0) {
				System.out.println("No leases... Returning to main menu.");
				mainStage();
			} else {
				if (leasee.getLeases().size() >= 6) {
					fetchLeases(startingWindow, 6);
				} else {
					fetchLeases(startingWindow, leasee.getLeases().size());

				}
				System.out.println("7. Back a page.\n" + "8. Foward a page.\n9.Return to main menu");
				int userInput = scan.nextInt();
				if (userInput >= 1 && userInput <= 6) {
					System.out.println(
							"Property: " + leasee.getLeases().get(startingWindow + (userInput - 1)).getAddress());
					System.out.println(
							"Duration: " + leasee.getLeases().get(startingWindow + (userInput - 1)).getDuration());
					System.out.println("Landlord ID: "
							+ leasee.getLeases().get(startingWindow + (userInput - 1)).getLandlordId());
					System.out.println(
							"Date Signed: " + leasee.getLeases().get(startingWindow + (userInput - 1)).getDate());
				} else if (userInput == 7) {
					if (startingWindow > 6) {
						startingWindow -= 6;
						fetchLeases(startingWindow, 6);
					} else {
						System.out.println("Error! You don't have that many leases. You aren't Trump.");
					}
				} else if (userInput == 8) {
					if (startingWindow < messageWindow) {
						if ((messageWindow - startingWindow) < 6) {
							startingWindow += (messageWindow - startingWindow);
						} else {
							startingWindow += 6;
						}
						fetchLeases(startingWindow, messageWindow - startingWindow);
					} else {
						System.out.println("Error! You don't have that many leases. You aren't Trump.");
					}
				} else if (userInput == 9) {
					mainStage();
				}
			}
		}
		else if(landlord.getType().equalsIgnoreCase("landlord")) {
			int messageWindow = 0;
			int startingWindow = 0;
			if (landlord.getLeases().size() >= 6) {
				messageWindow = 6;
			} else {
				messageWindow = landlord.getLeases().size();
			}
			if (messageWindow == 0) {
				System.out.println("No leases... Returning to main menu.");
				mainStage();
			} else {
				if (landlord.getLeases().size() >= 6) {
					fetchLeases(startingWindow, 6);
				} else {
					fetchLeases(startingWindow, landlord.getLeases().size());

				}
				System.out.println("7. Back a page.\n" + "8. Foward a page.\n9.Return to main menu");
				int userInput = scan.nextInt();
				if (userInput >= 1 && userInput <= 6) {
					System.out.println(
							"Leasee ID: " + landlord.getLeases().get(startingWindow + (userInput - 1)).getLeaseeId());
					System.out.println(
							"Duration: " + landlord.getLeases().get(startingWindow + (userInput - 1)).getDuration());
					System.out.println("Date Signed: " + landlord.getLeases().get(startingWindow + (userInput - 1)).getDate());
				} else if (userInput == 7) {
					if (startingWindow > 6) {
						startingWindow -= 6;
						fetchLeases(startingWindow, 6);
					} else {
						System.out.println("Error! You don't have that many leases. You aren't Trump.");
					}
				} else if (userInput == 8) {
					if (startingWindow < messageWindow) {
						if ((messageWindow - startingWindow) < 6) {
							startingWindow += (messageWindow - startingWindow);
						} else {
							startingWindow += 6;
						}
						fetchLeases(startingWindow, messageWindow - startingWindow);
					} else {
						System.out.println("Error! You don't have that many leases. You aren't Trump.");
					}
				} else if (userInput == 9) {
					mainStage();
				}
			}
		}
	}
/**
 * Fetches the leases
 * For leasees, prints address and duration
 * For landlords, prints out leaseID and duration
 * @param windowStart
 * @param howMany
 */
	private static void fetchLeases(int windowStart, int howMany) {
		if(leasee.getType().equalsIgnoreCase("leasee") ) {
			for (int i = 0; i < howMany; i++) {
				System.out.println((i + 1) + ". " + leasee.getLeases().get(windowStart + i).getAddress()
						+ " | " + leasee.getLeases().get(windowStart + i).getDuration());
			}
		}
		else if(landlord.getType().equalsIgnoreCase("landlord") ) {
			for (int i = 0; i < howMany; i++) {
				System.out.println((i + 1) + ". " + landlord.getLeases().get(windowStart + i).getLeaseeId()
						+ " | " + landlord.getLeases().get(windowStart + i).getDuration());
			}
		}
	}
}
