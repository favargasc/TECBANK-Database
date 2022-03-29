package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The type Bank.
 */
@Entity(tableName = "bank" , indices = {@Index(value = {"code"},unique = true)})
public class Bank {
    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    /**
     * The Name.
     */
    @ColumnInfo(name = "name")
    public String name;

    /**
     * The Code.
     */
    @ColumnInfo(name = "code")
    public String code;

    /**
     * Instantiates a new Bank.
     *
     * @param id   the id
     * @param name the name
     * @param code the code
     */
    @Ignore
    public Bank(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    /**
     * Instantiates a new Bank.
     *
     * @param name the name
     * @param code the code
     */
    public Bank(String name, String code) {
        this.name = name;
        this.code = code;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() { return code; }

    /**
     * To string string.
     *
     * @return the string
     */
    public String to_String() {
        return "Bank{" +
                "id=" + id +
                ", name=" + name +
                ", code=" + code +
                '}';
    }

}
