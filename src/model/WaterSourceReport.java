package model;

import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * @param date
     * @param location
     * @param reporter
     * @param type
     * @param condition
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
     * @param n
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

    public void saveToText(PrintWriter pw) {
        pw.println(date + "\t" + location + "\t" + reporter + "\t" + type + "\t" + condition + "\t" + number);
    }

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

