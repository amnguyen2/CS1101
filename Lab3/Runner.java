/*
Nguyen, Abram - Lab 3 [Due: September 28, 2018, 11:59 PM]

	RUNNER
		1) Read the input text file provided by the client and create an array of Package objects. 
			The sequence of the lines should be used in the sequence of objects in the array.
		2) Find the largest package in the array. 
			Report the index, dimensions, and volume of the largest object.
		3) How many cubic and non-cubic packages are there in the array?
		4) Report the indices and dimensions of the cubic packages.
		5) Report average volume of cubic packages only.	
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;	
	
	
public class Runner {
	
	//Main method
	public static void main(String [] args) {
		
		int c = countLines("input.txt");    //Count the lines in the file to create array of Package objects
		
		Package[] boxes = new Package[c];   //Create array of Package objects
		
		fillArray("input.txt", boxes);		//Give each Package object width, height and length
		
		maxPackage(boxes);				    //Index, dimensions and volume of largest box
		countCubes(boxes);				    //How many cubes there are
		allCubes(boxes);					//Indices and dimension of all cubic packages
		avgVolCubes(boxes);				    //Average volume of only cubic packages
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
			
		} catch (FileNotFoundException e) {
			System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
		}
		
		return count;
	}	
	
	//================================================================================================================================================
	
	//Read input file & create array of package objects
	public static void fillArray(String name, Package[] boxes) {
		
		try {
			Scanner scnr = new Scanner(new File(name));
			
			int b = 0;
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] values = line.split(" ");
				
				double[] temp = {0,0,0};
				
				for (int i=0; i<temp.length; i++) {
					temp[i] = Double.parseDouble(values[i]); //reading the values array as doubles into temp array of doubles
				}
				
				boxes[b] = new Package(temp[0], temp[1], temp[2]); //reading each line of the file into each Package object
				
				b++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
		}
	}
	
	//================================================================================================================================================
	
	//Index, dimensions and volume of largest box
	public static int maxPackage(Package[] boxes) {
		
		if(boxes == null || boxes.length == 0) {
			System.out.println("You don't have any boxes!");
			return -1;
		}
		
		double max = boxes[0].getVolume();
		int pos = 0;
		
		for(int i=1; i<boxes.length; i++) {
			if (boxes[i].getVolume() > max) {
				max = boxes[i].getVolume();
				pos = i;
			}
		}
		
		System.out.println("The largest package's dimensions are: " + boxes[pos].getWidth() + " x " 
																	+ boxes[pos].getHeight() + " x " 
																	+ boxes[pos].getLength());
		System.out.println("The largest package's volume is: " + max);
		System.out.println("The largest package's position is: " + pos);
		System.out.println();
		
		return pos;
	}
				
	
	
	//================================================================================================================================================
	
	//How many cubes there are, How many NON cubes there are
	public static void countCubes(Package[] boxes) {
		
		int c = 0;
		int n = 0;
		
		for (int i=0; i<boxes.length; i++) {
			if (boxes[i].isCube()) {
				c++;
			} else {
				n++;
			}
		}
		
		System.out.println("Number of cubes: " + c);
		System.out.println("Number of non-cubes: " + n);
		System.out.println();
		
	}
	
	
	//================================================================================================================================================
	
	//Indices and dimension of all cubic packages
	public static void allCubes(Package[] boxes) {
		
		for (int i=0; i<boxes.length; i++) {
			if (boxes[i].isCube()) {
				System.out.println("There is a cube at position: " + i);
				System.out.println("This cube's dimensions are: " + boxes[i].getWidth() + " x " 
																	+ boxes[i].getHeight() + " x " 
																	+ boxes[i].getLength());
				System.out.println();
			}
		}
	}
	
	//================================================================================================================================================
	
	//Average volume of only cubic packages
	public static double avgVolCubes(Package[] boxes) {
	
		if(boxes == null || boxes.length == 0) {
			System.out.println("You don't have any boxes!");
			return -1;
		}
		
		double sumCubes = 0;
		double count = 0;
		
		for (int i=0; i<boxes.length; i++) {
			if (boxes[i].isCube()) {
				sumCubes+=boxes[i].getVolume();
				count++;
			}
		}
		
		System.out.print("The average volume of all cubes is: " + sumCubes/count);
		System.out.println();
		
		return sumCubes/count;
	}
	
	
}