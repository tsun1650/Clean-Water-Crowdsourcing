package model;

/**
 * Created by tonys on 10/19/2016.
 */
public class HistoricalReport extends Report {
    private String location;
    private Double ppmCat;
    private Integer year;

    public HistoricalReport(String location, String ppmCat, Integer year) {
        this.location = location;
        this.ppmCat = ppmCat;
        this.year = year;
    }

    public Integer getYear() {return year;}

    public Double getContaminantPPM() {return ppmCat;}
}
