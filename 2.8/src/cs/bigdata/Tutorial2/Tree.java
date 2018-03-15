package cs.bigdata.Tutorial2;

public class Tree {

	// Define the variables Height and Year
	public String Height;
	public String Year;
	
	
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String  year) {
		Year = year;
	}
	
	// Assign values to the variables Height and Year for the current line
	public Tree(String line){
		super();
		
		String[] tokens=line.split(";");
        
		// Define location of the values in the line
		String year=tokens[5];
	    String height= tokens[6];
	    
	    // Assign values
		if(year.equals("")){
			Year=" NA ";
		}
		else {
			Year=year;
		}
	
		
		if (height.equals("")){
			Height=" NA ";
		}
		else {
			Height=height;
		}
	}
	
	// Display the result
	public void writeTree(){
		System.out.println( Height+" "+Year);
		}		
}