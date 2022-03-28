package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.Account;

import java.util.List;

@Dao
public interface AccountDao {

    // Her goes the querys
    @Insert
    void insert(Account account);

    @Query("SELECT * FROM account")
    LiveData<List<Account>> getAllAccounts();

    @Query("SELECT * FROM account WHERE user_id = :id")
    LiveData<List<Account>> getAccountByUserId(int id);

}
