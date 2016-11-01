package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import model.Report;
import model.ReportsDatabase;
import model.User;
import model.UserDatabase;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewReportsScreenController {
    private MainFXApplication mainApplication;
    private UserDatabase database;
    private ReportsDatabase rDatabase;
    private User u;
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

    /**
     * Method that transitions to the mainApplicationScene
     */
    public void backClicked() {
        u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }

    /**
     * transitions to the map Scene
     */
    public void viewMapClicked() {
        mainApplication.setViewMapScene();
    }

    /**
     * Adds new reports to the rDatabase
     */
    public void updateListView(){

        ObservableList<String> r = FXCollections.observableArrayList (rDatabase.getReportsAsString());
        System.out.println(rDatabase.getReportsAsString());
        listReports.setItems(r);

    }


}
