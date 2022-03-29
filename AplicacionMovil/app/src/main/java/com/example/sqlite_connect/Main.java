package com.example.sqlite_connect;

import com.example.sqlite_connect.controllers.SavingEnvelopeController;
import org.apache.commons.lang3.RandomStringUtils;
import com.example.sqlite_connect.utilities.Email;
import com.example.sqlite_connect.controllers.UserController;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SavingEnvelopeController seController = new SavingEnvelopeController();

        UserController uController = new UserController();

        int res = uController.getUserId("htitchmarshj", "4XeCB8");
        System.out.println(res);

        // ANTES DE METER LOS DATOS HABILITEN LA AUTH
        //https://myaccount.google.com/lesssecureapps
        //https://accounts.google.com/b/0/DisplayUnlockCaptcha
        /*Email email = new Email(
            "",
            "",
            "",
            "TECBANK Código de autenticación",
            RandomStringUtils.randomAlphanumeric(20)
        );
        email.send();*/
    }
}