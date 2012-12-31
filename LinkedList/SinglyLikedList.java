

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import sun.awt.image.ImageWatched.Link;

class LinkedList {

	int count;
	Node head;

	private class Node {

		Comparable data;
		Node next;

		Node(Comparable data) {
			this.next = null;
			this.data = data;
		}

		Node() {
			next = null;
		}
	}

	
	private class EnhancedNode {

		Comparable data;
		EnhancedNode next;
		EnhancedNode randomNext;

		EnhancedNode(Comparable data) {
			this.next = null;
			this.randomNext=null;
			this.data = data;
		}

		EnhancedNode() {
			next = null;
			randomNext=null;
		}
	}
	public LinkedList() {
		// TODO Auto-generated constructor stub

		Node head = new Node();
		this.count = 0;
	}

	/*
	 * public Comparable findNthNode(){
	 * 
	 * return findNthNode(head); }
	 */
	public Comparable findNthNode(int n) {

		Node p1 = head;
		Node p2 = head;
		for (int j = 0; j < n; ++j) { // make then n nodes apart.
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		while (p2 != null) { // move till p2 goes past the end of the list.
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1.data;

	}

	public void insert(Comparable obj) {
		Node newnode = new Node(obj);
		if (head == null) {
			head = newnode;
		} else {
			Node current = head;
			while (current.next != null)
				current = current.next;
			current.next = newnode;
		}

	}

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;

		}
	}

	private void insertAtFirst(Comparable obj) {
		Node newnode = new Node(obj);
		newnode.next = head;
		head = newnode;

	}

	public void reverse() {

		if (head.next == null)
			return;
		Node prev = head;
		Node current = head.next;
		while (current != null) {
			insertAtFirst(current.data);
			prev.next = current.next;
			current = current.next;

		}
	}

	public void insertAtNode(Node node, Comparable data) {
		if (node == head) {
			Node newNode = new Node(data);
			newNode.next = head.next;
			head = newNode;
		} else {
			Node newNode = new Node(data);
			newNode.next = node.next;
			node = newNode;
		}

	}

	public void reverseKth(int k) {

		if (head.next == null)
			return;
		Node prev = head;
		Node current = head.next;
		int count = 1;
		while (current != null) {
			if (count <= 3) {
				insertAtNode(prev, current.data);
				prev.next = current.next;
				current = current.next;
				count++;

			} else {
				count = 1;
				prev = current;
				current = current.next;
			}
		}

	}

	public LinkedList reverseRecursively(Node current, LinkedList reversedList) {
		if (current == null)
			return reversedList;
		reversedList.insertAtFirst(current.data);
		return this.reverseRecursively(current.next, reversedList);
	}

	public void Reverse(Node list) {
		/*if (list == null)
			return null; // first question

		if (list.next == null)
			return list; // second question

		// third question - in Lisp this is easy, but we don't have cons
		// so we grab the second element (which will be the last after we
		// reverse it)

		Node secondElem = list.next;

		// bug fix - need to unlink list from the rest or you will get a cycle
		list.next = null;

		// then we reverse everything from the second element on
		Node reverseRest = Reverse(secondElem);

		// then we join the two lists
		secondElem.next = list;

		return reverseRest;*/
		if (list == null)
			return; // first question

		/*if (list.next == null)
			return list; // second question
*/
		// third question - in Lisp this is easy, but we don't have cons
		// so we grab the second element (which will be the last after we
		// reverse it)

		
		
		Node secondElem = list.next;
		
		if(secondElem==null)
			return;

		
		// then we reverse everything from the second element on
		Reverse(secondElem);
		
		list.next.next=list;

		// bug fix - need to unlink list from the rest or you will get a cycle
		list.next = null;

		// then we join the two lists
		list=secondElem;

	}

	public LinkedList reverseWithThreeVar(LinkedList list) {

		Node current = list.head;
		Node prev=null;
		Node next;

		while (current != null) {
			
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			
		}

		return list;
	}

	public void frontBackSplit(LinkedList list) {
		Node slowPtr = list.head;
		Node fastPtr = list.head.next;

		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.head = list.head;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		list2.head = slowPtr.next;
		slowPtr.next = null;

		list1.display();

		System.out.println("LIST 2 IS::");
		list2.display();
	}

	public void frontBackSplit(LinkedList list, LinkedList list1,
			LinkedList list2) {
		Node slowPtr = list.head;
		Node fastPtr = list.head.next;

		list1 = new LinkedList();
		list2 = new LinkedList();
		list1.head = list.head;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		list2.head = slowPtr.next;
		slowPtr.next = null;

	}

	public Node mergesort(Node headOriginal) {

		if (headOriginal == null || headOriginal.next == null)
			return headOriginal;
		Node a = headOriginal;
		Node b = headOriginal.next;

		while (b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
		}
		b = a.next;
		a.next = null;

		// frontBackSplit(list,list1,list2);

		return merge(mergesort(a), mergesort(b));

	}

	public Node merge(Node a, Node b) {

		Node temp = new Node();
		Node head = temp;
		Node c = head;

		while (a != null && b != null) {
			Comparable val = a.data;
			if (val.compareTo(b.data) < 0) {
				c.next = a;
				a = a.next;
			} else {
				c.next = b;
				b = b.next;
			}

		}
		if (a == null) {
			while (b != null) {
				c.next = b;
				b = b.next;
			}
		}
		if (b == null) {
			while (a != null) {
				c.next = a;
				a = a.next;
			}
		}
		return c;
	}

	public void deleteAlternate() {
		Node currentNode = head;
		Node nextNode = head.next;
		while (currentNode != null && nextNode != null) {
			currentNode.next = nextNode.next;
			currentNode = currentNode.next;
			if (currentNode != null)
				nextNode = currentNode.next;
		}
		if (nextNode == null)
			currentNode.next = null;
	}

	public void findNthNodeFromEnd(int n) {

		Node offset = head;
		Node current = head;

		int i = 0;
		while (i < n && offset != null) {
			offset = offset.next;
			i++;
		}

		if (offset != null) {

			while (offset != null) {
				offset = offset.next;
				current = current.next;
			}
		}
		
		System.out.println("Nth DATA IS:"+current.data);

	}
	
	
	public LinkedList union(LinkedList list2){
		
		LinkedList unionList=new LinkedList();
		
		Node header1=this.head;
		Node header2=list2.head;
		Node header3=new Node();
		LinkedHashMap<Comparable, Node> map=new LinkedHashMap<Comparable, Node>();
		
		while(header1!=null){
			if(!map.containsKey(header1.data)){
				map.put(header1.data,header1);
				header1=header1.next;
			}
			else
				header1=header1.next;
		}
		
		while(header2!=null){
			if(!map.containsKey(header2.data)){
				map.put(header2.data,header1);
				header2=header2.next;
			}
			else
				header2=header2.next;
		}
		
		for(Comparable key:map.keySet()){
			if(unionList.head==null){
				
				Node node=new Node(key);
				header3.next=node;
				unionList.head=node;
				
			}	
			else{
				
				Node node=new Node(key);
				header3.next=node;
				
			}
			header3=header3.next;
		}
		
		return unionList;
	}
	
	
	public LinkedList intersection(LinkedList list2){

		
		LinkedList unionList=new LinkedList();
		
		Node header1=this.head;
		Node header2=list2.head;
		Node header3=new Node();
		LinkedHashMap<Comparable, Integer> map=new LinkedHashMap<Comparable, Integer>();
		
		while(header1!=null){
			if(!map.containsKey(header1.data)){
				map.put(header1.data,1);
				header1=header1.next;
			}
			else{
				map.put(header1.data,map.get(header1.data)+1);
				header1=header1.next;
			}
		}
		
		while(header2!=null){
			if(!map.containsKey(header2.data)){
				map.put(header2.data,1);
				header2=header2.next;
			}
			else{
				map.put(header2.data,map.get(header2.data)+1);
				header2=header2.next;
			}	
		}
		
		for(Comparable key:map.keySet()){
			
			if(map.get(key)>1){
				
				if(unionList.head==null){
					
					Node node=new Node(key);
					header3.next=node;
					unionList.head=node;
					
				}	
				else{
					
					Node node=new Node(key);
					header3.next=node;
					
				}
				header3=header3.next;
			}
			
			
		}
		
		return unionList;
	
	}
	
	
	public void removeDuplicates(){
		HashMap<Comparable, Integer> map=new HashMap<Comparable, Integer>();
		Node prev=head;
		Node current=head.next;
		map.put(head.data, 1);
		while(current!=null){
			if(map.containsKey(current.data)){
				prev.next=current.next;
				current=current.next;
			}
			else{
				map.put(current.data,1);
				prev=prev.next;
				current=current.next;
			}
		}
		
	}
	
	class TreeNode{
		Comparable data;
		
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {
			left=null;
			right=null;
		}
		public TreeNode(Comparable data) {
			// TODO Auto-generated constructor stub
			
			TreeNode node=new TreeNode();
			this.data=data;
			
		}
	}
	
	public TreeNode sortedListToBST(TreeNode root,Node start, Node end){
		if(start==end || start==end.next)
			return null;
		Node ptrSingle=start;
		Node ptrDouble=start;
		while(ptrDouble!=null && ptrDouble.next!=null){
			ptrSingle=ptrSingle.next;
			ptrDouble=ptrDouble.next.next;
		}
		TreeNode currentNode=new TreeNode(ptrSingle.data);
		if(root==null){
			root=currentNode;
			
		}
		else{
			if(currentNode.data.compareTo(root.data)<0)
				root.left=currentNode;
			else
				root.right=currentNode;
		}
		sortedListToBST(currentNode, start, ptrSingle);
		sortedListToBST(currentNode,ptrSingle,end);
		
		return  root;
	}
	
	
	public int numElements(Node h1){
	int count=0;
	HashSet<Node> hs=new HashSet();
	
	Node current=h1;
	while(!hs.contains(current)){
		count+=1;
		hs.add(current);
		current=current.next;
	}
	
	
	return count;
		
		
	}
	
	public Node swapK(Node h1, int K) {

		Node current = h1;
		Node beginner = h1;

		int count = 1;
		while (current != null && count <K) {
			current = current.next;
			// beginner=beginner.next;
			count++;
		}
		Node save1=null;
		if (current != null) {
			save1 = current;
		}

		while (current.next != null) {
			current = current.next;
			beginner = beginner.next;
		}
		
			Node save2 = beginner;
			
			Comparable temp=save1.data;
			save1.data=save2.data;
			save2.data=save1.data;
		return h1;
	}	
	
	
	public EnhancedNode clonedLinedList(EnhancedNode node){
		EnhancedNode clonedHead=null;
		EnhancedNode origCurrent=node;
		EnhancedNode clonedCurrent=null;
		HashMap<EnhancedNode,EnhancedNode> origToCloned=new HashMap<EnhancedNode, EnhancedNode>();
		HashMap<EnhancedNode,EnhancedNode> clonedToOrig=new HashMap<EnhancedNode, EnhancedNode>();
		while(origCurrent!=null){
			EnhancedNode newNode=new EnhancedNode(origCurrent.data);
			if(clonedHead==null){
				clonedHead=newNode;
				clonedCurrent=newNode;
			}
			origToCloned.put(origCurrent, clonedCurrent);
			clonedToOrig.put(clonedCurrent, origCurrent);
			clonedCurrent.next=newNode;
			origCurrent=origCurrent.next;
			clonedCurrent=clonedCurrent.next;
		}
		EnhancedNode current=clonedHead;
		while(current!=null){
			current.randomNext=origToCloned.get(clonedToOrig.get(current).randomNext);
			current=current.next;
		}
		return clonedHead;
	}
	
	Node MergeLists(Node list1, Node list2) {
		  if (list1 == null) {
		    return list2;
		  } 
		  if (list2 == null) {
		    return list1;
		  } 
		  
		  Comparable val1=list1.data;
		  
		  if(val1.compareTo(list2.data)<0){
			  list1.next = MergeLists(list1.next, list2);
			    return list1;  
		  }
		  else{
			  list2.next = MergeLists(list2.next, list1);
			    return list2;
		  }
		  
		/*  if (list1.data < list2.data) {
		    list1.next = MergeLists(list1.next, list2);
		    return list1;
		  } else {
		    list2.next = MergeLists(list2.next, list1);
		    return list2;
		  }*/
		}
	public EnhancedNode clonedLinkedList(EnhancedNode node){
		EnhancedNode origCurrent=node;
		EnhancedNode clonedCurrent=null;
		HashMap<EnhancedNode,EnhancedNode> nodeMap=new HashMap<EnhancedNode, EnhancedNode>();
		while(origCurrent!=null){
			EnhancedNode newNode=new EnhancedNode(origCurrent.data);
			nodeMap.put(clonedCurrent, clonedCurrent);
			origCurrent=origCurrent.next;
		}
		EnhancedNode current=node;
		while(current!=null){
			EnhancedNode clonedNode=nodeMap.get(current);
			/*current.next=nodeMap.get(current.next);
			current.randomNext=nodeMap.get(current.randomNext);*/
			clonedNode.next=nodeMap.get(current.next);
			clonedNode.randomNext=nodeMap.get(current.randomNext);
			current=current.next;
		}
		return nodeMap.get(node);
	}

}

public class SinglyLikedList {
	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(3);
		list.insert(5);

		
		LinkedList list2=new LinkedList();
		
		list2.insert(4);
		list2.insert(5);
		list2.insert(6);
		list2.insert(7);
		list2.insert(8);
		 list.display();
		// System.out.println("VALUE:" + list.findNthNode(2));
		 //list.Reverse(list.head);
		 list=list.reverseWithThreeVar(list);
		list.display();

		// LinkedList list2=new LinkedList().reverseRecursively(list.head,
		// list);
		// list.frontBackSplit(list);

		// list.head=list.mergesort(list.head);
		//list.deleteAlternate();
		//list.findNthNodeFromEnd(4);
		//LinkedList unionList=list.intersection(list2);
		//unionList.display();
		
		//list.removeDuplicates();
		list=list.reverseWithThreeVar(list);
	//	list.display();

		System.out.println("**************");
		//list.display();

	}

}
