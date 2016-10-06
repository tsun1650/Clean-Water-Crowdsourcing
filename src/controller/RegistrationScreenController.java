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

/**
 * Created by David on 9/27/2016.
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
    private ComboBox<String> accountTypeComboBox;

    private UserDatabase database;
    private User u;
    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {

        mainApplication = main;
        database = mainApplication.getUsers();
        accountTypeComboBox= new ComboBox<>();
        accountTypeComboBox.getItems().addAll("Worker", "Manager", "Admin");
    }
    public void submitClicked() {


        //needs to be able to add type (set up combobox) and also title.
        //make room for those fields in fxml
        //everything else should probably work - tony
        u = new User(accountTypeComboBox.getValue(), userField.getText(), passField.getText(), firstField.getText(), lastField.getText(), emailField.getText(), "address", "Mr.");
        database.add(u);
        mainApplication.setActiveUser(u);
        mainApplication.setApplicationScene();


    }
    public void cancelClicked() {
        mainApplication.setMainScene();
    }
}
