package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Informacion extends AppCompatActivity {
    private int accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        accountId = getIntent().getIntExtra("accountId",-1);
    }
    //Agregar boton para regresar a pantalla menu
}