/*
 * Krish Patel
 * Lab #5
 * CSC172 Introduction to Data Structures and Algorithms
 * Prof: Monica Polak
 * Date: 03/23/2024
 */

package lab5;

public class BinaryTree {
	private BinaryTree left;
	private int value;
	private BinaryTree right;

	public BinaryTree(BinaryTree left, int value, BinaryTree right) {
		this.left = left;
		this.value = value;
		this.right = right;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

    public int getValue() {
        return value;
    }


    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public static BinaryTree binarySearch(BinaryTree root, int target) {
        if (root == null) {
            return null;}
        else {
            if (target < root.getValue()){
                return binarySearch(root.getLeft(), target);
            } else if (target > root.getValue()){
                return binarySearch(root.getRight(), target);
            } else {
                return root;  // target == root.getValue()
            }
        }
    }

    public static BinaryTree insert(BinaryTree root, int value) {
        if (root == null){
            return new BinaryTree(null, value, null);
        } else {
            if (root.getValue() <= value){
                root.setRight(insert(root.getRight(), value));
            } else if (root.getValue() > value) {
                root.setLeft(insert(root.getLeft(), value));
            }
        }
        return root;
    }

    public static void printInOrder(BinaryTree tree)
    {
    	if (tree == null) return;
        printInOrder(tree.left);
        System.out.print(tree.value + " ");
        printInOrder(tree.right);
    }
    
    public static void printPreOrder(BinaryTree tree)
    {
        if (tree == null) return;
        System.out.print(tree.value + " ");
        printPreOrder(tree.left);
        printPreOrder(tree.right);
    }
    
    public static void printPostOrder(BinaryTree tree)
    {

        if (tree == null) return;
        printPostOrder(tree.left);
        printPostOrder(tree.right);
        System.out.print(tree.value + " ");

    }
    
    public static BinaryTree findMinNode(BinaryTree tree)
    {
    	while(tree.left != null) tree = tree.left;
    	return tree;
    }
    
    public static BinaryTree removeNode(BinaryTree tree, int value)
    {
        // BaseCase
        if (tree == null)
            return tree;
 
        //find node to delete
        if (tree.value > value) 
        {
            tree.left = removeNode(tree.left, value);
            return tree;
        } 
        else if (tree.value < value) 
        {
            tree.right = removeNode(tree.right, value);
            return tree;
        }
 
 
        //1 kid
        if (tree.left == null) 
        {
            BinaryTree temp = tree.right;
            return temp;
        } 
        else if (tree.right == null) 
        {
            BinaryTree temp = tree.left;
            return temp;
        }
 
        //2 kids
        else {
 
            BinaryTree succParent = tree;
 
            // smallest in the right tree
            BinaryTree succ = tree.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            if (succParent != tree)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;
 
            tree.value = succ.value;
 
            return tree;
        }
    	
    }
    
    public static void main(String[] args) {
        BinaryTree root = null;
        root = insert(root, 25);
        insert(root, 15);
        insert(root, 10);
        insert(root, 20);
        insert(root, 30);
        insert(root, 35);
        
        System.out.println("In-Order");
        printInOrder(root);
        System.out.println("\nPre-Order");
        printPreOrder(root);
        System.out.println("\nPost-Order");
        printPostOrder(root);
        
        removeNode(root, 30);
        System.out.println("\nBinary Search Tree after removing node with value 30:");
        printInOrder(root);
        
        removeNode(root, 10);
        System.out.println("\nBinary Search Tree after removing node with value 10:");
        printInOrder(root);
    }
}