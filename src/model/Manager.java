package model;

/**
 * Manager is an extension of Worker
 */
public class Manager extends Worker {
    private String username;
    private String password;
    private String first;
    private String last;
    private String email;
    private String address;
    private String title;
    private Type type;
    private boolean isLoggedIn;

    public Manager() {
        this.username = "manager";
        this.password = "pass";
        this.first = "first";
        this.last = "last";
        this.email = "ema@email.com";
        this.type = Type.MNGR;
        this.address = "208 Mailing Dr Atlanta, Ga";
        title = "Mr.";
        isLoggedIn = false;
    }

}
