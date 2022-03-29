package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * The type Saving envelope.
 */
@Entity(tableName = "saving_envelope")
public class SavingEnvelope {

    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    public Integer id;
    /**
     * The Name.
     */
    @ColumnInfo(name = "name")
    public String name;
    /**
     * The Current balance.
     */
    @ColumnInfo(name = "current_balance")
    public Double current_balance;
    /**
     * The Account id.
     */
    @ColumnInfo(name = "account_id")
    public Integer account_id;

    /**
     * Instantiates a new Saving envelope.
     *
     * @param id              the id
     * @param name            the name
     * @param current_balance the current balance
     * @param account_id      the account id
     */
    @Ignore
    public SavingEnvelope(Integer id, String name, Double current_balance, Integer account_id) {
        this.id = id;
        this.name = name;
        this.current_balance = current_balance;
        this.account_id = account_id;
    }

    /**
     * Instantiates a new Saving envelope.
     *
     * @param name            the name
     * @param current_balance the current balance
     * @param account_id      the account id
     */
    public SavingEnvelope(String name, Double current_balance, Integer account_id) {
        this.name = name;
        this.current_balance = current_balance;
        this.account_id = account_id;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets current balance.
     *
     * @return the current balance
     */
    public Double getCurrent_balance() {
        return current_balance;
    }
}
