package moblima;
import java.io.Serializable;
import java.util.ArrayList;
public class Movie implements Serializable{
	
	private int movieID;
	private String title;
	private Status showingStatus; //enum
	private String intro;
	private String director;
	private String actor;
	private Rating rating; //enum
	private double score;
	private MovieType movieType; //enum
	private ArrayList<Review> reviews;
	private int salesNumber;
	private ArrayList<MovieSlot> timeslot;
	
	public Movie() {
		this.movieID = Moblima.currentID;
		Moblima.currentID += 1;
		this.title = "new movie";
		this.showingStatus = Status.COMING_SOON;
		this.intro = "This is a movie.";
		this.rating = Rating.G;
		this.score = 0;
		this.movieType = MovieType.Regular;
		this.salesNumber = 0;
		this.reviews = new ArrayList<Review>();
		this.score = 0.0;
		this.timeslot = new ArrayList<MovieSlot>();
	}
	public Movie(int movieID, String title, Status showingStatus, String intro, String director, String actor, Rating rating,
			MovieType movieType, int sales) {
		this.movieID = movieID;
		this.title = title;
		this.showingStatus = showingStatus;
		this.intro = intro;
		this.director = director;
		this.actor = actor;
		this.rating = rating;
		this.movieType = movieType;
		this.salesNumber = sales;
		this.reviews = new ArrayList<Review>();
		this.score = 0.0;
		this.timeslot = new ArrayList<MovieSlot>();
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getShowingStatus() {
		return showingStatus;
	}

	public void setShowingStatus(Status mstatus) {
		this.showingStatus = mstatus;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Review review) {
		this.reviews.add(review);
	}
	
	public int getSalesNumber() {
		return salesNumber;
	}
	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}
	public ArrayList<MovieSlot> getMovieSlots() {
		return timeslot;
	}

	public void getMovieSLots(MovieSlot slot) {
		this.timeslot.add(slot);
	}
	
	public void saleOneMore() {
		this.salesNumber+=1;
	}
	
}
