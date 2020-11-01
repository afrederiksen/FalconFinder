import java.util.ArrayList;

public class Leases {
  private static Leases leases = null;
  private static ArrayList<Lease> leaseList = new ArrayList<Lease>();

  public Leases() {
    leaseList = DataReader.loadLeases();
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

  public void addLease(int leaseId, String landlordId, String leaseeId, String date, String address) {
    leaseList.add(new Lease(leaseId, landlordId, leaseeId, date, address));
    DataWriter.saveLeases();
  }
  
  public void printLeases() {
	  for(int i = 0; i < leaseList.size(); i ++) {
		  System.out.println("Lease " + i + ":");
		  System.out.println(leaseList.get(i).getDate());
		  System.out.println(leaseList.get(i).getAddress());
	  }  
  }
}
