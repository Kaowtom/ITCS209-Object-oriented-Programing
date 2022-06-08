import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.FileUtils;

public abstract class NameSearcher {

	protected static ArrayList<String> readNames = null;
	protected int number_of_compared = 0; 
	
	NameSearcher(String filename)
	{
		try {
			readNames = (ArrayList<String>) FileUtils.readLines(new File(filename), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//clean word
        readNames.replaceAll(name -> name.toLowerCase());  
        	
	}

	public int getNumComparisons() {
		return number_of_compared;
	}

	public void resetCompareCounter() {
		number_of_compared = 0;
	}
	
	/**
	 * This method will be used in the EXTRA TASK
	 */
    public void sortName() {
    	// YOUR CODE GOES HERE
    	int n = readNames.size();
        for (int i = 0; i < n-1; i++){
            
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (readNames.get(j).compareTo( readNames.get(min_idx) ) > 0)
                    min_idx = j;
  
            
            String temp = readNames.get(i);
            readNames.set(i, readNames.get(min_idx));
            readNames.set(min_idx, temp);
        }
    }

	public abstract String find(String query);


}


