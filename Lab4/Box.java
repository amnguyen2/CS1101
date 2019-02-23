/*
Nguyen, Abram - Lab 4 [Due: October 12, 2018, 11:59 PM]

	BOX
        1) You are allowed to keep only one of the status variables public. The rest of the status variables of the Box class must be private.  
        2) Write no more than two constructors. 
        3) The Box class must have a public method named getVolume() 
               that will return the volume of the box. 
        4) The Box class must have a public method named isCube() 
               that will return true if the box is cubic, false otherwise. 
        5) The Box class must NOT contain any main method.
*/

class Box {

    private double width;
	private double height;
    private double length;
    Box next;

	//Constructors
	Box() {
	}

	Box(double w, double h, double l) {
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