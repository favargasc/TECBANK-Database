package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomDatabase.models.Location;
import com.example.roomDatabase.models.User;

import java.util.List;

/**
 * The interface Location dao.
 */
@Dao
public interface LocationDao {
    /**
     * Insert.
     *
     * @param location the location
     */
    @Insert
  void insert(Location location);

    /**
     * Gets locations.
     *
     * @return the locations
     */
    @Query("SELECT * FROM location")
  LiveData<List<Location>> getLocations();
}
