/* 
 * CS211 Assignment 06 (ArrayList vs LinkedList)
 * Eyas Rashid - rashid_e@hotmail.com
 * Student ID: 985 762 980
 * 2018.05.29 - Spring Quarter
 *
 * this program compares the speed of multiple methods that are used by array lists
 * and linked lists.  It compares them and calculates the efficiency of each one in respect to
 * the faster of the two in that particular method.
 */
import java.util.*;

public class ASN_6 {
	
	static List <Integer> myArrayList = new ArrayList <Integer>();
	static List <Integer> myLinkedList = new LinkedList <Integer>();
	static Random rand = new Random();
	
	public static void main(String[] args) {
	
	
	int testNumber = 10000000; // total number of index's created in linked and array list
	double	totalArrayTime = 0.0;
	double	totalLinkedTime = 0.0;
	double startTime = System.currentTimeMillis();
	double endTime = System.currentTimeMillis();
	int value = 0;
	
	add(testNumber, value, startTime, endTime, totalArrayTime, totalLinkedTime);
	get(value, startTime, endTime, totalArrayTime, totalLinkedTime);
	set(value, startTime, endTime, totalArrayTime, totalLinkedTime);
	remove(value, startTime, endTime, totalArrayTime, totalLinkedTime);
	
				
	}
// this method adds 10,000,000 index's with random values 0-9999 to myArrayList & myLinkedList
// this method also tracks the time it takes to add the index and value to the lists
public static void add(int testNumber, int value, double startTime, double endTime, double totalArrayTime, double totalLinkedTime) {
	for (int i = 0 ; i < testNumber ; i++) {
	    value = rand.nextInt(9999);
	    startTime = System.currentTimeMillis();
		myArrayList.add(value);
		endTime = System.currentTimeMillis();
		totalArrayTime += (endTime - startTime);
		
		startTime = System.currentTimeMillis();
		myLinkedList.add(value);
		endTime = System.currentTimeMillis();
		totalLinkedTime += (endTime - startTime);
	}
		String testType = "ADD";
		listRunTime(totalArrayTime, totalLinkedTime, testType);
		efficiencyCalc( totalArrayTime, totalLinkedTime, testType);
	}
// this method gets 1000 index values 0-10,000,000 from myArrayList & myLinkedList
// while also tracking the time it takes to get all 1000 index's.
public static void get(int value, double startTime, double endTime, double totalArrayTime, double totalLinkedTime) {
	for (int i = 0 ; i < 1000 ; i++) {
		
	    value = rand.nextInt(10000000);
	    startTime = System.currentTimeMillis();
		myArrayList.get(value);
		endTime = System.currentTimeMillis();
		totalArrayTime += (endTime - startTime);
		
		startTime = System.currentTimeMillis();
		myLinkedList.get(value);
		endTime = System.currentTimeMillis();
		totalLinkedTime += (endTime - startTime);
	}
		String testType = "GET";
		listRunTime(totalArrayTime, totalLinkedTime, testType);
		efficiencyCalc( totalArrayTime, totalLinkedTime, testType);	
}
//this method removes 1000 index values 0-10,000,000 from myArrayList & myLinkedList
//while also tracking the time it takes to get all 1000 index's.
public static void remove(int value, double startTime, double endTime, double totalArrayTime, double totalLinkedTime) {
	for (int i = 0 ; i < 1000 ; i++) {
		
	    value = rand.nextInt(10000000);
	    startTime = System.currentTimeMillis();
		myArrayList.remove(value);
		endTime = System.currentTimeMillis();
		totalArrayTime += (endTime - startTime);
		
		startTime = System.currentTimeMillis();
		myLinkedList.remove(value);
		endTime = System.currentTimeMillis();
		totalLinkedTime += (endTime - startTime);
	}
		String testType = "REMOVE";
		listRunTime(totalArrayTime, totalLinkedTime, testType);
		efficiencyCalc( totalArrayTime, totalLinkedTime, testType);
}
//this method sets 1000 index values to a new random index value 0-10,000,000 from myArrayList & myLinkedList
//while also tracking the time it takes to set all 1000 index's.
public static void set(int value, double startTime, double endTime, double totalArrayTime, double totalLinkedTime) {
	for (int i = 0 ; i < 1000 ; i++) {
		
	    int indexValue = rand.nextInt(10000000);
	    value = rand.nextInt(9999);
	    startTime = System.currentTimeMillis();
		myArrayList.set(indexValue, value);
		endTime = System.currentTimeMillis();
		totalArrayTime += (endTime - startTime);
		
		startTime = System.currentTimeMillis();
		myLinkedList.set(indexValue, value);
		endTime = System.currentTimeMillis();
		totalLinkedTime += (endTime - startTime);
	}
		String testType = "SET";
		listRunTime(totalArrayTime, totalLinkedTime, testType);
		efficiencyCalc( totalArrayTime, totalLinkedTime, testType);
}
// this method prints the time, in seconds, it takes to complete whatever specific method it is being called in
public static void listRunTime(double totalArrayTime, double totalLinkedTime, String testType) {
	System.out.println(testType);
	System.out.println("Array List time  : " + totalArrayTime / 1000.0);	
	System.out.println("Linked List time : " + totalLinkedTime / 1000.0);	
}
// this method calculate compares and calculates the efficiency of the array list and linked list in respect to the whichever of the faster of the
// to lists.
public static void efficiencyCalc(double totalArrayTime, double totalLinkedTime, String testType) {
	double efficiencyPercentage  = 0.0;
	char percent = '%';
	if(totalArrayTime > totalLinkedTime) {
		efficiencyPercentage  = (100 * totalArrayTime / totalLinkedTime) - 100 ;

		System.out.printf("Linked list performs the %s Method  %.2f%c more efficiently than Array list.\n",testType, efficiencyPercentage, percent);
	}else if (totalArrayTime < totalLinkedTime) {
		efficiencyPercentage  = (100 *  totalLinkedTime / totalArrayTime) - 100 ; 
		System.out.printf("Array list performs the %s Method %.2f%c more efficiently than Linked list.\n",testType ,efficiencyPercentage, percent);
	}else if (totalArrayTime == totalLinkedTime) {
		System.out.println("");
	}
	System.out.println();
}
}
