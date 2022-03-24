package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;

import com.example.sqlite_connect.controllers.SavingEnvelopeController;
import com.example.sqlite_connect.controllers.UserController;

public class MainActivity extends AppCompatActivity {
    public EditText nombre;
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.ingNombre);
        password = (EditText) findViewById(R.id.ingContra);


        SavingEnvelopeController seController = new SavingEnvelopeController();

        UserController uController = new UserController();

        int res = uController.getUserId("lwarhurst0", "Xmj9QM74");
        System.out.println("PRUEBA: " + res);
        System.out.println("PRUEBA: " + res);


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