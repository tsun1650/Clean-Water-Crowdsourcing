package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * controller for main screen
 */
public class MainScreenController {
    private MainFXApplication mainApplication;
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
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
}
