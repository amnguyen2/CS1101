
/*
Nguyen, Abram - Lab 5 [Due: Monday, October 22, 2018, 7:00 AM]

    1) Read the input text file provided by the client and create a LinkedList object. 
        Show that your printAllBoxes method in the LinkedList class can print all the boxes 
        in the original sequence they were written in the input file. 
        Also demonstrate that the printReverse method in the LinkedList class prints the boxes
        in reverse order of their appearance in the linked list.  
    2) Find the smallest box in the LinkedList object. 
        Report the position, dimensions, and volume of the smallest object. 
        Position of an object in a linked list is equivalent of index in an array. 
        You must call the method getNextBox of the LinkedList object to iterate over the linked list.  
    3) Find the largest box in the LinkedList object. 
        Report the position, dimensions, and volume of the largest box. 
        You already know what a position in a linked list means. 
        You must call the method getNextBox of the LinkedList object to iterate over the linked list. 
    4) How many cubic boxes are there in the linked list? Notice that this will require iteration. 
    5) Demonstrate that your removeNode method of LinkedList object works properly when called from Runner.java. 
    6) Demonstrate that your insertNode method of LinkedList object works properly when called from Runner.java. 
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;	

public class Runner {

    //Main method
    public static void main(String [] args) {
    
        System.out.println("What is the name of the file you want to use?");
        Scanner userInput = new Scanner(System.in);     //Determine the name of the file
        String name = userInput.nextLine();
        userInput.close();

        LinkedList list = new LinkedList(); //LL object
        
        fillList(name, list);   //Read the file and create a linked list of Boxes, also print the list in order and reverse
        list.printAllBoxes();   //Demonstrate: print every box's data in order
		list.printReverse();    //Demonstrate: print every box's data in reverse
        
        smallBox(list);         //Find the smallest box and print its info
        largeBox(list);         //Find the largest box and print its info

        countCubes(list);       //Count the number of cubes in the list
        
        //Demonstrate: removeNode method of LinkedList object works properly when called from Runner.java. 
        list.removeNode(2);   
        list.printAllBoxes();

        //Demonstrate: insertNode method of LinkedList object works properly when called from Runner.java.
        Box demoBox = new Box(4, 3, 2);       //box to test with
        list.insertNode(demoBox, 2);
        list.printAllBoxes();
    }

    /* 
    *  Read the input text file provided by the client and create a LinkedList object. 
    *  Show that your printAllBoxes method in the LinkedList class can print all the boxes 
    *   in the original sequence they were written in the input file. 
    *  Also demonstrate that the printReverse method in the LinkedList class prints the boxes
    *   in reverse order of their appearance in the linked list.
    */
	public static LinkedList fillList(String name, LinkedList list)  {

        Box b = new Box();
        
    	try {
    		Scanner scnr = new Scanner(new File(name));
    		
    		while(scnr.hasNextLine()) { //each line...
				//Read a line 
    			String line = scnr.nextLine();
    			String[] split = line.split(" ");
    			double[] t = new double[3];
				//save the line into an array of double values
    			for (int i = 0; i < t.length; i++) {
					t[i] = Double.parseDouble(split[i]);
				}
				
    			b = new Box(t[0],t[1],t[2]); //create a new box
    			list.addNode(b); //add b to the end of the linked list
    		}
    		scnr.close();
    	} catch (FileNotFoundException e) {
            System.out.printf("%nCan't find your file, please create or move a file into local directory.%n");
    		System.exit(0);
    	}
    	return list;
    }


    /* 
    *  Find the smallest box in the LinkedList object. 
    *  Report the position, dimensions, and volume of the smallest object. 
    *  Position of an object in a linked list is equivalent of index in an array. 
    *  You must call the method getNextBox of the LinkedList object to iterate over the linked list. 
    */
    public static void smallBox(LinkedList list) {
        //keep track of the position using another variable
		int i = 1;
        int pos = 0;
        //the smallest box is the first box in the list by default
        Box smallest = new Box(list.getBox(0).getWidth(), 
                               list.getBox(0).getHeight(), 
                               list.getBox(0).getLength());
        
        //iterating through the list
		while (list.getBox(i) != null) {
            //if the current box's volume is less than the smallest's volume..
			if (list.getBox(i).getVolume() < smallest.getVolume()) {
                //...the current box is now the smallest box
                smallest = new Box(list.getBox(i).getWidth(), 
                               list.getBox(i).getHeight(), 
                               list.getBox(i).getLength());
                pos = i;    //updating position in the list
            }
            i++;
		}
        
        //printing information...
		System.out.println();
		System.out.println("The smallest box's position is: " + pos);
        System.out.println("The smallest box's dimensions are: " 
							+ smallest.getWidth() + " " 									 
							+ smallest.getHeight() + " "
							+ smallest.getLength());
        System.out.print("The smallest box's volume is: ");
        System.out.printf("%.2f", smallest.getVolume());
        System.out.printf("%n====================%n");
    } 


    /*
    *  Find the largest box in the LinkedList object. 
    *  Report the position, dimensions, and volume of the largest box. 
    *  You already know what a position in a linked list means. 
    *  You must call the method getNextBox of the LinkedList object to iterate over the linked list. 
    */
    public static void largeBox(LinkedList list) {
        //keep track of the position using another variable
        int i = 1;
        int pos = 0;
        //the largest box is the first box in the list by default
        Box largest = new Box(list.getBox(0).getWidth(), 
                               list.getBox(0).getHeight(), 
                               list.getBox(0).getLength());
		//iterating through the list...
		while (list.getBox(i) != null) {
            //if the current box's volume is greater than the largest's volume..
			if (list.getBox(i).getVolume() > largest.getVolume()) {
                //...the current box is now the largest box
                largest = new Box(list.getBox(i).getWidth(), 
                               list.getBox(i).getHeight(), 
                               list.getBox(i).getLength());
                pos = i;    //updating position in the list
            }
            i++;
		}
        
        //printing information...
		System.out.println();
		System.out.println("The largest box's position is: " + pos);
        System.out.println("The largest box's dimensions are: " 
							+ largest.getWidth() + " " 									 
							+ largest.getHeight() + " "
							+ largest.getLength());
        System.out.print("The largest box's volume is: ");
        System.out.printf("%.2f", largest.getVolume());
        System.out.printf("%n====================%n%n");
    } 


    /*
    *  How many cubic boxes are there in the linked list? Notice that this will require iteration. 
    */
    public static void countCubes(LinkedList list) {

        int cubes = 0;
        int i = 0;
		//iterating through the list...
		while (list.getBox(i) != null) {
            //if the current box is a cube...
			if (list.getBox(i).isCube()) {
                //...add 1 to the cubes counter
                cubes++;
            }
            i++;
        }
        System.out.println("Number of cubes in the linked list: " + cubes);
        System.out.printf("====================%n");
    }
}