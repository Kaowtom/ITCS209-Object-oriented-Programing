//Name: Nitit Ngamphotchanamongkol
//ID: 6388093
//Section: 2
//Name: Thanakij Pinyoboon
//ID: 6388097
//Section: 2
//Name: Tawan Meethong
//ID: 6388206
//Section: 2


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DataManagement {
	
	public static final String SAMPLE_PATH = Paths.get("").toAbsolutePath().toString() 
								+ File.separator + "sample" +  File.separator;
	
	public static final String STOCK_FILE = SAMPLE_PATH + "stocks.txt";
	public static final String CUSTOMER_FILE = SAMPLE_PATH + "customers.txt";
	public static final String WALLET_FILE = SAMPLE_PATH + "wallets.txt";
	public static final String ORDER_FILE = SAMPLE_PATH + "orders.txt";
	
	//**************************** DO NOT MODIFY **********************************//
	
	public static Map<Integer, Customer> customerData = new HashMap<Integer, Customer>();
			// The key of customerData is the customer's ID
	
	public static Map<Integer, EWallet> walletData = new HashMap<Integer, EWallet>();
			// The key of walletData is the customer's ID associated with that EWallet
	
	public static Map<String, Item> stockData = new HashMap<String, Item>();
			// The key of stockData is the item's name
	
	public static Map<Integer, Order> orderData = new HashMap<Integer, Order>();
			// The key of orderData is the order's ID
	
	//*****************************************************************************//
	
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct customer's format, recreates a Customer object, and put in the customerData map.
	 * The invalid line will be skipped.
	 * 
	 * Note that customer can be either general customer or an online customer.
	 * 
	 * @param filename that keeps customers data
	 * @return Map collection of customers read from the text file
	 */
	public static Map<Integer, Customer> initCustomer(String filename) {
		
		//******************* YOUR CODE HERE ******************
		File file = new File("src\\customers.txt");  //set locate file
		String a ="";
		try {
			BufferedReader customerDatanew = new BufferedReader(new FileReader(file));
			while((a = customerDatanew.readLine()) != null){	
				if(a.trim() != null && !a.trim().isEmpty()){	
					String[] line = a.split(",", 3);
					if(line.length == 2 && line[0].matches("[0-9]+") && !line[0].isBlank() && !line[1].isBlank()) {
						int id = Integer.parseInt(line[0]);	
						String name = line[1];
						Customer two = new Customer(id, name);
						customerData.put(id, two);
					}
						
					if(line.length == 3 && line[0].matches("[0-9]+") && !line[0].isBlank() && line[1].matches("[a-zA-Z]+") && !line[1].isBlank() && !line[2].isBlank() && !line[2].isEmpty()) {
						int id = Integer.parseInt(line[0]);	
						String name = line[1];
						double distance = Double.parseDouble(line[2]);
						Customer three = new CustomerOnline(id, name, distance);
						customerData.put(id, three);
					}
 				}
			}
		  customerDatanew.close();
		}	
		catch(IOException e) {
          e.printStackTrace();
		}	
		return customerData;	//return Data of customer
		
		//*****************************************************
	}
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct wallet's format, recreates a EWallet object, and put in the walletData map.
	 * The invalid line will be skipped.
	 * 
	 * Note that the password in the log file must be encoded password (positive or negative number only)
	 * 
	 * @param filename that keeps e-wallet data
	 * @return Map collection of wallets read from the text file
	 */
	public static Map<Integer, EWallet> initWallet(String filename) {
		
		//******************* YOUR CODE HERE ******************
		File file = new File("src\\wallets.txt");
		String a ="";
		try {
			BufferedReader EWalletnew = new BufferedReader(new FileReader(file));
			while((a = EWalletnew.readLine()) != null){	
				if(a.trim() != null && !a.trim().isEmpty()){	
					String[] line = a.split(",", 4);
					if(line.length == 4 && line[0].matches("[0-9]+") && !line[0].isBlank() 
							&& !line[1].matches("[a-z]+")  && !line[1].matches("[0-9]+") && !line[1].isBlank() 
							&& line[2].matches("[0-9]+") && !line[2].isBlank()  
							&& line[3].matches("[/^[0-9]+.[0-9]+$]+") && !line[3].isEmpty()) 
					{
						int id = Integer.parseInt(line[0]);	
						String user = line[1];
						int pwd = Integer.parseInt(line[2]);	
						double balance = Double.parseDouble(line[3]);
						EWallet f = new EWallet(id, user, pwd, balance);
						walletData.put(id, f);
					}
 				}
			}
			EWalletnew.close();
		}	
		catch(IOException e) {
          e.printStackTrace();
		}	
		return walletData;
		
		//*****************************************************

	}
	
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct item's format, recreates an Item object, and put in the stockData map.
	 * The invalid line will be skipped.
	 * 
	 * @param filename that keeps stocks data
	 * @return Map collection of items read from the text file
	 */
	public static Map<String, Item> initStock(String filename){
		
		//******************* YOUR CODE HERE ******************
		File file = new File("src\\stocks.txt");
		String a ="";
		try {
			BufferedReader itemnew = new BufferedReader(new FileReader(file));
			while((a = itemnew.readLine()) != null){	
				if(a.trim() != null && !a.trim().isEmpty()){	
					String[] line = a.split(",", 4);
					if(line.length == 4 && !line[0].isBlank() 
							&& line[1].matches("[/^[0-9]+.[0-9]+$]+") && !line[1].isBlank() 
							&& (line[2].matches("true")  || line[2].matches("false")) && !line[2].isBlank()  
							&& line[3].matches("[0-9]+") && !line[3].isEmpty()) 
					{
						String name = line[0];	
						double price = Double.parseDouble(line[1]);
						boolean taxable = Boolean.parseBoolean(line[2]);	
						int qty = Integer.parseInt(line[3]);
						Item f = new Item(name, price, taxable, qty);
						stockData.put(name, f);
					}
 				}
			}
			itemnew.close();
		}	
		catch(IOException e) {
          e.printStackTrace();
		}	
		return stockData;
		
		//*****************************************************
		
	}
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct order's format, recreates an Order object, and put in the orderData map.
	 * The invalid line will be skipped.
	 * 
	 * Note that if the qty is equal to 2147483647, this mean the item has unlimited supply
	 * 
	 * @param filename that keeps orders data
	 * @return Map collection of orders read from the text file
	 */
	
	public static Map<Integer, Order> initOrder(String filename) {
		//******************* YOUR CODE HERE ******************
		File file = new File("src\\orders.txt");
		String a ="";
		try {
			BufferedReader ordernew = new BufferedReader(new FileReader(file));
			while((a = ordernew.readLine()) != null){	
				if(a.trim() != null && !a.trim().isEmpty()){	
					String[] line = a.split(",", 4);
					String[] item = line[2].split("|");
					if(line.length == 4 && line[0].matches("[0-9]+") && !line[0].isBlank() 
							&& line[1].matches("[0-9]+") && !line[1].isBlank() && !line[2].isBlank()  
							&& line[3].matches("(PENDING || PAID || VOIDED).+::(UNKNOWN || CASH || CARD || EWALLET).+") && !line[3].isBlank() )  
					{
						int orderid = Integer.parseInt(line[0]);
						Order Obj = new Order(orderid);
						orderData.put(orderid, Obj);
					}
 				}
			}
			ordernew.close();
		}	
		catch(IOException e) {
          e.printStackTrace();
		}	
		return orderData;
		
		//*****************************************************
		
	}
	
	//**************************** DO NOT MODIFY **********************************//
	/**
	 * Initialize customerData, stockData, walletData, and orderData by calling initCustomer, initStock, initWallet, and initOrder respectively
	 * 
	 */
	public static void initData(){
		initStock(STOCK_FILE); 
		initCustomer(CUSTOMER_FILE);
		initWallet(WALLET_FILE);
		initOrder(ORDER_FILE);
	}

	
	/**
	 * Delete existing log files if any
	 */
	public static void removeLogFile(String filename) {
		
		try {
			File log = new File(filename);
			Files.deleteIfExists(log.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A convenient method to write str to the File identified by filename. 
	 * Only works with newer version of Java.
	 * @param filename
	 * @param append
	 * @param str
	 */
	public static void writeDataLog(String filename, Boolean append, String str)
	{
		try {
			FileWriter fileWriter = new FileWriter(filename, append);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.println(str); 
		    printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	//*****************************************************************************//
	
	/**
	 * Write the list of items into the given text file
	 * If the append is true, the list of items will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of items.
	 * 
	 * @param filename
	 * @param append: whether append the text file or not
	 * @param items: list of items
	 */
	public static void storeItems(
			String filename, Boolean append, List<Item> items) {
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append); 	// set file writer
			PrintWriter printerWriter = new PrintWriter(fileWriter); 	// set printer writer
			for( Item i: items) { 	// use for each loop to run i in list of items
				printerWriter.println(i.log()); 	// print of each line in to log file
			}
			printerWriter.close();
		}catch( IOException e) {
			e.printStackTrace();
		}
		
		//***************************************************** 
	}
	
	/**
	 * Write the list of customers into the given text file
	 * If the append is true, the list of customers will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of customers.
	 *   
	 * @param filename
	 * @param append
	 * @param customers
	 */
	public static void storeCustomers(
			String filename, Boolean append, List<Customer> customers) {
		
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append); 	// set file writer
			PrintWriter printerWriter = new PrintWriter(fileWriter); 	// set printer writer
			for(Customer i: customers) { 	// use for each loop to run i in list of customers
				printerWriter.println(i.log()); 	// print of each line in to log file
			}
			printerWriter.close();
		}catch( IOException e) {
			e.printStackTrace();
		}
		
		//*****************************************************
	}
	
	/**
	 * Write the list of wallets into the given text file
	 * If the append is true, the list of wallets will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of wallets.
	 * 
	 * @param filename
	 * @param append
	 * @param wallets
	 */
	public static void storeEWallets(
			String filename, Boolean append, List<EWallet> wallets) {
		
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append); 	// set file writer
			PrintWriter printerWriter = new PrintWriter(fileWriter); 	// set printer writer
			for(EWallet i: wallets) { 	// use for each loop to run i in list of wallets
				printerWriter.println(i.log()); 	// print of each line in to log file
			}
			printerWriter.close();
		}catch( IOException e) {
			e.printStackTrace();
		}
		//*****************************************************
	}
	
	/**
	 * Write the list of orders into the given text file
	 * If the append is true, the list of orders will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of orders.
	 * 
	 * @param append
	 * @param orders
	 */
	
	public static void storeOrders(
			String filename, Boolean append, List<Order> orders) {
		
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append); 	// set file writer
			PrintWriter printerWriter = new PrintWriter(fileWriter); 	// set printer writer
			for(Order i: orders) { 	// use for each loop to run i in list of orders
				printerWriter.println(i.log()); 	// print of each line in to log file
			}
			printerWriter.close();
		}catch( IOException e) {
			e.printStackTrace();
		}
		//*****************************************************
	}
	

	
	
	/**
	 * Filter the orders data (in the Map Collection) by the order's status and/or payment method
	 * and calculate the summation of the sub-total amount of those filtered ordered.
	 * 
	 * @param status
	 * @param method
	 * @return total summation of the sub-total of the orders matched with the given condition
	 */
	public static double filterSubTotal(Order.Status status, String method) {
		
		//******************* YOUR CODE HERE ******************
		double sumsub=0;
		for(Entry<Integer, Order> me :orderData.entrySet()) {
			Order O = new Order();
			O = me.getValue();
			
			if(O.getPaymentStatus()==status && O.getPaymentMethod()== method) {
				sumsub=sumsub+O.getSubTotal();
			}
		}
		return sumsub;
		
		//*****************************************************
		
	}
	
	/**
	 * Filter the orders data (in the Map Collection) by the order's status and/or payment method
	 * and calculate the summation of the grand total amount of those filtered ordered.
	 * 
	 * @param status
	 * @param method
	 * @return total summation of the grand total of the orders matched with the given condition
	 */
	
	public static double filterGrandTotal(Order.Status status, String method) {
		
		//******************* YOUR CODE HERE ******************
		double sumgrand=0;
		for(Entry<Integer, Order> me :orderData.entrySet()) {
	        Order O = new Order();
	        O = me.getValue();
	
	        if(O.getPaymentStatus()==status && O.getPaymentMethod()== method) {
	        	sumgrand=sumgrand+O.getGrandTotal();
	        }
		}
       return sumgrand;
		
		//*****************************************************
				
	}
	
	/**
	 * Calculate the grand total payment group by each payment method for all paid ordered
	 * The voided or pending orders are ignored
	 * 
	 * @return Map<String, Double> where key is the method name, and value is the total of grand total payment
	 */
	public static Map<String, Double> groupGrandTotalByPaymentMethod(){
		
		//******************* YOUR CODE HERE ******************
		HashMap<String, Double> M = new HashMap<String, Double>();
		double sumcash=0;
		double sumcard=0;
		double sumewallet=0;
		for(Entry<Integer, Order> me :orderData.entrySet()) {
			
			Order O = new Order();
			O = me.getValue();
		   if(O.getPaymentStatus()!=Order.Status.VOIDED && O.getPaymentStatus() !=Order.Status.PENDING  ) {
			   if(O.getPaymentMethod()=="CASH") {
				 sumcash=sumcash+O.getGrandTotal();
				 M.put(O.getPaymentMethod(), sumcash);  
			   }
			   
			   	if(O.getPaymentMethod()=="CARD") {
			   		sumcard=sumcard+O.getGrandTotal();
			   		M.put(O.getPaymentMethod(), sumcard);  
				   }
			   	
			   	 if(O.getPaymentMethod()=="EWALLET") {
			   		 sumewallet= sumewallet+O.getGrandTotal();
			   		 M.put(O.getPaymentMethod(), sumewallet);
			    }
			   	
		   }
		}
		return M;
		
		//*****************************************************
				
	}
	
	/**
	 * Sort the orders data (in Map Collection) by their grandTotal
	 * If asc is true, the grandTotal is sorted in ascending order
	 * Otherwise, the grandTotal is sorted in descending order 
	 * Only "paid" orders are included in the output
	 * If the amounts are equal, the order ID will be used later.
	 * 
	 * @param asc indicate ascending or descending order
	 * @return the sorted list of orders
	 */
	public static ArrayList<Order> sortPaidGrandTotal(boolean asc) {
		
		//******************* YOUR CODE HERE ******************
      ArrayList<Order> ans = new ArrayList<Order>();
      for(Entry<Integer, Order> me :orderData.entrySet()) {
          
          Order O = new Order();
          O = me.getValue();
          if(O.getPaymentStatus()==Order.Status.PAID ) {
              ans.add(O);
          }
      }
      if(asc) {
          Collections.sort(ans);
      }else {
    	  Collections.sort(ans, Collections.reverseOrder());
      }
		return ans;
		
		//*****************************************************
	}
	

}