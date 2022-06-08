import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sorting {
	
	public static ArrayList<String> read(String filename){
		File file = new File(filename);
		ArrayList<String> re = new ArrayList<>();
		String con = "";
		try {
			BufferedReader be = new BufferedReader(new FileReader(file));
			while((con = be.readLine())!=null) {
				if(!con.trim().isEmpty()) {
					String[] line = con.split(" ");
					re.addAll(Arrays.asList(line));
				}
			}
			be.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return re;
	}
	
	public static void print(ArrayList<String> print) {
		System.out.print(" " + print);
	}
	
	public static void sort (ArrayList<String> arr) {
		int n = arr.size();
        for (int i = 0; i < n-1; i++){
            
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j).compareTo( arr.get(min_idx) ) > 0)
                    min_idx = j;
  
            
            String temp = arr.get(i);
            arr.set(i, arr.get(min_idx));
            arr.set(min_idx, temp);
            System.out.print("Pass " + (i+1) + ": ");
            print(arr);
            System.out.println("");
        }
	}
	
	public static void main(String[] args) {
		ArrayList<String> readline = read("src\\unsorted.txt");
		System.out.print("Original:");
		print(readline);
		System.out.println("");
		sort(readline);
	}
}
