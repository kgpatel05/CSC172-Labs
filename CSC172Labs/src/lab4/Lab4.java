/*
 * Krish Patel
 * Lab #4
 * CSC172 Introduction to Data Structures and Algorithms
 * Prof: Monica Polak
 * Date: 02/24/2024
 */

package lab4;

import java.util.Random;


public class Lab4 
{
	
	public static int BinarySearch(int arr[], int target, int start, int end)
	{
		if(start > end) return -1;
		int mdIndex = (end+start)/2;
		if(arr[mdIndex] == target) return mdIndex;
		
		if( arr[mdIndex] < target)
		{
			start = mdIndex + 1;
			return BinarySearch(arr, target, start, end);
		}
		else {
			end = mdIndex - 1;
			return BinarySearch(arr, target, start, end);
		}
	}
	
	public static int binarySearch(int arr[], int target, int start, int end)
	{
		//TODO: Does not work if target value is larger than the largest value in the array
		
		
		while (start < end)
		{
			
			int mdIndex = (start+end)/2;
			if(mdIndex < arr.length && arr[mdIndex] == target) return mdIndex;
			else{
				if(arr[mdIndex] < target)
				{
					start = mdIndex + 1;
				}
				else
				{
					end = mdIndex;
				}
			}
		}
		return -1;
	}
	
	public static int linearSearch(int[] arr, int target)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] == target) return i;
		}
		return -1;
	}
	
	public static void printBS(int[] arr, int target, int index)
	{
		System.out.print("Binary Search on ");
		System.out.print("[");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		 System.out.print("]: Element " + target + " found at index " + index + "\n");
	}
	
	public static void printLS(int[] arr, int target, int index)
	{
		System.out.print("Linear Search on ");
		System.out.print("[");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		 System.out.print("]: Element " + target + " found at index " + index + "\n");
	}
	
	public static void Tests()
	{
		int[] arr = new int[] {1,2,3,4,5};
		printBS(arr, 2, binarySearch(arr, 2, 0, arr.length));
		
		int[] arr1 = new int[] {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
		printBS(arr, 6, binarySearch(arr1, 6, 0, arr1.length));
		
		int[] arr2 = new int[] {6,78,234,456,76543};
		printBS(arr2, Integer.MIN_VALUE, binarySearch(arr2, 2, 0, arr2.length));
		
		int[] arr3 = new int[] {6,777,777,864};
		printBS(arr3, 777, binarySearch(arr3, 777, 0, arr3.length));
		
		int[] arr4 = new int[] {1,2,3,4,5,89,234,1231,2334,622345,245345284};
		printBS(arr4, Integer.MAX_VALUE, binarySearch(arr4, Integer.MAX_VALUE, 0, arr4.length));
		
		
		
		arr = new int[] {1,2,3,4,5};
		printLS(arr, 2, linearSearch(arr, 2));
		
		arr1 = new int[] {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
		printLS(arr, 6, linearSearch(arr1, 6));
		
		arr2 = new int[] {6,78,234,456,76543};
		printLS(arr2, Integer.MIN_VALUE, linearSearch(arr2, 2));
		
		arr3 = new int[] {6,777,777,864};
		printLS(arr3, 777, linearSearch(arr3, 777));
		
		arr4 = new int[] {1,2,3,4,5,89,234,1231,2334,622345,245345284};
		printLS(arr4, Integer.MAX_VALUE, linearSearch(arr4, Integer.MAX_VALUE));
	}

	public static void averageExecTime(int size, String type)
	{
		
		//In this method, I run each case 100000 times in order to get a
		//true average value; Each time we are searching for a random value in the
		//array from 0 to size
		int repetitions = 100000;
		
		long[] times = new long[repetitions];
		for(int j = 0; j < repetitions; j++)
		{
			int[] arr = new int[size];
			for(int i = 0; i < size; i++ )
			{
				arr[i] = i;
			}
			int target = (new Random()).nextInt(0, size);
			
			if(type == "LS")
			{
				long begin = System.nanoTime();
				linearSearch(arr, target);
				long end = System.nanoTime();
				times[j] = end-begin;
			}
			if(type == "BS")
			{
				long begin = System.nanoTime();
				binarySearch(arr, target, 0, arr.length);
				long end = System.nanoTime();
				times[j] = end-begin;
			}
			
		}
		
		int sum = 0;
		for( int j = 0 ; j < repetitions; j++ )
		{
			sum += times[j];
		}
		
		System.out.println("Input Size: " + size + " , Average Execution Time: " + sum/repetitions + " nanoseconds");
	}
	
	public static void main(String[] args) 
	{

		System.out.println("Test Cases");
		Lab4.Tests();
		
		System.out.println("Execution Times");
		System.out.println("Binary Search");
		Lab4.averageExecTime(10, "BS");
		Lab4.averageExecTime(100, "BS");
		Lab4.averageExecTime(500, "BS");
		Lab4.averageExecTime(1000, "BS");
		Lab4.averageExecTime(5000, "BS");
		Lab4.averageExecTime(10000, "BS");
		Lab4.averageExecTime(50000, "BS");
		Lab4.averageExecTime(100000, "BS");
		
		
		System.out.println("Linear Search");
		Lab4.averageExecTime(10, "LS");
		Lab4.averageExecTime(100, "LS");
		Lab4.averageExecTime(500, "LS");
		Lab4.averageExecTime(1000, "LS");
		Lab4.averageExecTime(5000, "LS");
		Lab4.averageExecTime(10000, "LS");
		Lab4.averageExecTime(50000, "LS");
		Lab4.averageExecTime(100000, "LS");
	}
	
	

}
