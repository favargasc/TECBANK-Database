package com.example.sqlite_connect;

import com.example.sqlite_connect.controllers.SavingEnvelopeController;
import org.apache.commons.lang3.RandomStringUtils;
import com.example.sqlite_connect.utilities.Email;

public class Main {
    public static void main(String[] args) {
        //SavingEnvelopeController seController = new SavingEnvelopeController();

        // ANTES DE METER LOS DATOS HABILITEN LA AUTH
        //https://myaccount.google.com/lesssecureapps
        //https://accounts.google.com/b/0/DisplayUnlockCaptcha
        Email email = new Email(
            "",
            "",
            "",
            "TECBANK Código de autenticación",
            RandomStringUtils.randomAlphanumeric(20)
        );
        email.send();
    }
}