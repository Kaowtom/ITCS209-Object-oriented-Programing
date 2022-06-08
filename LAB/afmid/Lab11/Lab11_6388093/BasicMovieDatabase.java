// Student ID: 6388093
// Name: Nitit Ngamphotchanamongkol
// Section: 2

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BasicMovieDatabase {
	
	// DO NOT MOIDIFY THIS 
	public static final String INIT_PATH = Paths.get("").toAbsolutePath().toString() 
			+ File.separator + "init" +  File.separator;

	public Map<Integer, Movie> movies = null;
	
	public static enum OPERATOR {EQ, LT, GT, LTE, GTE};
					// EQ = Equal, LT = Less than, GT = Greater than
					// LTE = Less than or equal, GTE = Greater than or equal
	
	// ---------------------------------------------------------------------
	
	public void importMovies(String movieFilename) {
		movies = new HashMap<Integer, Movie>();
		
		// -------- Using your code from Lab 10 -------------- //
		String files = "src\\lab10_movies.txt"; //set file's address
		File file = new File(files); // set new object file to collect file's address
		String con =null;
		try {
			BufferedReader be = new BufferedReader(new FileReader(file)); // use buffered reader to open file follow file address
			movies = new HashMap<Integer, Movie>(); // set new hash map
			while((con = be.readLine()) != null) {
				if(!con.trim().isEmpty()) { // check is that line empty or not
					String[] line = con.split(",", 3); // spilt them
					if(line.length==3) { // use if to separate the line that we want to use
						if(!line[1].isBlank() && !line[2].isBlank()) {
							int id = Integer.parseInt(line[0]); //convert string to integer  
							Movie mov = new Movie(id, line[1]); 
							line[2] = line[2].replace('|', ',');
							mov.tags.add(line[2]);
							movies.put(id, mov);
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
	
	
	
	/**
	 * Import movie ratings from text file and update into each specific movie
	 * @param filename
	 */
	public void importRating(String filename) {
		File file = new File("src\\lab11_ratings.txt");
		String temp = "";
		String id;
		double rt;
		long tstamp;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((temp = in.readLine()) != null) {
					if(!temp.trim().isEmpty() && temp.trim() != null){ 
						String[] line = temp.split(",", 3);
						rt = Double.parseDouble(line[1]);
						tstamp = Long.parseLong(line[2]);
						for(int x : movies.keySet()){
							if(rt >= 0.0 && rt <= 5.0){
								id = String.valueOf(movies.get(x).mid);
								Pattern pattern = Pattern.compile(line[0]);
								Matcher matcher = pattern.matcher(id);
								if(matcher.find()){
									Rating more = new Rating(movies.get(x), rt, tstamp);
									movies.get(x).rate.add(more);
								}
							}
						}
					}
			}
			in.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exporting movie with the valid format 
	 * <mid>,<title>,<tag1>|<tag2>|...|<tagN> and write to the given file
	 * @param filename
	 * @return number of exported movies
	 */
	public int exportMovies(String filename) {
		// YOUR CODE GOES HERE //
		return 0;
	}
	
	
	/**
	 * If you want to use this method, you can copy your code from lab 10
	 * @param query
	 * @return
	 */
	public List<Movie> searchMovies(String query) {
		
		// -------- Using your code from Lab 10 -------------- //
		
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
	
	/**
	 * Search movies by the query and the rating
	 * The operator indicate the comparison operator on the rating value
	 * (note. You may reuse the searchMovies method here)
	 * @param query
	 * @param op
	 * @param rating
	 * @return List of movies that satisfied the conditions
	 */
	public List<Movie> searchMoviesWithRating(String query, OPERATOR op, double rating) {
		
		// YOUR CODE GOES HERE //
		List<Movie> fn =  new CopyOnWriteArrayList<Movie>(searchMovies(query));
		for(Movie m : fn){
			if(op.equals(OPERATOR.LT)){
				try {
					if(m.getAverageRating() >= rating){
						fn.remove(m);
					}
				} catch (MovieException e) {
					e.printStackTrace();
				}
			}
			if(op.equals(OPERATOR.EQ)){
				try {
					if(m.getAverageRating() != rating){
						fn.remove(m);
					}
				} catch (MovieException e) {
					e.printStackTrace();
				}
			}
			if(op.equals(OPERATOR.GT)){
				try {
					if(m.getAverageRating() <= rating){
						fn.remove(m);
					}
				} catch (MovieException e) {
					e.printStackTrace();
				}
			}
			if(op.equals(OPERATOR.GTE)){
				try {
					if(m.getAverageRating() < rating){
						fn.remove(m);
					}
				} catch (MovieException e) {
					e.printStackTrace();
				}
			}
			if(op.equals(OPERATOR.LTE)){
				try {
					if(m.getAverageRating() > rating){
						fn.remove(m);
					}
				} catch (MovieException e) {
					e.printStackTrace();
				}
			}
		}
		return fn;
	}
	
	// ********************************************************************************
	// DO NOT MODIFY THIS MAIN METHOD (except to uncomment the bonus part)
	public static void main(String[] args) {
		
		BasicMovieDatabase mdb = new BasicMovieDatabase();
		mdb.importMovies(INIT_PATH + "lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305, 140715, 148626};
		
		System.out.println("-- before adding ratings --");
		for(int mid: mids) {
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		// Task 1: importing movies rating file and update the movies rating
		System.out.println("-- after adding ratings --");
		mdb.importRating(INIT_PATH + "lab11_ratings.txt");
		for(int mid: mids) {
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
			
		}
		
		
		// Task 2: exporting movies into a new file
		System.out.println("-- exporting movies --");
		
		// add two more movies
		mdb.movies.put(999999, new Movie(999999, "Harry Potter"));
		mdb.movies.put(888888, new Movie(888888, "Up"));
		mdb.movies.get(888888).tags.add("Animation");
		
		// export movie into the text file
		try {
			File export = new File(INIT_PATH + "lab11_movies.txt");
			Files.deleteIfExists(export.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = mdb.exportMovies(INIT_PATH + "lab11_movies.txt");
		System.out.println("Done exporting " + count + " movies");
		// The file should contains 50 movies
		
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		double[] ratings = {0.0, 2.5, 4.0};
		String query = "america";
		
		OPERATOR[] ops = {OPERATOR.EQ, OPERATOR.GT, OPERATOR.GTE};
		for(OPERATOR op: ops) {
			for(int i = 0; i < 3; i++) {
				double rating = ratings[i];
				System.out.println("Results for movies that match: ["+query + "] and have rating " + op.toString() + " " + rating);
				for(Movie m: mdb.searchMoviesWithRating(query, op, rating)) {
					System.out.println("\t"+m);
				}
				System.out.println();
			}
		}
		
	}

}
