import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {
	public Map<Integer, Movie> movies = null;
	
	public void importMovies(String movieFilename)
	{	//YOUR CODE GOES HERE
		String files = "src\\lab10_movies.txt"; //set file's address
		File file = new File(files); // set new object file to collect file's address
		String con =null;
		try {
			BufferedReader be = new BufferedReader(new FileReader(file)); // use buffered reader to open file follow file address
//			List<Movie> list = new ArrayList<>();
			movies = new HashMap<Integer, Movie>(); // set new hash map
			while((con = be.readLine()) != null) {
//				System.out.println(con);
				if(!con.trim().isEmpty()) { // check is that line empty or not
					String[] line = con.split(",", 3); // spilt them
					if(line.length==3) { // use if to separate the line that we want to use
						if(!line[1].isBlank() && !line[2].isBlank()) {
//							System.out.println(line.length);
//							System.out.println(line[0]);
//							System.out.println(line[1]);
//							System.out.println(line[2]);
							int id = Integer.parseInt(line[0]); //convert string to integer  
							Movie mov = new Movie(id, line[1]); 
//							System.out.println(mov.mid);
							line[2] = line[2].replace('|', ',');
							mov.tags.add(line[2]);
//							System.out.println(mov.tags);
//							list.add(new Movie(id, line[1]));
//							movies = new HashMap<Integer, Movie>();
							movies.put(id, mov);
//							movies.entrySet();
//							System.out.println(movies.toString());
//							System.out.println(list.size());
						}
					}
				}
			}
//			for(Movie a : list) {
//				System.out.println(a.toString());
//			}
			be.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}


	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> list = new ArrayList<>();
		for(Movie i : movies.values()) {
			Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(i.title);
			if(matcher.find()) {
				list.add(i);
			}
		}
		return list;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie>  list = new ArrayList<>();
//		System.out.println(movies.keySet());
		for(int key : movies.keySet()) {
			
			String s = movies.get(key).tags+" ";
			if(s.contains(tag)) {
				list.add(movies.get(key));
			}
		}
		return list;
	}
	
	
	public static void main(String[] args)
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		
	}

}
