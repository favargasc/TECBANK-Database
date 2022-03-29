package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.Proofpayment;
import com.example.roomDatabase.models.SavingEnvelope;

import java.util.List;

/**
 * The interface Proof of payment dao.
 */
@Dao
public interface proofOfPaymentDao {

    /**
     * Insert.
     *
     * @param proof the proof
     */
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Proofpayment proof);

    /**
     * Gets proofofpayment.
     *
     * @param id the id
     * @return the proofofpayment
     */
    @Query("select * from proof_of_payment where id = :id")
    LiveData<Proofpayment> getProofofpayment(int id);

    /**
     * Gets all proofofpayment.
     *
     * @param idCard the id card
     * @return the all proofofpayment
     */
    @Query("select * from proof_of_payment where id_card = :idCard")
    LiveData<List<Proofpayment>> getAllProofofpayment(int idCard);

}
