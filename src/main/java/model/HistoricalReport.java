package model;

/**
 * Created by tonys on 10/19/2016.
 */
public class HistoricalReport extends Report {
    private String location;
    private String ppmCat;
    private Integer year;

    /**
     * constructor for historical report
     * @param location location
     * @param ppmCat ppm count
     * @param year year
     */
    public HistoricalReport(String location, String ppmCat, Integer year) {
        this.location = location;
        this.ppmCat = ppmCat;
        this.year = year;
    }

    @Override
    public String toString() {
        return "HistoricalReport{" +
                "location='" + location + '\'' +
                ", ppmCat='" + ppmCat + '\'' +
                ", year=" + year +
                '}';
    }
}
