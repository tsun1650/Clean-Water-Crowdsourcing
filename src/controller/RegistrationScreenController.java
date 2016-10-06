package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import model.UserDatabase;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller for registration screen
 */
public class RegistrationScreenController {
    private MainFXApplication mainApplication;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField firstField;
    @FXML
    private TextField lastField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private TextField typeField;

    private UserDatabase database;
    private User u;
    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {

        mainApplication = main;
        database = mainApplication.getUsers();


    }

    /**
     * register new user
     */
    public void submitClicked() {
        u = new User(typeField.getText(), userField.getText(), passField.getText(), firstField.getText(), lastField.getText(), emailField.getText(), "address", "Mr.");

        database.add(u);
        database.login(u);

        mainApplication.setApplicationScene(u);


    }

    /**
     * set scene to main
     */
    public void cancelClicked() {
        mainApplication.setMainScene();
    }
}
