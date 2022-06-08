//Name: Nitit Ngamphotchanamongkol
//ID: 6388093
//Section: 2
import java.util.ArrayList;
import java.util.Collections;

 
public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	
	private ArrayList<Double> data = new ArrayList<>(); 
	private double sum,mean,std,max,min; // calculating variable
	private double[] maxK,minK; // calculate data as Array
	
	//**************************************
	
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	
	Kalculator(){
		//******INSERT YOUR CODE HERE***********
		
		sum=0;
		mean=0;
		std=0;
		max=0;
		min=0;
		
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number){	
		//******INSERT YOUR CODE HERE***********
		
		data.add(number);
		
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber(){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()>0) {
		data.remove(0); // Index 0 = first number 
		}
		
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber(){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()>0) data.remove(data.size()-1); // Remove the last number 
		
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum(){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()>0) {
		for(int i=0;i<data.size();i++) sum+=data.get(i); // retrieve data for using 
			return sum;}
		return 0;
		
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg(){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()>0) {
			mean=sum/data.size(); // use math formula to find mean
			return mean;
			}
		return 0;
		
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd(){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()>2) {
			for(int i=0;i<data.size();i++) std+=Math.pow(data.get(i)-mean, 2);
			std=std/(data.size()-1); // use math formula to find std
			std=Math.sqrt(std);
			return std;
		}return 0;
		
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax(){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()!=0) {
			max=data.get(0);
			for(double da:data) {
				if(da>max) max=da; // use math formula to find max
			}return max;
		}return 0;
		
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin(){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()!=0) {
			min=data.get(0);
			for(double da:data) {
				if(da<min) min=da; // use math formula to find min
			}return min;
		}return 0;
		
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()>k) {
			ArrayList<Double> sorting = new ArrayList<>();
			for(int i=0;i<data.size();i++) sorting.add(data.get(i)); // Create and retrieve new ArrayList from the data
			Collections.sort(sorting); // Sort number from ArrayList
			maxK=new double [k]; // Assign maxK as an array of K number 
			for(int j=0;j<k;j++) maxK[j]=sorting.get(sorting.size()-(j+1));
			return maxK;
		}return null;
		
		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k){
		//******INSERT YOUR CODE HERE***********
		
		if(data.size()>k) {
			ArrayList<Double> sorting = new ArrayList<>();
			for(int i=0;i<data.size();i++) sorting.add(data.get(i)); // Create and retrieve new ArrayList from the data
			Collections.sort(sorting); // Sort number from ArrayList
			minK=new double [k]; // Assign maxK as an array of K number 
			for(int j=0;j<k;j++) minK[j]=sorting.get(j);
			return minK;
		}
		return null;
		
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData(){
		//******INSERT YOUR CODE HERE***********
		
		System.out.println("DATA["+data.size()+"]:"+data.toString());
		
		//**************************************
	}
}
