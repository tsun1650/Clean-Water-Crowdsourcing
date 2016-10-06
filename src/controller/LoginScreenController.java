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

/**
 * controller for login screen
 */
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

    /**
     * try to log in user
     */
    public void verifyUser() {
        String user = userField.getText().trim();
        String pass = passField.getText().trim();
        //u = new User(userField.getText().trim(), passField.getText().trim());
        u = database.getCredentials(user, pass);
        if (u != null) {
            database.login(u);
            mainApplication.setActiveUser(u);
            mainApplication.setApplicationScene(u);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "This is an incorrect login!", ButtonType.OK);
            alert.showAndWait();
        }
        /*
        if (database.login(userField.getText().trim(), passField.getText().trim())) {
            u = mainApplication.getActiveUser();
            mainApplication.setActiveUser(u);
            mainApplication.setApplicationScene(u);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "This is an incorrect login!", ButtonType.OK);
            alert.showAndWait();

        }*/
    }

    /**
     * after cancel, go home
     */
    public void backToMain() {
        mainApplication.setMainScene();
    }
}
