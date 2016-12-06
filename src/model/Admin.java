package model;

/**
 * Admin is an extension of Manager
 */
//@SuppressWarnings("ALL")
public class Admin extends User {

    @SuppressWarnings("UnusedAssignment")
    public Admin() {
        super(Type.ADMN, "admin", "pass", "first", "last", "ema@amil.com", "208 Mailing Dr Atlanta, GA");
//        String username = "admin";
//        String password = "pass";
//        String first = "first";
//        String last = "last";
//        String email = "ema@email.com";
//        Type type = Type.ADMN;
//        String address = "208 Mailing Dr Atlanta, Ga";
//        String title = "Mr.";
//        boolean isLoggedIn = false;
    }

}