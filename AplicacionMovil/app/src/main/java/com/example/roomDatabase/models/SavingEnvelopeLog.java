package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * The type Saving envelope log.
 */
@Entity(tableName = "saving_envelope_log")
public class SavingEnvelopeLog {

    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    Integer id;
    /**
     * The Amount.
     */
    @ColumnInfo(name = "name")
    Double amount;
    /**
     * The Date.
     */
    @ColumnInfo(name = "current_balance")
    String date;
    /**
     * The Transaction type id.
     */
    @ColumnInfo(name = "account_id")
    Integer transaction_type_id;

    /**
     * Instantiates a new Saving envelope log.
     *
     * @param id                  the id
     * @param amount              the amount
     * @param date                the date
     * @param transaction_type_id the transaction type id
     */
    @Ignore
    public SavingEnvelopeLog(Integer id, Double amount, String date, Integer transaction_type_id) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.transaction_type_id = transaction_type_id;
    }

    /**
     * Instantiates a new Saving envelope log.
     *
     * @param amount              the amount
     * @param date                the date
     * @param transaction_type_id the transaction type id
     */
    public SavingEnvelopeLog(Double amount, String date, Integer transaction_type_id) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.transaction_type_id = transaction_type_id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets transaction type id.
     *
     * @return the transaction type id
     */
    public Integer getTransaction_type_id() {
        return transaction_type_id;
    }

    /**
     * To string java . lang . string.
     *
     * @return the java . lang . string
     */
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