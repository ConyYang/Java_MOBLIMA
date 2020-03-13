package moblima;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Price {
	public static Map<String, Double> priceMap = new HashMap<String, Double>();
	
	public static void editPriceMap(String type, double price) {
		priceMap.replace(type,price);
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("price.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(priceMap);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println(priceMap);
	}
	
	public static void setPriceMap() {
		priceMap.put("WeekdayRegularStandard",9.00);
		priceMap.put("WeekendRegularStandard",11.00);
		priceMap.put("WeekdayThreeDimensionStandard",11.00);
		priceMap.put("WeekendThreeDimensionStandard",15.00);
		priceMap.put("WeekdayRegularPlatinum",15.00);
		priceMap.put("WeekendRegularPlatinum",20.00);
		priceMap.put("WeekdayThreeDimensionPlatinum",20.00);
		priceMap.put("WeekendThreeDimensionPlatinum",25.00);
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("price.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(priceMap);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println(priceMap);
	}
	public static void readPriceMap() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		priceMap = new HashMap<String, Double>();
		try {
			fis = new FileInputStream("price.dat");
			in = new ObjectInputStream(fis);
			priceMap = (Map<String, Double>)in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println(priceMap);
	}

	public static double calPrice(Ticket ticket)
	{
		if(ticket.getCinema().getCinemaclass()==CinemaClass.STANDARD) {
			//Senior Citizen and Students are not finish
			DayOfWeek day = ticket.getDate().getDayOfWeek();
			if (ticket.getMovieChosen().getMovieType() == MovieType.Regular)
			{
				switch (day)
				{
					case MONDAY:
					case TUESDAY:
					case WEDNESDAY:
					case THURSDAY:
						return priceMap.get("WeekdayRegularStandard");
					case FRIDAY:
					{
						if (Integer.parseInt(ticket.getSlot().getTime().substring(0,2))<18) {
							System.out.println("Before Friday Evening");//should be time of movie 
							return priceMap.get("WeekdayRegularStandard");
						}
						else
							return priceMap.get("WeekendRegularStandard");
					}
					case SATURDAY:
					case SUNDAY:
						return priceMap.get("WeekendRegularStandard");
				}
			}
			if (ticket.getMovieChosen().getMovieType() == MovieType.ThreeDimension)
			{
				
				switch (day)
				{
					case MONDAY :
					case TUESDAY:
					case WEDNESDAY:
					case THURSDAY:
						return priceMap.get("WeekdayThreeDimensionStandard");
					case FRIDAY:
					{
						

						if (Integer.parseInt(ticket.getSlot().getTime().substring(0,2))<18)//should be time of movie 
							return priceMap.get("WeekdayThreeDimensionStandard");
						else
							return priceMap.get("WeekendThreeDimensionStandard");
					}
					case SATURDAY:
					case SUNDAY:
						return priceMap.get("WeekendThreeDimensionStandard");
				}
			}
			
		}
		else {
			DayOfWeek day = ticket.getDate().getDayOfWeek();
			if (ticket.getMovieChosen().getMovieType() == MovieType.Regular)
			{
				switch (day)
				{
					case MONDAY:
					case TUESDAY:
					case WEDNESDAY:
					case THURSDAY:
						return priceMap.get("WeekdayRegularPlatinum");
					case FRIDAY:
					{
						//System.out.println(Integer.parseInt(ticket.getSlot().getTime().substring(0,2)));
						if (Integer.parseInt(ticket.getSlot().getTime().substring(0,2))<18)//should be time of movie 
							return priceMap.get("WeekdayRegularPlatinum");
						else
							return priceMap.get("WeekendRegularPlatinum");
					}
					case SATURDAY:
					case SUNDAY:
						return priceMap.get("WeekendRegularPlatinum");
				}
			}
			if (ticket.getMovieChosen().getMovieType() == MovieType.ThreeDimension)
			{
				
				switch (day)
				{
					case MONDAY :
					case TUESDAY:
					case WEDNESDAY:
					case THURSDAY:
						return priceMap.get("WeekdayThreeDimensionPlatinum");
					case FRIDAY:
					{
						if (Integer.parseInt(ticket.getSlot().getTime().substring(0,2))<18)//should be time of movie 
							return priceMap.get("WeekdayThreeDimensionPlatinum");
						else
							return priceMap.get("WeekendThreeDimensionPlatinum");
					}
					case SATURDAY:
					case SUNDAY:
						return priceMap.get("WeekendThreeDimensionPlatinum");
				}
			}
			
							
		}
		return 0;
	}
}
