package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.PersistenceManager;
import model.User;
import model.UserDatabase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * controller for main screen
 */
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

    public void loadClicked() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save JSON File");
        File file  = fc.showOpenDialog(mainApplication.getStage());
        List<User> uList = new ArrayList<>();
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
