package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * The type Registrar usuario.
 */
public class RegistrarUsuario extends AppCompatActivity {
    private EditText nombre, apellido, correo, nombreUs, contrasenna;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
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

    /**
     * Registrar.
     *
     * @param view the view
     */
    public void registrar(View view){
        //Registrar los datos del usuario en la base de datos y verificar si se guardo el usuario bien
        String validar = "";
        if(validar.equals("Usuario valido")){
            Intent mainMenu = new Intent(this, PantallaMenu.class);
            mainMenu.putExtra("NombreUs",nombreUs.getEditableText().toString());
            startActivity(mainMenu);
        }



    }
}