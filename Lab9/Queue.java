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











"""
Student ID: 0994

Automata 3350, MW 12-1:20 PM
Homework 8
Due: Sept 16, 2019
"""

"""
    Write and test a method that emulates a general finite automaton. 
        The input to this method should include:
    
        - the number N of states q0, ..., qN − 1; we assume that q0 is the start state;
        - the number M of symbols s0, ... sM − 1;
        - an integer array state[n][m] that describes to what state the finite 
            automaton moves if it was in the state qn and sees the symbol sm;
        - a boolean array final[n] that tells us, for each state, whether this 
            state is final or not.
    
    This program needs to keep track of a current state. Initially, this location is 0.
        Your program should emulate the work of the finite automaton step-by-step. 
        
        * Return the printout of the method, the printout of the program that you 
        used to test this method, and the printout of the result of this testing. 
        Feel free to use Java, C, C++, Fortran, or any programming language in which 
        the code is understandable.
"""

# Constructing a finite automata based on the user's inputs
def fautomaton(numState, numSym, state, final):
    
    print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    print("\nNow, we will construct your finite automaton. \nRemember that state 0 is your starting state.")
    
    # Connecting each state by links using input language
    q = 0 # start at state 0
    # from each state...
    for curr in state:
        print("\nRegarding state", q, "->")
        
        s = 0 # which state to move to?
        # ...if input is s0, s1, ... sM - 1, then which state will be the new current state
        for nextState in curr:
            userIn = -1
            while userIn < 0 or userIn >= numState:
                userIn = int(input("If input is {}, what is the next state?\n".format(s)))
            
            state[q][s] = userIn
            s += 1
        q += 1
    
    print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    print("\nYour finite automaton's links have been set.\nNext, we will define the final state(s).")
    
    while True not in final:
        q = 0
        
        for f in final:    
            b = input("Is state {} a final state?\n[y/n] ".format(q))
               
            if b == "y" or b == 'y':
                final[q] = True
            elif b == "n" or b == 'n':
                final[q] = False
                
            q += 1
        if True not in final:
            print("Your automata MUST contain at least 1 final state!")
    print()
            
# Test/Run an automata using a string of digits. Use language containing only digits (0-9).
def run(numState, numSym, state, final):
    print("Please input a word (character by character) to test on your automata.\nRemember that your language has {} character(s).\nTo end a word, input '-1'".format(numSym))
    curr = 0
    chara = " "
    
    while chara != "-1":
        print("Current state: {}".format(curr))
        chara = input("Input:")
        chara = int(chara)
        if chara > 0 and chara < numSym:
            curr = state[curr][chara]
        elif chara == -1:
            break
        else: 
            print("Remember that your language has {} character(s).".format(numSym))
    
    if final[curr] == True:
        print("ACCEPTED")
    else:
        print("DENIED")
        
        

numState = -1
while numState < 0:
    numState = int(input("How many states will this finite automata have?\n")) # the number of states, q0, ..., qN − 1; we assume that q0 is the start state

numSym = -1
while numSym < 0 or numSym > 10:
    numSym = int(input("How many symbols will this finite automata recognize?\nThis number must be 10 or lower.\n")) # the number of symbols s0, ..., sM -1; 
state = [[0] * numSym for i in range(numState)] # describes to what state the finite automaton moves if it was in the state qn and sees the symbol s_m
final = [False] * numState # for each state, whether this state is final or not   


fautomaton(numState, numSym, state, final)
run(numState, numSym, state, final)
