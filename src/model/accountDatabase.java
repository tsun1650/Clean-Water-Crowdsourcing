package model;
import java.util.ArrayList;

public class accountDatabase {
	private ArrayList<Account> accountList = new ArrayList<>();
	private Account activeAccount;
	public accountDatabase() {
		accountList.add(new Account());
	}
	public void add(Account a) {
	    accountList.add(a);
    }
	public ArrayList getAccounts() {
		return accountList;
	}
	public boolean contains(Account u) {
		for (Account i : accountList) {
			if (i.equals(u)) {
				return true;
			}
		}
		return false;
	}
	public Account whoIsLoggedIn () {
		for (Account i : accountList) {
			if (i.isLoggedIn()) {
				return i;
			}
		}
		return null;
	}
}