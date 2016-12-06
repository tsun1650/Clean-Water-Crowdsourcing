package model;

/**
 * Condition Enum
 */
@SuppressWarnings("ALL")
public enum Condition {
    WST("Waste"),
    TC("Treatable-Clear"),
    TM("Treatable-Muddy"),
    PTBL("Potable");

    private final String cond;

    /**
     * constructor for condition of water enum
     * @param cond condition of water
     */
    Condition(String cond) {
        this.cond = cond;
    }
    @Override
    public String toString() {
        return cond;
    }
}