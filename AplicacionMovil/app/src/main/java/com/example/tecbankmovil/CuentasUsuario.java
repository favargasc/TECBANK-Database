package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CuentasUsuario extends AppCompatActivity {
    private String nombreUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas_usuario);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }


    // utilizacion del reciclerveiw
}