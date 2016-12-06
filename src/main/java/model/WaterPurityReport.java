package model;

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

    public String getDate() { return date; }
    public String getWorker() { return worker; }
    public PurityCondition getCondition() { return condition; }
    public double getVirusPPM() { return virusPPM;}
    public double getContaminantPPM() { return contaminantPPM;}
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

// --Commented out by Inspection START (11/14/2016 9:56 PM):
//    public void saveToText(PrintWriter pw) {
//        pw.println(date + "\t" + worker + "\t" + location + "\t" + condition + "\t" + virusPPM + "\t" + contaminantPPM);
//    }
// --Commented out by Inspection STOP (11/14/2016 9:56 PM)

    public String toString() {
        return "<h2>WaterPurityReport</h2>{" +
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

    public boolean equals(WaterPurityReport other) {
        //number, location, year, date, worker, condition, virusPPM, containmentPPM
        boolean numB = this.getNumber() == other.getNumber();
        boolean locB = this.getLocation().equals(other.getLocation());
        boolean yearB = this.getYear().equals(other.getYear());
        boolean dateB = date.equals(other.getDate());
        boolean workB = worker.equals(other.getWorker());
        boolean condB = condition.equals(other.getCondition());
        boolean virB = virusPPM == other.getVirusPPM();
        boolean contB = contaminantPPM == other.getVirusPPM();
        return numB && locB && yearB && dateB && workB && condB && virB && contB;
    }

    public int getNumber() {
        return number;
    }
}