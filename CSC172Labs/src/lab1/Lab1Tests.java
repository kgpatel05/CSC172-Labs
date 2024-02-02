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


}