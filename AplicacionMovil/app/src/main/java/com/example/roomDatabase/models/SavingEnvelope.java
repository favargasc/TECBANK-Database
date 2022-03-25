package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "saving_envelope")
public class SavingEnvelope {

    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "current_balance")
    Double current_balance;
    @ColumnInfo(name = "account_id")
    Integer account_id;

    @Ignore
    public SavingEnvelope(Integer id, String name, Double current_balance, Integer account_id) {
        this.id = id;
        this.name = name;
        this.current_balance = current_balance;
        this.account_id = account_id;
    }

    public SavingEnvelope(String name, Double current_balance, Integer account_id) {
        this.name = name;
        this.current_balance = current_balance;
        this.account_id = account_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCurrent_balance() {
        return current_balance;
    }
}
