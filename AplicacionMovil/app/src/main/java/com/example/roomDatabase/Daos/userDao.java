package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.roomDatabase.models.User;

import java.util.List;

@Dao
public interface UserDao {

  @Insert
  void insert(User user);

  @Query("SELECT id FROM user u WHERE u.user_name = :userName AND u.password = :password")
  LiveData<Integer> getUserId(int userName, String password);
}