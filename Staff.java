package moblima;
/**
 * This is the Staff class.
 * @author Xia Chenguang
 *
 */
public class Staff {
	/**
	 * The account of the staff.
	 */
	private String account;
	/**
	 * The password of the staff.
	 */
	private String password;
	/**
	 * Create a new staff with default account of 11111111 and default password of 22222222.
	 * Both are String.
	 */
	public Staff() {
		this.account = "11111111";
		this.password = "22222222";
	}
	/**
	 * Get the account of the staff
	 * @return account of the staff
	 */
	public String getAccount() {
		return account;
	}
	public String getPassword() {
		return password;
	}
	/**
	 * Set staff's password.
	 * @param password Staff's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAccount(String account) {
		this.account = account;
	}
/**
 * Constructor for Staff.
 * @param account Staff's account.
 * @param password Staff's password.
 */
	public Staff(String account, String password) {
		this.account = account;
		this.password = password;
	}


	
}

	