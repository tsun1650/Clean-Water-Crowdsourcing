package model;

/**
 * Admin is an extension of Manager
 */
//@SuppressWarnings("ALL")
public class Admin extends User {

    @SuppressWarnings("UnusedAssignment")
    public Admin() {
        super(Type.ADMN, "admin", "pass", "first", "last", "ema@amil.com", "208 Mailing Dr Atlanta, GA");
    }

}