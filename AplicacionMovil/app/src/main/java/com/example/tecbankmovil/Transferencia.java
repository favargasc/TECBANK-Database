package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.roomDatabase.TecbankDatabase;

/**
 * The type Transferencia.
 */
public class Transferencia extends AppCompatActivity {
    private String accountId;
    private EditText numCuenta, monto, cedula;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Spinner spinner = (Spinner) findViewById(R.id.spnBancos);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.banks_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        setContentView(R.layout.activity_transferencia);

        accountId = getIntent().getStringExtra("accountId");

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
        panMenu.putExtra("accountId", accountId);
        startActivity(panMenu);
    }
}