package model;

/**
 * Created by tonys on 10/5/2016.
 */
public class User {
	//private AccountType type;
	private String username;
	private String password;
	private String first;
	private String last;
	private String email;
	private String type;
	private String address;
	private String title;
	private boolean isLoggedIn;


	public User() {
		this("User", "user", "pass", "Jon", "Snow", "jsnow@gatech.edu", "1 Techwood Dr Atlanta, Ga 30313", "Mr.");
	}
	public User(String type, String user, String pass, String first, String last, String email, String add,String t) {
		this.username = user;
        this.password = pass;
		this.first = first;
		this.last = last;
		this.email = email;
		this.type = type;
		this.address = add;
        title = t;
		isLoggedIn = false;
	}
	public User(String u, String p) {
        username = u;
        password = p;

		isLoggedIn = false;
	}

	public String getUser() {
		return username;
	}
	public String getPass() {
		return password;
	}
	public String getEmail() {return email;}

	public String getFirstName() {
		return first;
	}
	public String getAddress(){
		return address;
	}
	public String getTitle(){
	    return title;
    }
	public void setFirst(String first) {
		this.first = first;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setAddress(String a) {
	    address = a;
    }
    public void setTitle(String t) {
        title = t;
    }
	public String getLastName() {

		return last;
	}

	public String getType() {
		return type;
	}


	public void setUser(String s) {
		username = s;
	}
	public void setPass(String s) {
		password = s;
	}
	public boolean equals(User s) {
		return username.equals(s.getUser()) && password.equals(s.getPass());
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