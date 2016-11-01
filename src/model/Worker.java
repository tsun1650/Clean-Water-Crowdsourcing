package model;

/**
 * worker is an extension of user
 */
public class Worker extends User {
    /**
     * default constructor for worker
     */
    public Worker() {
        super(Type.WRKR, "worker", "pass", "Jon", "Snow", "jsnow@gatech.edu", "1 Techwood Dr Atlanta, Ga 30313", "Mr.");
    }
}
