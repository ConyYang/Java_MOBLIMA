package moblima;
import java.util.ArrayList;

public class Sort {

	public static ArrayList<Movie> sortByRate(ArrayList<Movie> givenMovies) {
		// TODO Auto-generated constructor stub
		ArrayList<Movie> movies = new ArrayList<Movie>(givenMovies);
		ArrayList<Movie> sortedMovies = new ArrayList<Movie>();
		///bubble sort is used to save on swapping operation
		
		//for(int)
		while(movies.size()!=0) {
			Movie topMovie = movies.get(0);
			double maxScore = topMovie.getScore();
			int maxIndex=0;
			if(topMovie.getShowingStatus() == Status.END_OF_SHOWING){
				movies.remove(0);
				continue;
			}
			for(int j = 0;j<movies.size();j++) {
				Movie tempMovie = movies.get(0);
				double tempScore = tempMovie.getScore();
				
				if(maxScore<tempScore) {
					topMovie = tempMovie;
					maxScore = tempScore;
					maxIndex = j;
				}
					
			}
			sortedMovies.add(topMovie);
			movies.remove(maxIndex);
		}
		
		
		return sortedMovies;
	}
	public static ArrayList<Movie> sortBySale(ArrayList<Movie> givenMovies) {
		// TODO Auto-generated constructor stub
		ArrayList<Movie> movies = new ArrayList<Movie>(givenMovies);
		ArrayList<Movie> sortedMovies = new ArrayList<Movie>();
		///bubble sort is used to save on swapping operation

		//for(int)
		//by changing the condition for while loop, can change to "sort first 10"
		while(movies.size()!=0) {
			Movie topMovie = movies.get(0);
			double maxSale = topMovie.getSalesNumber();
			int maxIndex=0;
			
			if(topMovie.getShowingStatus() == Status.END_OF_SHOWING){
				movies.remove(0);
				continue;
			}
			for(int j = 0;j<movies.size();j++) {
				Movie tempMovie = movies.get(0);
				double tempSale = tempMovie.getSalesNumber();
				if(tempMovie.getShowingStatus() == Status.END_OF_SHOWING){
					movies.remove(0);
					break;
				}
				
				if(maxSale<tempSale) {
					topMovie = tempMovie;
					maxSale = tempSale;
					maxIndex = j;
				}
					
			}
			sortedMovies.add(topMovie);
			movies.remove(maxIndex);
		}
		
		
		return sortedMovies;
	}
}
