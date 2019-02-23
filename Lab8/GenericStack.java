/*      
    Nguyen, Abram - Lab 8 [Due: Monday, November 19, 7:00 AM]

		GENERICSTACK
			Write a class for a stack using a linked list. The stack class must have the name
		GenericStack. You must write regular stack methods (e.g., createStack, isEmpty, push,
		pop, popAll, peek) in the GenericStack class.
*/

public class GenericStack {
	private Node top;
	
	//Create a new stack
	public GenericStack() {
		top = null;
	}

	//Is the stack empty?
	public boolean isEmpty() {
		return (top == null);
	}
	
	//Push a new item onto the top of the stack
	public void push(Object newItem) {
		top = new Node(newItem, top);
	}
	
	//Remove the top of the stack and retrieve its data
	public double pop() {
		if (isEmpty()) {
			//If the program reaches this point, the expression has too many operands
			System.out.println("Trying to print when stack is empty...the equation is unbalanced!");
			return 0;
		} else {
			Node temp = top;
			top = top.next;
			return temp.getItemInfo();
		}
	}
	
	//Return the size of a stack
	public int getSize() {
		int c = 0;
		while(!isEmpty()) {
			c++;
			pop();
		}
		return c;
	}

	//Remove the entire stack without retrieving data
	public void popAll() {
		top = null;
	}
	
	//Take a look at the top of the stack
	public Object peek() {
		if (isEmpty()) {
			System.out.println("Trying to peek when stack is empty...");
			return 0;
		} else {
			return top.getItemInfo();
		}
	}
}