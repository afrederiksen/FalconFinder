public class Lease {
  private long leaseId;
  private String landlordId;
  private String leaseeId;
  private String date;
  private String address;

  public Lease(long leaseId, String landlordId, String leaseeId, String date, String address) {
    this.leaseId = leaseId;
    this.landlordId = landlordId;
    this.leaseeId = leaseeId;
    this.date = date;
    this.address = address;
  }

  /**
   * @return the leaseId
   */
  public long getLeaseId() {
    return leaseId;
  }

  /**
   * @param leaseId the leaseId to set
   */
  public void setLeaseId(int leaseId) {
    this.leaseId = leaseId;
  }

  /**
   * @return the landlordId
   */
  public String getLandlordId() {
    return landlordId;
  }

  /**
   * @param landlordId the landlordId to set
   */
  public void setLandlordId(String landlordId) {
    this.landlordId = landlordId;
  }

  /**
   * @return the leaseeId
   */
  public String getLeaseeId() {
    return leaseeId;
  }

  /**
   * @param leaseeId the leaseeId to set
   */
  public void setLeaseeId(String leaseeId) {
    this.leaseeId = leaseeId;
  }

  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }

  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }
  
}
