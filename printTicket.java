package moblima;


public class printTicket {
	private Ticket userTicket;

	public printTicket(Ticket userTicket) {
		super();
		this.userTicket = userTicket;
	}
	
	public void print(Ticket userTicket)
	{
		System.out.println(userTicket.getPrice());
	}
	
}
