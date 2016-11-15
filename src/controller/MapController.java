package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.*;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


@SuppressWarnings("ALL")
public class MapController implements Initializable, MapComponentInitializedListener {
    @FXML
    private GoogleMapView mapView;
    private GoogleMap map;
    private MainFXApplication mainApplication;

    @FXML
    public void setApp(MainFXApplication main) {
        mainApplication = main;
        //UserDatabase database = mainApplication.getUsers();

    }

    /**
     * method for when the back button is clicked
     */
    public void backClicked() {

        mainApplication.setViewReportsScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }

// --Commented out by Inspection START (11/14/2016 10:02 PM):
//    /**
//     *
//     * @param app main app
//     */
//    public void setCallbacks(MainFXApplication app) {
//        mainApplication = app;
//    }
// --Commented out by Inspection STOP (11/14/2016 10:02 PM)


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
        System.out.println("PlaceMarkers");
        if (locations != null && locations.get(0) != null) {
            System.out.println(locations.get(0));
        }
        //        Facade fc = Facade.getInstance();
//        ReportsDatabase rD = ReportsDatabase.getInstance();
//        List<Location> locations = rDatabase.getLocations();

//        List<String> locationStrings = new ArrayList<>();
//        for (Report r : rDatabase.getReports()) {
//            locationStrings.add(r.getLocation());
//        }

//        List<Location> locations = new ArrayList<>();
//        for (String s : locationStrings) {
//            try {
//                locations.add(Location.makeFromFileString(s));
//            } catch (FileFormatException e) {
//                e.printStackTrace();
//            }
//        }

        assert locations != null;
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
//    @FXML
//    public void onCloseMenu() {
//        mainApplication.closeMapView();
//    }

}
