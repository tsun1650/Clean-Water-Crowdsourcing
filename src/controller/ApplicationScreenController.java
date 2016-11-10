package controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;

/**
 * Controller class for application screen
 */
public class ApplicationScreenController {
    private MainFXApplication mainApplication;
    private User u;
    @FXML
    private Button logoutButton;
    @FXML
    private Button reportButton;
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
    @FXML
    private ComboBox<WaterType> waterTypeComboBox = new ComboBox<>();
    @FXML
    private ComboBox<Condition> conditionComboBox = new ComboBox<>();
    @FXML
    private ComboBox<PurityCondition> purityConditionComboBox = new ComboBox<>();
    @FXML
    private ComboBox<VirusvContaminant> ppmTypeComboBox = new ComboBox<>();

    private UserDatabase database;
    private ReportsDatabase rDatabase;
    private int reportNumber = 0;



    /**
     * Ties controller to main app
     * @param main main app
     */
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
        rDatabase = mainApplication.getReports();

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
     * Decides whether to create a new type of report or view reports
     */
    public void report() {
        u = database.getActiveUser();
        List<String> options = new ArrayList<>();
        options.add("View Reports");
        options.add("View Historical Reports");
        options.add("Submit Water Source Report");
        options.add("Submit Historical Report");
        options.add("Submit Purity Report");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("View Reports", options);
        dialog.setTitle("Report");
        dialog.setHeaderText("Report Options");
        dialog.setContentText("Choose your Report");


        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            /*
             *copy edit profile dialog stuff, but with correct fields depending on result
             *
             */

            if (result.get().equals("View Reports")) {
                mainApplication.setViewReportsScene();
            }

            if (result.get().equals("View Historical Reports")) {
                mainApplication.setViewHistScene();
            }

            if (result.get().equals("Submit Water Source Report")) {

                //create pop up dialog
                Dialog<ArrayList> dialog2 = new Dialog<>();
                dialog2.setTitle("Reports");
                dialog2.setHeaderText("Submit Report");
                dialog2.setResizable(true);
                //add fields
                Label dateTime = new Label("Date & Time");
                Label waterLocation = new Label("Water Location");
                Label waterType = new Label("Type of Water");
                Label waterCondition = new Label("Water Condition");
                //Label reportNumber = new Label(reportNumber + "");
                TextField locationField = new TextField("00.000, 00.000");

                TextField dateTimeField = new TextField("MM/dd/yy HH:mm:ss");
                ObservableList<WaterType> wTypeList = FXCollections.observableArrayList(WaterType.values());
                waterTypeComboBox.setItems(FXCollections.observableArrayList(WaterType.values()));
                ObservableList<Condition> conditionList = FXCollections.observableArrayList(Condition.values());
                conditionComboBox.setItems(FXCollections.observableArrayList(Condition.values()));

                //add it to gridpane
                GridPane grid = new GridPane();
                //column,row
                grid.add(waterType, 1, 1);
                grid.add(waterTypeComboBox, 2, 1);
                grid.add(waterCondition, 1, 2);
                grid.add(conditionComboBox, 2, 2);
                grid.add(waterLocation, 1, 3);
                grid.add(locationField, 2, 3);
                //grid.add(reportNumber, 1, 4);
                //grid.add(text4, 2, 4);
                grid.add(dateTime, 1, 0);
                grid.add(dateTimeField, 2, 0);
                //put it all in
                dialog2.getDialogPane().setContent(grid);
                //Button Listener to take in Strings
                ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                dialog2.getDialogPane().getButtonTypes().add(buttonTypeOk);

                dialog2.setResultConverter(new Callback<ButtonType, ArrayList>() {
                    @Override
                    public ArrayList call(ButtonType b) {
                        //set new profile items
                        if (b == buttonTypeOk) {
                            String date;
                            if(dateTimeField.getText().equals("MM/dd/yy HH:mm:ss")){
                                DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
                                Date dateobj = new Date();
                                date = df.format(dateobj);
                            } else {
                                date = dateTimeField.getText();
                                System.out.print("default");
                            }
                            Condition c = conditionComboBox.getSelectionModel().getSelectedItem();
                            WaterType t = waterTypeComboBox.getSelectionModel().getSelectedItem();
                            WaterSourceReport r = new WaterSourceReport(date,locationField.getText(),u.getFirstName()+ " " + u.getLastName(), t, c);
                            rDatabase.add(r);
                            System.out.println(r);
                        }

                        return null;
                    }
                });
                dialog2.showAndWait();


            }
            if (result.get().equals("Submit Purity Report")) {
                //create pop up dialog
                Dialog<ArrayList> dialog3 = new Dialog<>();
                dialog3.setTitle("Reports");
                dialog3.setHeaderText("Submit Report");
                dialog3.setResizable(true);
                //add fields
                Label dateTime = new Label("Date & Time");
                Label waterLocation = new Label("Water Location");
                Label virusPPM = new Label("Virus PPM");
                Label contaminantPPM = new Label("Contaminant PPM");

                Label purityCond = new Label("Purity Condition");
                TextField locationField = new TextField("");
                TextField dateTimeField = new TextField("MM/dd/yy HH:mm:ss");

                TextField virusField = new TextField("0.0");
                TextField contaminantField = new TextField("0.0");
                purityConditionComboBox.setItems(FXCollections.observableArrayList(PurityCondition.values()));


                //add it to gridpane
                GridPane grid = new GridPane();
                //column,row
                grid.add(virusPPM, 1, 1);
                grid.add(virusField, 2, 1);
                grid.add(contaminantPPM, 1, 2);
                grid.add(contaminantField, 2, 2);
                grid.add(waterLocation, 1, 3);
                grid.add(locationField, 2, 3);
                grid.add(dateTime, 1, 0);
                grid.add(dateTimeField, 2, 0);
                grid.add(purityCond, 1, 4);
                grid.add(purityConditionComboBox, 2, 4);

                //put it all in
                dialog3.getDialogPane().setContent(grid);
                //Button Listener to take in Strings
                ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                dialog3.getDialogPane().getButtonTypes().add(buttonTypeOk);

                dialog3.setResultConverter(new Callback<ButtonType, ArrayList>() {
                    @Override
                    public ArrayList call(ButtonType b) {
                        //set new profile items
                        if (b == buttonTypeOk) {
                            String date;
                            if (dateTimeField.getText().equals("MM/dd/yy HH:mm:ss")){
                                DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
                                Date dateobj = new Date();
                                date = df.format(dateobj);
                            } else {
                                date = dateTimeField.getText();
                                System.out.print("default");
                            }

                            ObservableList<PurityCondition> vcTypeList = FXCollections.observableArrayList(PurityCondition.values());
                            PurityCondition c = purityConditionComboBox.getSelectionModel().getSelectedItem();
                            WaterPurityReport r = new WaterPurityReport(date,u.getFirstName()+ " " + u.getLastName(),
                                    locationField.getText(), c, Double.parseDouble(virusField.getText()),
                                    Double.parseDouble(contaminantField.getText()));


                            rDatabase.add(r);
                            System.out.println(r);
                        }

                        return null;
                    }
                });
                dialog3.showAndWait();


            }
            if (result.get().equals("Submit Historical Report")) {
                //create pop up dialog
                Dialog<ArrayList> dialog4 = new Dialog<>();
                dialog4.setTitle("Reports");
                dialog4.setHeaderText("Submit Report");
                dialog4.setResizable(true);
                //add fields
                Label waterLocation = new Label("Water Location");
                Label which = new Label("Impurity");
                Label yearLabel = new Label("Year");
                TextField locationField = new TextField();
                //ArrayList<String> ppmtypes = new ArrayList<String>();
                TextField year = new TextField();

                //ppmtypes.add("Virus");
                //ppmtypes.add("Contaminant");
                ppmTypeComboBox.setItems(FXCollections.observableArrayList(VirusvContaminant.values()));


                //add it to gridpane
                GridPane grid = new GridPane();
                //column,row
                grid.add(waterLocation, 1, 1);
                grid.add(which, 1, 2);
                grid.add(locationField, 2, 1);
                grid.add(ppmTypeComboBox, 2, 2);
                grid.add(yearLabel, 1, 3);
                grid.add(year, 2, 3);



                //put it all in
                dialog4.getDialogPane().setContent(grid);
                //Button Listener to take in Strings
                ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                dialog4.getDialogPane().getButtonTypes().add(buttonTypeOk);

                dialog4.setResultConverter(new Callback<ButtonType, ArrayList>() {
                    @Override
                    public ArrayList call(ButtonType b) {
                        //set new profile items
                        if (b == buttonTypeOk) {
                            Integer y = Integer.parseInt(year.getText());
                            ObservableList<VirusvContaminant> conditionList = FXCollections.observableArrayList(VirusvContaminant.values());
                            VirusvContaminant c = ppmTypeComboBox.getSelectionModel().getSelectedItem();
                            HistoricalReport r = new HistoricalReport(locationField.getText(), c.toString(), y);
                            //ArrayList<Report> hReports = rDatabase.getReportYears(y);
                            rDatabase.add(r);
                            System.out.println(r);
                        }

                        return null;
                    }
                });
                dialog4.showAndWait();


            }

        } else {
            System.out.println("nothing done");
        }


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
