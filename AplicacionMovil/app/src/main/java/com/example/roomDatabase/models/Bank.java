package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "bank" , indices = {@Index(value = {"code"},unique = true)})
public class Bank {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "code")
    public String code;

    @Ignore
    public Bank(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Bank(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public String getCode() { return code; }

    public String to_String() {
        return "Bank{" +
                "id=" + id +
                ", name=" + name +
                ", code=" + code +
                '}';
    }

}
