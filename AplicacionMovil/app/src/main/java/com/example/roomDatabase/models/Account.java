package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


/**
 * The type Account.
 */
@Entity(tableName = "account")
public class Account {

    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    public int id;

    /**
     * The Account number.
     */
    @ColumnInfo(name = "account_number")
    public String account_number;

    /**
     * The Current balance.
     */
    @ColumnInfo(name = "current_balance")
    public double current_balance;

    /**
     * The User id.
     */
    @ColumnInfo(name = "user_id")
    public int user_id;

    /**
     * Instantiates a new Account.
     *
     * @param id              the id
     * @param account_number  the account number
     * @param current_balance the current balance
     * @param user_id         the user id
     */
    @Ignore
    public Account(int id, String account_number, double current_balance, int user_id) {
        this.id = id;
        this.account_number = account_number;
        this.current_balance = current_balance;
        this.user_id = user_id;
    }

    /**
     * Instantiates a new Account.
     *
     * @param account_number  the account number
     * @param current_balance the current balance
     * @param user_id         the user id
     */
    public Account(String account_number, double current_balance, int user_id) {
        this.account_number = account_number;
        this.current_balance = current_balance;
        this.user_id = user_id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets account number.
     *
     * @return the account number
     */
    public String getAccount_number() {
        return account_number;
    }

    /**
     * Gets current balance.
     *
     * @return the current balance
     */
    public double getCurrent_balance() {
        return current_balance;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    public String to_String() {
        return "Account{" +
            "id=" + id +
            ", account_number=" + account_number +
            ", current_balance=" + current_balance +
            '}';
    }
}
