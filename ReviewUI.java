package moblima;
import java.util.Scanner;
public class ReviewUI {

	public void writeReview(Movie movie) {
		Scanner sc = new Scanner(System.in);
		String name;
		String comment;
		int score;
		Review review = new Review();
		System.out.println("Welcome to review writing!");
		System.out.println("Please enter your name:");
		name = sc.nextLine();
		review.setCommenter(name);
		System.out.println("Enter score as an interger between 1 to 5");
		while(true) {
			try {
				score = Integer.parseInt(sc.nextLine());
				if(1<=score && score<=5)
					break;
				else
					System.out.println("Bad input! Enter your selection again!");
			} catch(NumberFormatException e) {
				System.out.println("Bad input! Enter your selection again!");
			}
		}
		review.setRating(score);
		System.out.println("Please enter your comment:");
		comment = sc.nextLine();
		review.setComment(comment);
		movie.setReviews(review);
		System.out.println("Thank you for writing a review!");
		
	}

}
