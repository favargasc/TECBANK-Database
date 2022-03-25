package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "saving_envelope_log")
public class SavingEnvelopeLog {

    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "name")
    Double amount;
    @ColumnInfo(name = "current_balance")
    String date;
    @ColumnInfo(name = "account_id")
    Integer transaction_type_id;

    @Ignore
    public SavingEnvelopeLog(Integer id, Double amount, String date, Integer transaction_type_id) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.transaction_type_id = transaction_type_id;
    }

    public SavingEnvelopeLog(Double amount, String date, Integer transaction_type_id) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.transaction_type_id = transaction_type_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Integer getTransaction_type_id() {
        return transaction_type_id;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SavingEnvelopeLog{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", transaction_type_id=" + transaction_type_id +
                '}';
    }
}