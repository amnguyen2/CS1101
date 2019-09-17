/*      
    Nguyen, Abram - Lab 9 [Due: Wednesday, November 28 7:00 AM]
        
        QUEUE
            1) Change the QUEUE_SIZE=50 to QUEUE_SIZE=5 in the given code. 
            This will make analyses of your code easier.
            2) Change the enqueue method of the Queue class in such a way that if the array
                is full then the array-size will become double. 
            Obviously, the new item will be added in the expanded new array in that case. 
            That is, enqueue will never fail due to the size-limitation of the array. 
*/

public class Queue {
    private int QUEUE_SIZE = 5;
    private Object[] items;
    private int front, back, count;

    public Queue() {
        items = new Object[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE - 1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == QUEUE_SIZE;
    }

    public void enqueue(Object newItem) {		
        if (!isFull()) {
            back = (back + 1) % QUEUE_SIZE;
            items[back] = newItem;
            count++;
            return;
        } else {	
            System.out.println("Tried to enqueue into full queue...doubling the size of your array!");
            count *= 2; 
            Object[] a = new Object[count]; //creating a new array doubled in size
            int newfront = front;   //establishing a front for the new queue
			for(int i=0; i<items.length; i++) {
                a[i] = items[newfront];     //copying everything from the old array into the new array, keeping the order of elements
                newfront = (newfront + 1) % items.length;   //the newfront will loop back around to the beginning of the array if it reaches the end
			}
            front = 0;  //reset front
            back = items.length - 1;  //reset back
		}
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Object queueFront = items[front];
            front = (front + 1) % QUEUE_SIZE;
            count--;
            return queueFront;
        } else
            System.out.println("Trying to dequeue from empty queue.");
        return null;
    }

    public void dequeueAll() {
        items = new Object[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE - 1;
        count = 0;
    }

    public Object peek() {
        if (!isEmpty()) {
            return items[front];
        } else
            System.out.println("Trying to peek with empty queue!");
        return null;
    }

    public int size() {
        return count;
    }

}// End of class Queue
