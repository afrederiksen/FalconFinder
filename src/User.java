import java.util.ArrayList;

public class User {
	private String UUID;
	private String Email;
	private String Password;
	private boolean Suspended;
	private String type;
	private ArrayList<Messages> messages = new ArrayList<Messages>();
	private ArrayList<Lease> leases = new ArrayList<Lease>();

	
	public User(String UUID, String Email, String Password, boolean Suspended, String type) {
		this.UUID = UUID;
    		this.setEmail(Email);
   		this.Password = Password;
    		this.Suspended = Suspended;
    		this.type = type;
	}
	
	public String getUserType() {
		return this.type;
	}
	
	public boolean isSuspended() {
		return Suspended;
	}
	public ArrayList<Messages> getMessages() {
		return messages;
	}
	public ArrayList<Lease> getLeases() {
		return leases;
	}
	public void resetPassword(String oldPassword, String newPassword) {
		if(oldPassword.equals(this.Password)) {
			this.Password = newPassword;
			System.out.println("Sucessfully changed password.");
		}
		else {
			System.out.println("Error! Old password was incorrect.");
		}
	}
	
	public void changeEmail(String newEmail) {
		if(newEmail.contains("@")) {
			this.setEmail(newEmail);
		}
		else {
			System.out.println("Error! Please enter a valid email.");
		}
	}
	
	public void setUserType(String type) {
		if(type.equalsIgnoreCase("leasee")) {
			this.type = "Leasee";
		}
		else if(type.equalsIgnoreCase("landlord")) {
			this.type = "Landlord";
		}
		else if(type.equalsIgnoreCase("admin")) {
			this.type = "Admin";
		}
		else {
			System.out.println("Incorrect type!");{
			}
		}
		
	}
	
	public String getListing(String ListingID) {
		return ListingID;
	}
	
	public String getUUID() {
		return UUID;
	}

	public void logout() {
		// TODO Auto-generated method stub
		
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Object getPassword() {
		return Password;
	}

	public void deleteAccount(String terminateConfirmation) {
		if(terminateConfirmation.equals("TERMINATE")) {
			//Delete User Account
		}
		
	}
	
}

