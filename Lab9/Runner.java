/*      
    Nguyen, Abram - Lab 9 [Due: Wednesday, November 28 7:00 AM]
        
        RUNNER
        1) public static void printQueue(Queue q): 
            Print all the elements of a queue. 
            q must have the same numbers in the same sequence after printing all the numbers.
        2) public static void findMaxInQueue(Queue q): 
            Print the largest of all the numbers in q. 
            The queue q must have the same numbers in the same sequence after 
            entering the method and before leaving it.
        3) public static void reverseQueue(Queue q): 
            Reverse the content of the queue.
        
        The use of object cloning is strictly prohibited in this assignment.                  
*/

public class Runner {

    //Main method
    public static void main(String [] args) {
		Queue q = new Queue();
		q.enqueue(50);
		q.enqueue(20);
		q.enqueue(-10);
		q.enqueue(60);
		q.enqueue(-20);
		printQueue(q);
		
		System.out.println("I am going to DEQUEUE one element.");
		q.dequeue();
		printQueue(q);
		
		System.out.println("I am going to REVERSE my Queue.");
		reverseQueue(q);
		printQueue(q);
		/*
		System.out.println("I am going to ENQUEUE 60.");
		q.enqueue(60);
		printQueue(q);
		
		System.out.println("I am going to ENQUEUE 70.");
		q.enqueue(70);
		printQueue(q);
		
		System.out.println("I am going to REVERSE my Queue.");
		reverseQueue(q);
		printQueue(q);
		*/
		System.out.print("The LARGEST NUMBER in the queue is: ");
		findMaxInQueue(q);
		printQueue(q);
		
    }

    /*
    Print all the elements of a queue. 
    q must have the same numbers in the same sequence after printing all the numbers.
    */
    public static void printQueue(Queue q) {
		System.out.println("My queue is as follows:");
		for(int i=0; i<q.size(); i++) {
			int temp = (int)q.dequeue();	//get next value in queue
			q.enqueue(temp);				//enqueue the value
			System.out.print(temp + " ");	//print the value
		}
		System.out.println();
    }

    /*
    Print the largest of all the numbers in q. 
    The queue q must have the same numbers in the same sequence after 
    entering the method and before leaving it.
    */
    public static void findMaxInQueue(Queue q) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<q.size(); i++) {
			int temp = (int)q.dequeue(); 	//get the next value in in the queue
			if(temp > max) max = temp; 		//new maximum value
			q.enqueue(temp);
		}
		System.out.println(max);
    }

    //Reverse the content of the queue.
    public static void reverseQueue(Queue q) {
		if(!q.isEmpty()) {	
			int temp = (int)q.dequeue();	//record the value of a dequeued element
			reverseQueue(q);	//AFTER the recursive call...
			q.enqueue(temp);	//enqueue the value recorded earlier, enqueing everything in reverse
		}
	}


}