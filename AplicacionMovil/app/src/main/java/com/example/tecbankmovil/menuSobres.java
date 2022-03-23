package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite_connect.controllers.SavingEnvelopeController;

public class menuSobres extends AppCompatActivity {

    private int cuenta;
    private SavingEnvelopeController seController = new SavingEnvelopeController();
    private EditText dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sobres);

        cuenta = getIntent().getIntExtra("NombreCuenta",0);
        dinero = (EditText) findViewById(R.id.txtMontoMenuSobre);
    }

    public void depositar(View view){
        String monto = dinero.getEditableText().toString();
        if(monto != "") {
            seController.receiveMoney(cuenta, Double.parseDouble(monto));
        }else{
            Toast.makeText(menuSobres.this,"No ingreso el monto", Toast.LENGTH_SHORT).show();
        }
    }

    public void devolver(View view){
        String monto = dinero.getEditableText().toString();
        if(monto != "") {
            seController.returnMoney(cuenta, Double.parseDouble(monto));
        }else{
            Toast.makeText(menuSobres.this,"No ingreso el monto", Toast.LENGTH_SHORT).show();
        }
    }
}