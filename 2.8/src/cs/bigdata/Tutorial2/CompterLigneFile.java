package cs.bigdata.Tutorial2;


import java.io.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;


// Read the lines in the input CSV and return the height and year of each tree

public class CompterLigneFile {

	public static void main(String[] args) throws IOException {
		
		// Path of the input CSV file
		String localSrc = "/home/cloudera/Desktop/arbres.csv";

		// Open the file
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		
		try{
			
			// Setup to read the file
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			// Initialization of the variable counting the number of lines
			Integer nbLines = 0;
			
			// Read line by line
			String line = br.readLine();
			
			while (line !=null){
				
				// Read the current line go to the next one
                nbLines+=1;
               
                if(nbLines > 1){
                	
                	// Find the height and year of the tree
                    Tree tree = new Tree(line);
                    
                    // Output the information
                    tree.writeTree();
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