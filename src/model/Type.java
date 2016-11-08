package model;

/**
 * Created by David on 10/2/2016.
 */
public enum Type {
    USR("User"),
    WRKR("Worker"),
    MNGR("Manager"),
    ADMN("Admin");

    private final String type;

    /**
     * constructor for account type enum
     * @param type account type of user
     */
    private Type(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}