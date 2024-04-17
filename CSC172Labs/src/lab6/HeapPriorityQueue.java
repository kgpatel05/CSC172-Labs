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

public class HeapPriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public HeapPriorityQueue(int capacity) {
        this.heap = new int[capacity + 1]; // Adding 1 to capacity to skip index 0
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("Priority queue is full. Cannot insert.");
            return;
        }

        size ++;
        heap[size] = value;
        swim(size);
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty. Cannot delete.");
            return -1;
        }

        int max = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;
        sink(1);
        return max;
    }

    private void swim(int index) {
        while (index >= 1 && heap[index] < heap[parent(index)]){
        swap(index, parent(index));
        index = parent(index);
        }
    }

    private void sink(int index) {
        int maxIndex = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        
        if (rightChild <= size && heap[maxIndex] > heap[rightChild]){
            maxIndex = rightChild; }

        if (leftChild <=  size && heap[maxIndex] > heap[leftChild]){
            maxIndex = leftChild;}
        
        if (index != maxIndex){
            swap(index,maxIndex);
            sink(maxIndex);
        }
    }

    private int parent(int index) {
        return index/2;
    }

    private int leftChild(int index) {
        return 2*index;
    }

    private int rightChild(int index) {
        return 2*index +1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printQueue() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    public static List<Integer> sortWithPQ(List<Integer> l)
    {
    	HeapPriorityQueue pq = new HeapPriorityQueue(l.size());
    	for(int val: l)
    	{
    		pq.insert(val);
    	}
    	List<Integer> newlist = new ArrayList<Integer>();
    	while(!pq.isEmpty())
    	{
    		newlist.add(pq.remove());
    	}
    	return newlist;
    }

    public static void main(String[] args) {
        HeapPriorityQueue priorityQueue = new HeapPriorityQueue(5);
        priorityQueue.insert(3);
        priorityQueue.insert(8);
        priorityQueue.insert(1);
        priorityQueue.insert(5);
        priorityQueue.insert(2);

        priorityQueue.printQueue();

        System.out.println("Deleting min element: " + priorityQueue.remove());
        System.out.println("Deleting min element: " + priorityQueue.remove());

        priorityQueue.printQueue();
    }
}