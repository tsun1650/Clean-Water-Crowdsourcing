package controller;

import fxapp.MainFXApplication;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;

/**
 * The controller for the root/main window
 *
 */
public class MainScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Close menu item event handler
     */
    @FXML
    private void handleCloseMenu() {
        System.exit(0);

    }

    /**
     * About menu item event handler
     */
    @FXML
    private void handleAboutMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("M4 Login Screen");
        alert.setHeaderText("About");
        alert.setContentText("Made by Tony Sun");

        alert.showAndWait();

    }

}
