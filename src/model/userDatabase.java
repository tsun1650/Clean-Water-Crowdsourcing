package model;
import java.util.ArrayList;

public class UserDatabase {
	private ArrayList<User> userList;
	private User active;
	public UserDatabase() {
		userList = new ArrayList<>();
	}

	public void add(User a) {
		userList.add(a);
	}

	public ArrayList getUsers() {
		return userList;
	}

	public User getActiveUser() {
		return active;
	}

	public void setActiveUser(User u) { active = u; }

	public boolean login(User u) {
		for (User i : userList) {
			if (i.equals(u)) {
				u.login();
				setActiveUser(u);
				return true;
			}
		}
		setActiveUser(null);
		return false;

	}
	public void logOut(User a) {
		active = null;
		a.logout();
	}
}