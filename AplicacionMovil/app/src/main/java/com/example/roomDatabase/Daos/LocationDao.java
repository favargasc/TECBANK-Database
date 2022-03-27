package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomDatabase.models.Location;
import com.example.roomDatabase.models.User;

import java.util.List;

@Dao
public interface LocationDao {
  @Insert
  void insert(Location location);

  @Query("SELECT * FROM location")
  LiveData<List<Location>> getLocations();
}
