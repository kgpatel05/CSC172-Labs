package workshop1;

import java.util.ArrayList;
import java.util.List;

public class Workshop1 {

	
	public static void main(String args[])
	{
		//Problem 1:
		System.out.println((0+15)/2); //since all values are integers the output is truncated to an integer as well
		System.out.println(2.0e-6 * 100000000.1); //just basic arithmetic
		System.out.println((true && false || false && true)); //this statement will always be false
		
		//Problem 2:
		//Write a method that returns an absolute value of an integer value x.
		System.out.println(Workshop1.absval(-5));
		
		//Problem 4:
		//Write a program that takes three integer command-line arguments and prints equal if 
		//all three are equal, and not equal otherwise.
		if(args.length == 3)
		{
			if(args[0] == args[1] && args[1] == args[2]) System.out.println(true);
			else {System.out.println(false);}
		}
		
		for (int i = 0; i < 6; i++ )
		{
			System.out.println(Workshop1.fib(i));
			
		}
		
		System.out.println("////////////////////////");
		for (int i = 0; i < 6; i++ )
		{
			System.out.println(Workshop1.fibonacci(i));
			
		}
	}
	
	//Problem 2
	public static int absval(int x)
	{
		if(x < 0)
		{
			return -1*x;
		}
		return x;
	}
	
	//Problem 3: Creating a java ADT
	public class Date
	{
		private int month, day, year;
		public Date(int month, int day, int year) 
		{
			this.month = month;
			this.day = day;
			this.year = year;
		}
		
		public int getMonth()
		{
			return month;
		}
		public int getYear()
		{
			return year;
		}
		public int getDay()
		{
			return day;
		}
		public boolean equals(Date that)
		{
			if(this.month == that.month && this.year == this.year && this.day == this.day) return true;
			return false;
		}
		
		public int compareTo(Date that)
		{
			if(this.equals(that)) return 0;
			
			if(this.year < that.year) return -1;
			else {
				if(this.month < that.year) return -1;
				else {
					if(this.day < that.day) return -1;
				}
			}
			
			return 1;
		}
		
		@Override
		public String toString()
		{
			return month + "/" + day + "/" + year;
		}
	}
	
	//Problem 5:
	//Write a program to generate the Fibonacci sequence up to a specified number of terms.
	public static int fib(int n)
	{
		
		int first = 1;
		int second = 1;
		int accum = 0;
		
		for (int i = 0; i < n; i++ )
		{
			accum = first+second;
			first = second;
			second = accum;
		}
		
		return accum;
	}
	
	//rewrite fibonnacci code with recursion and optimized
	public static int fibonacci(int n)
	{
		
		List<Integer> seq = new ArrayList<Integer>();
		for(int i = 0; i < n+1; i++ )
		{
			seq.add(Integer.MIN_VALUE);
		}
		return Workshop1.fibRec(n, seq);
	}
	
	public static int fibRec(int n, List<Integer> seq)
	{
		if(n==0) return 1;
		if(n==1) return 1;
		if(seq.get(n) != Integer.MIN_VALUE)
		{
			return seq.get(n);
		}
		else {
			int temp = fibRec(n-1, seq) + fibRec(n-2, seq);
			seq.add(n, temp);
			return temp;
		}
	}
	
	
	
}
