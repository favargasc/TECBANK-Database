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
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", coordinates='" + getCoordinates() + "'" +
                ", name='" + getName() + "'" +
                ", schedule='" + getSchedule() + "'" +
                "}";
    }

}
