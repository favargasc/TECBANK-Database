package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.adapters.transferAccountAdapter;
import com.example.roomDatabase.TecbankDatabase;
import com.example.roomDatabase.models.Proofpayment;

import java.util.List;

/**
 * The type Informacion cuenta.
 */
public class informacionCuenta extends AppCompatActivity {
    private String accountNumber;
    transferAccountAdapter trasferAdapter = new transferAccountAdapter();
    TecbankDatabase database;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_informacion_cuenta);
        accountNumber = getIntent().getStringExtra("accountNumber");

        RecyclerView recyclerView = findViewById(R.id.rcvHistorialCuenta);
        recyclerView.setAdapter(trasferAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = TecbankDatabase.getDatabase(this);


        database.proofpaymentDao().getAllProofofpaymentByAccountNumber(accountNumber).observe(this,new Observer<List<Proofpayment>>(){

            @Override
            public void onChanged(List<Proofpayment> accountsTranfer) {
                if (accountsTranfer == null ||accountsTranfer.size() == 0) {
                    Toast.makeText(getApplicationContext(), "El usuario no tiene cuentas Activas " , Toast.LENGTH_LONG).show();
                    //informar de que se ingreso mal el texto
                } else {
                    trasferAdapter.updateAdapter(accountsTranfer);
                }
            }
        });

    }

    /**
     * Tran dinero.
     *
     * @param view the view
     */
    public void tranDinero(View view){
        Intent pasarDin = new Intent(this, Transferencia.class);

        //do we need this
        pasarDin.putExtra("accountId", accountNumber);
        //Agregar el numero de cuenta que seleciono en el reciclerview, si no se puede se cambia el recicler mejor
        startActivity(pasarDin);
    }

}