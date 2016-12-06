package model;

/**
 * Created by tonys on 10/19/2016.
 */
public class WaterSourceReport extends Report{

    private String date;
    private String reporter;
    private WaterType type;
    private Condition condition;

    /**
     * constructor
     * @param date date of report
     * @param location location of report
     * @param reporter reporter of report
     * @param type type of water
     * @param condition condition of water
     */
    public WaterSourceReport(String date, String location, String reporter, WaterType type, Condition condition) {
        super(location);
        this.date = date;
        this.reporter = reporter;
        this.type = type;
        this.condition = condition;

    }

    /**
     * set report number
     * @param n number to set
     */
    public void setNumber(int n) {
        number = n;
    }

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
//        pw.println(date + "\t" + location + "\t" + reporter + "\t" + type + "\t" + condition + "\t" + number);
//    }
// --Commented out by Inspection STOP (11/14/2016 9:56 PM)

    @Override
    public String toString() {
        return "WaterSourceReport{" +
                "date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", reporter='" + reporter + '\'' +
                ", type=" + type +
                ", condition=" + condition +
                ", number=" + number +
                '}';
    }
}

