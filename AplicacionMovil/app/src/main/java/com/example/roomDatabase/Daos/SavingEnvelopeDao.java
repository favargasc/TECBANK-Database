package com.example.roomDatabase.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.SavingEnvelope;

import java.util.List;

@Dao
public interface SavingEnvelopeDao {

  @Insert (onConflict = OnConflictStrategy.REPLACE)
  Long insert(SavingEnvelope savingEnvelope);

  @Query("SELECT * FROM saving_envelope where account_id = :accountId")
  LiveData<List<SavingEnvelope>> getSavingEnvelopeByAccountId(int accountId);

  @Query("UPDATE saving_envelope SET current_balance = current_balance + :amount WHERE id = :savingEnvelopeId")
  void receiveMoney(int savingEnvelopeId, double amount);

  @Query("UPDATE saving_envelope SET current_balance = current_balance - :amount WHERE id = :savingEnvelopeId")
  void returnMoney(int savingEnvelopeId, double amount);

  @Query("DELETE FROM saving_envelope WHERE id = :savingEnvelopeId")
  void delete(int savingEnvelopeId);

  @Query("SELECT a.id, a.account_number, a.current_balance, a.user_id FROM saving_envelope se INNER JOIN account a ON a.id = se.account_id WHERE se.id = :savingEnvelopeId")
  LiveData<Account> getAccount(int savingEnvelopeId);

  @Query("select id, name, current_balance from saving_envelope where id = :savingEnvelopeId")
  LiveData<SavingEnvelope> getSavingEnvelope(int savingEnvelopeId);

  @Query("UPDATE account SET current_balance = current_balance - :amount WHERE id = :savingEnvelopeId")
  void reduceAccountCB(int savingEnvelopeId, double amount);

  @Query("UPDATE account SET current_balance = current_balance + :amount WHERE id = :savingEnvelopeId")
  void increaseAccountCB(int savingEnvelopeId, double amount);

  @Query("SELECT id FROM saving_envelope WHERE name = :savEnvName")
  LiveData<Integer> getSavingEnvelopeId(String savEnvName);

/*  @Query("INSERT INTO saving_envelope_log(amount, date, transaction_type_id) VALUES (:amount, :date, :transactionTypeId)")
  void saveInLog(double amount, String date, int transactionTypeId);
  */
}

