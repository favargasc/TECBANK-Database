package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class cuentasParaSobres extends AppCompatActivity {
    private String nombreUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas_para_sobres);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }

    // utilizacion del reciclerveiw
    // Unir a infoSobres cuando selecione una cuenta en el reciclerveiw
}