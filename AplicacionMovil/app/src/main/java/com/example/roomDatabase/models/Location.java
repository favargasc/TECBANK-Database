package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * The type Location.
 */
@Entity(tableName = "location")
public class Location {

    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    public Integer id;
    /**
     * The Coordinates.
     */
    public String coordinates, /**
     * The Name.
     */
    name, /**
     * The Schedule.
     */
    schedule;

    /**
     * Instantiates a new Location.
     *
     * @param id          the id
     * @param coordinates the coordinates
     * @param name        the name
     * @param schedule    the schedule
     */
    @Ignore
    public Location(Integer id, String coordinates, String name, String schedule) {
        this.id = id;
        this.coordinates = coordinates;
        this.name = name;
        this.schedule = schedule;
    }

    /**
     * Instantiates a new Location.
     *
     * @param coordinates the coordinates
     * @param name        the name
     * @param schedule    the schedule
     */
    public Location(String coordinates, String name, String schedule) {
        this.coordinates = coordinates;
        this.name = name;
        this.schedule = schedule;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public String getCoordinates() {
        return this.coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets schedule.
     *
     * @return the schedule
     */
    public String getSchedule() {
        return this.schedule;
    }

    /**
     * Sets schedule.
     *
     * @param schedule the schedule
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * To string string.
     *
     * @return the string
     */
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
