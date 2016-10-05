package model;
import java.util.ArrayList;

public class accountDatabase {
	private ArrayList<Account> accountList;
    private Account active;
	public accountDatabase() {
        accountList = new ArrayList<>();
	}

	public void add(Account a) {
	    accountList.add(a);
    }

	public ArrayList getAccounts() {
		return accountList;
	}

	public Account getActiveAccount() {
	    return active;
	}

	public boolean login(Account u) {
		for (Account i : accountList) {
			if (i.equals(u)) {
			    u.login();
                active = u;
				return true;
			}
		}
		return false;

	}
	public void logOut(Account a) {
	    active = null;
	    a.logout();
    }

}