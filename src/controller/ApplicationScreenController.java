package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.User;

public class ApplicationScreenController {
    @FXML
    private Button logoutButton;

    public void logout() {
        //User u = database.whoIsLoggedIn();
        //u.logout();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MainScreen.fxml"));
            Parent mainScreen = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(mainScreen));
            stage.show();
        } catch(Exception e) {

            e.printStackTrace();

        }
    }

}
