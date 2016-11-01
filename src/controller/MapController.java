package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.*;
import netscape.javascript.JSObject;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import model.ReportsDatabase;
import model.User;
import model.UserDatabase;


public class MapController implements Initializable, MapComponentInitializedListener {
    @FXML
    private GoogleMapView mapView;
    private GoogleMap map;
    private Window mainStage;
    private MainFXApplication mainApplication;
    private UserDatabase database;
    private ReportsDatabase rDatabase;
    private User u;
    @FXML
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        database = mainApplication.getUsers();
        rDatabase = mainApplication.getReports();
    }

    /**
     * method for when the back button is clicked
     */
    public void backClicked() {
        u = database.getActiveUser();
        mainApplication.setViewReportsScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }

    /**
     *
     * @param stage main stage
     * @param app main app
     */
    public void setCallbacks(Window stage, MainFXApplication app) {
        mainStage = stage;
        mainApplication = app;
    }


    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        //set up the center location for the map
        LatLong center = new LatLong(34, -88);

        options.center(center)
                .zoom(9)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);

        map = mapView.createMap(options);

    }

    /**
     * Method that places markers on the map
     * @param locations the list of locations that have been added to the rdatabase
     */
    public void placeMarkers(List<Location> locations) {
        /** now we communciate with the model to get all the locations for markers */
        Facade fc = Facade.getInstance();
        ReportsDatabase rD = ReportsDatabase.getInstance();
//        List<Location> locations = rDatabase.getLocations();

        List<String> locationStrings = new ArrayList<>();
        for (Report r : rDatabase.getReports()) {
            locationStrings.add(r.getLocation());
        }

//        List<Location> locations = new ArrayList<>();
//        for (String s : locationStrings) {
//            try {
//                locations.add(Location.makeFromFileString(s));
//            } catch (FileFormatException e) {
//                e.printStackTrace();
//            }
//        }

        for (Location l: locations) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong loc = new LatLong(l.getLatitude(), l.getLongitude());

            markerOptions.position(loc)
                    .visible(Boolean.TRUE)
                    .title(l.getTitle());

            Marker marker = new Marker(markerOptions);

            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                        infoWindowOptions.content(l.getDescription());

                        InfoWindow window = new InfoWindow(infoWindowOptions);
                        window.open(map, marker);
                    });

            map.addMarker(marker);
        }
    }
    @FXML
    public void onCloseMenu() {
        mainApplication.closeMapView();
    }

}
