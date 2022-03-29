package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The type Transaction type.
 */
@Entity(tableName = "transaction_type" , indices = {@Index(value = {"name"},unique = true)})
public class TransactionType {

    /**
     * The Id.
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    /**
     * The Name.
     */
    @ColumnInfo(name = "name")
    String name;

    /**
     * Instantiates a new Transaction type.
     *
     * @param id   the id
     * @param name the name
     */
    @Ignore
    public TransactionType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Instantiates a new Transaction type.
     *
     * @param name the name
     */
    public TransactionType(String name) {
        this.name = name;
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To string java . lang . string.
     *
     * @return the java . lang . string
     */
    @java.lang.Override
    public java.lang.String toString() {
        return "Bank{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
