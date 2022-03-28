package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomDatabase.TecbankDatabase;
import com.example.roomDatabase.models.Account;
import com.example.roomDatabase.models.Bank;
import com.example.roomDatabase.models.User;
import com.example.tecbankmovil.databinding.ActivityCuentasParaSobresBinding;
import com.example.utilities.Email;

import java.nio.file.FileSystemAlreadyExistsException;
import java.util.List;

public class PantallaMenu extends AppCompatActivity {
    private int accountId;
    public User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_menu);

        accountId = getIntent().getIntExtra("accountId",-1);
    }

    public void cuentas(View view){

        TecbankDatabase database = TecbankDatabase.getDatabase(this);
        //database.bankDao().insert(new Bank(1,"TECBANK", "TBNK"));


        database.userDao().getUserById(accountId).observe(this,new Observer<User>(){

            @Override
            public void onChanged(User foundUser) {
                if(foundUser != null){
                    user = foundUser;
                    Email token = new Email(user.email);

                    //Error
                    //token.send();
                }
            }
        });

        Intent cuenta = new Intent(this, CuentasUsuario.class);
        cuenta.putExtra("accountId", accountId);
        startActivity(cuenta);
    }

    public void sobres(View view){
        Intent cSobre = new Intent(this, cuentasParaSobres.class);
        cSobre.putExtra("accountId", accountId);
        startActivity(cSobre);
    }

    public void informacion(View view){
        Intent informacion = new Intent(this, SeccionInfo.class);
        informacion.putExtra("accountId", accountId);
        startActivity(informacion);
    }

    public void cerrarSesion(View view){
        Intent cerSesion = new Intent(this, MainActivity.class);
        startActivity(cerSesion);
    }
}