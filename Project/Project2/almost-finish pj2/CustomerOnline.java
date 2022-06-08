//Name: Nitit Ngamphotchanamongkol
//ID: 6388093
//Section: 2
//Name: Thanakij Pinyoboon
//ID: 6388097
//Section: 2
//Name: Tawan Meethong
//ID: 6388206
//Section: 2

public class CustomerOnline extends Customer implements Loggable {
	
	//**************************** DO NOT MODIFY **********************************//
	private double distance;	// delivery distance
	
	//*****************************************************************************//
	
	/**
	 * Constructor initializes customer's name and delivery distance
	 * @param name
	 * @param distance
	 */
	public CustomerOnline(String name, double distance) {
		//******************* YOUR CODE HERE ******************
		super(name);
		this.distance = distance;
		//*****************************************************
	}
	
	/**
	 * Constructor initializes customer's ID, name and delivery distance
	 * @param id
	 * @param name
	 * @param distance
	 */
	public CustomerOnline(int id, String name, double distance) {
		//******************* YOUR CODE HERE ******************
		super(id, name);
		this.distance = distance;
		//*****************************************************
	}
	
	//**************************** DO NOT MODIFY **********************************//
	public double getDistance() {
		return this.distance;
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + distance;
	}
	//*****************************************************************************//
	
	@Override
	public String log() {
		return super.getCustID() + "," + super.getName() + "," + String.format("%.2f", getDistance());
	}
	
}