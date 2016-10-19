package model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tonys on 10/19/2016.
 */
public class WaterSourceReport extends Report{

    private String date;
    private String location;
    private String reporter;
    private WaterType type;
    private Condition condition;
    private int number;

    /**
     * constructor
     * @param date
     * @param location
     * @param reporter
     * @param type
     * @param condition
     */
    public WaterSourceReport(String date, String location, String reporter, WaterType type, Condition condition) {
        this.date = date;
        this.location = location;
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

