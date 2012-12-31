import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

class BinaryTree {
	// Node class
	private class Node {

		public Comparable data; // node data
		public Node right; // right child
		public Node left; // left child

		public Node parent;

		public Node(Comparable data) // node constructor
		{

			this(data, null, null);
		}

		public Node(Comparable data, Node left, Node right) // node constructor
		{

			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public Node root; // root variable
	public int size; // size variable

	public BinaryTree() // tree constructor
	{
		size = 0;
		root = null;
	}

	// Goes through nodes of the tree in order and prints the data of each node.
	public void printTree() {
		if (size == 0)
			System.out.println("Empty");
		else {
			System.out.println("Tree contents:");
			inorder(root);
		}
	}

	// inOrder algorithm for printTree.
	public void inorder(Node current) {
		if (current != null) {
			inorder(current.left);
			System.out.println(current.data);
			inorder(current.right);
		}
	}
	

	public void preOrderIter(Node root) {

		Stack<Node> stack = new Stack<Node>();

		Node current = root;
		stack.push(current);

		while (!stack.isEmpty()) {

			Node temp = stack.pop();

			System.out.println(temp.data);
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);

		}

	}
	
	public void inOrderIter(Node root){
		
		Stack<Node> stack =new Stack<Node>();
		Node current=root;
		stack.push(current);
		while(current!=null || !stack.isEmpty()){
			current=current.left;
			if(current!=null){
				stack.push(current);
				current=current.left;
			}
			else{
				current=stack.pop();
				System.out.println(current.data);
				current=current.right;
					
			}
			
		}
		
	}
	
	public void inOrderTraversalIterative(Node root) {

		Stack<Node> stack = new Stack<Node>();

		Node current = root;

		while (current != null || stack.size() > 0) {

			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {

				current = stack.pop();
				System.out.println(current.data);
				current = current.right;

			}
		}
	}

	
	//LRD
	
	public void postOrderIter(Node root){
		
		Stack<Node> temp=new Stack<Node>();
		Stack<Node> output=new Stack<Node>();
		
		temp.add(root);
		
		while(!temp.isEmpty()){
			
			Node current=temp.pop();
			output.push(current);
			if(current.left!=null){
				temp.push(current.left);
			}
			if(current.right!=null){
				temp.push(current.right);
			}
		}
		
		//print the elemetns of output stack;
		
	}
	
	//RLD
	/*public void reversedPostOrderIter(Node root){
		
		Stack<Node> temp=new Stack<Node>();
		Queue<Node> output=new Queue<Node>();
		
		temp.add(root);
		
		while(!temp.isEmpty()){
			
			Node current=temp.pop();
			output.add(current);
			if(current.left!=null){
				temp.push(current.left);
			}
			if(current.right!=null){
				temp.push(current.right);
			}
		}
		
		//print the elemetns of output queue;
		
	}*/


	
	//NOT WORKING
	public Comparable[] inorder(Node current, Comparable arr[], int size) {
		if (current != null) {
			size++;
			inorder(current.left, arr, size);
			arr[size] = current.data;
			//size++;
			inorder(current.right, arr, size);
			size++;

		}
		
		return arr;
	}
	
	public void getTreeElements(Node root, Comparable a[], int i) {

		if (root == null)
			return;
		getTreeElements(root.left, a, i);

		a[i] = root.data;
		i += 1;
		getTreeElements(root.right, a, i);

	}

	public Comparable[] getTreeElementsIter(Node root, int size) {

		Comparable elements[] = new Comparable[size];

		Stack<Node> stack = new Stack<Node>();
		int i = 0;

		Node current = root;

		while (current != null || stack.size() > 0) {

			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {

				current = stack.pop();
				elements[i++] = current.data;
				current = current.right;

			}
		}

		return elements;

	}

	public boolean isBST() {

		Comparable arr[] = new Comparable[50];
		Comparable output[] = inorder(root, arr, 0);

		for (int i = 0; i < output.length; i++)
			System.out.println(output[i]);

		return true;
	}
//try without saving the data to an array.
	public boolean isBSTOptimized(Node root) {


		
		if(root==null)
			return true;
		
		else if((root.left!=null &&root.left.data.compareTo(root.data) >0) || (root.right!=null &&root.right.data.compareTo(root.data)<0) )
			return false;
		else{
			
			return (isBSTOptimized(root.left) && isBSTOptimized(root.right)); 
		}
	}

	public void insert(Comparable data) {
		root = insert(data, root);
	}

	// Insert helper method
	private Node insert(Comparable data, Node current) {
		if (current == null) // location found
		{
			size++; // increment size
			current = new Node(data, null, null); // create a new node and
			// assign current to it
		} else if (data.compareTo(current.data) < 0) // data is less than
		// current node's data
		{
			current.left = insert(data, current.left); // call insert on
			// current's left
		} else if (data.compareTo(current.data) > 0) // data is greater than
		// current node's data
		{
			current.right = insert(data, current.right); // call insert on
			// current's right

			// System.out.println(current.data);
		}
		return current;
	}

	/*
	 * Searches binary tree for a comparable object equal to the given object.
	 * Returns true if object is found and false otherwise.
	 */
	public boolean search(Comparable data) {
		return search(data, root);
	}

	// Search helper method
	private boolean search(Comparable data, Node current) {

		if (current == null) // data not found
		{
			return false;
		} else if (current.data == data)// data found
		{
			return true;
		} else if (data.compareTo(current.data) < 0) // data is less than
		// current node's data
		{
			return search(data, current.left); // search the left of current
			// node
		} else // data is greater than current node's data
		{
			return search(data, current.right); // search the right of current
			// node
		}
	}

	// Returns true if node with target data was deleted, false otherwise
	public boolean remove(Comparable key) {
		if (search(key)) {
			delete(key);
			return true;
		} else {
			return false;
		}
	}

	public void delete(Comparable key) {
		// Algorithm note: There are four cases to consider:
		// 1. The node is a leaf.
		// 2. The node has no left child.
		// 3. The node has no right child.
		// 4. The node has two children.

		// initialize parent and current to root
		Node current = root;
		Node parent = root;

		boolean isLeftChild = true;

		// while loop to search for node to delete
		while (current.data.compareTo(key) != 0) {
			// assign parent to current
			parent = current;
			if (current.data.compareTo(key) > 0) {
				isLeftChild = true; // current is a left child
				current = current.left; // make current's left child the current
				// node
			} else {
				isLeftChild = false; // current is a right child
				current = current.right; // make current's right child the
				// current node
			}
			if (current == null)// data can't be found, break from loop
				return;
		}
		// test for a leaf
		if (current.left == null && current.right == null) {
			if (current == root) // tree has a single node, make root null
				root = null;
			else if (isLeftChild) // current is a left child so make its
				// parent's left null
				parent.left = null;
			else
				parent.right = null; // current is a right child so make its
			// parent's right null
		}
		// test for no right child
		else if (current.right == null)
			if (current == root) // current is root so make root point to
				// current's left
				root = current.left; // old root gets deleted by garbage
			// collector
			else if (isLeftChild) // current is a left child so make its
				// parent's left point to it's left child
				parent.left = current.left;
			else
				// current is a right child so make its parent's right point to
				// it's left child
				parent.right = current.left;
		// test for no left child
		else if (current.left == null)
			if (current == root) // current is root so make root point to
				// current's right
				root = current.right; // old root gets deleted by garbage
			// collector
			else if (isLeftChild) // current is a left child so make its
				// parent's left point to it's right child
				parent.left = current.right;
			else
				// current is a right child so make its parent's right point to
				// it's right child
				parent.right = current.right;
		// there are two children:
		// retrieve and delete the inorder successor
		else {

			Node successor = getSuccessor(current); // get successor

			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.left = successor; // set node to delete to successor
			else
				parent.right = successor;
			// attach current's left to successor's left since successor has no
			// left child
			successor.left = current.left;
		}
	}

	// This method searches the successor of a node to be deleted
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.right;

		while (current != null) {

			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if (successor != delNode.right) {

			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}

	void mirrorTree() {

		mirror(root);

	}

	void mirror(Node current) {
		if (current != null) {
			Node temp = current.left;
			current.left = current.right;
			current.right = temp;
			mirror(current.left);
			mirror(current.right);

		}
	}

	public Boolean isSymmetricTree() {
		if (root == null || (root.left == null && root.right == null))
			return true;
		else
			return isSymmetric(root.left, root.right);
	}

	private Boolean isSymmetric(Node left, Node right) {
		if (left == null && right == null)
			return true;
		else if (left == null && right != null)
			return false;
		// return (left.data==right.data && isSymmetric(left.right,
		// right.left)&& isSymmetric(left.right, right.left));
		return (isSymmetric(left.right, right.left) && isSymmetric(left.right,
				right.left));

	}

	public int numNodes() {

		return (numNodes(root));
	}

	private int numNodes(Node t) {
		// if(t!=null)
		// System.out.println(t.data);
		// else System.out.println(t);
		if (t == null)
			return 0;
		return (1 + numNodes(t.left) + numNodes(t.right));

	}

	public int height() {

		return (heightMine(root));
	}

	private int height(Node t) {

		if (t == null)
			return 0;
		int heightLeft = height(t.left);
		int heightRight = height(t.right);

		if (heightLeft > heightRight)
			return heightLeft + 1;
		else
			return heightRight + 1;
	}

	private int heightMine(Node t) {
		if (t == null)
			return 0;
		else
			return (1 + Math.max(heightMine(t.left), heightMine(t.right)));
	}

	void printPaths() {
		Comparable[] path = new Comparable[100];
		printPathsRecur(root, path, 0);
	}

	/*
	 * Recursive helper function -- given a node, and an array containing the
	 * path from the root node up to but not including this node, print out all
	 * the root-leaf paths.
	 */
	void printPathsRecur(Node node, Comparable path[], int pathLen) {
		if (node == null)
			return;

		/* append this node to the path array */
		path[pathLen] = node.data;
		pathLen++;

		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null) {
			printArray(path, pathLen);
		} else

			/* otherwise try both subtrees */
			printPathsRecur(node.left, path, pathLen);
		printPathsRecur(node.right, path, pathLen);
	}

	/* UTILITY FUNCTIONS */
	/* Utility that prints out an array on a line. */
	void printArray(Comparable ints[], int len) {
		int i;
		for (i = 0; i < len; i++) {
			// printf("%d ", ints[i]);
			System.out.print("\t" + ints[i]);
		}
		System.out.println();
	}

	public int CountLeafNodes(Node root) {

		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		else
			return (CountLeafNodes(root.left) + CountLeafNodes(root.right));

	}

	
	/*void printLevelOrder(Node root) {
		  if (root==null) return;
		  Queue<Node> nodesQueue=new Queue<Node>();
		  int nodesInCurrentLevel = 1;
		  int nodesInNextLevel = 0;
		  nodesQueue.add(root);
		  while (!nodesQueue.isEmpty()) {
		    Node currNode = nodesQueue.peek();
		    nodesQueue.remove();
		    nodesInCurrentLevel--;
		    if (currNode!=null) {
		      System.out.println(currNode.data+" ");
		      nodesQueue.add(currNode.left);
		      nodesQueue.add(currNode.right);
		      nodesInNextLevel += 2;
		    }
		    if (nodesInCurrentLevel == 0) {
		      System.out.println();
		      nodesInCurrentLevel = nodesInNextLevel;
		      nodesInNextLevel = 0;
		    }
		  }
		}*/
	void printLevelOrder(Node root) {
		  if (root==null) return;
		  Stack<Node> nodesStack=new Stack<Node>();
		  int nodesInCurrentLevel = 1;
		  int nodesInNextLevel = 0;
		  nodesStack.push(root);
		  while (!nodesStack.isEmpty()) {
		    Node currNode = nodesStack.peek();
		    nodesStack.pop();
		    nodesInCurrentLevel--;
		    if (currNode!=null) {
		      System.out.println(currNode.data+" ");
		      nodesStack.push(currNode.right);
		      nodesStack.push(currNode.left);
		      nodesInNextLevel += 2;
		    }
		    if (nodesInCurrentLevel == 0) {
		      System.out.println();
		      nodesInCurrentLevel = nodesInNextLevel;
		      nodesInNextLevel = 0;
		    }
		  }
		}
	public void levelOrderTraversal(Node root) {

	}

	public void spiralOrderTraversal(Node root) {

	}

	public int getwidth(Node root) {
		int maxWidth = 0;
		int height = height();
		for (int i = 1; i <= height; i++) {
			int width = getLevelWidth(root, i);
			if (width > maxWidth) {
				maxWidth = width;
			}
		}
		return maxWidth;

	}

	public int getLevelWidth(Node root, int level) {

		if (level == 0)
			return 0;
		else if (level == 1)
			return 1;
		else {
			return (getLevelWidth(root.left, level - 1) + getLevelWidth(
					root.right, level - 1));
		}

	}

	public void getTreeProperties(Node root) {
		// get height
		// get no of nodes
		// get no of leaf nodes
		// get no of levels
		// get max width of tree.

	}

	public void lowestCommonAnscetor(Node root, int data1, int data2) {

	}

	public Node convertToDLL(Node root) {

		Node head = null;

		Stack<Node> stack = new Stack<Node>();

		Node current = root;
		Node prev = null;

		while (!stack.empty() || current != null) {

			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.peek();
				stack.pop();
				if (head == null) {
					head = current;
					prev = current;
				} else {
					prev.right = current;
					current.left = prev;
				}
				current = current.right;
			}

		}

		return head;

	}

	
	
	/*
	 * void InorderTraverseNoRecursiveIteration(Node root){ if (root==null){
	 * return; } Node prev = null; Node cur = root; while (cur!=null){ if
	 * (prev!=null || prev.left == cur || prev.right == cur) { if
	 * (cur.left!=null) { cur = cur.left; } else if(cur.right!=null) {
	 * System.out.println(); // System.out.println(current.ri); // cout <data
	 * <right; } else { cur = prev; } } else if (cur.left == prev)
	 * System.out.println(); { // cout <data right) // { cur = cur.right; // }
	 * else { cur = cur.parent; } } else if (cur.right == prev) { cur =
	 * cur.parent; } prev = cur; } }
	 * 
	 * 
	 */

	public void BTtoBST(Node root) {

		Comparable array[] = new Comparable[size];
		Node current = root;
		
		array = getTreeElementsIter(root, size);

		Arrays.sort(array);

		Stack<Node> stack = new Stack<Node>();
		int i = 0;
		while (current != null || stack.size() > 0) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {

				current = stack.pop();

				current.data = array[i++];

				current = current.right;

			}
		}

	}
}

public class BinaryTreeProgram {
	public static void main(String[] args) {

		BinaryTree BT = new BinaryTree();
		BT.insert(5);
		BT.insert(10);
		BT.insert(1);
		BT.insert(20);
		BT.insert(8);
		// BT.insert(19);
		// BT.insert(21);

		BT.insert(3);
		BT.insert(-10);

		Comparable array[] = new Comparable[BT.size];
		
		BT.printLevelOrder(BT.root);
		//BT.getTreeElements(BT.root, array, 0);
		// BT.getTreeElements(BT.root, array,0);
//
	//	BT.BTtoBST(BT.root);

		// BT.inOrderTraversalIterative(BT.root);

		// System.out.println(BT.CountLeafNodes(BT.root));\
		//boolean result=BT.isBSTOptimized(BT.root);
		// BT.isBST();
		// BT.insert(2);
		// BT.insert(4);
		// boolean val=BT.mirrorTree();

		// BT.printTree();
		System.out.println("\n*************\n");
		// System.out.println("value:"+BT.isSymmetricTree());
		// BT.mirrorTree();
		// BT.printTree();
		// BT.inorder()
		// BT.printTree();
		// System.out.println("no nodes:"+BT.numNodes());
		// System.out.println("HEIGHT:"+BT.height());
		// BT.printPaths();

	}
}
