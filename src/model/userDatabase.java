package model;
import java.util.ArrayList;

public class userDatabase {
	private ArrayList<User> usersList = new ArrayList<>();

	public userDatabase() {
		usersList.add(new User());
	}
	public ArrayList getUsers() {
		return usersList;
	}
	public boolean contains(User u) {
		for (User i : usersList) {
			if (i.equals(u)) {
				return true;
			}
		}
		return false;
	}
}