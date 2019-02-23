/*
 Nguyen, Abram - Lab 2 [Due: September 18, 2018, 11:59 PM] 
 
	Part II
	
		1) The average number of calories consumed each day
		2) The average number of calories consumed in every meal of the week. 
			(For the example input file above, the list of averages for Meals 1 to 5 is: 
			 532.1428571, 1024.166667, 817.5, 466.6666667, and 300)
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;	
	
	
public class Calories2 {
	
	//Main method
	public static void main (String [] args) {
		
		int[][] meals = new int [7][];
		
		
		readFile("input2.txt", meals);
		
		calDayAvg(meals);		//Calculate the average number of calories consumed each day	
		calMealAvg(meals);		//Calculate the average number of calories consumed in every meal of the week
		
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
				for(int j = 0;j<words.length;j++) {
					meals[i][j] = Integer.parseInt(words[j]);
				}
				i++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.printf("%n%nCan't find your file, please create or move a file into local directory.");
		}
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
			
			s/=meals[r].length;
			
			System.out.println(week[r] + ": " + s);
		}
		
		System.out.println("====================");
		 
	}
	
	
	//================================================================================================================================================
	
	
	//Find the length of the longest row
	public static int lengthOfLongestRow(int[][] meals) {
		
		int l = meals[0].length;
		
		for (int i=1; i<meals.length; i++) {
			if (meals[i].length > l)
				l = meals[i].length;
		}
		return l;
	}
	

	//================================================================================================================================================	
	
	
	
	//Calculate the average number of calories consumed in every meal of the week
	//(For the example input file, the list of averages for Meals 1 to 5 is: 532.1428571, 1024.166667, 817.5, 466.6666667, and 300)
	public static void calMealAvg(int[][] meals) {
		
		System.out.printf("%nAverage number of calories consumed in every meal of the week:%n");
		
		String[] mealNum = {"first","second","third","fourth","fifth"};
		
		int l = lengthOfLongestRow(meals);
		float[] numberOfMeals = new float[l];	//Array of counters for how many times a meal has occured, length of longest row
		int[] sums = new int[l]; 				//Array of sums for each column, length of longest row
		
		//Inputting values for both arrays...
		for (int r=0; r<meals.length; r++) {
			for (int c=0; c<meals[r].length; c++) {
				sums[c]+=meals[r][c];
				numberOfMeals[c]++;
			}
		}
		
		//Print and compute using the 2 arrays
		for (int i=0; i<sums.length; i++) {
			System.out.printf("%nAverage of the " + mealNum[i] + " meal is: " + sums[i]/numberOfMeals[i]);
		}
	
	}	
	
}