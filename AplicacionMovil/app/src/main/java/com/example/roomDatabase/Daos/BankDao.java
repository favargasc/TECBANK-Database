package com.example.roomDatabase.Daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.Bank;

import java.util.List;

//Dao = database access object
//querys
@Dao
public interface BankDao {

    //Her goes the querys

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Bank bank);

    @Query("insert into bank (id, name, code) values (:id, :name, :code)")
    void insertWithId(int id, String name, String code);

    @Query("SELECT * FROM Bank")
    LiveData<List<Bank>> getAllBanks();

    @Query("SELECT * FROM bank where id = :bank_id")
    LiveData<Bank> getBankById(String bank_id);

}
