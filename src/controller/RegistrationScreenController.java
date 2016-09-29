package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by David on 9/27/2016.
 */
public class RegistrationScreenController {
    public void submitClicked() {

    }
    public void cancelClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MainScreen.fxml"));
            Parent mainScreen = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(mainScreen));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
