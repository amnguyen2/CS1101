/*
Nguyen, Abram - Lab 5 [Due: Monday, October 22, 2018, 7:00 AM]				  
*/
public class LinkedList {
	private Box head;
	private Box iterator;
	
	LinkedList(){}
	
	/* Add b as the last node of the linked list.*/
	void addNode(Box b){
		if(head == null) { 
			head = b; //if there is nothing on the head of the list, then b is the new head
			return;
		}
      	else {
			initiateIterator(); //initiateIterator each time

			while (iterator != null) { 
				if (iterator.next == null) { //if the next iteration is null, make the next iteration b
					iterator.next = b;
					return;
				}
				iterator = iterator.next;//iterate through the list
			}
		}
	}

	/* Return the box in the current iterator position. */
	Box getNextBox(){
		return iterator;
	}
	
	/*Print width, height, length, and volume of each of the boxes in
	* this linked list. */
	void printAllBoxes(){
		
		System.out.println();
		System.out.println("Width, height, length and volume of all boxes in order: ");
		initiateIterator();
		//iterate through the list, print every value
		while (iterator!=null) {
			System.out.println(iterator.getWidth() + ", " + 
								iterator.getHeight() + ", " + 
								iterator.getLength() + ", volume: " 
								+ iterator.getVolume());
			iterator = iterator.next;
		}
		System.out.printf("====================%n");
	}

	/*Print width, height, length, and volume of each of the boxes in
	* this linked list in reverse order.*/
	void printReverse(){
		initiateIterator();
		//first, reverse the linked list...
		if (iterator==null) 
			return;
		//use a temporary box to keep track
		Box prev = new Box(iterator.getWidth(), iterator.getHeight(), iterator.getLength()); 
		Box b = prev; 
		iterator = iterator.next;
		//iterate through the linked list
		while (iterator!=null){ 
			b = new Box(iterator.getWidth(), iterator.getHeight(), iterator.getLength()); 
			b.next = prev; 
			prev = b; 
			iterator=iterator.next; 
		}
		
		//then, print the linked list's information
		System.out.println();
		System.out.println("Width, height, length and volume of all boxes in reverse: ");
		//print each box's information
		while (prev!=null) {
			System.out.println(prev.getWidth() + ", " + 
								prev.getHeight() + ", " + 
								prev.getLength() + ", volume: " 
								+ prev.getVolume());
			prev = prev.next;
		}
		System.out.printf("====================%n");
	}
	
	/* Remove the box in position pos. Return true if removal
	* is successful, otherwise return false.*/
	boolean removeNode(int pos){
		initiateIterator();
		System.out.println("...REMOVING node from position " + pos + "...");
		//return false if pos is or iterator are invalid
		if(pos < 0 || iterator == null)
			return false;
		//iterate through the list
		for(int i=0; i<pos-1 && iterator.next!=null; i++)
			iterator = iterator.next;
		//removing the node at position pos	
		if(iterator.next!=null)
			iterator.next=iterator.next.next;
		return true;
	}

	/* Insert b in position pos. If insertion is successful
	* return true, otherwise return false.
	*/
	boolean insertNode(Box b, int pos){
		initiateIterator();
		System.out.println("...INSERTING node at position " + pos + "...");
		
		if(iterator == null && pos!= 0) {
			return false;
		} else if(iterator == null && pos == 0) { //if iter is null and position is 0, then set the new box to the head
			iterator = b;
		}
		 
		if(pos == 0) { // if pos is 0, then set the new node to the head
			System.out.println("pos = 0");
			b.next = iterator;
			iterator = b;
		} else if(pos < 0) { //if pos is invalid, return false
			return false;
		}

		Box prev = null;
		int i = 0;
		//iterate through the list
		for(i=0; i<pos; i++) {
			if(iterator.next!=null) {
				prev = iterator;
				iterator = iterator.next;
			}
		}

		//inserting the new node
		b.next = iterator; 
		prev.next = b; 
		return true;
	}

	/* Return the box in position pos. Return null when pos is
	* invalid.*/
	Box getBox(int pos){
		initiateIterator();
		for(int i=0; i<pos; i++) {
			iterator = iterator.next;
		}
		return iterator;
	}
	
	/*Initiate the iterator variable*/
	void initiateIterator(){
		iterator = head;
	}
	
}