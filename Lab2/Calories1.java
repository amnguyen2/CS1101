/*
 Nguyen, Abram - Lab 2 [Due: September 18, 2018, 11:59 PM] 

	Part I
	
		1) A list of the total number of calories consumed each day from Monday to Sunday
		2) The average number of calories consumed each day
		3) The average number of calories (average over the week) consumed in each of the meals
		4) The maximum number of calories consumed each day
		5) The maximum number of calories consumed in each meal type
		
 Print error and terminate if there aren't exactly 7 rows and 3 columns in the input file.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;	
	
	
public class Calories1 {
	
	//Main method
	public static void main (String [] args) {
		
		int[][] meals = new int [7][3]; //Creating 2D array to store data
	
		checkFile("input1.txt"); 		//Ragged arrays won't get past this point
		readFile("input1.txt", meals); 	//Read the file
		
		calDaySum(meals);		//Calculate the total calories consumed each day
		calDayAvg(meals);		//Calculate the average number of calories consumed each day
		calMealAvg(meals);		//Calculate the average number of calories for each meal throughout the week
		calDayMax(meals);		//Calculate the maximum number of calories consumed each day
		calMealMax(meals);		//Calculate the maximum number of calories consumed in each meal type
	}
	
	
	//================================================================================================================================================
	
	
	//Check the file for exactly 7 rows, 3 columns 
	public static void checkFile(String name) {
		
		try {
			Scanner scnr = new Scanner(new File(name));
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
	
	
	//================================================================================================================================================

	
	//Read the file
	public static void readFile(String name, int[][] meals) {  
			
		try {
			Scanner scnr = new Scanner(new File (name));
			int i = 0;
			
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] words = line.split(" ");
				
				meals[i] = new int [words.length];
				for(int j = 0; j<words.length; j++) {
					meals[i][j] = Integer.parseInt(words[j]);
				}
				
				i++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
		}
	}
	
	
	//================================================================================================================================================
	
	
	//List the total calories consumed each day
	public static void calDaySum(int[][] meals) {
		
		System.out.printf("%nTotal calories consumed for every day of the week:%n%n");
		
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		for(int r=0; r<meals.length; r++) {
			int s = 0;
			
			for (int c=0; c<meals[r].length; c++) {
				s+=meals[r][c];
			}	
			
			System.out.println(week[r] + ": " + s);
		}
		
		System.out.println("====================");
	}
	
	//================================================================================================================================================
	
	
	//Calculate the average number of calories consumed each day
	public static void calDayAvg(int[][] meals) {
		
		System.out.printf("%nAverage calories consumed for every day of the week:%n%n");
		
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		for(int r=0; r<meals.length; r++) {
			float s = 0;
			
			for (int c=0; c<meals[r].length; c++) {
				s+=meals[r][c];
			}	
			
			s/=3;
			
			System.out.println(week[r] + ": " + s);
		}
		
		System.out.println("====================");
	}
	

	//================================================================================================================================================
	
	
	//Calculate the average number of calories for each meal throughout the week, 3 values(breakfast,lunch,dinner)
	public static void calMealAvg(int[][] meals) {
		
		System.out.printf("%nAverage calories consumed for every meal throughout the week:%n%n");
		
		float bAvg = 0;
		float lAvg = 0;
		float dAvg = 0;
		
		
		for (int r=0; r<meals.length; r++) {
			
			for (int c=0; c<meals[r].length; c++) {
				//Breakfast average
				if (c==0) {
					bAvg+=meals[r][0];
				//Lunch average
				} else if (c==1) {
					lAvg+=meals[r][1];
				//Dinner average
				} else {
					dAvg+=meals[r][2];
				}
			}	
		}
		
		
		System.out.println("Breakfast: " + bAvg/7);
		System.out.println("Lunch: " + lAvg/7);
		System.out.println("Dinner: " + dAvg/7);
		
		System.out.println("====================");
	}
	
	
	//================================================================================================================================================
	
	
	//Calculate the maximum number of calories consumed each day
	public static void calDayMax(int[][] meals) {
		
		System.out.printf("%nMost calories consumed each day:%n%n");
		
		String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		for(int r=0; r<meals.length; r++) {
			int max = 0;
			
			for (int c=0; c<meals[r].length; c++) {
				if (meals[r][c] > max) 
					max = meals[r][c];
			}	
			
			System.out.println(week[r] + ": " + max);
		}
		
		System.out.println("====================");
	}

	
	//================================================================================================================================================	
	
	
	//Calculate the maximum number of calories consumed in each meal type
	public static void calMealMax(int[][] meals) {
		
		System.out.printf("%nMost calories consumed for every meal throughout the week:%n%n");
		
		int bMax = 0;
		int lMax = 0;
		int dMax = 0;
		
		for (int r=0; r<meals.length; r++) {
			
			for (int c=0; c<meals[r].length; c++) {
				//Breakfast maximum
				if (c==0) {
					if(meals[r][c] > bMax)
						bMax = meals[r][c];
				//Lunch maximum
				} else if (c==1) {
					if(meals[r][c] > lMax)
						lMax = meals[r][c];
				//Dinner maximum
				} else {
					if(meals[r][c] > dMax)
						dMax = meals[r][c];
				}
			}	
		}
		
		
		System.out.println("Breakfast: " + bMax);
		System.out.println("Lunch: " + lMax);
		System.out.println("Dinner: " + dMax);
		
		System.out.println("====================");
	}
}