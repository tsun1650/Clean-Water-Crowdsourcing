package model;

/**
 * worker is an extension of user
 */
class Worker extends User {

    @SuppressWarnings("UnusedAssignment")
    Worker() {
        String username = "user";
        String password = "pass";
        String first = "first";
        String last = "last";
        String email = "ema@email.com";
        Type type = Type.WRKR;
        String address = "208 Mailing Dr Atlanta, Ga";
        String title = "Mr.";
        boolean isLoggedIn = false;
    }
}
