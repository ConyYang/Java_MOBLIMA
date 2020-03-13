package moblima;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable{
	private int cinemaID;
	private Cineplex cineplex;
	private CinemaClass cinemaclass;
	private ArrayList<MovieSlot> movieSlots;
	public Cinema(Cineplex cineplex, int cinemaID, CinemaClass cinemaclass) {
		super();
		this.cineplex = cineplex;
		this.cinemaID = cinemaID;
		this.cinemaclass = cinemaclass;
		this.movieSlots = new ArrayList<MovieSlot>();
	}
	public Cinema() {
		// TODO Auto-generated constructor stub
	}
	public Cineplex getCineplex() {
		return cineplex;
	}
	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}
	public int getCinemaID() {
		return cinemaID;
	}
	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}
	public CinemaClass getCinemaclass() {
		return cinemaclass;
	}
	public void setCinemaclass(CinemaClass cinemaclass) {
		this.cinemaclass = cinemaclass;
	}
	public ArrayList<MovieSlot> getMovieSlots() {
		return movieSlots;
	}
	public void setMovieSlots(ArrayList<MovieSlot> movieSlots) {
		this.movieSlots = movieSlots;
	}
	public void addMovieSlot(MovieSlot mv) {
		movieSlots.add(mv);
	}
	
}
