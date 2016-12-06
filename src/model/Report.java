package model;

@SuppressWarnings("ALL")
public class Report {
    int number;
    private Integer year;
    String location;

    Report() {}
    Report(String location) {
        this.location = location;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getYear() {
        return year;
    }
    public String getLocation() { return location;}
    public int getNumber() {
        return number;
    }

    public double getLatitude() {
        String[] latLong = location.split(",");
        return Double.parseDouble(latLong[0]);
    }

    public double getLongitude() {
        String[] latLong = location.split(",");
        return Double.parseDouble(latLong[1]);
    }
}
