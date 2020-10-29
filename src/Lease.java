public class Lease {
  private int leaseId;
  private int landlordId;
  private int leaseeId;
  private int cosignerId;
  private String date;
  private String address;
  private String duration;

  public Lease(int leaseId, int landlordId, int leaseeId, int cosignerId, String date,
      String address, String duration) {
    this.leaseId = leaseId;
    this.landlordId = landlordId;
    this.leaseeId = leaseeId;
    this.cosignerId = cosignerId;
    this.date = date;
    this.address = address;
    this.duration = duration;
  }

  /**
   * @return the leaseId
   */
  public int getLeaseId() {
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
  public int getLandlordId() {
    return landlordId;
  }

  /**
   * @param landlordId the landlordId to set
   */
  public void setLandlordId(int landlordId) {
    this.landlordId = landlordId;
  }

  /**
   * @return the leaseeId
   */
  public int getLeaseeId() {
    return leaseeId;
  }

  /**
   * @param leaseeId the leaseeId to set
   */
  public void setLeaseeId(int leaseeId) {
    this.leaseeId = leaseeId;
  }

  /**
   * @return the cosignerId
   */
  public int getCosignerId() {
    return cosignerId;
  }

  /**
   * @param cosignerId the cosignerId to set
   */
  public void setCosignerId(int cosignerId) {
    this.cosignerId = cosignerId;
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

  /**
   * @return the duration
   */
  public String getDuration() {
    return duration;
  }

  /**
   * @param duration the duration to set
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }
}
