package moblima;
import java.util.ArrayList;
public class MovieView {

	public static void displayMovieDetail(String moviename,ArrayList<Movie> Movies) {
		Movie chosenMovie = Movies.get(0);
		for(int i=0;i<Movies.size();i++) {
			if(Movies.get(i).getTitle().equals(moviename)) {
				chosenMovie = Movies.get(i);
				break;
			}
		}
		System.out.println("Movie Title: "+chosenMovie.getTitle());
		System.out.println("Showing status: "+chosenMovie.getShowingStatus());
		System.out.println("Director: "+chosenMovie.getDirector());
		System.out.println("Rating: "+chosenMovie.getRating());
		System.out.println("Cast: "+chosenMovie.getActor());
		System.out.printf("Score: %.2f\n",chosenMovie.getScore());
		System.out.println("Sypnoosis: "+chosenMovie.getIntro());
		
		
	}
	public static ArrayList<Movie> displayTopRate(ArrayList<Movie> movies) {
		ArrayList<Movie> sortedMovies;
		sortedMovies = Sort.sortByRate(movies);
		System.out.println("All movies sorted by Rate");
		for(int i = 0;i<sortedMovies.size();i++) {
			System.out.println("No."+(i+1));
			System.out.println(sortedMovies.get(i).getTitle());
			System.out.printf("Score: %.2f\n",sortedMovies.get(i).getScore());
			//displayMovieDetail(sortedMovies.get(i));
			System.out.println(" ");
		}
		return sortedMovies;
	} 
	public static ArrayList<Movie> displayTopSale(ArrayList<Movie> movies) {
		ArrayList<Movie> sortedMovies;
		sortedMovies = Sort.sortBySale(movies);
		System.out.println("All movies sorted by Sale");
		for(int i = 0;i<sortedMovies.size();i++) {
			System.out.println("No."+(i+1));
			System.out.println(sortedMovies.get(i).getTitle());
			System.out.println(sortedMovies.get(i).getSalesNumber());
			//displayMovieDetail(sortedMovies.get(i));
			System.out.println(" ");
		}
		return sortedMovies;
	} 

}
