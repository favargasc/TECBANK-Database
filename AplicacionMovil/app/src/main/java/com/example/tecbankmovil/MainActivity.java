package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;

//import com.example.roomDatabase.Populate;
import com.example.roomDatabase.Populate;
import com.example.roomDatabase.models.Bank;
import com.example.roomDatabase.TecbankDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public EditText nombre;
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.ingNombre);
        password = (EditText) findViewById(R.id.ingContra);

        TecbankDatabase database = TecbankDatabase.getDatabase(this);
        //database.bankDao().insert(new Bank(1,"TECBANK", "TBNK"));

        database.bankDao().getAllBanks().observe(this,new Observer<List<Bank>>(){

            @Override
            public void onChanged(List<Bank> banks) {
                // not working?
                System.out.println("Prueba : CHANGE  " + banks.size());
            }
        });

        Runnable myRunnable =
                new Runnable(){
                    public void run(){
                        System.out.println("Prueba : insert here");

                    }
                };

        //myRunnable.run();
        new AsyncTask<String,Void,Integer>(){

            @Override
            protected Integer doInBackground(String... strings) {
                //database.bankDao().insert(new Bank("Tkibankca", "TiKi"));
                Populate.populateBank(database);
                //database.bankDao().getBankById("46");

                // not working?
                System.out.println("Prueba : insert here  " + database.bankDao().getBankById("22" ));
                return null;
            }
        }.execute("hello", "otra vara");


        /*SavingEnvelopeController seController = new SavingEnvelopeController();

        UserController uController = new UserController();

        int res = uController.getUserId("lwarhurst0", "Xmj9QM74");
        System.out.println("PRUEBA: " + res);
        System.out.println("PRUEBA: " + res);*/


    }

    public void iniciarSesion(View view){

        String ingNombre = nombre.getEditableText().toString();
        String ingPassword = password.getEditableText().toString();
        /*Buscar el password con el */
        String compNombre = "";
        String compContra = "";

        if(ingNombre.equals(compNombre)) {
            if (ingPassword.equals(compContra)) {
                Intent pantMenu = new Intent(this, PantallaMenu.class); //Crear la relacion para pasar a otra activity
                pantMenu.putExtra("NombreUs", ingNombre); // Pasar dato por paramatro de una activity a otra
                startActivity(pantMenu); // Iniciar la nueva activity
            } else {
                Toast.makeText(MainActivity.this, password.getEditableText(), Toast.LENGTH_SHORT).show(); // No seguro de si funciona
                //informar de que se ingreso mal el texto
            }
        }
    }

    public void registrarSesion(View view){
        Intent registrarUs = new Intent(this, RegistrarUsuario.class);
        startActivity(registrarUs);
    }

}