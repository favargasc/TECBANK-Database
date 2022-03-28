package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomDatabase.Populate;
import com.example.roomDatabase.TecbankDatabase;
import com.example.roomDatabase.models.User;

public class RegistrarUsuario extends AppCompatActivity {
    private EditText nombre, apellido, correo, nombreUs, contrasenna;
    public Observer<Integer> getUserIdObserver = null;
    public LiveData<Integer> userIdLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        Button btnRegistrarUs = (Button) findViewById(R.id.btnRegistrarUs);
        nombre = (EditText) findViewById(R.id.regNombreV);
        apellido = (EditText) findViewById(R.id.regApellido);
        correo = (EditText) findViewById(R.id.regCorreo);
        nombreUs = (EditText) findViewById(R.id.regNombreUs);
        contrasenna = (EditText) findViewById(R.id.regContra);


        //on click process
        btnRegistrarUs.setOnClickListener(x -> {
            registrar();
        });

    }

    public void registrar(){
        //Registrar los datos del usuario en la base de datos y verificar si se guardo el usuario bien
        TecbankDatabase database = TecbankDatabase.getDatabase(this);

        //TODO: VALIDAR CONTENIDO
        User newUser = new User(correo.getEditableText().toString(), contrasenna.getEditableText().toString(),
                nombre.getEditableText().toString(),apellido.getEditableText().toString(),
                nombreUs.getEditableText().toString());


        // If user doesnt exist, insert
        getUserIdObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer id) {
                if(id == null) {
                    newUser(database,newUser);
                }
                else{
                    Toast.makeText(getApplicationContext(), "El nombre de usuario ya existe, ingrese a su cuenta o ingrese un nombre diferente" , Toast.LENGTH_LONG).show();
                }
                removeGetUserIdObserver();
            }
        };

        userIdLiveData = database.userDao().getUserId(newUser.userName);
        userIdLiveData.observe(this, getUserIdObserver);

    }

    void newUser(TecbankDatabase database, User newUser){


        // Error when handling asyncTask, try not to do this if no errors
        Long insertResponse = database.userDao().insert(newUser);
        //TODO: ASSING NEW ACOUNT
        if (insertResponse != -1){
            succesfullRegister(insertResponse.intValue());
        }
        else{
            Toast.makeText(getApplicationContext(), "No fue posible registrar al usuario", Toast.LENGTH_LONG).show();
        }


    }

    public void succesfullRegister(int idUser){
        removeGetUserIdObserver();
        Intent mainMenu = new Intent(getApplicationContext(), PantallaMenu.class);
        Toast.makeText(getApplicationContext(), "Nuevo usuario: "+ idUser, Toast.LENGTH_LONG).show();
        mainMenu.putExtra("NombreUs", idUser);
        startActivity(mainMenu);

    }

    public void removeGetUserIdObserver(){
        userIdLiveData.removeObservers(this);
    }



}