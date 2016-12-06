package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import model.UserDatabase;

/**
 * Created by tonys on 12/6/2016.
 */
public class DeleteUsersController {
    @FXML
    private Button removeButton;
    @FXML
    private Button back;
    @FXML
    private ListView userField;
    @FXML
    private TextField removeUserField;

    MainFXApplication mainApplication;
    UserDatabase database;

    /**
     * Set up on app open
     * @param main instance of mainFXapp
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
        updateList();
    }

    /**
     * Response to removeButton clicked
     */
    public void removeButtonClicked() {

        String user = removeUserField.getText().trim();
        boolean worked = database.removeUserWithUName(user);
        if (!worked) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "This user may not be removed or does not exist!", ButtonType.OK);
            alert.showAndWait();
        }
        updateList();
    }

    /**
     * Response to back button click
     */
    public void backClicked() {
        User u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }

    /**
     * updates list of users
     */
    public void updateList() {
        ObservableList<String> r = FXCollections.observableArrayList (database.getUsersAsString());
        userField.setItems(r);
    }

}
