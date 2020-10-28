public class Listing {
  private int listingId;
  private String address;
  private String description;
  private double distanceFromRussellHouse;
  private String type;
  private boolean available;
  private int landlordId;
  private boolean amenitiesWasher;
  private boolean amenitiesAC;
  private boolean amenitiesFurniture;
  private boolean amenitiesPatio;
  private boolean amenitiesDishwasher;
  private boolean amenitiesFireplace;
  private boolean amenitiesWifi;
  private boolean amenitiesPool;

  public Listing(int listingId, String address, String description, double distanceFromRussellHouse,
      String type, boolean available, int landlordId, boolean amenitiesWasher, boolean amenitiesAC,
      boolean amenitiesFurniture, boolean amenitiesPatio, boolean amenitiesDishwasher,
      boolean amenitiesFireplace, boolean amenitiesWifi, boolean amenitiesPool) {
    this.listingId = listingId;
    this.address = address;
    this.description = description;
    this.distanceFromRussellHouse = distanceFromRussellHouse;
    this.type = type;
    this.available = available;
    this.landlordId = landlordId;
    this.amenitiesWasher = amenitiesWasher;
    this.amenitiesAC = amenitiesAC;
    this.amenitiesFurniture = amenitiesFurniture;
    this.amenitiesPatio = amenitiesPatio;
    this.amenitiesDishwasher = amenitiesDishwasher;
    this.amenitiesFireplace = amenitiesFireplace;
    this.amenitiesWifi = amenitiesWifi;
    this.amenitiesPool = amenitiesPool;
  }

  /**
   * @return the listingId
   */
  public int getListingId() {
    return listingId;
  }

  /**
   * @param listingId the listingId to set
   */
  public void setListingId(int listingId) {
    this.listingId = listingId;
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
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the distanceFromRussellHouse
   */
  public double getDistanceFromRussellHouse() {
    return distanceFromRussellHouse;
  }

  /**
   * @param distanceFromRussellHouse the distanceFromRussellHouse to set
   */
  public void setDistanceFromRussellHouse(double distanceFromRussellHouse) {
    this.distanceFromRussellHouse = distanceFromRussellHouse;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the available
   */
  public boolean isAvailable() {
    return available;
  }

  /**
   * @param available the available to set
   */
  public void setAvailable(boolean available) {
    this.available = available;
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
   * @return the amenitiesWasher
   */
  public boolean isAmenitiesWasher() {
    return amenitiesWasher;
  }

  /**
   * @param amenitiesWasher the amenitiesWasher to set
   */
  public void setAmenitiesWasher(boolean amenitiesWasher) {
    this.amenitiesWasher = amenitiesWasher;
  }

  /**
   * @return the amenitiesAC
   */
  public boolean isAmenitiesAC() {
    return amenitiesAC;
  }

  /**
   * @param amenitiesAC the amenitiesAC to set
   */
  public void setAmenitiesAC(boolean amenitiesAC) {
    this.amenitiesAC = amenitiesAC;
  }

  /**
   * @return the amenitiesFurniture
   */
  public boolean isAmenitiesFurniture() {
    return amenitiesFurniture;
  }

  /**
   * @param amenitiesFurniture the amenitiesFurniture to set
   */
  public void setAmenitiesFurniture(boolean amenitiesFurniture) {
    this.amenitiesFurniture = amenitiesFurniture;
  }

  /**
   * @return the amenitiesPatio
   */
  public boolean isAmenitiesPatio() {
    return amenitiesPatio;
  }

  /**
   * @param amenitiesPatio the amenitiesPatio to set
   */
  public void setAmenitiesPatio(boolean amenitiesPatio) {
    this.amenitiesPatio = amenitiesPatio;
  }

  /**
   * @return the amenitiesDishwasher
   */
  public boolean isAmenitiesDishwasher() {
    return amenitiesDishwasher;
  }

  /**
   * @param amenitiesDishwasher the amenitiesDishwasher to set
   */
  public void setAmenitiesDishwasher(boolean amenitiesDishwasher) {
    this.amenitiesDishwasher = amenitiesDishwasher;
  }

  /**
   * @return the amenitiesFireplace
   */
  public boolean isAmenitiesFireplace() {
    return amenitiesFireplace;
  }

  /**
   * @param amenitiesFireplace the amenitiesFireplace to set
   */
  public void setAmenitiesFireplace(boolean amenitiesFireplace) {
    this.amenitiesFireplace = amenitiesFireplace;
  }

  /**
   * @return the amenitiesWifi
   */
  public boolean isAmenitiesWifi() {
    return amenitiesWifi;
  }

  /**
   * @param amenitiesWifi the amenitiesWifi to set
   */
  public void setAmenitiesWifi(boolean amenitiesWifi) {
    this.amenitiesWifi = amenitiesWifi;
  }

  /**
   * @return the amenitiesPool
   */
  public boolean isAmenitiesPool() {
    return amenitiesPool;
  }

  /**
   * @param amenitiesPool the amenitiesPool to set
   */
  public void setAmenitiesPool(boolean amenitiesPool) {
    this.amenitiesPool = amenitiesPool;
  }
}
