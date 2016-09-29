package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScreenController {
    private MainFXApplication mainApplication;

    public void loginClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/LoginScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
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
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {

            e.printStackTrace();

        }
    }
}
