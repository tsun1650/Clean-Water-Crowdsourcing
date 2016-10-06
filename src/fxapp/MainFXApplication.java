package fxapp;

import controller.ApplicationScreenController;
import controller.LoginScreenController;
import controller.MainScreenController;
import controller.RegistrationScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.User;
import model.UserDatabase;

import java.io.IOException;
import java.util.ArrayList;

public class MainFXApplication extends Application {
    private User activeUser;
    private Stage stage;
    private Scene loginScene;
    private Scene applicationScene;
    private UserDatabase database;
    private Scene mainScene;
    private Scene registrationScene;
    private ApplicationScreenController applicationController;

    public User getActiveUser() {

        return activeUser;
    }
    public void setActiveUser(User u) {
        database.setActiveUser(u);
    }
    public UserDatabase getUsers() {
        return database;
    }
    /**
     * Launch app
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        database = new UserDatabase();
        setLayout(primaryStage);
    }

    /**
     * Set scene to logout controls
     */
    public void setApplicationScene() {
        applicationController.showProfile();
        setScene(applicationScene);
    }

    /**
     * Set scene to login controls
     */
    public void setLoginScene() {
        setScene(loginScene);
    }

    /**
     * Set scene to registration controls
     */
    public void setRegistrationScene() {
        setScene(registrationScene);
    }

    /**
     * Set scene to profile controls
     */
    public void setMainScene() {

        setScene(mainScene);
    }

    private void setScene(Scene s) {
        stage.hide();
        stage.setScene(s);
        stage.show();
    }

    private void setLayout(Stage mainScreen) {
        stage = mainScreen;
        try {
            //create loaders
            FXMLLoader applicationLoader = new FXMLLoader();
            FXMLLoader loginLoader = new FXMLLoader();
            FXMLLoader mainLoader = new FXMLLoader();
            FXMLLoader registrationLoader = new FXMLLoader();
            //tie loaders to fxmls
            applicationLoader.setLocation(MainFXApplication.class.getResource("../view/ApplicationScreen.fxml"));
            loginLoader.setLocation(MainFXApplication.class.getResource("../view/loginScreen.fxml"));
            mainLoader.setLocation(MainFXApplication.class.getResource("../view/mainScreen.fxml"));
            registrationLoader.setLocation(MainFXApplication.class.getResource("../view/registrationScreen.fxml"));
            //load them in layouts
            AnchorPane applicationLayout = applicationLoader.load();
            BorderPane loginLayout = loginLoader.load();
            BorderPane mainLayout = mainLoader.load();
            GridPane registrationLayout = registrationLoader.load();

            // attach layout to the scene
            applicationScene = new Scene(applicationLayout);
            loginScene = new Scene(loginLayout);
            mainScene = new Scene(mainLayout);
            registrationScene = new Scene(registrationLayout);

            // Give the controller access to the main app.
            applicationController = applicationLoader.getController();
            LoginScreenController loginController = loginLoader.getController();
            MainScreenController mainController = mainLoader.getController();
            RegistrationScreenController registrationController = registrationLoader.getController();
            applicationController.setApp(this);
            loginController.setApp(this);
            mainController.setApp(this);
            registrationController.setApp(this);

            setMainScene();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
