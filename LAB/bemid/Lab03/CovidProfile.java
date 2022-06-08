
public class CovidProfile {
	private String date;
	private String location;
	private int accumulatedCases;
	private int curedCases;
	private int deathCases;
	public static int number = 0;
	
	public CovidProfile() {
		date = "none";
		location = "none";
		accumulatedCases = 0;
		curedCases = 0;
		deathCases = 0;
		number++;
	}
	
	public CovidProfile(String _date, String loc, int noACC, int noCured, int noDeath) {
		date = _date;
		location = loc;
		accumulatedCases = noACC;
		curedCases = noCured;
		deathCases = noDeath;
		number++;
	}
	public String getDate() {
		return date;
	}public void setDate(String _date) {
		this.date = _date;
	}
	
	public String getLocation() {
		return location;
	}public void setLocation(String loc) {
		this.location = loc;
	}
	
	public int getAccCases() {
		return accumulatedCases;
	}public void setAccCases(int value) {
		this.accumulatedCases = value;
	}
	
	public int  getCuredCases() {
		return curedCases;
	}public void setCuredCases(int value) {
		this.curedCases = value;
	}
	
	public int getDeathCases() {
		return deathCases;
	}public void setDeathCases(int value) {
		this.deathCases = value;
	}
	
	public void printCovidinfo() {
		System.out.println((number)+". "+location+" at "+date);
		System.out.println("Accumulative Patient: "+ accumulatedCases);
		System.out.println("Cured Patient: "+ curedCases);
		System.out.println("Death Case: "+ deathCases);
		System.out.println("Is Dead Cases more than 10,000?");
		System.out.println(isSevere(deathCases));
		printpercent(curedCases, accumulatedCases);
		System.out.println("-------------------------------");
		
	}
	
	public void printpercent(float c, float a) {
//		System.out.println(d);
//		System.out.println(a);
		System.out.println("Cure percentage: "+(c/a)*100);
	}
	
	public boolean isSevere(int death) {
		if(death > 10000) {
			return true;
		}else {
			return false;
		}
	}
}
