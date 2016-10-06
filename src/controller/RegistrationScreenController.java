package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by David on 9/27/2016.
 */
public class RegistrationScreenController {
    private MainFXApplication mainApplication;
    @FXML
    private Button cancelButton;

    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
    }
    public void submitClicked() {

    }
    public void cancelClicked() {
        mainApplication.setMainScene();
    }
}
