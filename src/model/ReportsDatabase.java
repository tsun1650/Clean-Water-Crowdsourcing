package model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by tonys on 10/19/2016.
 */
@SuppressWarnings("ALL")
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


    public ArrayList<WaterSourceReport> getSourceReports() {
        return reports.stream().filter(r -> r instanceof WaterSourceReport).map(r -> (WaterSourceReport) r).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<WaterPurityReport> getPurityReports() {
        return reports.stream().filter(r -> r instanceof WaterPurityReport).map(r -> (WaterPurityReport) r).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * add report into database
     * @param r report to add
     */
    public void add(Report r) {
        reports.add(r);
        r.setNumber(reports.size());
    }

    /**
     * return reports
     * @return reports string
     */
    public ArrayList<String> getReportsAsString() {
        return reports.stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new));

    }
    public ArrayList<String> getUserReports() {
        return reports.stream().filter(r -> r instanceof WaterPurityReport).map(Object::toString).collect(Collectors.toCollection(ArrayList::new));

    }
    public ArrayList<Report> getReportYears(Integer year) {
        return reports.stream().filter(r -> Objects.equals(r.getYear(), year)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        int i = 0;
        for (Report r : reports) {

            locations.add(new Location(r.getLatitude(), r.getLongitude(), "Report " + i , r.toString()));
            i++;
        }
        return locations;
    }

    public ArrayList<Location> getSourceLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        int i = 0;
        for (Report r : reports) {
            if (r instanceof WaterSourceReport) {

                locations.add(new Location(r.getLatitude(), r.getLongitude(), "Report " + i , r.toString()));
                i++;
            }
        }
        return locations;
    }
}
