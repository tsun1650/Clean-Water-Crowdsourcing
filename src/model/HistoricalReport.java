package model;

/**
 * Created by tonys on 10/19/2016.
 */
public class HistoricalReport extends Report {
    private String location;
    private String ppmCat;
    private Integer year;

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
