package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import model.UserDatabase;

public class LoginScreenController {
    private String username = "user";
    private String password = "pass";
    private MainFXApplication mainApplication;
    private UserDatabase database = new UserDatabase();

    @FXML
    private TextField userField;

    @FXML
    private TextField passField;

    public void verifyUser() {
        // TO DO implement this (can be hard coded) so that
        // if the username & password are right, go to application screen
        // should be similar to the try catch in the mainscreen controller but with
        // an if statement checking if what's passed equals the variables -David
        User u = new User(userField.getText().trim(), passField.getText().trim());
        if (database.contains(u)) {
            u.login();

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ApplicationScreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "This is an incorrect login!", ButtonType.OK);
            alert.showAndWait();
            //throw new IllegalArgumentException("Bruh ain't even in the system");
        }
    }

    public void backToMain() {
        // TO DO: implement this so that when cancel is pressed,
        // go back to the main screen -idk if you can do it the same window 
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
