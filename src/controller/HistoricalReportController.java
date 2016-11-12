package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.ReportsDatabase;
import model.User;
import model.UserDatabase;

/**
 * Created by Kate on 11/8/2016.
 */
public class HistoricalReportController {

    private MainFXApplication mainApplication;
    private User u;
    private UserDatabase database;
    private ReportsDatabase rDatabase;
    @FXML
    private ListView<String> listReports;

    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
        rDatabase = mainApplication.getReports();
    }

    public void backClicked() {
        u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }

    public void viewGraphClicked() {
        mainApplication.setViewGraphScene();
    }

    public void updateListView(){

        ObservableList<String> r = FXCollections.observableArrayList (rDatabase.getReportsAsString());
        System.out.println(rDatabase.getReportsAsString());
        listReports.setItems(r);

    }

    public void cancelClicked() {
        mainApplication.setApplicationScene(u);
    }

}
