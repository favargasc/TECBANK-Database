package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.example.roomDatabase.TecbankDatabase;

public class Transferencia extends AppCompatActivity {
    private int accountId;
    private EditText numCuenta, monto, cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);

        accountId = getIntent().getIntExtra("accountId",-1);

        numCuenta = (EditText) findViewById(R.id.eTxtNumCuenta);
        monto = (EditText) findViewById(R.id.eTxtMontoTran);
        cedula = (EditText) findViewById(R.id.eTxtCedTran);
    }

    public void trans(View view){
        //trae toda la informacion de los datos
        // no se como aplicar lo combobox para los bancos

        //Cuando termina la transaccion que se devuelva al main menu
        Intent panMenu = new Intent(this, PantallaMenu.class);
        panMenu.putExtra("accountId", accountId);
        startActivity(panMenu);
    }
}