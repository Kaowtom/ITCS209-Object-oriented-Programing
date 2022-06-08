//Name: Nitit Ngamphotchanamongkol
//ID: 6388093
//Section: 2

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	//*********************** DO NOT MODIFY ****************************//
	public static enum CustomerType{DEFAULT, STUDENT, PROFESSOR, ATHLETE, ICTSTUDENT};	//Different types of customers 
	private static int customerRunningNumber = 1;	//static variable for assigning a unique ID to a customer
	private CanteenICT canteen = null;	//reference to the CanteenICT object
	private int customerID = -1;		//this customer's ID
	protected CustomerType customerType = CustomerType.DEFAULT;	//the type of this customer, initialized with a DEFAULT customer.
	protected List<FoodStall.Menu> requiredDishes = new ArrayList<FoodStall.Menu> ();	//List of required dishes
	//*****************************************************************//
	
	private int eatingTime = -1; //set eating time
	FoodStall myFs = null; // set new variable foodstalls type to null
	Table thisSeat; // set new variable to Table type
	
	Customer(CanteenICT _canteen)
	{
		//******************* YOUR CODE HERE **********************
		canteen = _canteen; //set this canteen to canteen(parameter)
		this.customerID = customerRunningNumber++; //count customer ID number and set to customerID
		
//		for(int i=0; i<FoodStall.Menu.values().length; i++) {
//			requiredDishes.add(FoodStall.getMenu().get(i));
//		}

//		for(FoodStall.Menu dish: requiredDishes) {
//		requiredDishes.add(dish);
//	}
		
		//add all menu to required dish
		requiredDishes.add(FoodStall.Menu.MEAT);
		requiredDishes.add(FoodStall.Menu.SALAD);
		requiredDishes.add(FoodStall.Menu.NOODLES);
		
		//reset eating time
		eatingTime =0;
		
		//add all eating time to a required dish
		for(FoodStall.Menu dish: requiredDishes) {
			eatingTime += FoodStall.EAT_TIME[dish.ordinal()];
		}
		//*****************************************************
	}
	
	
	
	public void takeAction()
	{
		//************************** YOUR CODE HERE **********************//
		// First, i separate the process to 3 big step Waiting order line, Waiting seat line, table step
		// First step = Set Customer to waiting order line
		FoodStall cur = canteen.getfoodStalls().get(0);
		
		if (!canteen.getWaitToEnterQueue().isEmpty() && canteen.getWaitToEnterQueue().get(0) == this && CanteenICT.AvaAdd) {
			
			// set variable(tmpfs) to define the location of food stall
			List<FoodStall> tmpfs = canteen.getfoodStalls();
			
			while(!cur.getMenu().containsAll(requiredDishes)) {
				// using for each-loop to set variable(index) to define the location of FoodStall that we want
				for (FoodStall index : tmpfs) {
					if ( index.customerQueueNext.size() < cur.customerQueueNext.size()) {
						cur = index;
					}
				}
				// remove the different menu with my required dish
				if (!cur.getMenu().containsAll(requiredDishes)) {
					tmpfs.remove(cur);
					cur = canteen.getfoodStalls().get(0);
					continue;
				}
			}
			// check the queue of customer
			if (cur.customerQueueNext.size() == FoodStall.MAX_QUEUE) {
				return;
			}
			
			if (cur.getMenu().containsAll(requiredDishes)) {
				canteen.getWaitToEnterQueue().remove(0);
				cur.getCustomerQueue().add(this);
				myFs = cur;
				CanteenICT.AvaAdd = false;
			}
		}

		// Second step = Set Customer to Ordering and go to waiting seat line
		else if (myFs != null) {
			if (myFs.customerQueueNext.size()!=0 && myFs.customerQueueNext.get(0) == this) {
				//check that is the customer ready to order?
				if (myFs.isWaitingForOrder() && myFs.NextCus) {
					myFs.takeOrder(requiredDishes);
					return;
				} else if (myFs.isReadyToServe()) {
					canteen.getWaitToSeatQueue().add(this);
					myFs.getCustomerQueue().remove(this);
					myFs.NextCus = false;
					return;
				}
			}
		}
		
		// Last step = Sent to the available Table.
		if (canteen.getWaitToSeatQueue().size() > 0) {
			if (canteen.getWaitToSeatQueue().get(0) == this) {
				
//				for(int i=0; i< Table.values.size(); i++) {
//				Table k = canteen.gettables();
//				}  I had no idea anymore ( O w O;)
			}
		}
		
		// last condition
		if (thisSeat != null) {
			// I can't handle it  ._.
		}
		
		
		//**************************************************************//
		
	}

	//***************For hashing, equality checking, and general purposes. DO NOT MODIFY **************************//	
	
	public CustomerType getCustomerType()
	{
		return this.customerType;
	}
	
	public int getCustomerID()
	{
		return this.customerID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerType=" + customerType +"]";
	}

	public String getCode()
	{
		return this.customerType.toString().charAt(0)+""+this.customerID;
	}
	
	/**
	 * print something out if VERBOSE is true 
	 * @param str
	 */
	public void jot(String str)
	{
		if(CanteenICT.VERBOSE) System.out.println(str);
		
		if(CanteenICT.WRITELOG) CanteenICT.append(str, canteen.name+"_state.log");
	}
	
	//*************************************************************************************************//
	
}
