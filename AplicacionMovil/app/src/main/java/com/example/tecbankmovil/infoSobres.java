package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomDatabase.TecbankDatabase;
import com.example.roomDatabase.models.SavingEnvelope;
import com.example.roomDatabase.models.User;

public class infoSobres extends AppCompatActivity {
    private int accountId;
    private int numCuenta;
    private EditText nomSobre, montoInicial;
    public Observer<Integer> getSobreIdObserver = null;
    public LiveData<Integer> sobreIdLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_sobres);

        accountId = getIntent().getIntExtra("accountId", -1);
        numCuenta = getIntent().getIntExtra("NumCuenta",0);

        nomSobre = (EditText) findViewById(R.id.txtNombreSobre);
        montoInicial = (EditText) findViewById(R.id.txtMontoSobre);

        Button btnCrearSobre = (Button) findViewById(R.id.btnCrearSobre);

        btnCrearSobre.setOnClickListener(x -> {
            crear();
        });
    }

    public void crear(){
        //Registrar los datos del usuario en la base de datos y verificar si se guardo el usuario bien
        TecbankDatabase database = TecbankDatabase.getDatabase(this);

        //TODO: VALIDAR CONTENIDO
        SavingEnvelope savEnt = new SavingEnvelope(nomSobre.getEditableText().toString(),
                Double.parseDouble(montoInicial.getEditableText().toString()),
                accountId);


        // If user doesnt exist, insert
        getSobreIdObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer id) {
                if(id == null) {
                    newSobre(database, savEnt);
                }
                else{
                    Toast.makeText(getApplicationContext(), "El nombre de usuario ya existe, ingrese a su cuenta o ingrese un nombre diferente" , Toast.LENGTH_LONG).show();
                }
                removeGetSobreIdObserver();
            }
        };

        sobreIdLiveData = database.savingEnvelopeDao().getSavingEnvelopeId(savEnt.name);
        sobreIdLiveData.observe(this, getSobreIdObserver);

    }
    void newSobre(TecbankDatabase database, SavingEnvelope sobre){


        // Error when handling asyncTask, try not to do this if no errors
        Long insertResponse = database.savingEnvelopeDao().insert(sobre);
        if (insertResponse != -1){
            succesfullRegister(insertResponse.intValue());
        }
        else{
            Toast.makeText(getApplicationContext(), "No fue posible registrar al usuario", Toast.LENGTH_LONG).show();
        }


    }

    public void succesfullRegister(int idSobre){
        removeGetSobreIdObserver();
        Toast.makeText(getApplicationContext(), "Nuevo usuario: "+ idSobre, Toast.LENGTH_LONG).show();
    }

    public void removeGetSobreIdObserver(){
        sobreIdLiveData.removeObservers(this);
    }

    // utilizacion del reciclerveiw
    // Unir a menuSobres cuando selecione una cuenta en el reciclerveiw
}