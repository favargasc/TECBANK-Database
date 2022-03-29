package com.example.utilities;

import android.app.Application;

import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.User;

public class globalUserData extends Application {

    private int accountId;
    private int userId;
    private User user;
    private Account account;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static globalUserData getInstance() {
        return ourInstance;
    }

    private static final globalUserData ourInstance = new globalUserData();
}
