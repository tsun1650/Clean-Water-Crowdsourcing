package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginScreenController {
    private String username = "user";
    private String password = "pass";
    private MainFXApplication mainApplication;
    public void verifyUser() {
        // TO DO implement this (can be hard coded) so that
        // if the username & password are right, go to application screen
        // should be similar to the try catch in the mainscreen controller but with
        // an if statement checking if what's passed equals the variables -David
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
