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
    protected accountDatabase database = new accountDatabase();
    private Account defaultAccount = new Account("user", "pass");
    private Account activeAccount;

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

        activeAccount = new Account(userField.getText().trim(), passField.getText().trim());

        if (database.login(activeAccount) || activeAccount.equals(defaultAccount)) {

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
        }
    }

    public void backToMain() {
        Parent root1;
        database.logOut(activeAccount);

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
