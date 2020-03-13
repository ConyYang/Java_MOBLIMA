package moblima;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Moblima {
	public static int currentID=0;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Price.setPriceMap();
		LocalDate dateIni = LocalDate.parse("2019-11-15");
		//Read data From Files
		ArrayList <Movie> movies = new ArrayList<Movie>();
		//ArrayList <Ticket> tickets = new ArrayList<Ticket>();
		/*try {
			movies = readMovie("movie.txt") ;
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
		ArrayList <Review> reviews = new ArrayList<Review>();
		try {
			reviews = readReview("review.txt") ;
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}*/
		
		/*for (int i = 0 ; i < reviews.size() ; i++) {
			Review review = (Review)reviews.get(i);
			System.out.println("Movie ID: "+review.getMovieID());
			System.out.println("Commenter: "+review.getCommenter());
			System.out.println("Score: "+review.getScore());
			System.out.println("Comment: "+review.getComment());
	    }*/
		
		/*for (Review r: reviews) {
			for (Movie m: movies) {
				if (r.getMovieID()==m.getMovieID()) {
					m.setReviews(r);
				}
			}
		}*/
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream("movie.dat");
			in = new ObjectInputStream(fis);
			movies = (ArrayList<Movie>)in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		ArrayList <MovieSlot> slots = new ArrayList<MovieSlot>();
		ArrayList <MovieGoer> goers = new ArrayList<MovieGoer>();
		ArrayList <Cineplex> cineplexes = new ArrayList<Cineplex>();
		
		Cineplex cineplex0 = new Cineplex("Jurong Point",0);
		Cineplex cineplex1 = new Cineplex("Vivocity",1);
		Cineplex cineplex2 = new Cineplex("Woodlands",2);
		

		Cinema cinema0_0 = new Cinema(cineplex0, 0, CinemaClass.STANDARD);
		Cinema cinema0_1 = new Cinema(cineplex0, 1, CinemaClass.STANDARD);
		Cinema cinema0_2 = new Cinema(cineplex0, 2, CinemaClass.PLATINUM);
		Cinema cinema1_0 = new Cinema(cineplex1, 0, CinemaClass.STANDARD);
		Cinema cinema1_1 = new Cinema(cineplex1, 1, CinemaClass.STANDARD);
		Cinema cinema1_2 = new Cinema(cineplex1, 2, CinemaClass.PLATINUM);
		Cinema cinema2_0 = new Cinema(cineplex2, 0, CinemaClass.STANDARD);
		Cinema cinema2_1 = new Cinema(cineplex2, 1, CinemaClass.STANDARD);
		Cinema cinema2_2 = new Cinema(cineplex2, 2, CinemaClass.PLATINUM);
		

		MovieSlot mv0 = new MovieSlot("11:30", cinema2_0, movies.get(0),dateIni);
		MovieSlot mv1 = new MovieSlot("14:30", cinema2_0, movies.get(0),dateIni);
		MovieSlot mv2 = new MovieSlot("11:30", cinema2_1, movies.get(1),dateIni);
		MovieSlot mv3 = new MovieSlot("14:30", cinema2_1, movies.get(1),dateIni);
		MovieSlot mv4 = new MovieSlot("11:30", cinema1_0, movies.get(0),dateIni);
		MovieSlot mv5 = new MovieSlot("14:30", cinema1_0, movies.get(0),dateIni);
		MovieSlot mv6 = new MovieSlot("11:30", cinema1_1, movies.get(1),dateIni);
		MovieSlot mv7 = new MovieSlot("14:30", cinema1_1, movies.get(1),dateIni);
		MovieSlot mv8 = new MovieSlot("11:30", cinema0_0, movies.get(0),dateIni);
		MovieSlot mv9 = new MovieSlot("14:30", cinema0_0, movies.get(0),dateIni);
		MovieSlot mv10 = new MovieSlot("11:30", cinema0_1, movies.get(1),dateIni);
		MovieSlot mv11 = new MovieSlot("14:30", cinema0_1, movies.get(1),dateIni);
		
		slots.add(mv0);
		slots.add(mv1);
		slots.add(mv2);
		slots.add(mv3);
		slots.add(mv4);
		slots.add(mv5);
		slots.add(mv6);
		slots.add(mv7);
		slots.add(mv8);
		slots.add(mv9);
		slots.add(mv10);
		slots.add(mv11);
		
		cinema2_0.addMovieSlot(mv0);
		cinema2_0.addMovieSlot(mv1);
		cinema2_1.addMovieSlot(mv2);
		cinema2_1.addMovieSlot(mv3);
		cinema1_0.addMovieSlot(mv4);
		cinema1_0.addMovieSlot(mv5);
		cinema1_1.addMovieSlot(mv6);
		cinema1_1.addMovieSlot(mv7);
		cinema0_0.addMovieSlot(mv8);
		cinema0_0.addMovieSlot(mv9);
		cinema0_1.addMovieSlot(mv10);
		cinema0_1.addMovieSlot(mv11);
		
		cineplex2.addCinemas(cinema2_0);
		cineplex2.addCinemas(cinema2_1);
		cineplex2.addCinemas(cinema2_2);
		cineplex1.addCinemas(cinema1_0);
		cineplex1.addCinemas(cinema1_1);
		cineplex1.addCinemas(cinema1_2);
		cineplex0.addCinemas(cinema0_0);
		cineplex0.addCinemas(cinema0_1);
		cineplex0.addCinemas(cinema0_2);
		
		cineplexes.add(cineplex2);
		cineplexes.add(cineplex1);
		cineplexes.add(cineplex0);
		
		/*try {
			fis = new FileInputStream("movieslot.dat");
			in = new ObjectInputStream(fis);
			slots = (ArrayList<MovieSlot>)in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}*/
		
		
		
		/*for(MovieSlot ms: slots) {
			ms.getCinema().addMovieSlot(ms);
		}*/

		for(Cineplex s: cineplexes)
			System.out.println(s.getName());
		/*try {
			fis = new FileInputStream("movieslot.dat");
			in = new ObjectInputStream(fis);
			movies = (ArrayList<Movie>)in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			fis = new FileInputStream("cineplex.dat");
			in = new ObjectInputStream(fis);
			movies = (ArrayList<Movie>)in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
			fis = new FileInputStream("moviegoer.dat");
			in = new ObjectInputStream(fis);
			movies = (ArrayList<Movie>)in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}*/
		
		//Calculate score for movies
		for (Movie m: movies) {
			if (m.getReviews().size()!=0){
				double sum =0;
				for (Review r: m.getReviews()) {
					sum+=r.getScore();
				}
				double value = sum/(m.getReviews().size());
				value = Math.round(value*100);
				value /= 100;
				m.setScore(value);
				System.out.println(m.getTitle()+m.getScore());
			}
		}
		
		currentID = movies.size();
		Scanner sc = new Scanner(System.in);
		int ch;
		while(true) {
			System.out.println("Welcome to use MOBLIMA");
			System.out.println("Select mode you want to enter:");
			System.out.println("1. Admin Mode");
			System.out.println("2. MovieGoer Mode");
			System.out.println("3. Exit");
			System.out.println("Enter your selection: (e.g.: 1)");
			while(true) {
				try {
					ch = Integer.parseInt(sc.nextLine());
					if(1<=ch && ch<=3)
						break;
					else
						System.out.println("Bad input! Enter your selection again!");
				} catch(NumberFormatException e) {
					System.out.println("Bad input! Enter your selection again!");
				}
			}
			switch(ch) {
			case 1:
				int login;
				System.out.println("You're using Admin mode!");
				LoginUI logStaff = new LoginUI();
				//String filename = "staff.txt" ;
				try {
					logStaff.staffs = logStaff.readStaff("staff.txt") ;
				}catch (IOException e) {
					System.out.println("IOException > " + e.getMessage());
				}
				while(true) {
					login = logStaff.staffLogin(); 
					if(login == 0)
						System.out.println("Your account and password doesn't match!");
					else
						break;
				}
				if(login == -1)
					break;
				while(true) {
					System.out.println("You've entered the admin Mode");
					System.out.println("Select what you want to do:");
					System.out.println("1. Add movie");
					System.out.println("2. edit movie information");
					System.out.println("3. Reconfigure system setting");
					System.out.println("4. List the movies by reviewer's rating");
					System.out.println("5. List the movies by sales");
					System.out.println("6. Remove Movie");
					System.out.println("7. Add Movie Slot");
					System.out.println("8. Leave admin mode");
					while(true) {
						try {
							ch = Integer.parseInt(sc.nextLine());
							if(1<=ch && ch<=8)
								break;
							else
								System.out.println("Bad input! Enter your selection again!");
						} catch(NumberFormatException e) {
							System.out.println("Bad input! Enter your selection again!");
						}
					}
					switch(ch) {
					case 1:
						movies.add(ModifyMovie.addMovie());
						break;
					case 2:
						for (int i = 0 ; i < movies.size() ; i++) {
							Movie mov = (Movie)movies.get(i);
							System.out.println("Movie ID: "+mov.getMovieID());
							System.out.println("Movie Title: "+mov.getTitle());
							}
						System.out.println("Select the movie you want to edit by ID");
						int id = 0;
						while(true) {
							try {
								id = Integer.parseInt(sc.nextLine());
								if(0<=id && id<movies.size())
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						System.out.println("The movie you want to edit is: "+movies.get(id).getTitle());
						while(true) {
							System.out.println("Select which attribute you want to modify:");
							System.out.println("1. Change title");
							System.out.println("2. Change status");
							System.out.println("3. Change introduction");
							System.out.println("4. Change director information");
							System.out.println("5. Change actors and actresses information");
							System.out.println("6. Change rating");
							System.out.println("7. Change movie type");
							System.out.println("8. Leave");
							try {
								ch = Integer.parseInt(sc.nextLine());
								if(1<=ch && ch<=8)
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						switch(ch) {
						case 1:
							movies.set(id, ModifyMovie.updateTitle(movies.get(id)));
							break;
						case 2:
							movies.set(id, ModifyMovie.updateStatus(movies.get(id)));
							break;
						case 3:
							movies.set(id, ModifyMovie.updateIntro(movies.get(id)));
							break;
						case 4:
							movies.set(id, ModifyMovie.updateDirector(movies.get(id)));
							break;
						case 5:
							movies.set(id, ModifyMovie.updateActor(movies.get(id)));
							break;
						case 6:
							movies.set(id, ModifyMovie.updateRating(movies.get(id)));
							break;
						case 7:
							movies.set(id, ModifyMovie.updateMovieType(movies.get(id)));
							break;
						case 8:
							System.out.println("You've left the editting.");
							break;
						default:
							break;
						}
						break;
					case 3:
						Price.readPriceMap();
						System.out.println("Input the category you want modify:");
						String key = sc.nextLine();
						System.out.println("Input the price:");
						double p = Double.parseDouble(sc.nextLine());
						Price.editPriceMap(key, p);
						break;
					case 4:
						MovieView.displayTopRate(movies);
						break;
					case 5:
						MovieView.displayTopSale(movies);
						break;
					case 6:
						for (int i = 0 ; i < movies.size() ; i++) {
							Movie mov = (Movie)movies.get(i);
							System.out.println("Movie ID: "+mov.getMovieID());
							System.out.println("Movie Title: "+mov.getTitle());
							}
						System.out.println("Select the movie you want to remove by ID");
						id = 0;
						while(true) {
							try {
								id = Integer.parseInt(sc.nextLine());
								if(0<=id && id<movies.size())
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						System.out.println("The movie you want to remove is: "+movies.get(id).getTitle());
						movies.set(id, ModifyMovie.removeMovie(movies.get(id)));
						break;
					case 7:
						/*for(MovieSlot ms: slots) {
							System.out.println("Index: "+slots.indexOf(ms));
							System.out.println("Date: "+ms.getDate());
							System.out.println("Time: "+ms.getTime());
							System.out.println("Cineplex: "+ms.getCinema().getCineplex().getName());
							System.out.println("Cinema: "+ms.getCinema().getCinemaID());
						}*/
						boolean find = false;
						Cineplex selectedCineplex = new Cineplex();
						while(true) {
							System.out.println("Select Cineplex");
							for(Cineplex c: cineplexes) {
								System.out.println(c.getName());
							}
							String selectedCineplexName = sc.nextLine();
							for(Cineplex c: cineplexes) {
								if(selectedCineplexName.equals(c.getName())) {
									selectedCineplex = c;
									find = true;
								}
							}
							if(find)
								break;
							System.out.println("Nothing matched!");
							}
						int hour,minute;
						System.out.println("Input hour");
						while(true) {
							try {
								hour = Integer.parseInt(sc.nextLine());
								if(0<=ch && ch<=23)
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						System.out.println("Input hour");
						while(true) {
							try {
								minute = Integer.parseInt(sc.nextLine());
								if(0<=ch && ch<=59)
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						String time = String.valueOf(hour)+":"+String.valueOf(minute);
						
						System.out.println("Select the movie you want to add by ID");
						for (int i = 0 ; i < movies.size() ; i++) {
							Movie mov = (Movie)movies.get(i);
							System.out.println("Movie ID: "+mov.getMovieID());
							System.out.println("Movie Title: "+mov.getTitle());
							}
						int movieid = 0;
						while(true) {
							try {
								movieid = Integer.parseInt(sc.nextLine());
								if(0<=movieid && movieid<movies.size())
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						System.out.println("The movie you want to add is: "+movies.get(movieid).getTitle());
						System.out.println("Select the cinema(from 1 to 3");
						int cinemaid = 0;
						while(true) {
							try {
								cinemaid = Integer.parseInt(sc.nextLine());
								if(1<=cinemaid && cinemaid<=3)
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						System.out.println("The cinema you selected is: "+cinemaid);
						Cinema selectedCinema = new Cinema();
						for(Cinema c: selectedCineplex.getCinemas()) {
							if(c.getCinemaID()==(cinemaid-1))
								selectedCinema = c;
						}
						LocalDate dateSet = LocalDate.now();
						while(true) {
							System.out.println("Input playing date (must in format yyyy-mm-dd):");
							String date = sc.nextLine();
							try {
								dateSet = LocalDate.parse(date);
								break;
							}catch(DateTimeParseException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						MovieSlot newMS = new MovieSlot(time,selectedCinema,movies.get(movieid),dateSet);
						slots.add(newMS);
						for(MovieSlot ms: slots) {
							System.out.println("Index: "+slots.indexOf(ms));
							System.out.println("Date: "+ms.getDate());
							System.out.println("Time: "+ms.getTime());
							System.out.println("Cineplex: "+ms.getCinema().getCineplex().getName());
							System.out.println("Cinema: "+ms.getCinema().getCinemaID());
						}
						break;
					case 8:
						System.out.println("You've left Admin Mode!");
						break;
					default:
						ch = 8;
						System.out.println("You've left Admin Mode!");
						break;
					}
					if(ch == 8) {
						FileOutputStream fos = null;
						ObjectOutputStream out = null;
						try {
							fos = new FileOutputStream("movie.dat");
							out = new ObjectOutputStream(fos);
							out.writeObject(movies);
							out.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						try {
							fos = new FileOutputStream("movieslot.dat");
							out = new ObjectOutputStream(fos);
							out.writeObject(movies);
							out.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						break;
					}
						
				}
				break;
			
			case 2:
				System.out.println("You're using MovieGoer mode!");
				while(true) {
					System.out.println("Select what you want to do:");
					System.out.println("1. List Movie");
					System.out.println("2. View Movie Details");
					System.out.println("3. Book Tickets");
					System.out.println("4. View Booking History");
					System.out.println("5. Make Review");
					System.out.println("6. Leave MovieGoer Mode");
					while(true) {
						try {
							ch = Integer.parseInt(sc.nextLine());
							if(1<=ch && ch<=6)
								break;
							else
								System.out.println("Bad input! Enter your selection again!");
						} catch(NumberFormatException e) {
							System.out.println("Bad input! Enter your selection again!");
						}
					}
					switch(ch) {
					case 1:
						for(Movie m: movies) {
							System.out.println("No."+(movies.indexOf(m)+1));
							System.out.println("Title: "+m.getTitle());
							System.out.println();
						}
						break;
					case 2:
						for(Movie m: movies) {
							System.out.println("No."+(movies.indexOf(m)+1));
							System.out.println("Title: "+m.getTitle());
							System.out.println();
						}
						int id = 0;
						System.out.println("Select the movie you want to know more details by ID");
						while(true) {
							try {
								id = Integer.parseInt(sc.nextLine());
								if(1<=id && id<=movies.size())
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						MovieView.displayMovieDetail(movies.get(id-1).getTitle(),movies);
						break;
					case 3:
						System.out.println("Input your first name");
						String firstName = sc.nextLine();
						System.out.println("Input your last name");
						String lastName = sc.nextLine();
						System.out.println("Input your mobile phone number(eg: 12345678)");
						String mobile = sc.nextLine();
						while(!mobile.matches("\\d{8}")) {
							System.out.println("Wrong format");
							System.out.println("Input your mobile phone number(eg: 12345678)");
						}
						boolean find = false;
						MovieGoer user = new MovieGoer();
						for(MovieGoer m: goers) {
							if(mobile.equals(m.getMobileNumber())){
								find = true;
								user = m;
								break;
							}
						}
						
						if(!find) {
							user.setFirst_name(firstName);
							user.setLast_name(lastName);
							user.setMobileNumber(mobile);
							goers.add(user);
						}
						int cat = 1;
						System.out.println("Choose type of ticket you want to buy");
						System.out.println("1.Adult Ticket");
						System.out.println("2.Senior Ticket");
						System.out.println("3.Children Ticket");
						System.out.println("Please input a number between 1 to 3 as shown in the choice");
						while(true) {
							try {
								cat = Integer.parseInt(sc.nextLine());
								if(1<=cat && cat<=3)
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						Ticket t = BookingTicket.BookTicket(movies, slots, cat);
						user.getBookingHistory().add(t);
							
						break;
					case 4:
						boolean findUser = false;
						boolean quit = false;
						MovieGoer currentUser = new MovieGoer();
						for(MovieGoer mvg: goers) {
							System.out.println(mvg.getMobileNumber());
						}
						while(true) {
							System.out.println("Input your mobile phone number(eg: 12345678)");
							System.out.println("Input \"quit\" to quit");
							String mobileNumber = sc.nextLine();
							if(mobileNumber.contentEquals("quit")) {
								quit = true;
								break;
							}
							while(!mobileNumber.matches("\\d{8}")) {
								System.out.println("Wrong format");
								System.out.println("Input your mobile phone number(eg: 12345678)");
							}
							for(MovieGoer m: goers) {
								if(mobileNumber.equals(m.getMobileNumber())){
									findUser = true;
									currentUser = m;
									break;
								}
							}
							if(findUser)
								break;
							System.out.println("No matching entries");
						}
						if(quit)
							break;
						for(Ticket tk: currentUser.getBookingHistory()) {
							System.out.println("Ticket "+(currentUser.getBookingHistory().indexOf(tk)+1));
							tk.printTicket();
						}
						break;
					case 5:
						ReviewUI reviewUI = new ReviewUI();
						for(Movie m: movies) {
							System.out.println("No."+(movies.indexOf(m)+1));
							System.out.println("Title: "+m.getTitle());
							System.out.println();
						}
						int movieID = 0;
						System.out.println("Select the movie you want to know more details by ID");
						while(true) {
							try {
								movieID = Integer.parseInt(sc.nextLine());
								if(1<=movieID && movieID<=movies.size())
									break;
								else
									System.out.println("Bad input! Enter your selection again!");
							} catch(NumberFormatException e) {
								System.out.println("Bad input! Enter your selection again!");
							}
						}
						reviewUI.writeReview(movies.get(movieID-1));
						for (Movie m: movies) {
							if (m.getReviews().size()!=0){
								double sum =0;
								for (Review r: m.getReviews()) {
									sum+=r.getScore();
								}
								double value = sum/(m.getReviews().size());
								value = Math.round(value*100);
								value /= 100;
								m.setScore(value);
								System.out.println(m.getTitle()+m.getScore());
							}
						}
						
					case 6:
						System.out.println("You've left the MovieGoer mode!");
						break;
					default:
						System.out.println("You've left the MovieGoer mode!");
						break;
					}
				}
			case 3:
				System.out.println("You've left the system!");
				break;
			default:
				ch = 3;
				System.out.println("You've left the system!");
				break;
			}
			if(ch == 3)
				break;
		}
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("movie.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(movies);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			fos = new FileOutputStream("movieslot.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(slots);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			fos = new FileOutputStream("moviegoer.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(goers);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			fos = new FileOutputStream("cineplex.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(cineplexes);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			fos = new FileOutputStream("price.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(Price.priceMap);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void write(String fileName, ArrayList <String> data) throws IOException  {
	    PrintWriter out = new PrintWriter(new FileWriter(fileName));

	    try {
			for (int i =0; i < data.size() ; i++) {
	      		out.println((String)data.get(i));
			}
	    }
	    finally {
	      out.close();
	    }
	  }
	public static ArrayList <String> read(String fileName) throws IOException {
		ArrayList <String> data = new ArrayList <String> () ;
	    Scanner scanner = new Scanner(new FileInputStream(fileName));
	    try {
	      while (scanner.hasNextLine()){
	        data.add(scanner.nextLine());
	      }
	    }
	    finally{
	      scanner.close();
	    }
	    return data;
	  }
	public static ArrayList <Movie> readMovie(String filename) throws IOException {
		ArrayList <String> stringArray = (ArrayList<String>)read(filename);
		ArrayList <Movie> movieList = new ArrayList<Movie>() ; // to store Staff data
        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				StringTokenizer star = new StringTokenizer(st , "|");
				int  movieID = Integer.parseInt(star.nextToken().trim());	// movieID
				String  title = star.nextToken().trim();	// movie title
				Status status = Status.valueOf(star.nextToken().trim());  //status
				String intro = star.nextToken().trim();	// movie introduction
				String direc = star.nextToken().trim();	// director
				String actor = star.nextToken().trim();	// actors
				Rating rating = Rating.valueOf(star.nextToken().trim());  //rating
				MovieType type = MovieType.valueOf(star.nextToken().trim());  //Movie type
				int  sales = Integer.parseInt(star.nextToken().trim());	// sales number
				Movie movie = new Movie(movieID, title, status,intro, direc, actor, rating, type, sales);
				movieList.add(movie) ;
			}
			return movieList ;
	}
	public static void saveMovies(String filename, ArrayList<Movie> movieList) throws IOException {
		ArrayList<String> newList = new ArrayList<String>() ;// to store Movie data

        for (int i = 0 ; i < movieList.size() ; i++) {
				Movie mov = (Movie)movieList.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(Integer.toString(mov.getMovieID()).trim());
				st.append("|");
				st.append(mov.getTitle().trim());
				st.append("|");
				st.append(mov.getShowingStatus().toString().trim());
				st.append("|");
				st.append(mov.getIntro().trim());
				st.append("|");
				st.append(mov.getDirector().trim());
				st.append("|");
				st.append(mov.getActor().trim());
				st.append("|");
				st.append(mov.getRating().toString().trim());
				st.append("|");
				st.append(mov.getMovieType().toString().trim());
				st.append("|");
				st.append(Integer.toString(mov.getSalesNumber()).trim());
				st.append("|");
				newList.add(st.toString()) ;
			}
			write(filename, newList);
	}
	public static ArrayList<Review> readReview(String filename) throws IOException{
		ArrayList <String> stringArray = (ArrayList<String>)read(filename);
		ArrayList <Review> reviewList = new ArrayList<Review>();
		for (int i = 0 ; i < stringArray.size() ; i++) {
			String st = (String)stringArray.get(i);
			StringTokenizer star = new StringTokenizer(st , "|");
			int  movieID = Integer.parseInt(star.nextToken().trim());	// movieID
			String  commenter = star.nextToken().trim();	// commenter
			int  score = Integer.parseInt(star.nextToken().trim()); //score
			String  comment = star.nextToken().trim();
			Review review = new Review(commenter, movieID, comment, score);
			reviewList.add(review) ;
		}
		return reviewList ;
	}
	public static void saveReviews(String filename, ArrayList<Review> reviewList) throws IOException {
		ArrayList<String> newList = new ArrayList<String>() ;// to store Movie data

        for (int i = 0 ; i < reviewList.size() ; i++) {
				Review rev = (Review)reviewList.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(Integer.toString(rev.getMovieID()).trim());
				st.append("|");
				st.append(rev.getCommenter().trim());
				st.append("|");
				st.append(Integer.toString(rev.getScore()).trim());
				st.append("|");
				st.append(rev.getComment().trim());
				st.append("|");
				newList.add(st.toString()) ;
			}
			write(filename, newList);
	}
	
	
	
}
