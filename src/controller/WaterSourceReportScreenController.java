package controller;

import fxapp.MainFXApplication;
import javafx.scene.input.MouseEvent;

/**
 * Created by David on 10/19/2016.
 */
public class WaterSourceReportScreenController {
    private MainFXApplication mainApplication;
    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
    }

    public void cancelClicked() {
        mainApplication.setMainScene();
    }

    public void submitClicked() {
    }


}
