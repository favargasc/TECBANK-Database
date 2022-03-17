package com.example.sqlite_connect;

import com.example.sqlite_connect.controllers.AccountController;
import com.example.sqlite_connect.controllers.SavingEnvelopeController;
import org.apache.commons.lang3.RandomStringUtils;
import com.example.sqlite_connect.utilities.Email;
import com.example.sqlite_connect.controllers.UserController;

public class Main {
    public static void main(String[] args) {
        AccountController aController = new AccountController();
        boolean res = aController.externalTransfer(
            "6379570178296713",
            "6331100655042047349",
            "117890261",
            "Envio de dinero",
            5000,
            2000,
            3
        );
        System.out.println(res);
    }
}