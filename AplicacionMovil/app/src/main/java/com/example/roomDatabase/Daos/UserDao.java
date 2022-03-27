package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.User;


@Dao
public interface UserDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("SELECT id FROM user u WHERE u.user_name = :userName AND u.password = :password")
    LiveData<Integer> getUserId(String userName, String password);
}