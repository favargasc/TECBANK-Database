package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomDatabase.models.SavingEnvelope;

import java.util.List;

@Dao
public interface SavingEnvelopeDao {

  @Insert
  void insert(SavingEnvelope savingEnvelope);

  @Query("SELECT * FROM saving_envelope where account_id = :accountId")
  LiveData<Integer> getSavingEnvelopeByAccountId(int accountId);

  @Query("UPDATE saving_envelope SET current_balance = current_balance + :amount WHERE id = :savingEnvelopeId")
  LiveData<Boolean> receiveMoney(int savingEnvelopeId, double amount);

  @Query("UPDATE saving_envelope SET current_balance = current_balance - :amount WHERE id = :savingEnvelopeId")
  LiveData<Boolean> returnMoney(int savingEnvelopeId, double amount);

  @Query("DELETE FROM saving_envelope WHERE id = :savingEnvelopeId")
  LiveData<Boolean> delete(int savingEnvelopeId);

  @Query("SELECT a.id, a.account_number, a.current_balance FROM saving_envelope se INNER JOIN account a ON a.id = se.account_id WHERE se.id = :savingEnvelopeId")
  LiveData<Boolean> getAccount(int savingEnvelopeId);

  @Query("select id, name, current_balance from saving_envelope where id = :savingEnvelopeId")
  LiveData<Boolean> getSavingEnvelope(int savingEnvelopeId);

  @Query("UPDATE account SET current_balance = current_balance - :amount WHERE id = :savingEnvelopeId")
  LiveData<Boolean> reduceAccountCB(int savingEnvelopeId, double amount);

  @Query("UPDATE account SET current_balance = current_balance + :amount WHERE id = :savingEnvelopeId")
  LiveData<Boolean> increaseAccountCB(int savingEnvelopeId, double amount);

  @Query("INSERT INTO saving_envelope_log (amount, date, transaction_type_id) VALUES (:amount, :date, :transactionTypeId)")
  LiveData<Boolean> saveInLog(double amount, String date, int transactionTypeId);
}
