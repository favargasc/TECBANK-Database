package com.example.sqlite_connect.models;

public class Bank {
    int id;
    String name;
    double code;

    public Bank(int id, String name, double code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public double getCode() { return code; }

    public String to_String() {
        return "Bank{" +
                "id=" + id +
                ", name=" + name +
                ", code=" + code +
                '}';
    }

}
