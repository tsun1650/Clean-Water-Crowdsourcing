package fxapp;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Facade;
import model.ReportsDatabase;
import model.User;
import model.UserDatabase;
import sun.applet.Main;
import controller.MapController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * create the main application
 */
public class MainFXApplication extends Application {
    private User activeUser;
    private Stage stage;
    private Scene loginScene;
    private Scene applicationScene;
    private Scene mapScene;
    private UserDatabase database;
    private ReportsDatabase rDatabase;
    private Scene mainScene;
    private Scene registrationScene;
    private Scene waterSourceScene;
    private Scene viewReportsScene;
    private ApplicationScreenController applicationController;
    //private WaterSourceReportScreenController waterSourceController;
    private ViewReportsScreenController viewReportsController;
    private MapController mapController;

    /**
     * get the logged in user
     * @return activeUser user logged in
     */
    public User getActiveUser() {

        return activeUser;
    }

    /**
     * set the logged in user
     * @param u user to login
     */
    public void setActiveUser(User u) {
        database.setActiveUser(u);
    }

    /**
     * get the database
     * @return database the userlist
     */
    public UserDatabase getUsers() {
        return database;
    }
    /**
     * get the database
     * @return database the userlist
     */
    public ReportsDatabase getReports() {
        return rDatabase;
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
        rDatabase = new ReportsDatabase();
        database.add(new User());
        setLayout(primaryStage);
    }

    /**
     * Set scene to logout controls
     */
    public void setApplicationScene(User u) {
        applicationController.showProfile(u);
        setScene(applicationScene);
    }

    /**
     * Sets the scene to the google maps
     */
    public void setViewMapScene() {
        setScene(mapScene);
        System.out.println("setViewMapScene");
        mapController.placeMarkers(rDatabase.getLocations());
        System.out.println("to here");
    }




    /**
     * set scene to login
     */
    public void setLoginScene() {
        setScene(loginScene);
    }

    /**
     * set scene to registration
     */
    public void setRegistrationScene() {
        setScene(registrationScene);
    }

    /**
     * set scene to main
     */
    public void setMainScene() {

        setScene(mainScene);
    }

    /**
     * sets scene to submit water source report screen
     */
    public void setWaterSourceScene() {
        setScene(waterSourceScene);
    }

    /**
     * sets scene to view reports
     */
    public void setViewReportsScene() {
        viewReportsController.updateListView();
        setScene(viewReportsScene);

    }

    /**
     * set scene
     * @param s scene to set it to
     */
    private void setScene(Scene s) {
        stage.hide();
        stage.setScene(s);
        stage.show();
    }

    /**
     * set the layout
     * @param mainScreen screen to set it to
     */
    private void setLayout(Stage mainScreen) {
        stage = mainScreen;
        try {
            //create loaders
            FXMLLoader applicationLoader = new FXMLLoader();
            FXMLLoader loginLoader = new FXMLLoader();
            FXMLLoader mainLoader = new FXMLLoader();
            FXMLLoader registrationLoader = new FXMLLoader();
            FXMLLoader viewReportsLoader = new FXMLLoader();
            FXMLLoader viewMapLoader = new FXMLLoader();
            //tie loaders to fxmls
            applicationLoader.setLocation(MainFXApplication.class.getResource("../view/ApplicationScreen.fxml"));
            loginLoader.setLocation(MainFXApplication.class.getResource("../view/loginScreen.fxml"));
            mainLoader.setLocation(MainFXApplication.class.getResource("../view/mainScreen.fxml"));
            registrationLoader.setLocation(MainFXApplication.class.getResource("../view/registrationScreen.fxml"));
            viewReportsLoader.setLocation(MainFXApplication.class.getResource("../view/ViewReportsScreen.fxml"));
            viewMapLoader.setLocation(MainFXApplication.class.getResource("../view/mapview.fxml"));
            //load them in layouts
            AnchorPane applicationLayout = applicationLoader.load();
            BorderPane loginLayout = loginLoader.load();
            BorderPane mainLayout = mainLoader.load();
            GridPane registrationLayout = registrationLoader.load();
            AnchorPane viewReportsLayout = viewReportsLoader.load();
            BorderPane viewMapsLayout = viewMapLoader.load();

            // attach layout to the scene
            applicationScene = new Scene(applicationLayout);
            loginScene = new Scene(loginLayout);
            mainScene = new Scene(mainLayout);
            registrationScene = new Scene(registrationLayout);
            //waterSourceScene = new Scene(waterSourceLayout);
            viewReportsScene = new Scene(viewReportsLayout);
            mapScene = new Scene(viewMapsLayout);

            // Give the controller access to the main app.
            applicationController = applicationLoader.getController();
            LoginScreenController loginController = loginLoader.getController();
            MainScreenController mainController = mainLoader.getController();
            RegistrationScreenController registrationController = registrationLoader.getController();
            viewReportsController = viewReportsLoader.getController();
            mapController = viewMapLoader.getController();

            applicationController.setApp(this);
            loginController.setApp(this);
            mainController.setApp(this);
            registrationController.setApp(this);
            viewReportsController.setApp(this);
            mainController.setApp(this);
            mapController.setApp(this);


            setMainScene();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    /**
     * dummy method to simulate a callback from the map view
     */
    public void closeMapView() {
        Facade fc = Facade.getInstance();
        fc.addLocations();
        mapController.mapInitialized();
        stage.setScene(mapScene);
    }


}
