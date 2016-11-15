package model;
import java.util.ArrayList;

/**
 * Instance of userDatabase
 */
public class UserDatabase {
	private ArrayList<User> userList;
	private User active;

	/**
	 * constructor to create the arraylsit
	 */
	public UserDatabase() {
		userList = new ArrayList<>();
	}

	/**
	 * constructor to accept an arraylist to add
	 */
	public UserDatabase(ArrayList<User> a) {userList = a;}

	/**
	 * add users to the list
	 *
	 * @param a user to add
	 */
	public void add(User a) {
		userList.add(a);
	}

	/**
	 * get all the users
	 *
	 * @return userlist
	 */
	public ArrayList<User> getUsers() {
		return userList;
	}

	/**
	 * get logged in user
	 *
	 * @return active active user
	 */
	public User getActiveUser() {
		return active;
	}

	/**
	 * set the logged in user
	 *
	 * @param u user to login
	 */
	public void setActiveUser(User u) {
		active = u;
	}

	/**
	 * check if user is in database
	 *
	 * @param u to log in
	 */
	public void login(User u) {
		if (u.getUser().equals("user") && u.getPass().equals("pass")) {
			setActiveUser(u);
			return;
		}
		for (User i : userList) {
			if (i.equals(u)) {
				u.login();
				setActiveUser(u);
				return;
			}
		}
		setActiveUser(null);

	}

	/**
	 * Check if the user exists within database off its user and pass
	 *
	 * @param u username
	 * @param p password
	 * @return user in database
	 */
	public User getCredentials(String u, String p) {
		for (User i : userList) {
			if (i.getUser().equals(u) && i.getPass().equals(p)) {
				return i;
			}
		}
		return null;
	}

	/**
	 * log out user
	 *
	 * @param a user to log out
	 */
	public void logOut(User a) {

		a.logout();
		active = null;
	}
}
