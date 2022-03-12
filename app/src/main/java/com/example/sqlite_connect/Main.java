package com.example.sqlite_connect;

import com.example.sqlite_connect.controllers.LocationController;
import com.example.sqlite_connect.models.Location;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocationController locationController = new LocationController();
        ArrayList<Location> locations = locationController.getLocations();

        for (int i = 0; i < locations.size(); i++) {
            System.out.println(locations.get(i).getCoordinates());
        }

    }
}
