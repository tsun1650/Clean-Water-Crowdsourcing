package model;

/**
 * Created by tonys on 10/5/2016.
 */
public class Account {
    private String username;
    private String password;
    private String first;
    private String last;
    private String email;
    private String type;
    private String address;
    private boolean isLoggedIn;


    public Account() {
        this("User", "user", "pass", "Jon", "Snow", "jsnow@gatech.edu", "1 Techwood Dr Atlanta, Ga 30313");
    }
    public Account(String type, String user, String pass, String first, String last, String email, String add) {
        this(user,pass);
        this.first = first;
        this.last = last;
        this.email = email;
        this.type = type;
        this.address = add;
        isLoggedIn = false;
    }
    public Account(String u, String p) {
        this.username = u;
        this.password = p;
        isLoggedIn = false;
    }
    public Account(String user, String pass, String first, String last, String email) {
        this("User",user,pass,first,last,email,"");
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
        if (this.username.equals(s.getUser()) && this.password.equals(s.getPass()) ) {
            return true;
        }
        return false;
    }
    public void login() {
        isLoggedIn = true;
        //actual login check
        //check if valid user
        //yes >>
        //openApplication();
        //no throw popup

    }
    public void logout() {
        isLoggedIn = false;
    }
    public boolean isLoggedIn() { return this.isLoggedIn;}
    public String toString() {
        return username + " : " + password;
    }
}
