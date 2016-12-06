package model;

/**
 * Created by Kate on 10/19/2016.
 */
@SuppressWarnings("ALL")
public enum WaterType {
    BTL("Bottled"),
    WLL("Well"),
    STRM("Stream"),
    LKE("Lake"),
    SPRG("Spring"),
    OTR("Other");

    private final String wType;

    /**
     * constructor for water type enum
     * @param wType water type reported
     */
    WaterType(String wType) {
        this.wType = wType;
    }
    @Override
    public String toString() {
        return wType;
    }
}