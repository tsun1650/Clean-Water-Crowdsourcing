package model;

/**
 * Created by David on 10/19/2016.
 */
public class WaterPurityReport extends Report {
    private String date;
    private int number;
    private String worker;
    private String location;
    private PurityCondition condition;
    private double virusPPM;
    private double contaminantPPM;
    private Integer year;


    public WaterPurityReport(String dateTime, String worker,
                             String location, PurityCondition condition,
                             double virusPPM, double contaminantPPM) {
        this.date = dateTime;
        this.number = number;
        this.worker = worker;
        this.location = location;
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

    public String toString() {
        return "WaterPurityReport{" +
                "date='" + date + '\'' +
                ", number='" + number + '\'' +
                ", worker='" + worker + '\'' +
                ", location='" + location +
                ", condition=" + condition +
                ", Virus PPM=" + virusPPM +
                ", Contaminant PPM=" + contaminantPPM +
                '}';
    }
    public Integer getYear() {

        return Integer.parseInt(date.substring(6,8));
    }
}