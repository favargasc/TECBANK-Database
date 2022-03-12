package com.example.sqlite_connect.models;

public class User {
    private final Integer id;
    private final String email, password, name, last_name, user_name;

    public User(Integer id, String email, String password, String name, String last_name, String user_name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.user_name = user_name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String to_String() {
        return "User{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", user_name='" + user_name + '\'' +
            '}';
    }
}
