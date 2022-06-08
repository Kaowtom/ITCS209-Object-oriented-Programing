//Name: Nitit Ngamphotchanamongkol
//ID: 6388093
//Section: 2
//Name: Thanakij Pinyoboon
//ID: 6388097
//Section: 2
//Name: Tawan Meethong
//ID: 6388206
//Section: 2


public class Customer implements Loggable{
	
	//**************************** DO NOT MODIFY **********************************//
	public static int runningID = 0;	// static variable for assigning a unique ID to a customer

	private int custID;		// customer's ID
	private String name;	// customer's name
	//*****************************************************************************//
	
	/**
	 * Constructor initializes the customer's name.
	 * The customer's ID will be automatically assigned according to the running ID. 
	 * The first customer will have ID as 1, and the second customer will have ID as 2, and so on
	 * @param name
	 */
	public Customer(String name) {
		//******************* YOUR CODE HERE ******************
		this.name = name;
//		custID = runningID + 1;
//		runningID = custID;
		runningID++;
		custID = runningID;
		//*****************************************************
	}
	
	/**
	 * Constructor initializes both customer's ID and name.
	 * If the provided ID is larger than the running ID, then the running ID will be set to equal to that provided ID. 
	 * @param id
	 * @param name
	 */
	public Customer(int id, String name) {
		//******************* YOUR CODE HERE ******************
		this.name = name;
		custID = id;
		if(id>runningID) {
			runningID = id;
		}
		//*****************************************************
	}
	
	//**************************** DO NOT MODIFY **********************************//
	public int getCustID() {
		return this.custID;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "CID::" + custID + ",name::" + name;
	}

	public void print() {
		System.out.printf("%-15s %-4d \n", "Customer ID:", custID);
		System.out.printf("%-15s %-4d \n", "Name:", name);
	}
	//*****************************************************************************//
	@Override
	public String log() {
		return getCustID() + "," + getName();
	}
	
}