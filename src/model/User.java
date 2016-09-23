package model;

public class User {
	private String username;
	private String password;
	private boolean isLoggedIn;

	public User() {
		username = "user";
		password = "pass";
		isLoggedIn = false;
	}

	public User(String u, String p) {
		this.username = u;
		this.password = p;
		isLoggedIn = false;
	}
	public String getUser() {
		return username;
	}
	public String getPass() {
		return password;
	}
	public void setUser(String s) {
		username = s;
	}
	public void setPass(String s) {
		password = s;
	}
	public boolean equals(User s) {
		if (this.username.equals(s.getUser()) && this.password.equals(s.getPass()) ) {
			return true;
		}
		return false;
	}
	public void login() {
		isLoggedIn = true;
	}
	public void logout() {
		isLoggedIn = false;
	}
	public boolean isLoggedIn() { return this.isLoggedIn;}
	public String toString() {
		return username + " : " + password;
	}
}