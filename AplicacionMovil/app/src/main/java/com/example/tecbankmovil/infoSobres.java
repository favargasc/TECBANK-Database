package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.roomDatabase.TecbankDatabase;
import com.example.roomDatabase.models.SavingEnvelope;

public class infoSobres extends AppCompatActivity {
    private int accountId;
    private int numCuenta;
    private EditText nomSobre;
    private EditText montoInicial;
    TecbankDatabase database = TecbankDatabase.getDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_sobres);

        accountId = getIntent().getIntExtra("accountId", -1);
        numCuenta = getIntent().getIntExtra("NumCuenta",0);

        nomSobre = (EditText) findViewById(R.id.txtNombreSobre);
        montoInicial = (EditText) findViewById(R.id.txtMontoSobre);
    }

    public void crearSobre(View view){
        SavingEnvelope savEnt = new SavingEnvelope(nomSobre.getEditableText().toString(),
                Double.parseDouble(montoInicial.getEditableText().toString()),
                accountId);
        database.savingEnvelopeDao().insert(savEnt);
    }

    // utilizacion del reciclerveiw
    // Unir a menuSobres cuando selecione una cuenta en el reciclerveiw
}