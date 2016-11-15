package controller;

import fxapp.MainFXApplication;
import model.User;
import model.UserDatabase;

/**
 * Controller for the graph
 */
@SuppressWarnings("ALL")
class GraphController {

    private MainFXApplication mainApplication;
    private UserDatabase database;


    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();

    }

    public void backClicked() {
        User u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }
}

