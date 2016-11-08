package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.User;

/**
 * Created by Kate on 11/8/2016.
 */
public class HistoricalReportController {

    private MainFXApplication mainApplication;
    private User u;
    @FXML
    private Button submitHReportButton;
    @FXML
    private Button cancelHReportButton;

    public void setApp(MainFXApplication main) {

        mainApplication = main;
    }

    public void cancelClicked() {
        mainApplication.setApplicationScene(u);
    }

}
