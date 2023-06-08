
package cs146F22.Jorapur.project1;


/**
 * The class is the SinglyLinkedList to implement a set of items.
 * @author Aditi Jorapur
 * @date 9/28/22
 *
 */
public class SinglyLinkedList<T>{
	
	//Instance variable for SinglyLinkedList class: head is initially set to null.
	private Node head = null;
	
	/**
	 * This is an inner class in the SinglyLinkedList class. It gives the class access to the Node object. SinglyLinkedlIsts consists of Node objects which is why we use the inner Node class. The SinglyLinkedList class implements Generics <T> which means any data type can be used as a Node. For example, you can use integers, Strings, or any other data types in the class.
	 *
	 */
	public class Node{
		
		// Instance variables of Node class: next value and data 
		private Node next;
		private T data;
		
		
		//constructor for the Node class initializing next and data
		public Node(T data, Node next) {
			this.next = next;
			this.data = data;
		}
		
		public T getData() {
			return data;
		}
		
		
	}
	
	//make a clone method for the first while loop in union and then in the singlylinkedlist test for reference, check node as well, test cases for clone method
	//clone method on project report
	
	//add in the head, search in linear time
	//remove: stop at the previous node so we don't loose access; current.next = current.next.next
	// ignore it, don't reference it (linear time)
	//reference to a node: return value is a node
	// union and intersection: union is all distinct values, intersection is common element
	
/**	
 * This public method first creates a new node with the data called node. 
 * Then, it checks to see if the list is empty by checking to see if the head is equal to null. 
 * If it is empty, it adds the new node at the front of the list. Then, it checks if the node is already a member of the set. 
 * If it is not a member of the set, then the node is added at the head of the LinkedList. 
 * @param n
 */
	
	public void add(T n) {
		Node node = new Node(n, null);
		if(head == null) {
			head = node;
		}
		if(!isMember(n)) {
			node.next = head;
			head = node;
		}
		
	}
	
	
	/**
	 * This public method removes a node from the SinglyLinkedList. 
	 * First it checks whether the list is empty by checking if the head is null. 
	 * If it is empty, then the method just returns and doesn’t do anything. 
	 * Then it checks whether the node we want to remove is in the head. If it is in the head, it will remove the node from the head and set the next node to the new head. 
	 * Then, it creates a temporary node called node which is equal to the head. 
	 * The method traverses through the LinkedList until it finds the next node that has the same data as ‘n’. If the data is equal to ‘n’, then we point to the node after to remove the node. 
	 * @param n- data passed in
	 */	
	public void remove(T n){
		if(head == null) {
			return;
		}
		
		if(n.equals(head.data)) {
			head = head.next; 
			return;
		}
		
		Node node = head;
		
		while(node.next != null) {
			if(n.equals(node.next.data)){
				node.next = node.next.next;
				return;
			}
			node = node.next;
		}
	}
	
/**
 * This method returns the number of items in the set. 
 * It sets the temporary variable current to the head and then traverses through the LinkedList until it reaches the end. 
 * It then returns the size. 	
 * @return
 */
	public int numItems() {
		int size = 0;
		Node current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}
	
/**
 * This method checks to see if the data given is a member of the set. 
 * First it sets the temporary node current to head. If the list is empty, it will return false because the data is not in the LinkedList. 
 * Otherwise it will traverse through the list and if the data is found, it will return true. 
 * If the data is not found, it will return false. 
 * @param n- data passed in
 * @return
 */
	public boolean isMember(T n) {
		Node current = head;
		if(head == null) {
			return false;
		} else {
			while(current != null) {
				if(n.equals(current.data)){
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

/**
 * This method returns a reference node to a specific node in the set. 
 * First, it creates a temporary node called current and sets it to head. 
 * Then, it traverses through the SinglyLinkedList and if the data is found in the LinkedList, it will return the node. 
 * If the list is empty, it will return null.
 * @param n - data passed in
 * @return
 */
	public Node reference(T n) {
		Node current = head;
		while(current != null) {
			if(n.equals(current.data)) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
/**
 * This method finds the and returns the set of all distinct elements. 
 * It first creates setUnion which is a singlyLinkedList to return the set of all distinct elements. 
 * It creates two new temporary elements that are equal to the head. 
 * If either of the lists are empty, it will return null because there are no common nodes between the two sets. 
 * If either of the lists are empty, it will return the other list. 
 * Otherwise, it traverses through the lists and adds the data in setUnion. 
 * Then, it will return the list with the distinct elements. 
 
 * @param n- SinglyLinkedList passed in
 * @return
 */
	public SinglyLinkedList<T> union(SinglyLinkedList<T> n) {
		SinglyLinkedList<T> setUnion = new SinglyLinkedList<T>();
		Node current1 = n.head;
		Node current2 = head;
		if(current1 == null && current2 == null) {
			return null;
		}
		if(current2 == null) {
			return this;
		} else if (current1 == null) {
			return n;
		}
		else {
//			while(current1 != null){
//				setUnion.add(current1.data);
//				current1 = current1.next;
//			}
			
			setUnion.clone(n);
//			System.out.println(setUnion.toString());
			
			while(current2 != null) {
				setUnion.add(current2.data);
				current2 = current2.next;
			}
		}
		return setUnion;
	}
	

/**
 * This method finds the set of all common distinct elements between two sets. 
 * It creates a new SinglyLinkedList called setIntersection and two temporary nodes that store the heads of both of the sets. 
 * If either one of the lists are empty, it will return the empty setIntersection list. 
 * Otherwise, it will traverse through the linked list and check if the node is found in the other list. 
 * If it is found, it will be added to the setIntersection list. 
 * Then, it will return the new SinglyLinkedList of all the common distinct elements. 	
 * @param n- the SinglyLinkedList that is passed in
 * @return
 */
	public SinglyLinkedList<T> intersection(SinglyLinkedList<T> n) {
		SinglyLinkedList<T> setIntersection = new SinglyLinkedList<T>();
		Node current1 = n.head;
		Node current2 = head;
		if(current1 == null || current2 == null) {
			return setIntersection;
		}
		while(current1 != null) {
			if(isMember(current1.data)) {
				setIntersection.add(current1.data);
			}
			current1 = current1.next;
		}
		return setIntersection;
	}
	
//	public SinglyLinkedList<T> clone(SinglyLinkedList<T> input) {
//		Node current = input.head;
//		answer.head = input.head;
//		Node current2 = answer.head;
//		
//		while(current != null) {
////			System.out.println(current.toString());
//			Node node = new Node(current.data, null);
//			current2.next = node;
//			current = current.next;
//			current2 = current2.next;
//		}
		
//		Node inList = input.head;
//		this.head = input.head;
//		Node current = this.head;
//		current.next = null;
//		
//		
//		
//		while(inList.next != null && current != null) {
//			current.next = new Node(inList.next.data, null);
//			inList = inList.next;
//			current = current.next;
//		}
//		
//		this.head = current;
//		
//		return this; 
		
//		Node head = new Node(input.head.data, null);
//		Node currentHead = head;
//		Node inList = input.head;
//		
//		while(inList != null && head != null) {
//			head.next = new Node(inList.next.data, null);
//			inList = inList.next;
//			head = head.next;
//		}
//		
//		head = currentHead;
//		return this;
//		
//	}
	
	
	/**
	 * This method clones a given singly linked list. 
	 * It creates a new node called current which is set to the head of the given list. 
	 * It checks to see if the list isn’t empty and if it isn’t, then it sets the head of the new list to the one of input. 
	 * Then, it traverses through the list and duplicates the nodes into the new list, and returns the new list.
	 * @param input the list that needs to be duplicated
	 * @return
	 */
	
	public SinglyLinkedList<T> clone(SinglyLinkedList<T> input) {
		Node current = input.head;
		if(current != null) {
			this.head = new Node(input.head.data, null);
		}
		
		Node newCurrent = this.head;
		while(current.next != null) {
			current = current.next;
			Node node = new Node(current.data, null);
			newCurrent.next = node;
			newCurrent = newCurrent.next;
		}
		
		return this;
	}
	
/**
 * I created a toString method to print out the sets I created for the JUnit tests. 
 * First it started off by creating a temporary node called current as the head. 
 * Then it creates a String answer which starts off with a bracket. 
 * It then traverses through the linkedlist and adds the data to the answer String.
 */
	@Override
	public String toString() {
		
		Node current = head;
		String answer = "{";
		while(current != null) {
			if(current.next != null) {
				answer += current.data + ", ";
			} else {
				answer += current.data;
			}
			current = current.next;
		}
		answer += "}";
		return answer;
	}
	

	
	
//	public static void main(String[] args) {
//        SinglyLinkedList<Integer> sing1 = new SinglyLinkedList<>();
//
//
//        for(int i=0; i<9000; i++) {
//            sing1.add(i);
//        }
//        long time1 = System.currentTimeMillis();
//        for(int i=0; i<1000; i++) {
//            sing1.remove(i);
//        }
//
//        long time2 = System.currentTimeMillis();
//
//        System.out.println(time2-time1);


 //   }
	
}