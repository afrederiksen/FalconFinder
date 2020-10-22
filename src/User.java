public class User {
	private String UUID;
	private String Email;
	private String Password;
	private boolean Suspended;
	private String type;
	
	public User(String UUID, String Email, String Password, boolean Suspended, String type) {
		this.UUID = UUID;
    		this.Email = Email;
   		this.Password = Password;
    		this.Suspended = Suspended;
    		this.type = type;
	}
	
	public String getUserType(String UUID) {
		return "";
	}
	
	public boolean isSuspended(String UUID) {
		return true;
	}
	
	public void resetPassword(String UUID, String oldPassword, String newPassword) {
		
	}
	
	public void changeEmail(String UUID, String newEmail) {
		
	}
	
	public void setUserType(String UUID, String type) {
		
	}
	
	public String getListing(String ListingID) {
		return "";
	}
	
}

