import java.util.ArrayList;

public class Users {
  private static Users users = null;
  public static ArrayList<User> userList = new ArrayList<User>();

  public Users() {
    userList = DataReader.loadUsers();
  }

  /**
   *returns instance of Users
  */
  public static Users getInstance() {
    if (users == null) {
      users = new Users();
    }

    return users;
  }

  /**
   *returns arrayList of users
  */
  public ArrayList<User> getUsers() {
    return userList;
  }

  /**
   *adds new User to arrayList of users
  */
  public static void addUser(String id, String firstName, String lastName, String address,
      String email, String password, String type) {
    userList.add(new User(id, firstName, lastName, address, email, password, type));
    DataWriter.saveUsers();
  }

}
