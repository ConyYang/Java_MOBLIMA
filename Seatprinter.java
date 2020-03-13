package moblima;

public class Seatprinter {
	
	public static void printSeat(Seat[][] Seats)
    {		

		System.out.println("-----------Screen-----------");
		System.out.println("  1  2    3  4  5  6    7  8");
		
		char rowChar = 'A';
		for(int item=0 ; item<8 ; item++)
		{
			System.out.print(rowChar);
			rowChar ++;
			for( int j=0 ;j<8; j++)
			{
				if( j == 2 || j == 6)
					System.out.print("  ");
				
				if(!Seats[item][j].isBooked())
					System.out.print(" o ");
				
				else 
					System.out.print(" x ");
			}	
			System.out.println(" ");
		}
		System.out.println("KEY- o =unbook, x = booked");
	}
}