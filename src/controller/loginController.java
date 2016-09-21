package controller;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * Created by robertwaters on 9/4/16.
 * Some code reused from the code makery tutorial
 *
 * Controller for the Student Edit / Add dialog box
 */
public class loginController {

    /*  **********************
        References to the FXML widgets in the .fxml file
     */
    @FXML
    private TextField nameField;

    @FXML
    private TextField majorField;

    @FXML
    private ComboBox<ClassStanding> classStandingField;

    /** the window for this dialog */
    private Stage _dialogStage;



    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {


    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage the stage for this dialog
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }



    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return  true if the user clicked the OK button
     */
    public boolean isOkClicked() {
        return _okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleRegisterPressed() {

    }


    @FXML
    private void handleLoginPressed() {

    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        //for now just check they actually typed something
        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid student name!\n";
        }
        if (majorField.getText() == null || majorField.getText().length() == 0) {
            errorMessage += "No valid major entered!\n";
        }


        //no error message means success / good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(_dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
