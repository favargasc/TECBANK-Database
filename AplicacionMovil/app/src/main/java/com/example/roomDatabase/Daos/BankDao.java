package com.example.roomDatabase.Daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.Bank;

import java.util.List;

/**
 * The interface Bank dao.
 */
//Dao = database access object
//querys
@Dao
public interface BankDao {

    //Her goes the querys

    /**
     * Insert.
     *
     * @param bank the bank
     */
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Bank bank);

    /**
     * Insert with id.
     *
     * @param id   the id
     * @param name the name
     * @param code the code
     */
    @Query("insert into bank (id, name, code) values (:id, :name, :code)")
    void insertWithId(int id, String name, String code);

    /**
     * Gets all banks.
     *
     * @return the all banks
     */
    @Query("SELECT * FROM Bank")
    LiveData<List<Bank>> getAllBanks();

    /**
     * Gets bank by id.
     *
     * @param bank_id the bank id
     * @return the bank by id
     */
    @Query("SELECT * FROM bank where id = :bank_id")
    LiveData<Bank> getBankById(String bank_id);

}
