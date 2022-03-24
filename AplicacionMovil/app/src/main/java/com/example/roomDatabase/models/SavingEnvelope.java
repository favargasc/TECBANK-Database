package com.example.roomDatabase.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SavingEnvelope {

    @PrimaryKey(autoGenerate = true)
    Integer id;
    String name;
    Double current_balance;

    public SavingEnvelope(Integer id, String name, Double current_balance) {
        this.id = id;
        this.name = name;
        this.current_balance = current_balance;
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
