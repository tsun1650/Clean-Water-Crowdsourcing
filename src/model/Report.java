package model;

public class Report {
    private int number;
    private Integer year;
    private String location;

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
