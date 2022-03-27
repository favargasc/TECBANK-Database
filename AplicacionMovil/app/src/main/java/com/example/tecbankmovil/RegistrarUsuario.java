package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.roomDatabase.TecbankDatabase;
import com.example.roomDatabase.models.User;

public class RegistrarUsuario extends AppCompatActivity {
    private EditText nombre, apellido, correo, nombreUs, contrasenna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        nombre = (EditText) findViewById(R.id.regNombreV);
        apellido = (EditText) findViewById(R.id.regApellido);
        correo = (EditText) findViewById(R.id.regCorreo);
        nombreUs = (EditText) findViewById(R.id.regNombreUs);
        contrasenna = (EditText) findViewById(R.id.regContra);
    }

    public void registrar(View view){
        //Registrar los datos del usuario en la base de datos y verificar si se guardo el usuario bien
        TecbankDatabase database = TecbankDatabase.getDatabase(this);
        User newUser = new User(correo.getEditableText().toString(), contrasenna.getEditableText().toString(),
                nombre.getEditableText().toString(),apellido.getEditableText().toString(),
                nombreUs.getEditableText().toString());

        database.userDao().insert(newUser); // Void function

        LiveData<Integer> user = database.userDao().getUserId(nombreUs.getEditableText().toString(),
                contrasenna.getEditableText().toString());

        Intent mainMenu = new Intent(this, PantallaMenu.class);
        mainMenu.putExtra("NombreUs",user.getValue());
        startActivity(mainMenu);
    }
}