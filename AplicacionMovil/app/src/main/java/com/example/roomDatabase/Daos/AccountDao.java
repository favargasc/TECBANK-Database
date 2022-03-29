package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomDatabase.models.Account;

import java.util.List;

/**
 * The interface Account dao.
 */
@Dao
public interface AccountDao {

    // Her goes the querys

    /**
     * Insert.
     *
     * @param account the account
     */
    @Insert
    void insert(Account account);

    /**
     * Gets all banks.
     *
     * @return the all banks
     */
    @Query("SELECT * FROM account")
    LiveData<List<Account>> getAllBanks();

}
