package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jkatz35 on 11/09/16.
 */
public class PersistenceManager {

    private List<User> userList;
    private List<WaterSourceReport> sourceReportList;
    private List<WaterPurityReport> purityReportList;
    public PersistenceManager(ArrayList<User> userList) {
        this.userList = userList;
    }
    public PersistenceManager(List<WaterSourceReport> availabilityReports,
                              List<WaterPurityReport> qualityReports) {
        this.sourceReportList = availabilityReports;
        this.purityReportList = qualityReports;
    }
    public void saveUsersToJson(File file) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file));) {
            Gson gson = new Gson();
            String str = gson.toJson(userList);
            pw.println(str);
            pw.close();
        } catch (IOException e){
            throw new IOException("Exception with JSON file");
        }


    }
    public void saveWaterSourceReportsToJson(File file) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        Gson gson = new Gson();
        String str = gson.toJson(sourceReportList);
        pw.println(str);
        pw.close();
    }
    public void saveWaterPurityReportsToJson(File file) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        Gson gson = new Gson();
        String str = gson.toJson(purityReportList);
        pw.println(str);
        pw.close();
    }
    public List<User> loadUsersFromJson(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        Type collectionType = new TypeToken<List<User>>(){}.getType();
        Gson gson = new Gson();
        String content = br.readLine();
        userList = gson.fromJson(content, collectionType);
        br.close();
        return userList;
    }
    public List<WaterSourceReport> loadWaterSourceReportsFromJson(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        Type collectionType = new TypeToken<List<WaterSourceReport>>(){}.getType();
        Gson gson = new Gson();
        String content = br.readLine();
        sourceReportList = gson.fromJson(content, collectionType);
        br.close();
        return sourceReportList;
    }
    public List<WaterPurityReport> loadWaterPurityReportsFromJson(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        Type collectionType = new TypeToken<List<WaterPurityReport>>(){}.getType();
        Gson gson = new Gson();
        String content = br.readLine();
        purityReportList = gson.fromJson(content, collectionType);
        br.close();
        return purityReportList;
    }
}

//    private static Logger LOGGER = Logger.getLogger("PersistenceManager");
//
//    private List<Location> model;
//
//    public PersistenceManager(List<Location> m) {
//        model = m;
//    }
//
//    public void saveToText(File file) {
//        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
//            pw.println(model.size());
//            for (Location l : model) {
//                l.saveToText(pw);
//            }
//            pw.close();
//        } catch (IOException e) {
//            LOGGER.log(Level.SEVERE, "Exception working with Text Save File", e);
//        }
//
//    }
//
//    public void loadFromText(File file) {
//        String ct = null;
//        model.clear();
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            ct = br.readLine();
//            int count = Integer.parseInt(ct);
//            for (int i = 0; i < count; ++i) {
//                ct = br.readLine();
//                Location loc = Location.makeFromFileString(ct);
//                model.add(loc);
//            }
//            br.close();
//        } catch(IOException ex) {
//            LOGGER.log(Level.SEVERE, "Exception working with Text Load File", ex);
//        } catch(NumberFormatException fe) {
//            LOGGER.log(Level.SEVERE, "File Format problem with count of elements: " + ct, fe);
//        } catch (FileFormatException e) {
//            LOGGER.log(Level.SEVERE, "Format problem with individual line: " + e.getOriginalLine(), e);
//        }
//    }
//
//    public void saveToBinary(File file) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
//            oos.writeObject(model);
//            oos.close();
//        } catch (IOException e) {
//            LOGGER.log(Level.SEVERE, "Failed to make an output stream for Binary", e);
//        }
//    }
//
//    public void loadFromBinary(File file) {
//       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//           model = (ArrayList<Location>) ois.readObject();
//           ois.close();
//       } catch (IOException ex) {
//           LOGGER.log(Level.SEVERE, "Failed to make an input stream for Binary", ex);
//       } catch (ClassNotFoundException ex) {
//           LOGGER.log(Level.SEVERE, "Failed to find appropriate class in Binary", ex);
//       }
//    }
//
//    public void saveToJson(File file) {
//        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
//            Gson gson = new Gson();
//            String str = gson.toJson(model);
//            pw.println(str);
//            pw.close();
//        } catch (IOException e) {
//            LOGGER.log(Level.SEVERE, "Exception working with Json Save File", e);
//        }
//    }
//
//    public void loadFromJsonfile(File file) {
//        String ct = null;
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            Type collectionType = new TypeToken<List<Location>>(){}.getType();
//            Gson gson = new Gson();
//
//            ct = br.readLine();
//
//            model = gson.fromJson(ct, collectionType);
//
//            br.close();
//        } catch (IOException ex) {
//              LOGGER.log(Level.SEVERE, "Exception working with Json load file", ex);
//        }
//    }