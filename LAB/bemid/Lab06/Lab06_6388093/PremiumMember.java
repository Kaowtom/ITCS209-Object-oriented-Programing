import java.util.ArrayList;

public class PremiumMember extends Member {
	
	private double fe=0;
	private static double Family_FEE = 80.00;
	ArrayList<String> family = new ArrayList<String>();
	private double count =0;
	
	public PremiumMember(String em, String pa, double fee) {
		super(em, pa);
		fe = fee;
	}
	
	@Override
	public void printMemberInfo() {
		System.out.println("---- Premium MEMBER ----");
		System.out.println("Member fee: "+fe);
		super.printMemberInfo();
		if(family.size() > 0) {
			System.out.println("List of Family");
			for(int i=0; i<family.size(); i++) {
				System.out.println(family.get(i)+",");
			}
		}
	}
	
	public boolean addFamily(String username) {
		if(username!=null && count < 2) {
			count++;
			family.add(username);
			System.out.println(username+" is added successfully.");
			return true;
		}else {
			System.out.println("user: "+username+" cannot be added, the Family user is reached the limit");
			return false;
		}
	}
	public boolean removeFamily(String username) {
		if(family.contains(username)) {
			family.remove(username);
			count--;
			System.out.println(username+"is removed successfully.");
			return true;
		}else {
			System.out.println("user: " + username + "does not exist and cannot be removed.");
			return false;
		}
	}
	
	public double getMonthlyBill() {
//		System.out.println("The monthly bill: "+(Family_FEE+fe));
		return Family_FEE+fe;
	}
	
//	@Override
//	public void printMemberInfo() {
//		System.out.println("Email: "+email+" (pwd: "+password+")");
//		System.out.println("List of Video");
//		for(int i=0; i<getVdoList().size(); i++) {
//			Video ne = getVdoList().get(i);
//			System.out.print("["+(i+1)+"] "+ne.toString());
//			System.out.println("");
//		}System.out.println("---------------------");
//	}
}
