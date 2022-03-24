package com.example.roomDatabase.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Location {

    @PrimaryKey(autoGenerate = true)
    Integer id;
    String coordinates, name, schedule;

    public Location(Integer id, String coordinates, String name, String schedule) {
        this.id = id;
        this.coordinates = coordinates;
        this.name = name;
        this.schedule = schedule;
    }

    public Integer getId() {
        return id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return schedule;
    }
}
