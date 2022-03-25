package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user", indices = {@Index(value = {"user_name"},unique = true)})
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  public int id;

  @ColumnInfo(name = "name")
  public String name;

  @ColumnInfo(name = "last_name")
  public String lastName;

  @ColumnInfo(name = "password")
  public String password;

  @ColumnInfo(name = "email")
  public String email;

  @ColumnInfo(name = "bank_id")
  public int bankId;

  @ColumnInfo(name = "user_name")
  public String userName;

  @Ignore
  public User(int id, String name, String lastName, String password, String email, int bankId, String userName) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    this.bankId = bankId;
    this.userName = userName;
  }

  public User(String email, String password, String name, String lastName, String userName) {
    this.name = name;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    this.bankId = 1;
    this.userName = userName;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getBankId() {
    return this.bankId;
  }

  public void setBankId(int bankId) {
    this.bankId = bankId;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        ", lastName='" + getLastName() + "'" +
        ", password='" + getPassword() + "'" +
        ", email='" + getEmail() + "'" +
        ", bankId='" + getBankId() + "'" +
        "}";
  }

}
