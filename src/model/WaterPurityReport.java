package model;

import java.io.PrintWriter;

/**
 * Created by David on 10/19/2016.
 */
public class WaterPurityReport extends Report {
    private String date;
    private String worker;
    private PurityCondition condition;
    private double virusPPM;
    private double contaminantPPM;


    public WaterPurityReport(String dateTime, String worker,
                             String location, PurityCondition condition,
                             double virusPPM, double contaminantPPM) {
        super(location);
        this.date = dateTime;
        this.worker = worker;
        this.condition = condition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
    }

//    public String getDate() { return date; }
//    public int getNumber() {return number;}
//    public String getWorker() { return worker; }
//    public String getLocation() { return location; }
//    public String getCondition() { return condition; }
//    public double getVirusPPM() { return virusPPM;}
//    public double getContaminantPPM() { return contaminantPPM;}
//
//    public void setDate(String dateTime) { this.date = dateTime;}
//    public void setNumber(int number) { this.number = number;}
//    public void setWorker(String worker) { this.worker = worker;}
//    public void setLocation(String location) { this.location = location;}
//    public void setCondition(String condition) { this.condition = condition;}
//    public void setVirusPPM(double virusPPM) { this.virusPPM = virusPPM;}
//    public void setContaminantPPM(double contaminantPPM) { this.contaminantPPM = contaminantPPM;}

    public double getLatitude() {
        String[] latLong = location.split(",");
        return Double.parseDouble(latLong[0]);
    }

    public double getLongitude() {
        String[] latLong = location.split(",");
        return Double.parseDouble(latLong[1]);
    }

    public void saveToText(PrintWriter pw) {
        pw.println(date + "\t" + worker + "\t" + location + "\t" + condition + "\t" + virusPPM + "\t" + contaminantPPM);
    }

    public String toString() {
        return "WaterPurityReport{" +
                "date='" + date + '\'' +
                ", worker='" + worker + '\'' +
                ", location='" + location + '\'' +
                ", condition=" + condition +
                ", Virus PPM=" + virusPPM +
                ", Contaminant PPM=" + contaminantPPM +
                ", number='" + number +
                '}';
    }
    public Integer getYear() {

        return Integer.parseInt(date.substring(6,8));
    }
}