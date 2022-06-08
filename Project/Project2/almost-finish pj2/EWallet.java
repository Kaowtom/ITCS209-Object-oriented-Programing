//Name: Nitit Ngamphotchanamongkol
//ID: 6388093
//Section: 2
//Name: Thanakij Pinyoboon
//ID: 6388097
//Section: 2
//Name: Tawan Meethong
//ID: 6388206
//Section: 2

public class EWallet implements Loggable{
	
	//**************************** DO NOT MODIFY **********************************//
	private int custID;			// customer's ID who owns this wallet
	private String username;
	private int password;		// password will be encoded using hashCode()
	private double balance;		// current balance in this wallet
	
	//*****************************************************************************//
	
	/**
	 * Constructor initializes customer's ID, username, encoded password, and balance
	 * @param custID
	 * @param user
	 * @param encodedPwd
	 * @param balance
	 */
	public EWallet(int custID, String user, int encodedPwd, double balance) {
		
		//******************* YOUR CODE HERE ******************
		this.custID = custID;
		this.username = user;
//		String pas = String.valueOf(encodedPwd);
//		this.password = pas.hashCode();
		this.password = encodedPwd;
		this.balance = balance;
		//*****************************************************
	}
	
	/**
	 * Similar to the previous constructor, but the password is provided as the plain text.
	 * The plain text password have to be encoded before assigned to password instance field.
	 * @param custID
	 * @param user
	 * @param pwd
	 * @param balance
	 */
	public EWallet(int custID, String user, String plainPwd, double balance) {
		
		//******************* YOUR CODE HERE ******************
		this.custID = custID;
		this.username = user;
		String pas = String.valueOf(plainPwd);
		this.password = pas.hashCode();
		this.balance = balance;
		//*****************************************************
	}
	
	/**
	 * Increase the balance by the given amount and return true.
	 * If the amount is zero or negative, 
	 * print a message ("Cannot add balance. Incorrect amount!") and return false. 
	 * @param amount to be added
	 * @return boolean 
	 */
	public boolean addBalance(double amount){
		
		//******************* YOUR CODE HERE ******************
		if(amount<=0) {
			System.out.println("Cannot add balance. Incorrect amount!");
			return false;
		}else {
			this.balance += amount;
			return true;
		}
		
		//*****************************************************
	}
	
	/**
	 * Decrease the balance by the given amount and return true.
	 * If the amount is zero or negative, 
	 * print a  message ("Cannot deduct balance. Incorrect amount!") and return false
	 * @param amount to be deducted
	 * @return boolean
	 */
	public boolean deductBalance(double amount){
		
		//******************* YOUR CODE HERE ******************
		if(amount<=0) {
			System.out.println("Cannot add balance. Incorrect amount!");
			return false;
		}else {
			this.balance -= amount;
			return true;
		}
		
		//*****************************************************
		
	}
	
	//**************************** DO NOT MODIFY **********************************//
	
	public int getCustID() {
		return custID;
	}
	
	public String getUserName() {
		return username;
	}
	
	public int getEncodedPassword() {
		return password;
	}
	
	public double getBalance(){
		return balance;
	}
	
	@Override
	public String toString(){
		return "CID::" + custID 
				+ ",username::" + username 
				+ ",encodedpassword::" + password 
				+ ",balance::" + Loggable.df.format(balance);
	}
	
	//*****************************************************************************//
	@Override
	public String log() {
		return getCustID() + "," + getUserName() + "," + getEncodedPassword() + "," + String.format("%.2f", getBalance());
	}
}