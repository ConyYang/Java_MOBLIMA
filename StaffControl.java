package moblima;
import java.util.Scanner;
public class StaffControl {
	public static Movie addMovie() {
		Scanner sc = new Scanner(System.in);
		Movie mov = new Movie();
		mov = updateTitle(mov);
		mov = initiateStatus(mov);
		mov = updateIntro(mov);
		mov = updateDirector(mov);
		mov = updateActor(mov);
		mov = updateRating(mov);
		mov = updateMovieType(mov);
		return mov;
	}

	
	/**
	 * Set title for the movie.
	 * @param m Movie instance.
	 * @return Movie instance.
	 */
	public static Movie updateTitle(Movie m) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the title of the movie:");
		m.setTitle(sc.nextLine());
		System.out.println("Set title successfully.");
		return m;
	}
	/**
	 * Set status for the movie.
	 * @param m Movie instance.
	 * @return Movie instance.
	 */
	public static Movie updateStatus(Movie m) {
		Scanner sc = new Scanner(System.in);
		String mstatus;
		System.out.println("Please enter the status of the movie:");
		System.out.println("There are four status available. Choose one of them.");
		System.out.println("Exactly same word is required.");
		System.out.println("COMING_SOON, PREVIEW, NOW_SHOWING");
		System.out.println("Your input:");
		while(true){
			mstatus = sc.nextLine();
			if((mstatus=="COMING_SOON")|(mstatus=="PREVIEW")|(mstatus=="NOW_SHOWING"))
				break;
			System.out.println("Sorry. Your input doesn't match with any status. Try again.");
			System.out.println("Your input:");
		}
		
		m.setShowingStatus(Status.valueOf(mstatus)); 
		System.out.println("Set status successfully.");
		return m;
	}
	public static Movie initiateStatus(Movie m) {
		Scanner sc = new Scanner(System.in);
		String mstatus;
		System.out.println("Please enter the status of the movie:");
		System.out.println("There are four status available. Choose one of them.");
		System.out.println("Exactly same word is required.");
		System.out.println("COMING_SOON, PREVIEW, NOW_SHOWING,END_OF_SHOWING");
		System.out.println("Your input:");
		while(true){
			mstatus = sc.nextLine();
			if((mstatus=="COMING_SOON")|(mstatus=="PREVIEW")|(mstatus=="NOW_SHOWING")|(mstatus == "END_OF_SHOWING"))
				break;
			System.out.println("Sorry. Your input doesn't match with any status. Try again.");
			System.out.println("Your input:");
		}
		
		m.setShowingStatus(Status.valueOf(mstatus)); 
		System.out.println("Set status successfully.");
		return m;
	}
	public static Movie removeMovie(Movie m) {
		m.setShowingStatus(Status.END_OF_SHOWING); 
		System.out.println("Movie is removed");
		return m;
	}
	/**
	 * Set synopsis for the movie.
	 * @param m Movie instance.
	 * @return Movie instance.
	 */
	public static Movie updateIntro(Movie m) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the synopsis of the movie:");
		m.setIntro(sc.nextLine());
		System.out.println("Set synopsis successfully.");
		return m;
	}
	/**
	 * Set director for the movie.
	 * @param m Movie instance.
	 * @return Movie instance.
	 */
	public static Movie updateDirector(Movie m) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the director of the movie:");
		m.setDirector(sc.nextLine());
		System.out.println("Set director successfully.");
		return m;
	}
	/**
	 * Set cast for the movie.
	 * @param m Movie instance.
	 * @return Movie instance.
	 */
	public static Movie updateActor(Movie m) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the actors and actresses of the movie:");
		System.out.println("Use \", \"in between, for example: Andy Lau, Jackie Chan");
		m.setActor(sc.nextLine());
		System.out.println("Set actors and actresses successfully.");
		return m;
		}
	public static Movie updateRating(Movie m) {
		Scanner sc = new Scanner(System.in);
		String rawRating;
		System.out.println("Please select the rating of the movie:");
		System.out.println("1)G,\n2)PG,\n3)PG13,\n4)NC16,\n5)M18,\n6)R21,\n7)NAR");
		System.out.println("Exactly same Abbreviation is required. For example: \"NC16\"");
		System.out.println("Your input:");
		while(true){
			rawRating = sc.nextLine();
			if((rawRating=="G")|(rawRating=="PG")|(rawRating=="PG13")|(rawRating=="NC16")|(rawRating=="M18")|(rawRating=="R21")|(rawRating=="NAR"))
				break;
			System.out.println("Sorry. Your input doesn't match with any categories. Try again.");
			System.out.println("Your input:");
		}
		
		m.setRating(Rating.valueOf(rawRating)); 
		System.out.println("Set rating successfully.");
		return m;
	}
	public static Movie updateMovieType(Movie m) {
		Scanner sc = new Scanner(System.in);
		String rawType;
		System.out.println("Please select the type of the movie:");
		System.out.println("1) Regular\n2) ThreeDimension");
		System.out.println("Exactly same speeling is required. For example: \"Regular\"");
		System.out.println("Your input:");
		while(true){
			rawType = sc.nextLine();
			if((rawType=="Regular")|(rawType=="ThreeDimension"))
				break;
			System.out.println("Sorry. Your input doesn't match with any categories. Try again.");
			System.out.println("Your input:");
		}
		
		m.setMovieType(MovieType.valueOf(rawType)); 
		System.out.println("Set movie type successfully.");
		return m;
	}
	
	@SuppressWarnings("finally")
	public Ticket setTicketPrice(Ticket t) {
		Scanner sc = new Scanner(System.in);
		double price = 0;
		System.out.println("How much is the price?");
		try {
			price = sc.nextDouble();
			if(price<0)
				throw new ArithmeticException( "Error: ticket price cannot less than 0." );
			t.setPrice(price);
			System.out.println("Set price successfully.");
		}
		catch(Exception e){
			System.out.println( e.getMessage() );
			System.out.println("Set price unsuccessfully.");
		}
		finally {
			return t;
		}
	}
}
