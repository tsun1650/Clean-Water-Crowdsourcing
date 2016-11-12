package model;

import java.io.PrintWriter;

public class Report {
    protected int number;
    protected Integer year;
    protected String location;

    public Report() {}
    public Report(String location) {
        this.location = location;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Integer getYear() {
        return year;
    }
    public String getLocation() { return location;}

    public double getLatitude() {
        String[] latLong = location.split(",");
        return Double.parseDouble(latLong[0]);
    }

    public double getLongitude() {
        String[] latLong = location.split(",");
        return Double.parseDouble(latLong[1]);
    }
}
