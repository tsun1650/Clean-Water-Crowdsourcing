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

    /**
     * set app to main
     * @param main main application
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();

    }

    /**
     * go back home
     */
    public void backClicked() {
        User u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }
}

