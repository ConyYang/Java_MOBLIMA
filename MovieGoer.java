package moblima;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieGoer implements Serializable{
	private String first_name;
	private String last_name;
	private ArrayList<Ticket> bookingHistory;
	private String mobileNumber;
	public MovieGoer(long goerID, String first_name, String last_name, ArrayList<Ticket> bookingHistory, String mobileNumber) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.bookingHistory = bookingHistory;
		this.mobileNumber = mobileNumber;
	}
	public MovieGoer() {
		bookingHistory = new ArrayList<Ticket>();
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public ArrayList<Ticket> getBookingHistory() {
		return bookingHistory;
	}
	public void setBookingHistory(ArrayList<Ticket> bookingHistory) {
		this.bookingHistory = bookingHistory;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
