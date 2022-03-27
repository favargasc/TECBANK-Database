package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CuentasUsuario extends AppCompatActivity {
    private int accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas_usuario);

        accountId = getIntent().getIntExtra("accountId",-1);
    }


    // utilizacion del reciclerveiw
    // Unir a informacionCuenta cuando selecione una cuenta en el reciclerveiw
}