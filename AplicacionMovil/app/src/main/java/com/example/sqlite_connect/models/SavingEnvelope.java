package com.example.sqlite_connect.models;

public class SavingEnvelope {
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
