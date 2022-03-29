package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.Account;

import java.util.List;

/**
 * The interface Account dao.
 */
@Dao
public interface AccountDao {

    /**
     * Insert.
     *
     * @param account the account
     */
// Her goes the querys
    @Insert
    Long insert(Account account);

    /**
     * Gets all accounts.
     *
     * @return the all accounts
     */
    @Query("SELECT * FROM account")
    LiveData<List<Account>> getAllAccounts();

    /**
     * Gets account by user id.
     *
     * @param id the id
     * @return the account by user id
     */
    @Query("SELECT * FROM account WHERE user_id = :id")
    LiveData<List<Account>> getAccountByUserId(int id);

    @Query("SELECT * FROM account WHERE id = :id")
    LiveData<Account> getAccountById(int id);


}
