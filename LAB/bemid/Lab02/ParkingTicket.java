import java.util.Scanner;
public class ParkingTicket {

	public static void main(String[] args) {
		int be, af, h1, h2, n, hour, min, count=0;
		double fee=0;
		String tbe, taf;
		Scanner k = new Scanner(System.in);
		tbe = k.nextLine();
		taf = k.nextLine();
		k.close();
		System.out.println("Entering time -> "+tbe);
		System.out.println("Leaving time  -> "+taf);
		/*/if(be>af) {
			System.out.print("(overnight)");
			on = 1;
		}/*/
		be = Integer.parseInt(tbe);
		af = Integer.parseInt(taf);
		h1 = be / 100;
		//System.out.println(h1);
		h2 = af / 100;
		n = (h2-h1)*60;
		/*/if(on==0) {
			h1 = be / 100;
			//System.out.println(h1);
			h2 = af / 100;
			n = (h2-h1)*60;
		}else {
			h1 = (24-be) / 100;
			System.out.println(h1);
			h2 = af / 100;
			System.out.println(h2);
			n = (h2+h1)*60;
		}/*/
		//System.out.println((af-(h2*100)) - (be-(h1*100)));
		n = n + ((af-(h2*100)) - (be-(h1*100)));
		//System.out.println(n);
		hour = n/60;
		min = n - hour*60;
		System.out.println("Parking duration: "+ hour+" hours and "+min+ " minutes");
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
		System.out.println("");
		if(hour>=2) {
			fee = ((hour-2)*99);
			if(min>0) {
				if(min <= 30) {
					fee = fee + 49.50;
				}else {
					fee = fee + 99;
				}
			}
		}
		System.out.println("Parking fee: "+fee);
	}

}
