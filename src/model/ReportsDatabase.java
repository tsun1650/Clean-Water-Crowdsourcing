package model;

import java.util.ArrayList;

/**
 * Created by tonys on 10/19/2016.
 */
public class ReportsDatabase {
    private ArrayList<Report> reports;
    private static final ReportsDatabase instance = new ReportsDatabase();
    public static ReportsDatabase getInstance() { return instance; }
    public ReportsDatabase() {
        reports = new ArrayList<>();
    }
    public ArrayList<Report> getReports() {
        return reports;
    }
    public void add(Report r) {
        reports.add(r);
        r.setNumber(reports.size());
    }

    /**
     * return reports
     * @return reports string
     */
    public ArrayList<String> getReportsAsString() {
        ArrayList<String> give = new ArrayList<>();
        for (Report r : reports) {
            give.add(r.toString());
        }
        return give;

    }
    public ArrayList<Report> getReportYears(Integer year) {
        ArrayList<Report> give = new ArrayList<>();
        for (Report r: reports) {
            if (r.getYear() == year) {
                give.add(r);
            }
        }
        return give;
    }

    public ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        for (Report r : reports) {
            int i = 0;
            locations.add(new Location(r.getLatitude(), r.getLongitude(), "Report " + i , r.toString()));
            i++;
        }
        return locations;
    }
}
