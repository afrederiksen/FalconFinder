import java.util.ArrayList;

public class Users {
  private static Users users = null;
  private static ArrayList<User> userList = new ArrayList<User>();

  private Users() {
    userList = DataReader.loadUser();
  }

  public static Users getInstance() {
    if (users == null) {
      users = new Users();
    }

    return users;
  }

  public ArrayList<User> getUsers() {
    return userList;
  }

  public static void addUser(String id, String firstName, String lastName, String address, String email,
      String password, String type, String favoriteListings) {
    userList.add(new User(id, firstName, lastName, address, email, password, type, favoriteListings));
    DataWriter.saveUsers();
  }
}
