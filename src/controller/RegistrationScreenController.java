package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;
import controller.LoginScreenController;
//import model.AccountType;


/**
 * Created by David on 9/27/2016.
 */
public class RegistrationScreenController {
    @FXML
    private Button cancelButton;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private TextField firstField;
    @FXML
    private TextField lastField;
    @FXML
    private TextField emailField;

    //@FXML
    //private ComboBox<AccountType> accountTypeComboBox;

    public void submitClicked() {

        String first = firstField.getText().trim();
        String last = lastField.getText().trim();
        String user = userField.getText().trim();
        String pass = passField.getText().trim();
        String email = emailField.getText().trim();
        Account a = new Account(user, pass, first, last, email);
        //database.add(a);
        //a.login();
        //verifyUser();

    }
    public void cancelClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MainScreen.fxml"));
            Parent mainScreen = (Parent) fxmlLoader.load();
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(mainScreen));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
