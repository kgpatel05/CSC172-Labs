/*
 * Krish Patel
 * Lab #2
 * CSC172 Introduction to Data Structures and Algorithms
 * Prof: Monica Polak
 * Date: 02/17/2024
 */

package lab3;

public class CustomStack<T> {
	private Node<T> top;
    private int size;

    // Constructor
    public CustomStack() {
    	top = null;
        size = 0;
    }

    private static class Node<T> {
    	T data;
        Node<T> next;

        Node(T data) {
        	this.data = data;
            this.next = null;
        }
    }
    
    private static class Bunny {
    	String name;
    	String color;
    	
    	public Bunny(String name, String color)
    	{
    		this.name = name;
    		this.color = name;
    	}
    	
    	public void setName(String name)
    	{
    		this.name = name;
    	}
    	public void setColor(String color)
    	{
    		this.color = color;
    	}
    	public String getName()
    	{
    		return this.name;
    	}
    	public String getColor()
    	{
    		return this.color;
    	}
    	
    	public void print()
    	{
    		System.out.println("A " + this.color + " bunny named " + this.name + " jumpped out of a burrow");
    	}
    }

    public void push(T item) {
    	Node<T> newNode = new Node<T>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
    	if (isEmpty()) {
        	throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
    	if (isEmpty()) {
        	throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }
    public boolean isEmpty() {
    	return size == 0;
    }

    public int size() {
    	return size;
    }

    public static void main(String[] args) {
    	CustomStack<Integer> stack = new CustomStack<Integer>();

        stack.push(10);
        stack.push(20);
		stack.push(30);
		System.out.println(stack.peek());
		
		CustomStack<Bunny> bunnies = new CustomStack<Bunny>();
		bunnies.push(new Bunny("Josh", "Black"));
		bunnies.push(new Bunny("Bobby", "Light Blue"));
		bunnies.push(new Bunny("Rob", "Green"));
		
		bunnies.pop().print();
		bunnies.pop().print();
		bunnies.pop().print();

        }
}