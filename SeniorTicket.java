package moblima;

import java.time.LocalDate;

public class SeniorTicket extends Ticket {
	private double discountRatio;
	private double discountedPrice;
	
	public SeniorTicket() {
		// TODO Auto-generated constructor stub
		super();
		discountRatio = 0.8;
		discountedPrice = -1; //sentinal value
	}

	public SeniorTicket(Movie movieChosen, Seat seat, Cineplex cineplex, Cinema cinema, LocalDate date, MovieSlot slot) {
		super(movieChosen, seat, cineplex, cinema, date, slot);
		// TODO Auto-generated constructor stub
	}
	public double getPrice() {
		//double discountedPrice;
		if(discountedPrice == -1) {
		discountedPrice = super.getPrice()*discountRatio;
		}
		//super.setPrice(basicPrice*discountRatio);
		return discountedPrice;
		
	}
	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}


}
