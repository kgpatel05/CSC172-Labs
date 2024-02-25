package workshop3;

public class CustomLinkedList {

    public Node head;

    public CustomLinkedList(Node node)
    {
        this.head = node;
    }
    public CustomLinkedList(int data)
    {
        this.head = new Node(data, null);
    }
    public CustomLinkedList()
    {
        this.head = null;
    }


    public void addNode(int data)
    {
        if(head == null) this.head = new Node(data);
        else if(head.next == null){
            head.next = new Node(data);
        }
        
        else{
            Node node = head;
            while(node.next.next != null)
            {
                node = node.next;
            }
            node.next = new Node(data);
        }
    }

    //write a method to delete the last element from a given linked link
    //this method has O(n)
    public void deleteLast()
    {
        if(this.head == null) return;
        if(this.head.next == null) return;
        else
        {
            Node node = this.head;
            while(node.next.next != null)
            {
                node = node.next;
            }
            node.next = null;
        }
        return;
    }

    public void print()
    {
    	System.out.println("Printing");
    	if(head == null)
        {
            System.out.println("The list is epmty");
        }
        else{
        	Node n;
            for( n = head; n.next != null; n = n.next )
            {
                System.out.println(n.data + ", ");
            }
            System.out.println(n.data);
        }
    }

    public static void main(String args[])
    {
        CustomLinkedList l = new CustomLinkedList();
        l.addNode(0);
        l.addNode(1);
        l.addNode(2);
        l.addNode(6);
        l.deleteLast();

        l.print();


    }

    public class Node
    {
        public int data;
        public Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
}
