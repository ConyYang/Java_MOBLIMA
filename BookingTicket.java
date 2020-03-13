package moblima;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingTicket {
	public static Ticket BookTicket(ArrayList<Movie> movies, ArrayList<MovieSlot> slots, int cat) {
		
		String sel = ""; //selcted movie
		Cineplex selectedCineplex = null;
		Movie chosen = new Movie();
		System.out.println("Welcome to Ticket Booking");
		//--------------------------Select Movie------------------------------
		System.out.println("Available movies are listed below");
		for(Movie m: movies) {
			if(m.getShowingStatus()==Status.NOW_SHOWING)
				System.out.println(m.getTitle());
		}
		Scanner sc = new Scanner(System.in);
		boolean find=false;
		while(find!=true) {
			System.out.println("Enter Movie title: ");
			String movieName = sc.nextLine(); 
			for(Movie m: movies) {
				if (m.getTitle().equals(movieName)) {
					chosen = m;
					sel = m.getTitle();
					find = true;
					break;
				}
			}
			if(find)
				break;
			System.out.println("Cannot match movie");
		}
		//-------------------------Select Cineplex----------------------------
		ArrayList<MovieSlot> ava = new ArrayList<MovieSlot>();
		ArrayList<Cineplex> avaCpx = new ArrayList<Cineplex>();
		for(MovieSlot ms:slots) {
			if(ms.getMovie().getTitle().equals(sel)) {
				ava.add(ms);
			}
		}
		for(MovieSlot ms:slots) {
			if(!avaCpx.contains(ms.getCineplex()))
				avaCpx.add(ms.getCineplex());
		}
		System.out.println("Available Cineplexes are listed below");
		for(Cineplex s:avaCpx) {
			System.out.println(s.getName());
		}
		find=false;
		while(find!=true) {
			System.out.println("Enter Cineplex name: ");
			String cineplexName = sc.nextLine(); 
			for(Cineplex s: avaCpx) {
				if (s.getName().equals(cineplexName)) {
					selectedCineplex = s;
					find = true;
					break;
				}
			}
			if(find)
				break;
			System.out.println("Cannot match Cineplex");
		}
		//----------------------Select Time Slot--------------------------------
		ArrayList<MovieSlot> avaTS = new ArrayList<MovieSlot>();
		System.out.println("Available Time Slots:");
		System.out.println("Select according to the choice number:");
		for(MovieSlot ms:ava) {
			if(ms.getCineplex().equals(selectedCineplex)) {
				avaTS.add(ms);
				System.out.println("Choice "+(avaTS.indexOf(ms)+1));
				System.out.println("Date: "+ms.getDate());
				System.out.println("Time: "+ms.getTime());
				System.out.println("Cinema: "+ms.getCinema().getCinemaID());
				System.out.println("Cinema Class: "+ms.getCinemaClass());
				System.out.println("");
			}
		}
		int ch;
		System.out.println("Enter your selection: ");
		while(true) {
			try {
				ch = Integer.parseInt(sc.nextLine());
				if(1<=ch && ch<=avaTS.size())
					break;
				else
					System.out.println("Bad input! Enter your selection again!");
			} catch(NumberFormatException e) {
				System.out.println("Bad input! Enter your selection again!");
			}
		}
		MovieSlot msFound = avaTS.get(ch-1);
		for(MovieSlot ms: slots) {
			System.out.println("Looking slot");
			if(ms.getMovie().getMovieID()==msFound.getMovie().getMovieID()&&
					ms.getCineplex().getID() == msFound.getCineplex().getID()&&
					ms.getTime().equals(msFound.getTime())) {
				System.out.println("found slot!");
				while(true) {
					System.out.println("Choose your seat");
					Seatprinter.printSeat(ms.getCinemaSeats());
					System.out.println("Input the row number you selected (Capital Letter)");
					char row = sc.nextLine().charAt(0); 
					System.out.println("Input the column number you selected (integer)");
					int col = Integer.parseInt(sc.nextLine());
					int rowNum = (int)row - 65;
					System.out.println((col-1)+" "+rowNum);
					if(!ms.getCinemaSeats()[rowNum][col-1].isBooked()) {
						System.out.println(ms.getCinemaSeats()[rowNum][col-1]);
						ms.bookSeat(rowNum,col-1);
						ms.getMovie().saleOneMore();
						if(cat == 2) {
							SeniorTicket ts = new SeniorTicket(chosen,ms.getCinemaSeats()[rowNum][col-1],selectedCineplex,ms.getCinema(),ms.getDate(),ms);
							ts.printTicket();
							return ts;
							}
						else if(cat == 3) {
							ChildTicket tc = new ChildTicket(chosen,ms.getCinemaSeats()[rowNum][col-1],selectedCineplex,ms.getCinema(),ms.getDate(),ms);
							tc.printTicket();
							return tc;
						}
						Ticket ta = new Ticket(chosen,ms.getCinemaSeats()[rowNum][col-1],selectedCineplex,ms.getCinema(),ms.getDate(),ms);
						ta.printTicket();
						//Seatprinter.printSeat(ms.getCinemaSeats());
						return ta;
					}
					else
						System.out.println("The seat you have chosen is occupied!");
					}
			}
		}
		return null;
					
	}
	
}
