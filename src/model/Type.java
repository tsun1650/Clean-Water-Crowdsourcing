package model;

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
    Type(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}