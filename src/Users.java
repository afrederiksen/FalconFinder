import java.util.ArrayList;

public class Users {
  private static Users users = null;
  private static ArrayList<User> userList = new ArrayList<User>();

  private Users() {
    userList = DataReader.loadUsers();
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
}
