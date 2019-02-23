/*
Nguyen, Abram - Lab 3 [Due: September 28, 2018, 11:59 PM]

	PACKAGE	
		1) All status variables of the Package class must be private.
		2) Write no more than two constructors.
		3) Must have a public method named getVolume() that will return the volume of the package.
		4) Must have a public method named isCube() that will return true if the package is cubic, false otherwise.
		5) The Package class must NOT contain any main method.
*/
 class Package { 
 
	private double width;
	private double height;
	private double length;
	
	//Constructor
	Package(double w, double h, double l) {
		width = w;
		height = h;
		length = l;
	}
	
	//Calculate volume
	double getVolume() {
		return width*height*length;
	}
	
	//Is it a cube?
	boolean isCube() {
		if (width == height && height == length)
			return true;
		return false;
	}
	
	
	//Mutators / Setters ==========================
	
	//Set WIDTH
	public void setWidth(double w) {
		width = w;
	}
	
	//Set HEIGHT
	public void setHeight(double h) {
		height = h;
	}
	
	//Set LENGTH
	public void setLength(double l) {
		length = l;
	}
	
	
	//Accessors / Getters ==========================
	
	//Get WIDTH
	public double getWidth() {
			return width;
	}

	//Get HEIGHT
	public double getHeight() { 
		return height;
	}
	
	//Get LENGTH
	public double getLength() { 
		return length;
	}
}

