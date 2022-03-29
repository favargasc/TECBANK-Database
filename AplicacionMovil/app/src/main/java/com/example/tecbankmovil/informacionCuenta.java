package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * The type Informacion cuenta.
 */
public class informacionCuenta extends AppCompatActivity {
    private int accountId;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_cuenta);

        accountId = getIntent().getIntExtra("accountId",-1);
    }

    /**
     * Tran dinero.
     *
     * @param view the view
     */
    public void tranDinero(View view){
        Intent pasarDin = new Intent(this, Transferencia.class);
        pasarDin.putExtra("accountId", accountId);
        //Agregar el numero de cuenta que seleciono en el reciclerview, si no se puede se cambia el recicler mejor
        startActivity(pasarDin);
    }

}