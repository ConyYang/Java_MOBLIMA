package moblima;

import java.io.Serializable;

public class Review implements Serializable{
	private String commenter;
	private int movieID;
	private String comment;
	private int score;
	public Review() {};
	public Review(String commenter, int movieID, String comment, int score) {
		this.commenter = commenter;
		this.movieID = movieID;
		this.comment = comment;
		this.score = score;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getScore() {
		return score;
	}
	public void setRating(int score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
