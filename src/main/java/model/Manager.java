package model;

/**
 * Manager is an extension of Worker
 */
public class Manager extends User {

    @SuppressWarnings("UnusedAssignment")
    public Manager() {
        super(Type.MNGR, "manager", "pass", "first", "last", "ema@amil.com", "208 Mailing Dr Atlanta, GA");
    }

}
