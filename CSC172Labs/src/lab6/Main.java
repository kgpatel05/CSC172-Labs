/*
 * Krish Patel
 * Lab #6
 * CSC172 Introduction to Data Structures and Algorithms
 * Prof: Monica Polak
 * Date: 03/31/2024
 */

package lab6;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) 
	{
		
		//testing quicksort
		int[] lengths = new int[] {10, 100, 500, 1000, 5000, 10000, 50000, 100000};
		long[] times = new long[lengths.length];
		final int REPS = 20;
		for(int j = 0; j < lengths.length; j++)
		{
			for(int i = 0; i < REPS; i++)
			{
				long start = System.nanoTime();
				QuickSort.quickSort(makeRandomList(lengths[j]));
				times[j] += System.nanoTime() - start;
			}
		}
		//compute average
		for(int i = 0; i < times.length; i++)
		{
//			System.out.println(times[i]);
			times[i] = times[i]/REPS;
			System.out.println(times[i]);
		}

		long[] timesPQ = new long[lengths.length];
		for(int j = 0; j < lengths.length; j++)
		{
			for(int i = 0; i < REPS; i++)
			{
				long start = System.nanoTime();
				HeapPriorityQueue.sortWithPQ(makeRandomList(lengths[j]));
				timesPQ[j] += System.nanoTime() - start;
			}
		}
		//compute average
		for(int i = 0; i < times.length; i++)
		{
			timesPQ[i] = timesPQ[i]/REPS;
			System.out.println(timesPQ[i]);
		}
  
		System.out.println("Quick Sort");
		for(int j = 0 ; j < lengths.length; j++)
		{
			System.out.println("Average execution time on input size " + lengths[j] + ": " + times[j] + " nanoseconds");
		}
		System.out.println("Priority Queue Sorting");
		for(int j = 0 ; j < lengths.length; j++)
		{
			System.out.println("Average execution time on input size " + lengths[j] + ": " + timesPQ[j] + " nanoseconds");
		}
		
	}

    public static List<Integer> makeRandomList(int n)
    {
    	List<Integer> l = new ArrayList<Integer>();
    	for(int i = 0; i < n; i++)
    	{
    		l.add((int) ((Math.random() * (n))));
    	}
    	return l;
    }
}
