package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.User;

public class WaterSourceReportScreenController {
    private MainFXApplication mainApplication;
    private User u;
    @FXML
    private Button submitReportButton;
    @FXML
    private Button cancelReportButton;
    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {

        mainApplication = main;
        //u = mainApplication.getActiveUser();
    }

    public void cancelClicked() {
        mainApplication.setApplicationScene(u);
    }

    public void submitClicked() {

    }


}
