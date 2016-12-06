package model;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Instance of userDatabase
 */
public class UserDatabase {
	private ArrayList<User> userList;
	private User active;

	/**
	 * constructor to create the arrayList
	 */
	public UserDatabase() {
		userList = new ArrayList<>();
	}

	/**
	 * constructor to accept an arrayList to add
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
	 * @return userList
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
	 * Check if the user exists within database off its user and pass
	 *
	 * @param u username
	 * @param p password
	 * @return user in database
	 */
	public User getCredentials(String u, String p) {
		for (User i : userList) {
			if (i.getUser().equals(u) && i.getPass().equals(p)) {
				setActiveUser(i);
				i.login();
				return i;
			}
		}
		return null;
	}

	public boolean removeUserWithUName(String u) {
		User rUser = null;
		for (User i : userList) {
			if (i.getUser().equals(u)) {
				rUser = i;
				break;
			}
		}
		if (rUser == null || rUser.getType() == Type.ADMN) {
			return false;
		}
		userList.remove(rUser);
		return true;
	}

	public ArrayList<String> getUsersAsString() {
		return userList.stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new));
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
