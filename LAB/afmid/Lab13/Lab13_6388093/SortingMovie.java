import java.util.ArrayList;

public class SortingMovie {

	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie(1, "The Intern", 2009));
		movieList.add(new Movie(2, "The Gift", 2009));
		movieList.add(new Movie(3, "The Lost Room", 2009));
		movieList.add(new Movie(4, "The Gift", 2012));
		movieList.add(new Movie(5, "Pasolini", 2012));
		movieList.add(new Movie(6, "The Intern", 2009));
		movieList.add(new Movie(7, "American Ultra", 2019));
		movieList.add(new Movie(8, "Sweet Red Bean Paste", 2019));
		
		sort(movieList);
		System.out.println("== sorted movie list (ascending) ==");
		for(Movie i: movieList) {
			System.out.println(i.toString());
		}
	}
	
	public static void sort (ArrayList<Movie>  movies) {
		// YOUR CODE GOES HERE
		int n = movies.size();
        for (int i = 0; i < n-1; i++){
            
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (movies.get(j).compareTo( movies.get(min_idx) ) > 0)
                    min_idx = j;
  
            
            Movie temp = movies.get(i);
            movies.set(i, movies.get(min_idx));
            movies.set(min_idx, temp);
        }
	}

}
