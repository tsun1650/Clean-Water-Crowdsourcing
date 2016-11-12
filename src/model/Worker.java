package model;

/**
 * worker is an extension of user
 */
public class Worker extends User {
    private String username;
    private String password;
    private String first;
    private String last;
    private String email;
    private String address;
    private String title;
    private Type type;
    private boolean isLoggedIn;

    public Worker() {
        this.username = "user";
        this.password = "pass";
        this.first = "first";
        this.last = "last";
        this.email = "ema@email.com";
        this.type = Type.WRKR;
        this.address = "208 Mailing Dr Atlanta, Ga";
        title = "Mr.";
        isLoggedIn = false;
    }
}
