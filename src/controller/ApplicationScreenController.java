package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import model.User;
import model.UserDatabase;

import java.util.ArrayList;

/**
 * Controller class for application screen
 */
public class ApplicationScreenController {
    private MainFXApplication mainApplication;
    private User u;
    @FXML
    private Button logoutButton;
    @FXML
    private Label firstNameField;
    @FXML
    private Label lastnameField;
    @FXML
    private Label emailField;
    @FXML
    private Label addressField;
    @FXML
    private Label titleField;
    private UserDatabase database;


    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();

    }

    /**
     * shows the profile info
     * @param u user
     */
    public void showProfile(User u) {

        firstNameField.setText(u.getFirstName());
        lastnameField.setText(u.getLastName());
        emailField.setText(u.getEmail());
        addressField.setText(u.getAddress());
        titleField.setText(u.getTitle());
    }

    /**
     * edit the profile attributes
     */
    public void editProfile() {
        u = database.getActiveUser();
        //create pup up dialog
        Dialog<ArrayList> dialog = new Dialog<>();
        dialog.setTitle("Profile");
        dialog.setHeaderText("Edit Profile");
        dialog.setResizable(true);
        //add fields
        Label label1 = new Label("First Name: ");
        Label label2 = new Label("Last Name: ");
        Label label3 = new Label("Email: ");
        Label label4 = new Label("Address: ");
        Label label5 = new Label("Title: " );
        TextField text1 = new TextField(u.getFirstName());
        TextField text2 = new TextField(u.getLastName());
        TextField text3 = new TextField(u.getEmail());
        TextField text4 = new TextField(u.getAddress());
        TextField text5 = new TextField(u.getTitle());
        //add it to gridpane
        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);
        grid.add(label3, 1, 3);
        grid.add(text3, 2, 3);
        grid.add(label4, 1, 4);
        grid.add(text4, 2, 4);
        grid.add(label5, 1, 0);
        grid.add(text5, 2, 0);
        //put it all in
        dialog.getDialogPane().setContent(grid);
        //Button Listener to take in Strings
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.setResultConverter(new Callback<ButtonType, ArrayList>() {
            @Override
            public ArrayList call(ButtonType b) {
                //set new profile items
                if (b == buttonTypeOk) {
                    u.setFirst(text1.getText());
                    u.setLast(text2.getText());
                    u.setEmail(text3.getText());
                    u.setAddress(text4.getText());
                    u.setTitle(text5.getText());

                }

                return null;
            }
        });
        dialog.showAndWait();
        showProfile(u);

    }

    /**
     * log out the user
     */
    public void logout() {
        u = database.getActiveUser();
        database.logOut(u);
        mainApplication.setMainScene();
    }

}
