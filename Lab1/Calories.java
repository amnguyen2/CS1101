/*
 Nguyen, Abram - Lab 1 [Due: September 7, 2018, 11:59 PM] 

 1) A list of total calories consumed each day
 2) A list of days when more calories than required are consumed
 3) Average calories consumed during each of the three meals
 
 Print error and terminate if there aren't exactly 7 rows and 3 columns in the input file.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Calories{
	
	//Main method
	public static void main (String [] args) {
		
		int[] breakfast = new int[7];
		int[] lunch = new int[7];
		int[] dinner = new int[7];
		
		checkFile(breakfast, lunch, dinner);
		readFile(breakfast, lunch, dinner);
		
		calSum(breakfast, lunch, dinner);
		calMax(breakfast, lunch, dinner);
		calAvg(breakfast, lunch, dinner);
	}
	
	//Check file for exactly 7 rows and exactly 3 columns
	public static void checkFile(int[] breakfast, int[] lunch, int[] dinner) {
		
		try {
			Scanner scnr = new Scanner(new File("input.txt"));
			int r = 0;
			int c = 3; //r and c are initially different because of my methods of counting rows and columns separately
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine(); //read a line
				String[] words = line.split(" "); //separate each line into 3 pieces each
				
				r++;
				
				//check number of columns for each row that is read
				if(words.length != 3) {
					System.out.printf("%nThe input file must contain exactly 7 rows and 3 columns!%n");
					System.exit(0);
				}
			} 
			//check number of rows total
			if (r != 7) {
					System.out.printf("%nThe input file must contain exactly 7 rows and 3 columns!%n");
					System.exit(0);
			}
	
		} catch (FileNotFoundException e) {
			System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.printf("%nOut of bounds! The input file must contain exactly 7 rows and 3 columns!%n");	
		} 
	}		
	
	
	//Reading input.txt
	public static void readFile(int[] breakfast, int[] lunch, int[] dinner) {
		
		try {
			Scanner scnr = new Scanner(new File ("input.txt"));
			int i = 0;
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] words = line.split(" ");
				
				breakfast[i] = Integer.parseInt(words[0]);
				lunch[i] = Integer.parseInt(words[1]);
				dinner[i] = Integer.parseInt(words[2]);
				
				i++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.printf("%nOut of bounds! The input file must contain exactly 7 rows and 3 columns!%n%n");	
		} 
	}	
	
	
	//Total calories consumed each day
	public static void calSum(int[] breakfast, int[] lunch, int[] dinner) {
		
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		int s = 0;
		
		for(int i=0; i<week.length; i++) {
				s = breakfast[i] + lunch[i] + dinner[i];
				System.out.println(week[i] + ": " + s);
				
		}
		System.out.println("====================");
	}
	
	
	//List of days when more calories than required are consumed
	public static void calMax(int[] breakfast, int[] lunch, int[] dinner) {
		
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		int s = 0;
		
		System.out.printf("You've consumed more calories than the required amount on:%n");
		
		for(int i=0; i<week.length; i++) {
				s = s + breakfast[i] + lunch[i] + dinner[i];
				
				if(s > 2250) {
					System.out.println(week[i]);
				}
				s = 0;
		}	
		System.out.println("====================");
	}
	
	
	//Calculate the average amount of calories consumed during each of the 3 meals
	public static void calAvg(int[] breakfast, int[] lunch, int[] dinner) {
		
		float bAvg = 0;
		float lAvg = 0;
		float dAvg = 0;
		
		//breakfast average
		for(int i = 0; i<breakfast.length; i++) {
			bAvg = bAvg + breakfast[i];
		}
		System.out.println("Average calories consumed during breakfast: " + bAvg/breakfast.length);
		
		//lunch average
		for(int i = 0; i<lunch.length; i++) {
			lAvg = lAvg + lunch[i];
		}
		System.out.println("Average calories consumed during lunch: " + lAvg/lunch.length);
		
		//dinner average
		for(int i = 0; i<dinner.length; i++) {
			dAvg+=dinner[i];
		}
		System.out.println("Average calories consumed during dinner: " + dAvg/dinner.length);
	}	
}
