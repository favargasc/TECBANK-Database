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
     * Insert long.
     *
     * @param user the user
     * @return the long
     */
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    Long insert(User user);

    /**
     * Gets verify user id.
     *
     * @param userName the user name
     * @param password the password
     * @return the verify user id
     */
    @Query("SELECT id FROM user u WHERE u.user_name = :userName AND u.password = :password")
    LiveData<Integer> getVerifyUserId(String userName, String password);

    /**
     * Gets user id.
     *
     * @param userName the user name
     * @return the user id
     */
    @Query("SELECT id FROM user u WHERE u.user_name = :userName")
    LiveData<Integer> getUserId(String userName);

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    @Query("SELECT * FROM user u WHERE u.id = :userId")
    LiveData<User> getUserById(int userId);
}