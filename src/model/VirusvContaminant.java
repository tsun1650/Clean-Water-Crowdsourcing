package model;

/**
 * Created by Kate on 11/8/2016.
 */
public enum VirusvContaminant {
    V("Virus"),
    C("Contaminant");


    private final String vc;

    /**
     * constructor for condition of water enum
     * @param vc condition of water
     */
    private VirusvContaminant(String vc) {
        this.vc = vc;
    }
    @Override
    public String toString() {
        return vc;
    }
}