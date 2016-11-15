package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Type;
import model.User;
import model.UserDatabase;

/**
 * controller for registration screen
 */
@SuppressWarnings("ALL")
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
    private ComboBox<Type> typeField;


    private UserDatabase database;

    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {

        mainApplication = main;
        database = mainApplication.getUsers();


    }
    @FXML
    private void initialize() {
        //bring back the enum
        typeField.setItems(User.getTypes());
    }
    /**
     * register new user
     */
    public void submitClicked() {
        Type t = typeField.getSelectionModel().getSelectedItem();
        User u = new User(t, userField.getText(), passField.getText(), firstField.getText(), lastField.getText(), emailField.getText(), "address");


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
