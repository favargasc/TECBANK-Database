package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomDatabase.TecbankDatabase;

public class menuSobres extends AppCompatActivity {

    private int cuenta;
    private int savingEnv; //Identificador del sobre seleccionado en el recliclerview
    private EditText dinero;
    TecbankDatabase database = TecbankDatabase.getDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sobres);

        cuenta = getIntent().getIntExtra("NombreCuenta",0);
        dinero = (EditText) findViewById(R.id.txtMontoMenuSobre);
    }

    public void depositar(View view){
        double monto = Double.parseDouble(dinero.getEditableText().toString());
        //obtener el id del sobre del reciclerview
        if(monto != 0) {
            database.savingEnvelopeDao().reduceAccountCB(savingEnv, monto);
            database.savingEnvelopeDao().receiveMoney(savingEnv, monto);
        }else{
            Toast.makeText(menuSobres.this,"No ingreso el monto", Toast.LENGTH_SHORT).show();
        }
    }

    public void devolver(View view){
        double monto = Double.parseDouble(dinero.getEditableText().toString());
        //obtener el id del sobre del reciclerview
        if(monto != 0) {
            database.savingEnvelopeDao().increaseAccountCB(savingEnv, monto);
            database.savingEnvelopeDao().returnMoney(savingEnv, monto);
        }else{
            Toast.makeText(menuSobres.this,"No ingreso el monto", Toast.LENGTH_SHORT).show();
        }
    }
}