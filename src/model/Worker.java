package model;

/**
 * worker is an extension of user
 */
public class Worker extends User {

    @SuppressWarnings("UnusedAssignment")
    Worker() {
        super(Type.WRKR, "worker", "pass", "first", "last", "ema@amil.com", "208 Mailing Dr Atlanta, GA");
    }

}
