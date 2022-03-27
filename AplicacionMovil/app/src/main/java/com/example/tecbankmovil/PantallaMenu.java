package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tecbankmovil.databinding.ActivityCuentasParaSobresBinding;

public class PantallaMenu extends AppCompatActivity {
    private int accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_menu);

        accountId = getIntent().getIntExtra("accountId",-1);
    }

    public void cuentas(View view){
        Intent cuenta = new Intent(this, CuentasUsuario.class);
        cuenta.putExtra("accountId", accountId);
        startActivity(cuenta);
    }

    public void sobres(View view){
        Intent cSobre = new Intent(this, cuentasParaSobres.class);
        cSobre.putExtra("accountId", accountId);
        startActivity(cSobre);
    }

    public void informacion(View view){
        Intent informacion = new Intent(this, SeccionInfo.class);
        informacion.putExtra("accountId", accountId);
        startActivity(informacion);
    }

    public void cerrarSesion(View view){
        Intent cerSesion = new Intent(this, MainActivity.class);
        startActivity(cerSesion);
    }
}