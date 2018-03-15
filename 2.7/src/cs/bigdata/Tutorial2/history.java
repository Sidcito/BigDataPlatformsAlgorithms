package cs.bigdata.Tutorial2;

import java.io.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class history {
	
	// Define the 4 variables of interest and extract information from the right location
	public static String DisplayLine (String line) {
		String USAF = line.substring(0, 6);
        String Name = line.substring(13, 42);
        String FIPS = line.substring(43, 45);
        String Elevation = line.substring(74, 81);
        
        // Output the relevant information of the line
        return String.format("USAF: %s\t Name: %s\t FIPS: %s\t Elevation: %s\n", USAF, Name, FIPS, Elevation);  
	}

    public static void main(String[] args) throws IOException, NumberFormatException {
        
        // Define the path of the input TXT file
        String localSrc = "/home/cloudera/Desktop/isd-history.txt"; 
        
        // Open the file
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
        
        try{
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            
            // Initialize the variable counting the number of lines
            Integer nbLines = 0;
            
            // Read line
            String line = br.readLine();
            
            while (line !=null){
                // Read the current line and go to the next one
                nbLines+=1;
                
                // Skip the first 22 lines
                if(nbLines > 22){
                   System.out.println(DisplayLine(line));
                }
          
                line = br.readLine();
            }
            br.close();
        }
        finally{
        	
            // Close the file
            in.close();
            fs.close();
            
        }    
        
    }

}