package com.example.roomDatabase.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The type User.
 */
@Entity(tableName = "user", indices = {@Index(value = {"user_name"},unique = true)})
public class User {

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
   * The Last name.
   */
  @ColumnInfo(name = "last_name")
  public String lastName;

  /**
   * The Password.
   */
  @ColumnInfo(name = "password")
  public String password;

  /**
   * The Email.
   */
  @ColumnInfo(name = "email")
  public String email;

  /**
   * The Bank id.
   */
  @ColumnInfo(name = "bank_id")
  public int bankId;

  /**
   * The User name.
   */
  @ColumnInfo(name = "user_name")
  public String userName;

  /**
   * Instantiates a new User.
   *
   * @param id       the id
   * @param name     the name
   * @param lastName the last name
   * @param password the password
   * @param email    the email
   * @param bankId   the bank id
   * @param userName the user name
   */
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

  /**
   * Instantiates a new User.
   *
   * @param email    the email
   * @param password the password
   * @param name     the name
   * @param lastName the last name
   * @param userName the user name
   */
  public User(String email, String password, String name, String lastName, String userName) {
    this.name = name;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    this.bankId = 1;
    this.userName = userName;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public int getId() {
    return this.id;
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
    return this.name;
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
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets bank id.
   *
   * @return the bank id
   */
  public int getBankId() {
    return this.bankId;
  }

  /**
   * Sets bank id.
   *
   * @param bankId the bank id
   */
  public void setBankId(int bankId) {
    this.bankId = bankId;
  }

  /**
   * To string string.
   *
   * @return the string
   */
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
