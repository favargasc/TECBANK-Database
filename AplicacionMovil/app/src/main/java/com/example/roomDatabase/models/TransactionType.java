package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaction_type" , indices = {@Index(value = {"name"},unique = true)})
public class Bank {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "name")
    String name;

    @Ignore
    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Bank(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Bank{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
