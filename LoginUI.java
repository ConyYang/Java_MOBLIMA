package moblima;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;

public class LoginUI {
	ArrayList<Staff> staffs = new ArrayList<Staff>();
	/**
	 * A staff can login. If account and password are correct, then return true. Otherwise false.
	 * @return True or false.
	 */
	public ArrayList <Staff> readStaff(String filename) throws IOException {
		ArrayList <String> stringArray = (ArrayList<String>)Moblima.read(filename);
		ArrayList <Staff> staffList = new ArrayList<Staff>() ; // to store Staff data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by "|"
				StringTokenizer star = new StringTokenizer(st , "|");
				String  account = star.nextToken().trim();	// first token
				String  password = star.nextToken().trim();	// second token
				// create Staff object from file data
				Staff staff = new Staff(account, password);
				// add to staff list
				staffList.add(staff) ;
			}
			return staffList ;
	}
	public int staffLogin() {
		String acc,pw;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter \"quit\" as account to leave");
		System.out.println("Please enter your account:");
		acc = sc.nextLine();
		if(acc.equals("quit")) {
			System.out.println("You're quiting the staff login interface!");
			return -1;
		}
		System.out.println("Please enter your password:");
		pw = sc.nextLine();
		System.out.println("Account you have entered:"+acc);
		System.out.println("Password you have entered:"+pw);
		return verifyPassword(acc, pw);
	}
	private int verifyPassword(String acc, String pw) {
		for(Staff s: this.staffs) {
			if(acc.equals(s.getAccount()) && pw.equals(s.getPassword()))
				return 1;
		}
		return 0;
	}
}
