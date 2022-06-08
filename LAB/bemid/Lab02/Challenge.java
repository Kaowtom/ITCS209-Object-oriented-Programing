import java.util.Scanner;
public class Challenge {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String en = k.nextLine();
		String le = k.nextLine();
		k.close();
		printParkingDuration(en, le);
	}
	public static void printParkingDuration(String enterTime, String leaveTime){
		int hour, min, count=0, on=0;
		int h1, h2, n=0;
		/*/if(be>af) {
			System.out.print("(overnight)");
			on = 1;
		}/*/
		int be=Integer.parseInt(enterTime);
		int af=Integer.parseInt(leaveTime);
		System.out.print("Entering time -> "+enterTime);
		System.out.println("");
		System.out.print("Leaving time  -> "+leaveTime);
		if(be>af) {
			System.out.print(" (overnight)");
			on = 1;
		}System.out.println("");
		if(on==0) {
			h1 = be / 100;
			//System.out.println(h1);
			h2 = af / 100;
			n = (h2-h1)*60;
			n = n + ((af-(h2*100)) - (be-(h1*100)));
		}else {
			int t1=(be/100)*60;
			//System.out.println(t1);
			h1 = 1440-(t1 + (be - ((be/100)*100)));
			//System.out.println(t1);
			int t2 = (af/100)*60;
			h2 = t2 + af-((af/100)*100);
			//System.out.println(h2);
			n=h1+h2;
		}
		//System.out.println(n);
		hour = n/60;
		min = n - hour*60;
		System.out.println("Total duration: "+ hour+" hours and "+min+ " minutes");
		System.out.println("");
		
		for(int i=0; i<(hour+1); i++) {
			for(int l=0; l<60; l++) {
				if((l)%10==0||l==0){
					System.out.print("|");
				}
				if(count < n) {
					System.out.print("-");
				}else {
					System.out.print(" ");
				}count++;
			}//System.out.println(" "+ (i+1) +" hr");
			if(i<hour) {
				System.out.print(" "+ (i+1) +" hr");
			}else {
				System.out.print(" "+ min +" min");
			}
			System.out.println("");
			//System.out.print("|");
		}
		printParkingFee(hour, min);
	}
	public static void printParkingFee(int hour, int minute) {
		double fee=0;
		if(hour>=2) {
			fee = ((hour-2)*99);
			if(minute>0) {
				if(minute < 30) {
					fee = fee + 49.50;
				}else {
					fee = fee + 99;
				}
			}
		}
		System.out.println("");
		System.out.println("Total parking fee: "+fee);
	}

}
