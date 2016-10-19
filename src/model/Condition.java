package model;

/**
 * Created by Kate on 10/19/2016.
 */
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
    private Condition(String cond) {
        this.cond = cond;
    }
    @Override
    public String toString() {
        return cond;
    }
}