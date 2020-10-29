import java.util.ArrayList;

public class Leases {
  private static Leases leases = null;
  private static ArrayList<Lease> leaseList = new ArrayList<Lease>();

  private Leases() {
    leaseList = DataReader.loadLease();
  }

  public static Leases getInstance() {
    if (leases == null) {
      leases = new Leases();
    }

    return leases;
  }

  public ArrayList<Lease> getLeases() {
    return leaseList;
  }

  public void addLease(int leaseId, int landlordId, int leaseeId, int cosignerId, String date,
      String address, String duration) {
    leaseList.add(new Lease(leaseId, landlordId, leaseeId, cosignerId, date, address, duration));
    DataWriter.saveLeases();
  }
}
