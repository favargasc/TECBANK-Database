package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "account")
public class Account {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "account_number")
    public String account_number;

    @ColumnInfo(name = "current_balance")
    public double current_balance;

    @ColumnInfo(name = "user_id")
    public int user_id;

    @Ignore
    public Account(int id, String account_number, double current_balance, int user_id) {
        this.id = id;
        this.account_number = account_number;
        this.current_balance = current_balance;
        this.user_id = user_id;
    }

    public Account(String account_number, double current_balance, int user_id) {
        this.account_number = account_number;
        this.current_balance = current_balance;
        this.user_id = user_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public double getCurrent_balance() {
        return current_balance;
    }

    public String to_String() {
        return "Account{" +
            "id=" + id +
            ", account_number=" + account_number +
            ", current_balance=" + current_balance +
            '}';
    }
}
