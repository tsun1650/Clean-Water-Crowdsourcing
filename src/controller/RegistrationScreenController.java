package controller;

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
    @FXML
    private Button cancelButton;
    public void submitClicked() {

    }
    public void cancelClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MainScreen.fxml"));
            Parent mainScreen = (Parent) fxmlLoader.load();
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(mainScreen));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
