/*
 * Krish Patel
 * Lab #1
 * CSC172 Introduction to Data Structures and Algorithms
 * Prof: Monica Polak
 * Date: 02/03/2024
 */

package lab1;

import java.util.*; 
import java.util.List;
/**
 * 
 * @param <T> Generic Data Type 
 */
public class Lab1<T extends Comparable<T>> {
	
	/**
	 * Method Specifications:
	 * The generic method prettyPrint should take a list of elements and it should print it in the following format:
	 * Printing type List:
	 * Element 1: element 1
	 * Element 2: element 2
	 * Element 3: element 3
	 * Element 4: element 4
	 * @param <T> Generic Type 
	 * @param list list of generic type to be printed 
	 */
	public static <T> void prettyPrint(List<T> list) {
		
		/*
		 * This method uses the toString method to convert the list into a String for printing
		 */
		System.out.println(Lab1.toString(list));
	}
	
	/**
	 * 
	 * @param <T> Generic Data Type
	 * @param list The list which we wish to convert to a String
	 * @return a string which is in the format of the assignment specifications defined above in the prettyPrint method comments.
	 */
	static <T> String toString(List<T> list)
	{
		//ensure that the list is not empty
		if( list.size() == 0 )
		{
			return "The List is Empty\n";
		}
		
		//create the heading for the list
		String output = "Printing <" + list.get(0).getClass().getSimpleName() + "> List\n";
		
		//iterate through the list appending to the output string 
		for(int i = 0; i < list.size(); i++)
		{
			output = output + "Element " + (i + 1) + ": " + list.get(i) + "\n";
		}
		
		return output;
	}
	
	/**
	 * 
	 * @param <T> any data type as defined by the lab1 class 
	 * @param arr list from which we want to remove something
	 * @param element the element we want to remove from the list
	 */
	public static <T extends Comparable<T>> List<T> createListWithoutElements(List<T> arr, T element)
	{
	
		//create a new list to eventually return
		List<T> newlist = new LinkedList<>();

		//iterate through the list
		for(int i = 0; i < arr.size(); i++)
		{
			//if the element at index i is not the element of interest then we may add it to the list we will return
			if( arr.get(i).compareTo(element) != 0 ) 
			{
				newlist.add(arr.get(i));
			}
		}
		
		return newlist;
		
		
		
	}

	/**
	 * @param <T> any data type as defined by the lab1 class
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		System.out.println("The following are test cases for the prettyPrint method");
		System.out.println("Additional test cases can be found in the JUnit tests");
		System.out.println("-------------------------------------------------------");
		
		//Example code for the prettyPrint function
		
		//Example 1:
		//Trying to print an empty list
		System.out.println("EXAMPLE 1: Trying to print an empty list");
		List<String> list1 = List.of();
		Lab1.prettyPrint(list1);
		
		
		
		//Example 2:
		//Trying to print a full list of booleans
		System.out.println("EXAMPLE 2: Trying to print a full list of booleans");
		List<Boolean> list2 = List.of(true, true, false, true, false, false);
		Lab1.prettyPrint(list2);
		
		
		//Example 3:
		//Trying to print a full list of Integers
		System.out.println("EXAMPLE 3: Trying to print a full list of integers");
		List<Integer> list3 = List.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 3);
		Lab1.prettyPrint(list3);
		
		//Example 4:
		//Trying to print a full list of a user defined class
		System.out.println("EXAMPLE 4: Trying to print a list of User Defined Objects");
		List<ADT> list4 = List.of(new ADT(5),
				new ADT(9),
				new ADT(19),
				new ADT(-43));
		Lab1.prettyPrint(list4);
		
		
		System.out.println("The following are test cases for the createListWithoutElements method");
		System.out.println("Additional test cases can be found in the JUnit tests");
		System.out.println("-------------------------------------------------------");
		//Examples code for the createListWithoutElement function
		
		//Example 1:
		//Trying to remove an element not in the list
		System.out.println("EXAMPLE 1: Trying to remove an element that does not exist in the list");
		List<String> list5 = List.of("Hello", "World", "!", "Krish");
		List<String> newList1 = Lab1.createListWithoutElements(list5, "doesntExist");
		System.out.println("Orignal List: " + list5);
		System.out.println("Updated List: " + newList1 + "\n");
		
		//Example 2:
		//Removing all the elements in the list
		System.out.println("EXAMPLE 2: Trying to remove all instances of the element from a list exclusively composed of the element");
		List<Double> list6 = List.of(0.9, 0.9, 0.9, 0.9);
		List<Double> newList2 = Lab1.createListWithoutElements(list6, 0.9);
		System.out.println("Orignal List: " + list6);
		System.out.println("Updated List: " + newList2);
		
		
		//Example 3:
		//Trying to remove from an empty list
		System.out.println("EXAMPLE 3: Trying to remove an element from an empty list");
		List<Integer> list7 = List.of();
		List<Integer> newList3 = Lab1.createListWithoutElements(list7, 56);
		System.out.println("Orignal List: " + list7);
		System.out.println("Updated List: " + newList3 + "\n");
		
		//Example 4:
		//Simply removing 2 elements from a full list
		System.out.println("EXAMPLE 4: Trying to remove a single element from the list");
		List<String> list8 = List.of("Krish", "G", "Patel", "is", "taking", "CSC", "172", "?");
		List<String> newList4 = Lab1.createListWithoutElements(list8, "?");
		System.out.println("Orignal List: " + list8);
		System.out.println("Updated List: " + newList4 + "\n");
		
	}
	
	


}