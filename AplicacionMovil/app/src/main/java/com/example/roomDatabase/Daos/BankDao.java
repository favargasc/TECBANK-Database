package com.example.roomDatabase.Daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomDatabase.models.Bank;

import java.util.List;

//Dao = database access object
//querys
@Dao
public interface BankDao {

    //Her goes the querys

    @Insert
    void insert(Bank bank);

    @Query("SELECT * FROM Bank")
    LiveData<List<Bank>> getAllBanks();

}
