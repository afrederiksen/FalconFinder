import java.util.Date;

public class Lease {
	private String LeaseUUID;
	private String LandlordUUID;
	private String LeaseeUUID;
	private String CoSignerUUID;
	private Date DateSigned;
	private String property;
	private String duration;
	
	public Lease(String LeaseUUID, String LandlordUUID, String LeaseeUUID, Date DateSigned) {
		
	}
	
	public Lease(String LeaseUUID, String LandlordUUID, String LeaseeUUID, String CoSignerUUID, Date DateSigned) {
		
	}
	public String getLeaseUUID() {
		return LeaseUUID;
	}

	public void setLeaseUUID(String leaseUUID) {
		LeaseUUID = leaseUUID;
	}

	public String getLandlordUUID() {
		return LandlordUUID;
	}

	public void setLandlordUUID(String landlordUUID) {
		LandlordUUID = landlordUUID;
	}

	public String getLeaseeUUID() {
		return LeaseeUUID;
	}

	public void setLeaseeUUID(String leaseeUUID) {
		LeaseeUUID = leaseeUUID;
	}

	public String getCoSignerUUID() {
		return CoSignerUUID;
	}

	public void setCoSignerUUID(String coSignerUUID) {
		CoSignerUUID = coSignerUUID;
	}

	public Date getDateSigned() {
		return DateSigned;
	}

	public void setDateSigned(Date dateSigned) {
		DateSigned = dateSigned;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}


	
}
