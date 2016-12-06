package controller;

import fxapp.MainFXApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.PersistenceManager;
import model.User;
import model.UserDatabase;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * controller for main screen
 */
@SuppressWarnings("ALL")
public class MainScreenController {
    private UserDatabase database;
    private MainFXApplication mainApplication;
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button load;

    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
    }

    /**
     * set scene to login scene
     */
    public void loginClicked() {
        mainApplication.setLoginScene();
    }

    /**
     * set scene to register scene
     */
    public void registerClicked() {
        mainApplication.setRegistrationScene();
    }

    /**
     * load file
     */
    public void loadClicked() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save JSON File");
        File file  = fc.showOpenDialog(mainApplication.getStage());
        List<User> uList;
        if (file != null) {
            PersistenceManager pm = new PersistenceManager(database.getUsers());
            try {
                uList = pm.loadUsersFromJson(file);
                for (User u : uList) {
                    database.add(u);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void linkClicked() {
        Stage stage = new Stage();
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        stage.setTitle("Where's My Water on Facebook");
        stage.setWidth(570);
        stage.setHeight(550);
        final Hyperlink hpl = new Hyperlink();
        hpl.setText("Like Us On Facebook!");
        final String url = "https://www.facebook.com/WhereMyWaterAt/?view_public_for=1675867439371914";
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        hpl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                webEngine.load(url);
            }
        });
        HBox hbox = new HBox();
        hbox.getChildren().addAll(hpl);

        vbox.getChildren().addAll(hbox, browser);
        VBox.setVgrow(browser, Priority.ALWAYS);

        stage.setScene(scene);
        stage.showAndWait();
    }


    public void link2Clicked() {
        Stage stage = new Stage();
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        stage.setTitle("Where's My Water Homepage");
        stage.setWidth(570);
        stage.setHeight(550);
        final Hyperlink hpl = new Hyperlink();
        hpl.setText("Check Out Our Website!");
        final String url = "http://www.wheresmywaterat.weebly.com";
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        hpl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                webEngine.load(url);
            }
        });
        HBox hbox = new HBox();
        hbox.getChildren().addAll(hpl);

        vbox.getChildren().addAll(hbox, browser);
        VBox.setVgrow(browser, Priority.ALWAYS);

        stage.setScene(scene);
        stage.showAndWait();
    }
}
