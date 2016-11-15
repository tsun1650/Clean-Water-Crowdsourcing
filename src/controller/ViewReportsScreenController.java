package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.ReportsDatabase;
import model.User;
import model.UserDatabase;

@SuppressWarnings("ALL")
public class ViewReportsScreenController {
    private MainFXApplication mainApplication;
    private UserDatabase database;
    private ReportsDatabase rDatabase;
    @FXML
    private ListView<String> listReports;


    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
        rDatabase = mainApplication.getReports();
    }


    public void backClicked() {
        User u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }

    public void viewMapClicked() {
        mainApplication.setViewMapScene();
    }

    public void updateListView(){

        ObservableList<String> r = FXCollections.observableArrayList (rDatabase.getReportsAsString());
        System.out.println(rDatabase.getReportsAsString());
        listReports.setItems(r);

    }


}
