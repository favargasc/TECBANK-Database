package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.os.Bundle;

public class cuentasParaSobres extends AppCompatActivity {
    private int accountId;
    private int numCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas_para_sobres);

        accountId = getIntent().getIntExtra("accountId",-1);

    }

    // utilizacion del reciclerveiw
    // Unir a infoSobres cuando selecione una cuenta en el reciclerveiw
    //Agregar este intent para abrir la ventana cuando el usuario seleciona una cuenta
    /*Intent infoSob = new Intent(this, infoSobres.class);
    infoSob.putExtra("accountId", accountId);
    infoSob.putExtra("NumCuenta", numCuenta);
    startActivity(infoSob);*/
}