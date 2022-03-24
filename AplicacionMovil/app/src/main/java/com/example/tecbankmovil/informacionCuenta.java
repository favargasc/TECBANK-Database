package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class informacionCuenta extends AppCompatActivity {
    private String nombreUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_cuenta);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }

    public void tranDinero(View view){
        Intent pasarDin = new Intent(this, Transferencia.class);
        pasarDin.putExtra("NombreUs", nombreUs);
        //Agregar el numero de cuenta que seleciono en el reciclerview, si no se puede se cambia el recicler mejor
        startActivity(pasarDin);
    }

}