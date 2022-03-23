package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaMenu extends AppCompatActivity {
    private String nombreUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_menu);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }

    public void cuentas(View view){
        Intent cuenta = new Intent(this, CuentasUsuario.class);
        cuenta.putExtra("NombreUs", nombreUs);
        startActivity(cuenta);
    }

    public void informacion(View view){
        Intent informacion = new Intent(this, Informacion.class);
        informacion.putExtra("NombreUs", nombreUs);
        startActivity(informacion);
    }

    public void cerrarSesion(View view){
        Intent cerSesion = new Intent(this, MainActivity.class);
        startActivity(cerSesion);
    }
}