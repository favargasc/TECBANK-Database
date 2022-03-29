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

/**
 * The type Info sobres.
 */
public class infoSobres extends AppCompatActivity {
    private int accountId;
    private int numCuenta;
    private EditText nomSobre, montoInicial;
    /**
     * The Get sobre id observer.
     */
    public Observer<Integer> getSobreIdObserver = null;
    /**
     * The Sobre id live data.
     */
    public LiveData<Integer> sobreIdLiveData;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
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

    /**
     * Crear.
     */
    public void crear(){
        //Registrar el nombre y el monto inicial de un sobre de ahorro
        TecbankDatabase database = TecbankDatabase.getDatabase(this);

        //TODO: VALIDAR CONTENIDO
        SavingEnvelope savEnt = new SavingEnvelope(nomSobre.getEditableText().toString(),
                Double.parseDouble(montoInicial.getEditableText().toString()),
                accountId);


        // si el sobre no existe insert
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

    /**
     * New sobre.
     *
     * @param database the database
     * @param sobre    the sobre
     */
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

    /**
     * Succesfull register.
     *
     * @param idSobre the id sobre
     */
    public void succesfullRegister(int idSobre){
        removeGetSobreIdObserver();
        Toast.makeText(getApplicationContext(), "Nuevo usuario: "+ idSobre, Toast.LENGTH_LONG).show();
    }

    /**
     * Remove get sobre id observer.
     */
    public void removeGetSobreIdObserver(){
        sobreIdLiveData.removeObservers(this);
    }

    // utilizacion del reciclerveiw
    // Unir a menuSobres cuando selecione una cuenta en el reciclerveiw
}