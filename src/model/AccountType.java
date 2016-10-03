package model;

/**
 * Created by David on 10/2/2016.
 */
public enum AccountType {
    USR("User"),
    WRKR("Worker"),
    MNGR("Manager"),
    ADMN("Admin");

    private final String accountType;

    /**
     * constructor for account type enum
     * @param accType account type of user
     */
    private AccountType(String accType) {
        accountType = accType;
    }
    @Override
    public String toString() {
        return accountType;
    }
}
