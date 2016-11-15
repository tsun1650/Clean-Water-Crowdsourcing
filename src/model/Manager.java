package model;

/**
 * Manager is an extension of Worker
 */
public class Manager extends Worker {

    @SuppressWarnings("UnusedAssignment")
    public Manager() {
        String username = "manager";
        String password = "pass";
        String first = "first";
        String last = "last";
        String email = "ema@email.com";
        Type type = Type.MNGR;
        String address = "208 Mailing Dr Atlanta, Ga";
        String title = "Mr.";
        boolean isLoggedIn = false;
    }

}
