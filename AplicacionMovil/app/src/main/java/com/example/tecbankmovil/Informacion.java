package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Informacion extends AppCompatActivity {
    private String nombreUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }
    //Agregar boton para regresar a pantalla menu
}