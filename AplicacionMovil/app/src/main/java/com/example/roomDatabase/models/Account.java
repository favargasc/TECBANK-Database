package com.example.roomDatabase.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "account")
public class Account {

    @PrimaryKey(autoGenerate = true)
    int id;
    String account_number;
    double current_balance;

    @Ignore
    public Account(int id, String account_number, double current_balance) {
        this.id = id;
        this.account_number = account_number;
        this.current_balance = current_balance;
    }

    public Account(String account_number, double current_balance) {
        this.account_number = account_number;
        this.current_balance = current_balance;
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
