/*
Nguyen, Abram - Lab 4 [Due: October 12, 2018, 11:59 PM]

	RUNNER
        1) Read the input text file provided by the client and create a linked list of Box objects. 
               The sequence of the lines should be used in the sequence of objects in the linked list. 
        2) Find the smallest box in the linked list. 
               Report the position, dimensions, and volume of the smallest object. 
               Position of an object in a linked list is equivalent to the index of an array. 
        3) Find the largest box in the linked list. 
               Report the position, dimensions, and volume of the largest object. 
               You already know what a position in a linked list means. 
        4) How many cubic boxes are there in the linked list? 
        5) What are the position, dimensions, and volume of the smallest cubic box in the linked list? 
               If multiple boxes have the same smallest cubic size, report only the one that 
               appeared the earliest in the input file. 
        6) What are the position, dimensions, and volume of the largest cubic box in the linked list? 
               If multiple boxes have the same largest cubic size, report only the one that 
               appeared the earliest in the input file. 
        7) Report average volume of all boxes. 
        8) Report average volume of cubic boxes. 
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

                int count = countLines(name);   //Count the lines in the file
                Box head = new Box();           //Create a new Box object

                fillList(name, head, count);    //Read the file and create a linked list of Boxes
                smallBox(head);                 //Smallest box's details
                largeBox(head);                 //Largest box's details
                int cubes = countCubes(head);   //Number of cubes
                smallCube(head, cubes);         //Smallest cube's details
                largeCube(head, cubes);         //Largest cube's details
                avgVolBox(head, count);         //Average volume of all boxes
                avgVolCube(head, cubes);        //Average volume of only cubes

        }

        //================================================================================================================================================
    
		//Count the lines in the file
		public static int countLines(String name) {  
				
			int count = 0;
			
			try {
				Scanner scnr = new Scanner(new File(name));
				while(scnr.hasNextLine()) {
					count++; //counting lines
					scnr.nextLine();
							}
							scnr.close();
				
			} catch (FileNotFoundException e) {
				System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
			}
			
			return count;
		}	
        
        //================================================================================================================================================
        
        //Read input file & create linked list of Boxes
        public static Box fillList(String name, Box head, int c) {
                
                try {
						Scanner scnr = new Scanner(new File(name));

                        while(scnr.hasNextLine() ) {
                                
                                String line = scnr.nextLine();
                                String[] values = line.split(" ");

                                double[] t = {0,0,0};
                                
                                for (int i=0; i<t.length; i++) {
                                        t[i] = Double.parseDouble(values[i]); //reading the values array as doubles into temp array of doubles
                                }
                                        
                                head.setWidth(t[0]);
                                head.setHeight(t[1]);
                                head.setLength(t[2]);

                                if (c!=1) { //Avoid creating an extra box
                                        head.next = new Box();
                                        head = head.next; 
                                }
                                c--;
                        }
                        scnr.close();

                } catch (FileNotFoundException e) {
                        System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
                }

                return head;
        }

        //================================================================================================================================================
        
        //Report the smallest box's position, dimensions and volume
        public static void smallBox(Box head) {
                
                double vol = head.getVolume();
                int c = 0;
                int obj = -1;
                double w = 0;
                double h = 0;
                double l = 0;

                while(head!=null) {
                        obj++;
                        if (head.getVolume() <= vol) {
                                vol = head.getVolume();
                                c = obj;
                                w = head.getWidth();
                                h = head.getHeight();
                                l = head.getLength();

                        }
                        head = head.next;
                }

                System.out.println("The smallest box's position is: " + c);
                System.out.println("The smallest box's dimensions are: " + w + " " + h + " " + l);
                System.out.print("The smallest box's volume is: ");
                System.out.printf("%.2f", vol);
                System.out.printf("%n%n====================%n%n");

        } 
        
        //================================================================================================================================================
        
        //Report the largest box's position, dimensions and volume
        public static void largeBox(Box head) {
                
                double vol = head.getVolume();
                int c = 0;
                int obj = -1;
                double w = 0;
                double h = 0;
                double l = 0;

                while(head!=null) {
                        obj++;
                        if (head.getVolume() >= vol) {
                                vol = head.getVolume();
                                c = obj;
                                w = head.getWidth();
                                h = head.getHeight();
                                l = head.getLength();

                        }
                        head = head.next;
                }

                System.out.println("The largest box's position is: " + c);
                System.out.println("The largest box's dimensions are: " + w + " " + h + " " + l);
                System.out.print("The largest box's volume is: ");
                System.out.printf("%.2f", vol);
                System.out.printf("%n%n====================%n%n"); 
        } 
        
        //================================================================================================================================================
        
        //Report the # of cubic boxes
        public static int countCubes(Box head) {

                int cubes = 0;

                while(head!=null) {
                        if (head.isCube()) {
                                cubes++;
                        }
                        head = head.next;
                }

                System.out.print("There are " + cubes + " cubes.");
                System.out.printf("%n%n====================%n%n");

                return cubes;
        } 
        
        //================================================================================================================================================
        
        //Report the smallest cube's position, dimensions and volume (report the first one if there are more than 1)
        public static void smallCube(Box head, int cubes) {
                
                if (cubes == 0) {
                        System.out.print("There are no cubes!");
                        System.out.printf("%n%n====================%n%n");
                        return;
                }

                double smallVol = Integer.MAX_VALUE;
                int c = 0;
                int obj = -1;
                double w = 0;
                double h = 0;
                double l = 0;

                while(head!=null) {
                        obj++;
                        if (head.isCube() && head.getVolume() < smallVol) {
                                smallVol = head.getVolume();
                                c = obj;
                                w = head.getWidth();
                                h = head.getHeight();
                                l = head.getLength();
                        }
                        head = head.next;
                }

                System.out.println("The smallest cube's position is: " + c);
                System.out.println("The smallest cube's dimensions are: " + w + " " + h + " " + l);
                System.out.print("The smallest cube's volume is: ");
                System.out.printf("%.2f", smallVol);
                System.out.printf("%n%n====================%n%n"); 
        } 

        //================================================================================================================================================
        
        //Report the largest cube's position, dimensions and volume (report the first one if there are more than 1)
        public static void largeCube(Box head, int cubes) {

                if (cubes == 0) {
                        System.out.print("There are no cubes!");
                        System.out.printf("%n%n====================%n%n");
                        return;
                }

                double largeVol = 0;
                int c = 0;
                int obj = -1;
                double w = 0;
                double h = 0;
                double l = 0;

                while(head!=null) {
                        obj++;
                        if (head.isCube() && head.getVolume() > largeVol) {
                                largeVol = head.getVolume();
                                c = obj;
                                w = head.getWidth();
                                h = head.getHeight();
                                l = head.getLength();
                        }
                        head = head.next;
                }

                System.out.println("The largest cube's position is: " + c);
                System.out.println("The largest cube's dimensions are: " + w + " " + h + " " + l);
                System.out.print("The largest cube's volume is: ");
                System.out.printf("%.2f", largeVol);
                System.out.printf("%n%n====================%n%n"); 
        } 

        //================================================================================================================================================

        //Report the average volume of all boxes
        public static void avgVolBox(Box head, int c) {

                double vol = 0;

                while(head!=null) {
                        
                        vol += head.getVolume();
                        head = head.next;
                }

                System.out.print("The average volume of all boxes is: ");
                System.out.printf("%.2f", vol/c);
                System.out.printf("%n%n====================%n%n");
                
        } 

        //================================================================================================================================================

        //Report the average volume of all cubes
        public static void avgVolCube(Box head, int cubes) {
                
                if (cubes == 0) {
                        System.out.print("There are no cubes!");
                        System.out.printf("%n%n====================%n%n");
                        return;
                }

                double vol = 0;

                while(head!=null) {
                        if (head.isCube()) {
                                vol += head.getVolume();
                        }
                        head = head.next;
                }

                System.out.print("The average volume of all cubes is: ");
                System.out.printf("%.2f", vol/cubes);
                System.out.printf("%n%n====================%n%n");
        } 
}