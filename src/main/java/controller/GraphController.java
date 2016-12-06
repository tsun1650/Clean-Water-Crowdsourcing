package controller;

import fxapp.MainFXApplication;
import model.ReportsDatabase;
import model.User;
import model.UserDatabase;

/**
 * Controller for the graph
 */
@SuppressWarnings("ALL")
public class GraphController {
    private MainFXApplication mainApplication;
    private UserDatabase database;
    private ReportsDatabase rDatabase;


    /**
     * set app to main
     * @param main main application
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
        rDatabase = mainApplication.getReports();
    }

    /**
     * go back home
     */
    public void backClicked() {
        User u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }
}

