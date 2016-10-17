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
    private User u;
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
        typeField.setItems(u.getTypes());
    }
    /**
     * register new user
     */
    public void submitClicked() {
        Type t = typeField.getSelectionModel().getSelectedItem();
        u = new User(Type.USR, userField.getText(), passField.getText(), firstField.getText(), lastField.getText(), emailField.getText(), "address", "Mr.");
        /*if (typeField.getText().equals("user") || typeField.getText().equals("manager") || typeField.getText().equals("worker") || typeField.getText().equals("admin")) {
            System.out.println(typeField.getText());
        } else {
            System.out.println("not valid type");
        }*/

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
