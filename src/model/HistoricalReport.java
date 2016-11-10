package model;

/**
 * Created by tonys on 10/19/2016.
 */
public class HistoricalReport extends Report {
    private String location;
    private Number ppmCat;
    private Number year;

    public HistoricalReport(String location, Number ppmCat, Number year) {
        this.location = location;
        this.ppmCat = ppmCat;
        this.year = year;
    }

    public Number getYear() {return year;}

    public Number getContaminantPPM() {return ppmCat;}
}
