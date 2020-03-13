package moblima;

import java.io.Serializable;

public class Seat implements Serializable{
	private int row;
	private int col;
	private boolean booked;
	public Seat(int row, int col, boolean booked) {
		this.row = row;
		this.col = col;
		this.booked = booked;
	}
	public int getRow() {
		return row;
	}
	public void setRow(char row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked() {
		this.booked = true;
	}
	
}
