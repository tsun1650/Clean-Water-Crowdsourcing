package Test;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Joel on 11/15/2016.
 */
public class JoelTest {
    private WaterSourceReport[] sArray;
    private ReportsDatabase rDatabase;
    private WaterSourceReport sReport, sReport2, sReport3, sReport4, sReport5, sReport6;
    private WaterPurityReport pReport;

    @Before
    public void setUp() {
        rDatabase = new ReportsDatabase();
        sReport = new WaterSourceReport("11/17/16", "90.00", "Joel", WaterType.BTL, Condition.PTBL);
        sReport2 = new WaterSourceReport("11/11/16", "90.00", "Joel", WaterType.BTL, Condition.PTBL);
        sReport3 = new WaterSourceReport("11/17/16", "91.00", "Joel", WaterType.BTL, Condition.PTBL);
        sReport4 = new WaterSourceReport("11/17/16", "90.00", "NotJoel", WaterType.BTL, Condition.PTBL);
        sReport5 = new WaterSourceReport("11/17/16", "90.00", "Joel", WaterType.LKE, Condition.PTBL);
        sReport6 = new WaterSourceReport("11/17/16", "90.00", "Joel", WaterType.BTL, Condition.TC);
        pReport = new WaterPurityReport("11/17/16, 10:30", "Joel", "90.00", PurityCondition.S, 11.11, 11.11);
    }

    @Test
    public void testEmptyList() {
        sArray = new WaterSourceReport[0];
        Assert.assertArrayEquals(sArray,rDatabase.getSourceReports().toArray());
    }

    @Test
    public void testSourceReportEquals() {
        Assert.assertTrue(sReport.equals(new WaterSourceReport("11/17/16", "90.00", "Joel", WaterType.BTL, Condition.PTBL)));
    }

    @Test
    public void testSourceReportNotEqual() {
        Assert.assertFalse(sReport.equals(sReport2));
        Assert.assertFalse(sReport.equals(sReport3));
        Assert.assertFalse(sReport.equals(sReport4));
        Assert.assertFalse(sReport.equals(sReport5));
        Assert.assertFalse(sReport.equals(sReport6));
    }

    @Test
    public void testSourceReportNotEqualPurityReport() {
        Assert.assertFalse(sReport.equals(pReport));
    }

    @Test
    public void testDatabaseLengthOneEqual() {
        sArray = new WaterSourceReport[1];
        sArray[0] = sReport;
        rDatabase.add(sReport);
        Assert.assertArrayEquals(sArray, rDatabase.getSourceReports().toArray());
    }

    @Test
    public void testDatabaseLengthOneNotEqual() {
        sArray = new WaterSourceReport[1];
        sArray[0] = sReport;
        System.out.println(sReport);
        rDatabase.add(sReport2);
        System.out.println(sReport2);
        Assert.assertFalse(rDatabase.getSourceReports().get(0).equals(sArray[0]));
    }

    @Test
    public void testDatabaseLengthTwo() {
        sArray = new WaterSourceReport[2];
        sArray[0] = sReport;
        sArray[1] = sReport2;
        rDatabase.add(sReport);
        rDatabase.add(sReport2);
        Assert.assertArrayEquals(sArray, rDatabase.getSourceReports().toArray());
    }

    @Test
    public void testDatabaseWithPurityReports() {
        sArray = new WaterSourceReport[1];
        sArray[0] = sReport;
        rDatabase.add(sReport);
        rDatabase.add(pReport);
        Assert.assertArrayEquals(sArray, rDatabase.getSourceReports().toArray());
    }
}