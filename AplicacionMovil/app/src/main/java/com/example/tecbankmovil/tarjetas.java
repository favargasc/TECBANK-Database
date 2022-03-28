package com.example.tecbankmovil;

import android.os.Bundle;
/*
* Creacion de la clase Tarjetas, modulo informativo
* Tipo de tarjeta y beneficios
* */
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class tarjetas extends AppCompatActivity {
    private int accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tarjetas);

        accountId = getIntent().getIntExtra("accountId",-1);

    }
}
