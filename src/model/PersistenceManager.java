package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jkatz35 on 11/09/16.
 */
@SuppressWarnings("ALL")
public class PersistenceManager {

    private List<User> userList;
    private ArrayList<Report> reportList;
    private ArrayList<WaterSourceReport> sourceReportList;
    private ArrayList<WaterPurityReport> purityReportList;

    public PersistenceManager() {}
    public PersistenceManager(ArrayList<User> userList) {
        this.userList = userList;
    }

//    public PersistenceManager(ArrayList<Report> reportList, int dummy) {
//        this.reportList = reportList;
//    }

// --Commented out by Inspection START (11/14/2016 10:01 PM):
//    public void addUsers(ArrayList<User> userList) {
//        this.userList = userList;
//    }
// --Commented out by Inspection STOP (11/14/2016 10:01 PM)

// --Commented out by Inspection START (11/14/2016 10:01 PM):
//    public void addSourceReports(ArrayList<WaterSourceReport> sourceReportList) {
//        this.sourceReportList = sourceReportList;
//    }
// --Commented out by Inspection STOP (11/14/2016 10:01 PM)

    public void addPurityReports(ArrayList<WaterPurityReport> purityReportList) {
        this.purityReportList = purityReportList;
    }

    public PersistenceManager(ArrayList<WaterSourceReport> availabilityReports, ArrayList<WaterPurityReport> qualityReports) {
        this.sourceReportList = availabilityReports;
        this.purityReportList = qualityReports;
    }
    public void saveUsersToJson(File file) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            Gson gson = new Gson();
            String str = gson.toJson(userList);
            pw.println(str);
            pw.close();
        } catch (IOException e) {
            throw new IOException("Exception with JSON file");
        }
    }

    public void saveSourceReportsToJson(File file) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            Gson gson = new Gson();
            String str = gson.toJson(sourceReportList);
            pw.println(str);
            pw.close();
        } catch (IOException e) {
            throw new IOException("Exception with JSON file");
        }
    }

    public void savePurityReportsToJson(File file) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            Gson gson = new Gson();
            String str = gson.toJson(purityReportList);
            pw.println(str);
            pw.close();
        } catch (IOException e) {
            throw new IOException("Exception with JSON file");
        }
    }

    public List<User> loadUsersFromJson(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        Type collectionType = new TypeToken<List<User>>() {
        }.getType();
        Gson gson = new Gson();
        String content = br.readLine();
        userList = gson.fromJson(content, collectionType);
        br.close();
        return userList;
    }

    public List<WaterSourceReport> loadSourceReportsFromJson(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        Type collectionType = new TypeToken<List<WaterSourceReport>>() {
        }.getType();
        Gson gson = new Gson();
        String content = br.readLine();
        sourceReportList = gson.fromJson(content, collectionType);
        br.close();
        return sourceReportList;
    }

    public List<WaterPurityReport> loadPurityReportsFromJson(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        Type collectionType = new TypeToken<List<WaterPurityReport>>() {
        }.getType();
        Gson gson = new Gson();
        String content = br.readLine();
        purityReportList = gson.fromJson(content, collectionType);
        br.close();
        return purityReportList;
    }
}