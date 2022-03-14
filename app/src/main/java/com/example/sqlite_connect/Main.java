package com.example.sqlite_connect;

import com.example.sqlite_connect.controllers.SavingEnvelopeController;
import com.example.sqlite_connect.models.SavingEnvelope;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SavingEnvelopeController seController = new SavingEnvelopeController();
        seController.receiveMoney(4, 1000.0);
    }
}

