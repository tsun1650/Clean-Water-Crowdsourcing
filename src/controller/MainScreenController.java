package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController {
    private MainFXApplication mainApplication;
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;
    public void loginClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/LoginScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {

            e.printStackTrace();

        }
    }

    public void registerClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RegistrationScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {

            e.printStackTrace();

        }
    }
}
