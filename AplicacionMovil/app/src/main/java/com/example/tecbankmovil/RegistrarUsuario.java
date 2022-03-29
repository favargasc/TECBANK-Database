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
import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.Proofpayment;
import com.example.roomDatabase.models.User;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

/**
 * The type Registrar usuario.
 */
public class RegistrarUsuario extends AppCompatActivity {
    private EditText nombre, apellido, correo, nombreUs, contrasenna;
    /**
     * The Get user id observer.
     */
    public Observer<Integer> getUserIdObserver = null;
    public Observer<Integer> getAccountIdObserver = null;
    /**
     * The User id live data.
     */
    public LiveData<Integer> userIdLiveData;
    public LiveData<Integer> accountIdLiveData;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
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

    /**
     * Registrar.
     */
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

    /**
     * New user.
     *
     * @param database the database
     * @param newUser  the new user
     */
    void newUser(TecbankDatabase database, User newUser){


        // Error when handling asyncTask, try not to do this if no errors
        Long insertResponse = database.userDao().insert(newUser);
        //TODO: ASSING NEW ACOUNT
        if (insertResponse != -1){
            succesfullRegister(insertResponse.intValue(), database);
        }
        else{
            Toast.makeText(getApplicationContext(), "No fue posible registrar al usuario", Toast.LENGTH_LONG).show();
        }


    }


    void newAccount(TecbankDatabase database, Account newAccount){


        // Error when handling asyncTask, try not to do this if no errors
        Long insertResponse = database.accountDao().insert(newAccount);
        if (insertResponse != -1){
            Toast.makeText(getApplicationContext(), "Su nueva cuenta ha sido registrada!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "No fue posible registrar su cuenta", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Succesfull register.
     *
     * @param idUser the id user
     */
    public void succesfullRegister(int idUser, TecbankDatabase database){

        removeGetUserIdObserver();

        Account newAccount = new Account(RandomStringUtils.randomAlphanumeric(20),0.0,idUser);

        getAccountIdObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer id) {
                if(id == null) {
                    newAccount(database,newAccount);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Nueva cuenta creada!" , Toast.LENGTH_LONG).show();
                }
                removeGetUserIdObserver();
            }
        };

        accountIdLiveData = database.accountDao().getAccountIdByNumber(newAccount.account_number);
        accountIdLiveData.observe(this, getAccountIdObserver);


        Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
        Toast.makeText(getApplicationContext(), "Nuevo usuario: "+ idUser, Toast.LENGTH_LONG).show();
        //mainMenu.putExtra("NombreUs", idUser);
        startActivity(mainMenu);

    }

    /**
     * Remove get user id observer.
     */
    public void removeGetUserIdObserver(){
        userIdLiveData.removeObservers(this);
    }



}