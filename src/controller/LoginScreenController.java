package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;
import model.accountDatabase;

public class LoginScreenController {
    private String username = "user";
    private String password = "pass";
    private MainFXApplication mainApplication;
    private accountDatabase database = new accountDatabase();

    @FXML
    private TextField userField;

    @FXML
    private TextField passField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;




    public void verifyUser() {
        Parent root1;

        // TO DO implement this (can be hard coded) so that
        // if the username & password are right, go to application screen
        // should be similar to the try catch in the mainscreen controller but with
        // an if statement checking if what's passed equals the variables -David
        Account u = new Account(userField.getText().trim(), passField.getText().trim());
        database.add(u);
        if (database.contains(u)) {
            u.login();

            try {

                root1 = FXMLLoader.load(getClass().getResource("../view/ApplicationScreen.fxml"));
                Stage stage = (Stage) loginButton.getScene().getWindow();
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
        Parent root1;
        // TO DO: implement this so that when cancel is pressed,
        // go back to the main screen -idk if you can do it the same window 
        try {
            root1 = FXMLLoader.load(getClass().getResource("../view/MainScreen.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
