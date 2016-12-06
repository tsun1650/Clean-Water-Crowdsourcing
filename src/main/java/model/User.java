package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * User uses the app
 */
@SuppressWarnings("ALL")
public class User {
	private String username;
	private String password;
	private String first;
	private String last;
	private String email;
	private String address;
	private String title;
	private Type type;
	private boolean isLoggedIn;

	/**
	 * default constructor
	 */
	public User() {
		this(Type.USR, "user", "pass", "Jon", "Snow", "jsnow@gatech.edu", "1 Techwood Dr Atlanta, Ga 30313");
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
	 */
	public User(Type type, String user, String pass, String first, String last, String email, String add) {
		this.username = user;
		this.password = pass;
		this.first = first;
		this.last = last;
		this.email = email;
		this.type = type;
		this.address = add;
		title = "Mr.";
		isLoggedIn = false;
	}

	/**
	 * 2 argument constructor
	 * @param u username
	 * @param p password
	 */
	@SuppressWarnings("unused")
	public User(String u, String p) {
		username = u;
		password = p;
		first = "bob";
		last = "son";
		email = "bobson@gmail.com";
		type= Type.USR;
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
	public Type getType() {
		return type;
	}




	/**
	 * check if users are the same
	 * @param s user to check
	 * @return if they are the same
	 */
	@Override
	public boolean equals(Object s) {
		User us = (User) s;
		return username.equals(us.getUser()) && password.equals(us.getPass());
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
	@SuppressWarnings("unused")
	public boolean isLoggedIn() { return this.isLoggedIn;}
	@Override
	public String toString() {
		return username + " : " + password;
	}

	public static ObservableList<Type> getTypes() {
		return FXCollections.observableArrayList(Type.values());
	}
}