package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.SavingEnvelope;

import java.util.List;

/**
 * The interface Saving envelope dao.
 */
@Dao
public interface SavingEnvelopeDao {

    /**
     * Insert.
     *
     * @param savingEnvelope the saving envelope
     */
    @Insert
  void insert(SavingEnvelope savingEnvelope);

    /**
     * Gets saving envelope by account id.
     *
     * @param accountId the account id
     * @return the saving envelope by account id
     */
    @Query("SELECT * FROM saving_envelope where account_id = :accountId")
  LiveData<List<SavingEnvelope>> getSavingEnvelopeByAccountId(int accountId);

    /**
     * Receive money.
     *
     * @param savingEnvelopeId the saving envelope id
     * @param amount           the amount
     */
    @Query("UPDATE saving_envelope SET current_balance = current_balance + :amount WHERE id = :savingEnvelopeId")
  void receiveMoney(int savingEnvelopeId, double amount);

    /**
     * Return money.
     *
     * @param savingEnvelopeId the saving envelope id
     * @param amount           the amount
     */
    @Query("UPDATE saving_envelope SET current_balance = current_balance - :amount WHERE id = :savingEnvelopeId")
  void returnMoney(int savingEnvelopeId, double amount);

    /**
     * Delete.
     *
     * @param savingEnvelopeId the saving envelope id
     */
    @Query("DELETE FROM saving_envelope WHERE id = :savingEnvelopeId")
  void delete(int savingEnvelopeId);

    /**
     * Gets account.
     *
     * @param savingEnvelopeId the saving envelope id
     * @return the account
     */
    @Query("SELECT a.id, a.account_number, a.current_balance, a.user_id FROM saving_envelope se INNER JOIN account a ON a.id = se.account_id WHERE se.id = :savingEnvelopeId")
  LiveData<Account> getAccount(int savingEnvelopeId);

    /**
     * Gets saving envelope.
     *
     * @param savingEnvelopeId the saving envelope id
     * @return the saving envelope
     */
    @Query("select id, name, current_balance from saving_envelope where id = :savingEnvelopeId")
  LiveData<SavingEnvelope> getSavingEnvelope(int savingEnvelopeId);

    /**
     * Reduce account cb.
     *
     * @param savingEnvelopeId the saving envelope id
     * @param amount           the amount
     */
    @Query("UPDATE account SET current_balance = current_balance - :amount WHERE id = :savingEnvelopeId")
  void reduceAccountCB(int savingEnvelopeId, double amount);

    /**
     * Increase account cb.
     *
     * @param savingEnvelopeId the saving envelope id
     * @param amount           the amount
     */
    @Query("UPDATE account SET current_balance = current_balance + :amount WHERE id = :savingEnvelopeId")
  void increaseAccountCB(int savingEnvelopeId, double amount);

/*  @Query("INSERT INTO saving_envelope_log(amount, date, transaction_type_id) VALUES (:amount, :date, :transactionTypeId)")
  void saveInLog(double amount, String date, int transactionTypeId);
  */
}

