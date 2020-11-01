import java.util.ArrayList;
import java.util.Scanner;

public class Platform extends DataConstants{
	// Login user????
	static User user;
	static Leasee leasee;
	static Landlord landlord;
	static boolean guest = true;
	static Listings listings = new Listings();
	static Users users = new Users();
	static ArrayList<Listing> listingList = listings.getListings();
	static ArrayList<User> userList = users.getUsers();

	public static void main(String[] args) {
		mainStage();
	}

	public static void mainStage() {
		Scanner scan = new Scanner(System.in);
		//default values for Landlord and User
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getType().equalsIgnoreCase("Leasee")) {
				leasee = new Leasee(userList.get(i).getId(), userList.get(i).getFirstName(), userList.get(i).getLastName(), userList.get(i).getAddress(), userList.get(i).getEmail(), userList.get(i).getPassword(), userList.get(i).getType(), null);
			}
			else
			{
				landlord = new Landlord(userList.get(i).getId(), userList.get(i).getFirstName(), userList.get(i).getLastName(), userList.get(i).getAddress(), userList.get(i).getEmail(), userList.get(i).getPassword(), userList.get(i).getType());
			}
		}
		if (guest) {
			System.out.println("Guest View:\n" + "1. Login\n" + "2. Register\n" + "3. View Listings\n" + "4. Search Listings\n" + "5. Sign a Lease");
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
			case 5:
				signLease();
				break;
			default:
				System.out.println("Invalid entry please try again.");
				mainStage();

			}
			if (user != null && user.getType().equalsIgnoreCase("Leasee")) {
				System.out.println("Leasee View:\n" + "1. Search Listings\n" + "2. Sign a lease\n"
						+ "3. View favorite listings\n" + "4. Review Listings\n"
						+ "5. Manage Account\n"
						+ "9. Logout\n");
				switch (scan.nextInt()) {
				case 1:
					searchListings();
					break;
				case 2:
					signLease();
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
				System.out.println("Landlord View:\n" + "1. View listings\n" + "2. Post listings\n"
						+ "3. Manage Account\n" + "9. Logout\n");
				switch (scan.nextInt()) {
				case 1:
					viewListings();
					break;
				case 2:
					postListing();
					break;
				case 3:
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

	public static void login() {
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

	public static void register() {
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

	public static void logout() {
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

	public static void searchListings() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Search Listings:\n" + "1. Search by address\n" + "2. Seach by ammenties\n"
				+ "3. Search by price\n" + "4. Search by distance from Russ\n" + "9. Return to main menu\n");
		String searchTerm;
		Double searchPrice;
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
			// Search by amentities
			// Need enum support
			ArrayList<Listing> refinedListings = listingList;
			System.out.println("How many beds do you want");
			long beds = scan.nextLong();
			for(int i = 0; i < listingList.size(); i++) {
				if(!(beds == listingList.get(i).getBeds()))
					refinedListings.remove(listingList.get(i));
			}
			System.out.println("Do you want a washer and dryer? (y/n)");
			scan.nextLine();
			String washerStr = scan.nextLine();
			if(!(washerStr.equalsIgnoreCase("n") || washerStr.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).isAmenitiesWasher()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			}
			System.out.println("Do you want AC? (y/n)");
			String ACStr = scan.nextLine();
			if(!(ACStr.equalsIgnoreCase("n") || ACStr.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).isAmenitiesAC()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			}    	
			System.out.println("Do you want furniture? (y/n)");
			String furnitureStr = scan.nextLine();
			if(!(furnitureStr.equalsIgnoreCase("n") || furnitureStr.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).isAmenitiesFurniture()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			}
			System.out.println("Do you want a patio? (y/n)");
			String patioStr = scan.nextLine();
			if(!(patioStr.equalsIgnoreCase("n") || patioStr.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).isAmenitiesPatio()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			}
			System.out.println("Do you want a dishwasher? (y/n)");
			String dishwasherStr = scan.nextLine();
			if(!(dishwasherStr.equalsIgnoreCase("n") || dishwasherStr.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).isAmenitiesDishwasher()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			} 
			System.out.println("Do you want a place that allows pets? (y/n)");
			String AllowsPets = scan.nextLine();
			if(!(AllowsPets.equalsIgnoreCase("n") || AllowsPets.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).doesAllowPets()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			} 
			System.out.println("Do you want Wi-Fi? (y/n)");
			String WiFiStr = scan.nextLine();
			if(!(WiFiStr.equalsIgnoreCase("n") || WiFiStr.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).isAmenitiesWifi()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			} 
			System.out.println("Do you want a pool? (y/n)");
			String poolStr = scan.nextLine();
			if(!(poolStr.equalsIgnoreCase("n") || poolStr.equalsIgnoreCase("no"))) {
				for(int i = 0; i < refinedListings.size(); i++) {
					if(!refinedListings.get(i).isAmenitiesPool()) {
						refinedListings.remove(listingList.get(i));
					}
				}
			}
			if(refinedListings.size() == 0)
				System.out.println("No matching results");
			for(int i = 0; i < refinedListings.size(); i++) {
				refinedListings.get(i).printListing();
			}
			break;
		case 3:
			// Search by price;
			System.out.println("Please enter the max price you wish to search by");
			scan.nextLine();
			searchPrice = scan.nextDouble();
			for(int i = 0; i < listingList.size(); i++) {
				if(searchPrice >= listingList.get(i).getPrice())
					listingList.get(i).printListing();
			}
			break;
		case 4:
			// Search by distance
			System.out.println("Please enter the max miles from Russ you wish to search by");
			scan.nextLine();
			searchPrice = scan.nextDouble();
			for(int i = 0; i < listingList.size(); i++) {
				if(searchPrice >= listingList.get(i).getDistanceFromRussellHouse())
					listingList.get(i).printListing();
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

	public static void viewFavoriteList() {
		for (Listing listing : leasee.getFavoriteListings()) {
			System.out.println(listing.getLandlordId());
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any key to return back to the main page");
		if (!scan.nextLine().equalsIgnoreCase(null)) {
			mainStage();
		}
	}
	public static void viewListing(long listingId) {
		for (Listing listing : listings.getListings()) {
			if (listing.getListingId() == listingId) {
				System.out.println("Beds: " + listing.getBeds() + "\nAddress:" + listing.getAddress()
				+ "\nDistance from Russel House" + listing.getDistanceFromRussellHouse() + "\nRating: "
				+ listing.getRating() + "Available:" + listing.isAvailable() +  "\nAmenities:");
				System.out.println("\nWasher: "+(listing.isAmenitiesWasher() ? "Yes" : "No") + "\nAir Conditioning: "+(listing.isAmenitiesAC() ? "Yes" : "No") + "\nFurniture: "+(listing.isAmenitiesFurniture() ? "Yes" : "No") + "\nPatio: "+(listing.isAmenitiesPatio() ? "Yes" : "No") + "\nDishwasher: "+(listing.isAmenitiesDishwasher() ? "Yes" : "No") + "\nFireplace: "+(listing.doesAllowPets() ? "Yes" : "No") + "\nWi-Fi: "+(listing.isAmenitiesWifi() ? "Yes" : "No") + "\nPool: "+(listing.isAmenitiesPool() ? "Yes" : "No"));
				for (String review : listing.getReviewList()) {
					System.out.println(review);
				}
				Scanner scan = new Scanner(System.in);
				System.out.println(
						"Type \"Lease\" if you wish to lease this property or enter any key to return back to the main page");
				if (!scan.nextLine().equalsIgnoreCase("Lease")) {
					mainStage();
				}
			}
		}

	}
	public static void viewListings() {
		listings.printListings();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any key to return back to the main page");
		if (!scan.nextLine().equalsIgnoreCase(null)) {
			mainStage();
		}
	}

	public static void reviewListings() {
		System.out.println("Which of the following properties do you wish to review?");
		fetchLeases(0, leasee.getLeases().size());
		// Implement user menu
	}

	public static void manageAccount() {
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
						Platform.mainStage();
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
					Platform.mainStage();
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
					Platform.mainStage();
					break;
				default:
					System.out.println("Invalid entry please try again.");
					manageAccount();
				}
			}    	  
		}
	}



	public static void postListing() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Create a listing!\n if you wish to continue press y");
		if(scan.nextLine().equalsIgnoreCase("y")) {
			System.out.println("What is the address/title?");
			String address = scan.nextLine();
			System.out.println("How many Beds?");
			long beds = scan.nextLong();
			System.out.println("How many Bathrooms?");
			long bathrooms = scan.nextLong();
			System.out.println("What is the distance from Russell House?");
			double distanceFromRussellHouse = scan.nextDouble();
			System.out.println("What is the monthly price?");
			double price = scan.nextDouble();
			System.out.println("How many are available? (y/n)");
			long available = scan.nextLong();
			scan.nextLine();
			System.out.println("Does the unit have a washer/dryer? (y/n)");
			String washerStr = scan.nextLine();
			boolean amenitiesWasher;
			if(washerStr.equalsIgnoreCase("y") || washerStr.equalsIgnoreCase("yes")) {
				amenitiesWasher=true;
			}
			else {
				amenitiesWasher=false;
			}
			System.out.println("Does the unit have a gym? (y/n)");
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
			//Listings.getInstance();
			listingList.add(new Listing(listingList.size()+1,  address,  beds, bathrooms, distanceFromRussellHouse, price, available,  landlord.getId(),  amenitiesWasher,  amenitiesAC,
					amenitiesFurniture,  amenitiesPatio,  amenitiesDishwasher,
					amenitiesFireplace,  amenitiesWifi,  amenitiesPool));  
		}
	}

	public static void signLease() {
		Scanner scan = new Scanner(System.in);
		if(guest = false) {
			if(user.getType().equalsIgnoreCase("leasee")) {
				System.out.println("Please enter the property ID that you are interested in");
				long ID = scan.nextLong();
				for(int i = 0; i < listingList.size(); i++) {
					if(ID == listingList.get(i).getListingId()) {
						System.out.println("You are about to sign a lease for " + listingList.get(i).getAddress() + " type y to continue");
						scan.nextLine();
						String response = scan.nextLine();
						if(response.equalsIgnoreCase("y")) {
							Lease l1 = new Lease(ID, listingList.get(i).getLandlordId(), user.getId(), "10/31/20", listingList.get(i).getAddress());
							String lease = "This lease Agreement is made and entered on " + l1.getDate() + " by and between " + listingList.get(i).getLandlordId() + " and " 
									+ leasee.getFirstName() + " " + leasee.getLastName() + " " + LEASEPT1 + " " + listingList.get(i).getBeds() + " bedrooms and" + listingList.get(i).getBeds() + " bathrooms, located at " + listingList.get(i).getAddress() + " 29208.  "
									+ LEASEPT2 + " 11/1/20" + " to " + "11/1/21. \r\n" + "\r\n4.  Rent. The Tenant will pay $" + listingList.get(i).getPrice() + " each month on the first of the month.\r\n \r\n5.  Payment should be sent to: " + landlord.getAddress() + "\r\n \r\n6.  Damages. Charges will be billed to the client for damaged property, up to $5000"
									+ "\r\n \r\n7.  Signatures\n" + LEASESIGN + leasee.getFirstName() + " " + leasee.getLastName() + LEASESIGN + listingList.get(i).getLandlordId();
							DataWriter.createFile(lease);
						}
					}
				}
			}
		}
		else {
			System.out.println("You are not signed in!");
		}
	}
	// Leases
	public static void viewLeases() {
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

	private static void fetchLeases(int windowStart, int howMany) {
		if(leasee.getType().equalsIgnoreCase("leasee") ) {
			for (int i = 0; i < howMany; i++) {
				System.out.println((i + 1) + ". " + leasee.getLeases().get(windowStart + i).getAddress()
						+ " | ");
			}
		}
		else if(landlord.getType().equalsIgnoreCase("landlord") ) {
			for (int i = 0; i < howMany; i++) {
				System.out.println((i + 1) + ". " + landlord.getLeases().get(windowStart + i).getLeaseeId()
						+ " | ");
			}
		}
	}
}
