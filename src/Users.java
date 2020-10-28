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

  public void addUser(int id, String firstName, String lastName, String address, String email,
      String password, String studentId, String type, boolean suspended, String favoriteListings) {
    userList.add(new User(id, firstName, lastName, address, email, password, studentId, type,
        suspended, favoriteListings));
    DataWriter.saveUsers();
  }
}
