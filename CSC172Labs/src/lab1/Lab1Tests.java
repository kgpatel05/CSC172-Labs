package lab1;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;


//In the notes, EOI stands for Element of Interest

class Lab1Tests {
	
	@Test
	@DisplayName("Input of Empty List")
	/**
	 * this function simply ensures that an empty list does not throw any exceptions
	 */
	void test()
	{
		String output = "The List is Empty\n";
		
		List<Integer> emp = new LinkedList<>();
		
		assertEquals(Lab1.toString(Lab1.createListWithoutElements(emp, 4)), output);
	}
	
	@Test
	@DisplayName("Full List Printing Validation")
	void test1() 
	{
		List<Integer> list = new LinkedList<>( List.of(1,2,3,4,5,6,7,8,9) );
		String intendedOutput = "Printing <Integer> List\n"
				+ "Element 1: 1\n"
				+ "Element 2: 2\n"
				+ "Element 3: 3\n"
				+ "Element 4: 4\n"
				+ "Element 5: 5\n"
				+ "Element 6: 6\n"
				+ "Element 7: 7\n"
				+ "Element 8: 8\n"
				+ "Element 9: 9\n";
		assertEquals(Lab1.toString(list), intendedOutput );
	}

	@Test
	@DisplayName("List of Just One EOI")
	/**
	 * This function takes in a list of just one EOI which we want to remove and checks if the method
	 * createListWithoutElement() returns an empty list
	 */
	void test2() 
	{
		
		List<Integer> list = new LinkedList<>( List.of(4) );
		Lab1.prettyPrint(Lab1.createListWithoutElements(list, 4));
		
		assertEquals(Lab1.toString(Lab1.createListWithoutElements(list, 4)), "The List is Empty\n" );
		
	}
	
	@Test
	@DisplayName("List of Multiple EOI")
	/**
	 * This function takes in a list of multiple EOI which we want to remove and checks if the method
	 * createListWithoutElement() returns an empty list
	 */
	void test3()
	{
		
		List<Integer> list = new LinkedList<>( List.of(4,4,4,4,4,4,4,4) );
		Lab1.prettyPrint(Lab1.createListWithoutElements(list, 4));
		
		assertEquals(Lab1.toString(Lab1.createListWithoutElements(list, 4)), "The List is Empty\n" );
		
	}
	
	@Test
	@DisplayName("List of Multiple EOI w/ Other Elements")
	/**
	 * This function takes in a list of multiple EOI as well as other values checks if the EOI is removed
	 */
	void test4()
	{
		List<Integer> list = new LinkedList<>( List.of(5,6,8,4,9,2,4,5) );
		Lab1.prettyPrint(Lab1.createListWithoutElements(list, 4));
		
		String output = "Printing <Integer> List\n"
				+ "Element 1: 5\n"
				+ "Element 2: 6\n"
				+ "Element 3: 8\n"
				+ "Element 4: 9\n"
				+ "Element 5: 2\n"
				+ "Element 6: 5\n";
		
		assertEquals(Lab1.toString(Lab1.createListWithoutElements(list, 4)), output);
	}
	
	@Test
	@DisplayName("Empty List")
	/**
	 * This method checks the prettyPrint method when a null list is passed
	 */
	void test5()
	{
		List<String> list = List.of();
		String newlist = Lab1.toString(list);
		String output = "The List is Empty\n";
		assertEquals(newlist, output);
	}
	
	@Test
	@DisplayName("Printing a List of Booleans")
	void test6()
	{
		List<Boolean> list2 = List.of(true, true, false, true, false, false);
		String newlist = Lab1.toString(list2);
		String output = "Printing <Boolean> List\n"
				+ "Element 1: true\n"
				+ "Element 2: true\n"
				+ "Element 3: false\n"
				+ "Element 4: true\n"
				+ "Element 5: false\n"
				+ "Element 6: false\n";
		assertEquals(newlist, output);
	}

	@Test
	@DisplayName("Printing a list of Integers")
	void test7()
	{
		List<Integer> list3 = List.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 3);
		String newlist = Lab1.toString(list3);
		String output = "Printing <Integer> List\n"
				+ "Element 1: -2147483648\n"
				+ "Element 2: 2147483647\n"
				+ "Element 3: 0\n"
				+ "Element 4: 3\n";
		assertEquals(newlist, output);
	}
	
	@Test
	@DisplayName("Printing a list of user defined objects")
	void test8()
	{
		List<ADT> list4 = List.of(new ADT(5),
				new ADT(9),
				new ADT(19),
				new ADT(-43));
		String newlist = Lab1.toString(list4);
		String output = "Printing <ADT> List\n"
				+ "Element 1: 5\n"
				+ "Element 2: 9\n"
				+ "Element 3: 19\n"
				+ "Element 4: -43\n";
		assertEquals(newlist, output);
	}
	
	@Test
	@DisplayName("Removing non existing element from list")
	void test9()
	{
		List<String> list5 = List.of("Hello", "World", "!", "Krish");
		List<String> newlist = Lab1.createListWithoutElements(list5, "doesntExist");
		List<String> output = List.of("Hello", "World", "!", "Krish");
		assertEquals(newlist, output);
	}
	
	@Test
	@DisplayName("Removing all elements in the list")
	void test10()
	{
		List<Double> list6 = List.of(0.9, 0.9, 0.9, 0.9);
		List<Double> newlist = Lab1.createListWithoutElements(list6, 0.9);
		List<Double> output = List.of();
		assertEquals(newlist, output);
	}
	
	@Test
	@DisplayName("Removing from an Empty List")
	void test11()
	{
		List<Integer> list = List.of();
		List<Integer> newlist = Lab1.createListWithoutElements(list, 56);
		List<Integer> output = List.of();
		assertEquals(newlist, output);

	}
	
	
	@Test
	@DisplayName("Removing 2 elements from a full list")
	void test12()
	{
		List<String> list = List.of("Krish", "G", "Patel", "is", "taking", "CSC", "172", "?", "?");
		List<String> newlist = Lab1.createListWithoutElements(list, "?");
		List<String> output = List.of("Krish", "G", "Patel", "is", "taking", "CSC", "172");
		assertEquals(newlist, output);
	}
		

	
	
	
	
	
	
	
	
	
	
	
	

}