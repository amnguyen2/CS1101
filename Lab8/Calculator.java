/*      
    Nguyen, Abram - Lab 8 [Due: Monday, November 19, 7:00 AM]
        
        CALCULATOR
            The Calculator class is the only class that will contain the main method. 
            The Calculator class will prompt for an input file and read the file line by line. 
            Each line of the file will contain a postfix expression as an input.
            Use a GenericStack object to compute the value of each expression your program will
                read from the input file. 
            The actual evaluation must be done in the Calculator class.
            GenericStack is the data structure that will be used to evaluate an expression. 
            Report the result for each expression on the terminal. 
            Some expressions may be incomplete; report an error for those expressions.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Calculator {
    public static void main(String [] args) {
        System.out.println("What is the name of the file you want to use?");
        Scanner userInput = new Scanner(System.in);     //Determine the name of the file
        String name = userInput.nextLine();
        userInput.close();
		
		calculate(name); //fill the array with new stacks
    }

	//================================================================================================================================================
	
	public static void calculate(String name) {
		double result = 0;
		double t = 0;
		try {
			Scanner scnr = new Scanner(new File(name));						
			while(scnr.hasNextLine()) {				//For each line of the input file:
				String line = scnr.nextLine();
				String[] values = line.split(" ");	//Read the nums/operands into an array of strings
				
				GenericStack s = new GenericStack();//Create a new stack
				for(int j=0; j<values.length; j++) {//Run through the expression using a stack
					switch(values[j]) {
						//When a number is encountered... 
						case "0":
							s.push(0.0);	//...push it onto the stack (remember it!)
							break;
						case "1":
							s.push(1.0);
							break;
						case "2":
							s.push(2.0);
							break;
						case "3":
							s.push(3.0);
							break;	
						case "4":
							s.push(4.0);
							break;	
						case "5":
							s.push(5.0);
							break;
						case "6":
							s.push(6.0);
							break;	
						case "7":
							s.push(7.0);
							break;	
						case "8":
							s.push(8.0);
							break;
						case "9":
							s.push(9.0);
							break;
						//When an operand is encountered...
						case "+":
							result = s.pop() + s.pop(); //...operate on the top 2 elements in the stack, remove them, and...
							s.push(result);				//...push the result back on top
							break;
						case "-":
							t = s.pop();			//The program will subtract the numbers in the wrong order,
							result = s.pop() - t;	// if not for this work-around!
							s.push(result);
							t = 0;
							break;
						case "/":
							t = s.pop();			//The program will divide the numbers in the wrong order,
							result = s.pop() / t;	// if not for this work-around!
							s.push(result);
							t = 0;
							break;
						case "*":
							result = s.pop() * s.pop();	
							s.push(result);
							break;
					}
				}
				//If there is not exactly 1 remaining element, the expression has too many numbers
				if(s.getSize() == 1) System.out.println("Result: " + result);
				else System.out.println("This equation is unbalanced!");
				s.popAll();
			}
		} catch (FileNotFoundException e) {
		}	
	}
}