package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/**
 * The type Transferencia.
 */
public class Transferencia extends AppCompatActivity {
    private String nombreUs;
    private EditText numCuenta;
    private EditText monto;
    private EditText cedula;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);

        nombreUs = getIntent().getStringExtra("NombreUs");

        numCuenta = (EditText) findViewById(R.id.eTxtNumCuenta);
        monto = (EditText) findViewById(R.id.eTxtMontoTran);
        cedula = (EditText) findViewById(R.id.eTxtCedTran);
    }

    /**
     * Trans.
     *
     * @param view the view
     */
    public void trans(View view){
        //trae toda la informacion de los datos
        // no se como aplicar lo combobox para los bancos

        //Cuando termina la transaccion que se devuelva al main menu
        Intent panMenu = new Intent(this, PantallaMenu.class);
        panMenu.putExtra("NombreUs", nombreUs);
        startActivity(panMenu);
    }
}