package controller;

import java.util.ArrayList;
import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.HistoricalReport;
import model.ReportsDatabase;
import model.User;
import model.UserDatabase;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.Scene;

import java.util.List;

/**
 * Created by Kate on 11/10/2016.
 */
public class GraphController {

    private MainFXApplication mainApplication;
    private User u;
    private UserDatabase database;
    private ReportsDatabase rDatabase;
    private List<HistoricalReport> reportList;
    private boolean virusPPM;
    private boolean contaminantPPM;
    @FXML
    private ListView<String> listReports;

    @FXML private ScatterChart<Number, Number> historyChart;
    public GraphController(List<HistoricalReport> reportList, boolean virusPPM, boolean contaminantPPM) {
        this.reportList = reportList;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
    }

    @FXML
    public void initialize() {

        //final NumberAxis xAxis = new NumberAxis(0, 100, 10);
        //final NumberAxis yAxis = new NumberAxis(0, 12, 1);
        //historyChart = new ScatterChart<>(xAxis, yAxis);
        //xAxis.setLabel("PPM");
        //yAxis.setLabel("Month");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (HistoricalReport report : reportList) {
            series.getData().add(new XYChart.Data<>(report.getContaminantPPM
                    (), report.getYear()));
        }
        //historyChart.getData().add(series);
        List<XYChart.Series<Number, Number>> seriesList = new ArrayList<>();
        seriesList.add(series);
        historyChart.getData().add(series);
        //historyChart.setData(FXCollections.observableArrayList(seriesList));
        historyChart.getXAxis().setLabel("PPM");
        historyChart.getYAxis().setLabel("Month");

    }

    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
        rDatabase = mainApplication.getReports();
    }

    public void backClicked() {
        u = database.getActiveUser();
        mainApplication.setApplicationScene(u);
    }
}

