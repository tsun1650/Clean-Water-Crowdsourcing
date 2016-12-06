package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import model.PersistenceManager;
import model.User;
import model.UserDatabase;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * controller for main screen
 */
@SuppressWarnings("ALL")
public class MainScreenController {
    private UserDatabase database;
    private MainFXApplication mainApplication;
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button load;

    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
    }

    /**
     * set scene to login scene
     */
    public void loginClicked() {
        mainApplication.setLoginScene();
    }

    /**
     * set scene to register scene
     */
    public void registerClicked() {
        mainApplication.setRegistrationScene();
    }

    /**
     * load file
     */
    public void loadClicked() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save JSON File");
        File file  = fc.showOpenDialog(mainApplication.getStage());
        List<User> uList;
        if (file != null) {
            PersistenceManager pm = new PersistenceManager(database.getUsers());
            try {
                uList = pm.loadUsersFromJson(file);
                for (User u : uList) {
                    database.add(u);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
