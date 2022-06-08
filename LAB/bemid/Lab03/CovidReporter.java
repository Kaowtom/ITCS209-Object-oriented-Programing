//import java.util.Scanner;
public class CovidReporter {
//	String d = "2021-02-03";
//	String l = "THAILAND";
//	int a = 20454;
//	int c = 13217;
//	int de = 79;
	public static void main(String[]args) {
//		Scanner k = new Scanner(System.in);
//		String dat = k.nextLine();
//		String loc = k.nextLine();
//		int acc = k.nextInt();
//		int cur = k.nextInt();
//		int dea = k.nextInt();
		String d = "2021-02-03";
		String l = "Brazil";
		int a = 9283418	;
		int c = 8258074;
		int de = 226309;
//		k.close();
		
		CovidProfile p = new CovidProfile();
		p.setDate("2021-02-03");
		p.setLocation("THAILAND");
		p.setAccCases(20454);
		p.setCuredCases(13217);
		p.setDeathCases(79);
		p.printCovidinfo();
		
		CovidProfile o = new CovidProfile(d, l, a, c, de);
		o.printCovidinfo();
		System.out.println("total covid proflie: "+ (CovidProfile.number));
	}
}
