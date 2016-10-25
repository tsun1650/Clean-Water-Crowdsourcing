package model;

/**
 * Created by Kate on 10/19/2016.
 */
public enum PurityCondition {
    S("Safe"),
    T("Treatable"),
    U("Unsafe");


    private final String cond;

    /**
     * constructor for condition of water enum
     * @param cond condition of water
     */
    private PurityCondition(String cond) {
        this.cond = cond;
    }
    @Override
    public String toString() {
        return cond;
    }
}