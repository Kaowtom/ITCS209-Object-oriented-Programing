import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LinearNameSearcher extends NameSearcher {
	
//	ArrayList<String> re = new ArrayList<>();
//	String con = "";
	
	LinearNameSearcher(String filename) {
		super(filename);
//		try {
//			BufferedReader be = new BufferedReader(new FileReader(filename));
//			while((con = be.readLine())!=null) {
//				if(!con.trim().isEmpty()) {
//					String[] line = con.split(" ");
//					re.addAll(Arrays.asList(line));
//				}
//			}
//			be.close();
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
	}


	public String find(String query) {
		 for(int i = 0 ; i < readNames.size() ; i++){
	            number_of_compared++;
	            if(readNames.get(i).equalsIgnoreCase(query)) {
	                return "Found "+readNames.get(i)+"(" + i +")";
	            }
	        }
		 return "Not Found Name: '"+query+"'";
	}

}
