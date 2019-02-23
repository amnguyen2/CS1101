/*
	Nguyen, Abram - Lab 7 [Due: Sunday, November 11, 11:59 PM]

	SEARCH
	1) A linear search method to search in an array of doubles.
	2) A binary search method to search in an ordered array of doubles.
	
		Each method should return the location of the element searched for
		in the array, -1 if it isn't found.
	
		a) Generate a new array with n elements, and initialize the elements to
			random values using Math.random().
		b) Sort the array using Arrays.sort(). Remember that binary search works on
			ordered arrays only.
		c) Select the value to search for by selecting a random index between 0 and
			n-1 and using that value (so you can be sure the value is in the array).
			Select the random index using Math.random().
		d) Run linear and binary search for the same element on the sorted array, and 
			record the elapsed time for each algorithm.
		e) Repeat the above steps at least 30 times using a for loop and calculate the
			average time taken by each algorithm. This will be more accurate than
			doing the test only once.
*/


import java.util.Random;
import java.util.Arrays;

public class Search {
	public static void main(String[] args) {
		double [] a = randNums(10000);
		double [] b = randNums(40000);
		double [] c = randNums(160000);
		double [] d = randNums(640000);
		double [] e = randNums(1280000);

		long start;
		long end;
		long timeLinear = 0;
		long timeBinary = 0;
		//=======================================================================
	
		for (int i=0; i<30; i++) {
			int r = searchItemGen(a);				//Generate a random number to find
			
			start = System.nanoTime();				//Begin stopwatch				
			linearSearch(a, r);						//SEARCH (LINEAR)
			end = System.nanoTime();				//End stopwatch
			timeLinear += (end - start);			//Add time to total (L)
			
			start = System.nanoTime();				//Begin stopwatch
			binarySearch(a, r, 0, a.length-1);		//SEARCH (BINARY)
			end = System.nanoTime();				//End stopwatch
			timeBinary += (end - start);			//Add time to total (B)
		}
		System.out.println("LINEAR A: 10,000 ==> " + (timeLinear/30)); 
		System.out.println("BINARY A: 10,000 ==> " + (timeBinary/30));
		System.out.printf("\n=====================================\n");
		//=======================================================================
		
		timeLinear = 0;
		timeBinary = 0;
		for (int i=0; i<30; i++) {
			int r = searchItemGen(b);				//Generate a random number to find
			
			start = System.nanoTime();				//Begin stopwatch				
			linearSearch(b, r);						//SEARCH (LINEAR)
			end = System.nanoTime();				//End stopwatch
			timeLinear += (end - start);			//Add time to total (L)
			
			start = System.nanoTime();				//Begin stopwatch
			binarySearch(b, r, 0, b.length-1);		//SEARCH (BINARY)
			end = System.nanoTime();				//End stopwatch
			timeBinary += (end - start);			//Add time to total (B)
		}
		System.out.println("LINEAR B: 40,000 ==> " + (timeLinear/30)); 
		System.out.println("BINARY B: 40,000 ==> " + (timeBinary/30));
		System.out.printf("\n=====================================\n");

		//=======================================================================

		timeLinear = 0;
		timeBinary = 0;
		for (int i=0; i<30; i++) {
			int r = searchItemGen(c);				//Generate a random number to find
			
			start = System.nanoTime();				//Begin stopwatch				
			linearSearch(c, r);						//SEARCH (LINEAR)
			end = System.nanoTime();				//End stopwatch
			timeLinear += (end - start);			//Add time to total (L)
			
			start = System.nanoTime();				//Begin stopwatch
			binarySearch(c, r, 0, c.length-1);		//SEARCH (BINARY)
			end = System.nanoTime();				//End stopwatch
			timeBinary += (end - start);			//Add time to total (B)
		}
		System.out.println("LINEAR C: 160,000 ==> " + (timeLinear/30)); 
		System.out.println("BINARY C: 160,000 ==> " + (timeBinary/30));
		System.out.printf("\n=====================================\n");

		//=======================================================================
		
		timeLinear = 0;
		timeBinary = 0;
		for (int i=0; i<30; i++) {
			int r = searchItemGen(d);				//Generate a random number to find
			
			start = System.nanoTime();				//Begin stopwatch				
			linearSearch(d, r);						//SEARCH (LINEAR)
			end = System.nanoTime();				//End stopwatch
			timeLinear += (end - start);			//Add time to total (L)
			
			start = System.nanoTime();				//Begin stopwatch
			binarySearch(d, r, 0, d.length-1);		//SEARCH (BINARY)
			end = System.nanoTime();				//End stopwatch
			timeBinary += (end - start);			//Add time to total (B)
		}
		System.out.println("LINEAR D: 640,000 ==> " + (timeLinear/30)); 
		System.out.println("BINARY D: 640,000 ==> " + (timeBinary/30));
		System.out.printf("\n=====================================\n");
		
		//=======================================================================

		timeLinear = 0;
		timeBinary = 0;
		for (int i=0; i<30; i++) {
			int r = searchItemGen(e);				//Generate a random number to find
			
			start = System.nanoTime();				//Begin stopwatch				
			linearSearch(e, r);						//SEARCH (LINEAR)
			end = System.nanoTime();				//End stopwatch
			timeLinear += (end - start);			//Add time to total (L)
			
			start = System.nanoTime();				//Begin stopwatch
			binarySearch(e, r, 0, e.length-1);		//SEARCH (BINARY)
			end = System.nanoTime();				//End stopwatch
			timeBinary += (end - start);			//Add time to total (B)
		}
		System.out.println("LINEAR E: 1,280,000 ==> " + (timeLinear/30)); 
		System.out.println("BINARY E: 1,280,000 ==> " + (timeBinary/30));
		System.out.printf("\n=====================================\n");
		
		//=======================================================================
		
	}
	
	//LINEAR search for r in an array of doubles
	public static int linearSearch(double[] x, int r) {
		for(int i=0; i<x.length; i++) {
			if (x[i] == r)
				return i;
		}
		return -1;
	}

	
	public static int binarySearch(double[] x, int key, int low, int high) {
		
		if (low > high) // The list has been exhausted without a match
			return -low - 1;
		
		int mid = (low + high) / 2;
		
		if (key < x[mid])
			return binarySearch(x, key, low, mid - 1);

		else if (key == x[mid])
			return mid;
		
		else
			return binarySearch(x, key, mid + 1, high);
	}
	

	//Generate a random number between 0 and n-1
	public static int searchItemGen(double[] x) {
		Random rand = new Random();
		return rand.nextInt(x.length);
	}

	//Fill array of size 'size' with random numbers
	public static double[] randNums(int size) {
		Random rand = new Random();
		double[] x = new double[size];
		
		for(int i=0; i<x.length; i++) {
			x[i] = rand.nextInt(size+1);
		}
		Arrays.sort(x);
		return x;
	}
}