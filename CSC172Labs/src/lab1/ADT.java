package lab1;

public class ADT implements Comparable<Object>{
	
	public int value;

	public ADT(int value)
	{
		this.value = value;
	}
	

	public String toString(){
		
		return Integer.toString(value);

	}


	@Override
	public int compareTo(Object o) {
		
		if(this.hashCode() == o.hashCode())
		{
			return 0;
		}
		else if(this.hashCode() > o.hashCode())
		{
			return 1;
		}
		return -1;
		
	}
	
	
}