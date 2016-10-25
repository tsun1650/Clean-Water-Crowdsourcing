package model;

import java.util.ArrayList;

/**
 * Created by tonys on 10/19/2016.
 */
public class ReportsDatabase {
    private ArrayList<Report> reports;
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
}
