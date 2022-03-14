package com.example.sqlite_connect;

import com.example.sqlite_connect.controllers.SavingEnvelopeController;

public class Main {
    public static void main(String[] args) {
        SavingEnvelopeController seController = new SavingEnvelopeController();
        seController.returnMoney(4, 1000);
    }
}