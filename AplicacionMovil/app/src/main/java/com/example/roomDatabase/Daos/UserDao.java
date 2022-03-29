package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.User;


/**
 * The interface User dao.
 */
@Dao
public interface UserDao {

    /**
     * Insert.
     *
     * @param user the user
     */
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    /**
     * Gets user id.
     *
     * @param userName the user name
     * @param password the password
     * @return the user id
     */
    @Query("SELECT id FROM user u WHERE u.user_name = :userName AND u.password = :password")
    LiveData<Integer> getUserId(int userName, String password);
}