
import java.util.ArrayList;
import java.util.Scanner;

public class Platform {
  // Login user????
  static User user;
  static Leasee leasee;
  static Landlord landlord;
  static boolean guest = true;
  static ArrayList<User> userList = new ArrayList<User>();

  public static void main(String[] args) {
    mainStage();
  }

  public static void mainStage() {
    Scanner scan = new Scanner(System.in);
    if (guest) {
      System.out.println("Guest View:\n" + "1. Login\n" + "2. Register\n" + "3. Search Listings");
      switch (scan.nextInt()) {
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
      if (leasee.getType().equalsIgnoreCase("Leasee")) {
        System.out.println("Leasee View:\n" + "1. Search Listings\n" + "2. View leases\n"
            + "3. View favorite listings\n" + "4. Review Listings\n"
            + "5. Manage Account\n"
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
        }
      } else if (landlord.getType().equalsIgnoreCase("Landlord")) {
        System.out.println("Leasee View:\n" + "1. View listings\n" + "2. Post listings\n"
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
        }
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
        }
        else {
        	System.out.println("Incorrect username or password");
        }
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
          // Users.addUser(username, firstName, lastName, address, email, password, USCID, type,
          // false, null);
          userList.add(user1);
          System.out.println("Welcome to FalconFinder " + user1.getFirstName() + "!");
        } else {
          System.out.println("Error passwords did not match! Try again");
        }
      }
      // Return to main stage
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
    System.out.println("Search Listings:\n" + "1. Search by title\n" + "2. Seach by ammenties\n"
        + "3. Search by price\n" + "4. Search by distance\n" + "9. Return to main menu\n");
    String searchTerm;
    switch (scan.nextInt()) {
      case 1:
        // Search by title
        System.out.println("Please enter the title you wish to search by");
        searchTerm = scan.nextLine();
        break;
      case 2:
        // Search by amentities
        // Need enum support
        System.out.println("Please enter the amentities you wish to search for");
        searchTerm = scan.nextLine();
        break;
      case 3:
        // Search by price;
        System.out.println("Please enter the max price you wish to search by");
        searchTerm = scan.nextLine();
        break;
      case 4:
        // Search by distance
        System.out.println("Please enter the max distnace you wish to search by");
        searchTerm = scan.nextLine();
        break;
      case 9:
        mainStage();
        break;
    }
  }

  public static void viewFavoriteList() {
    for (Listing listing : leasee.getFavoriteListings()) {
      System.out.println(listing.getLandlordId() + " | " + listing.getDescription());
    }
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter any key to return back to the main page");
    if (!scan.nextLine().equalsIgnoreCase(null)) {
      mainStage();
    }
  }

  public static void viewListings() {
    for (Listing listing : landlord.listings) {
      System.out.println(listing);
    }
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
        }    	  
      }
    }

  }

  public static void postListing() {
    // Implement post listing based on other files...
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
    if(landlord.getType().equalsIgnoreCase("landlord")) {
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
