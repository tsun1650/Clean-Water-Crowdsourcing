package model;

/**
 * User uses the app
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

    /**
     * default constructor
     */
	public User() {
		this("User", "user", "pass", "Jon", "Snow", "jsnow@gatech.edu", "1 Techwood Dr Atlanta, Ga 30313", "Mr.");
	}

    /**
     * constructor with all the fields
     * @param type usertype
     * @param user username
     * @param pass password
     * @param first firstname
     * @param last lastname
     * @param email email
     * @param add address
     * @param t title
     */
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

    /**
     * 2 argument constructor
     * @param u username
     * @param p password
     */
	public User(String u, String p) {
        username = u;
        password = p;
		first = "bob";
		last = "son";
		email = "bobson@gmail.com";
		type="user";
		address = "229 bob st";
		title = "mr.";
		isLoggedIn = false;
	}

    /**
     * username getter
     * @return username
     */
	public String getUser() {
		return username;
	}

    /**
     * password getter
     * @return password
     */
	public String getPass() {
		return password;
	}

    /**
     * email getter
     * @return email
     */
	public String getEmail() {return email;}

    /**
     * firstname getter
     * @return firstname
     */
	public String getFirstName() {
		return first;
	}

    /**
     * address getter
     * @return address
     */
	public String getAddress(){
		return address;
	}

    /**
     * title getter
     * @return title
     */
	public String getTitle(){
	    return title;
    }

    /**
     * set first name
     * @param first first name
     */
	public void setFirst(String first) {
		this.first = first;
	}

    /**
     * set last name
     * @param last lastname
     */
	public void setLast(String last) {
		this.last = last;
	}

    /**
     * set email
     * @param email email
     */
	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * set type
     * @param type type
     */
	public void setType(String type) {
		this.type = type;
	}

    /**
     * set address
     * @param a address
     */
	public void setAddress(String a) {
	    address = a;
    }

    /**
     * set title
     * @param t title
     */
    public void setTitle(String t) {
        title = t;
    }

    /**
     * get last name
     * @return last lastname
     */
	public String getLastName() {

		return last;
	}

    /**
     * get type
     * @return type type
     */
	public String getType() {
		return type;
	}

    /**
     * set username
     * @param s username
     */
	public void setUser(String s) {
		username = s;
	}

    /**
     * set password
     * @param s password
     */
	public void setPass(String s) {
		password = s;
	}

    /**
     * check if users are the same
     * @param s user to check
     * @return if they are the same
     */
	public boolean equals(User s) {
		return username.equals(s.getUser()) && password.equals(s.getPass());
	}

    /**
     * set login to true
     */
	public void login() {
		isLoggedIn = true;

	}

    /**
     * set login to false
     */
	public void logout() {
		isLoggedIn = false;
	}

    /**
     * is user logged in?
     * @return isLoggedIn login status
     */
	public boolean isLoggedIn() { return this.isLoggedIn;}
	@Override
	public String toString() {
		return username + " : " + password;
	}
}