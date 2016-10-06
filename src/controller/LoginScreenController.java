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
import model.User;
import model.UserDatabase;

public class LoginScreenController {
    private String username = "user";
    private String password = "pass";
    private MainFXApplication mainApplication;
    private UserDatabase database;
    private User u;
    @FXML
    private TextField userField;

    @FXML
    private TextField passField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;


    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
    }

    public void verifyUser() {

        u = new User(userField.getText().trim(), passField.getText().trim());
        //u = new User();

        database.add(u);
        if (database.login(u)) {
            mainApplication.setActiveUser(u);
            mainApplication.setApplicationScene();

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "This is an incorrect login!", ButtonType.OK);
            alert.showAndWait();

        }
    }

    public void backToMain() {
        mainApplication.setMainScene();
    }
}
