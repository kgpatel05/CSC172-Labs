/*
 * Krish Patel
 * Lab #2
 * CSC172 Introduction to Data Structures and Algorithms
 * Prof: Monica Polak
 * Date: 02/10/2024
 */


package lab2;

import java.util.ArrayList;
import java.util.List;

public class Lab2 {

	//Task 1
	
	public static void main(String[] args) {
		System.out.println("Task 1");
		
		List<Integer> firstList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) { firstList.add(i);}
        System.out.println("Original List: " + firstList);
        System.out.println("List without Element 2: " + Lab2.RemoveElements(firstList, 2));
		
        System.out.println();        
        List<Integer> secondList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) { secondList.add(4);} secondList.add(2);
        System.out.println("Original List: " + secondList);
        System.out.println("List without Element 4: " + Lab2.RemoveElements(secondList, 4));
        
        System.out.println(); 
        List<String > thirdListList = List.of( "a", "b", "c", "a");
        System.out.println("Original List: " + thirdListList);
        System.out.println("List without Element 'a': " + Lab2.RemoveElements(thirdListList, "a"));
        
		System.out.println("\nTask 2");
		
		System.out.println(Lab2.testSeries(10));
		
	}
	
	public static <T> List<T> createWithoutElementRec(List<T> list, T element)
	{
		int index = Lab2.existsIn(list, element);
		
		if( index == Integer.MIN_VALUE ) 
		{
			return list;
		}
		else {
			List<T> newlist = new ArrayList<>();
			for(int i = 0; i < list.size(); i++)
			{
				if(i != index)
				{
					newlist.add(list.get(i));
				}
			}
			return createWithoutElementRec(newlist, element);
		}
		
	}
	
	private static <T> int existsIn(List<T> list, T element)
	{
		//this is just a helper function to find which index the element is at
		for (int i = 0; i < list.size(); i++) 
		{
			if(list.get(i) == element)
			{
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static <T> List<T> RemoveElements(List<T> list, T element)
	{
		return Lab2.createWithoutElementRec(list, element);
	}
	
	
	
	//Task 2
	public static long seriesTerm(int n) 
	{
        // Base cases: f(0) = 0, f(1) = 1
        if (n == 0) 
        {
            return 0;
        } 
        else if (n == 1) 
        {
            return 1;
        } 
        else 
        {
            // Recursive case: f(n) = 2 * f(n-1) + 3 * f(n-2)
            return 2 * seriesTerm(n - 1) + 3 * seriesTerm(n - 2);
        }
	}
	
	public static long seriesTermTail(int n)
	{
		return Lab2.seriesTermRec(n, 1, 0);
	}
	
	private static long seriesTermRec(int n, long prev, long prev2)
	{
		
		if (n == 0) {
            return prev2;
        } 
		else {
            return seriesTermRec(n - 1, (2 * prev) + (3 * prev2), prev);
        }
		
	}
	
	public static boolean testSeries(int n)
	{
		if(Lab2.seriesTerm(n) == Lab2.seriesTermTail(n))
		{
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}
