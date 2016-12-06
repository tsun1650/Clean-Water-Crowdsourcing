package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import model.UserDatabase;

/**
 * controller for login screen
 */
@SuppressWarnings("ALL")
public class LoginScreenController {

    private MainFXApplication mainApplication;
    private UserDatabase database;
    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

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

        User u = database.getCredentials(user, pass);
        if (u != null) {

            mainApplication.setApplicationScene(u);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "This is an incorrect login!", ButtonType.OK);
            alert.showAndWait();
        }

    }
    /*
    public void recoverPW(User u) {

        Email email = new Email();
        email.setFromAddress("System", "tonysun996@gmail.com");
        email.addRecipient(u.getFirstName(), u.getEmail(), RecipientType.TO);

        email.setSubject("Password Recovery");
        email.setText("Your password is " + u.getPass());

        new Mailer("server", "25", "username", "password").sendMail(email);
    }*/
    /**
     * after cancel, go home
     */
    public void backToMain() {
        mainApplication.setMainScene();
    }
}
