package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected EditText nombre;
    protected EditText password;
    protected Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingresarUsuario();

    }

    public void ingresarUsuario(){
        nombre = (EditText) findViewById(R.id.ingNombre);
        password = (EditText) findViewById(R.id.ingContra);
        ingresar = (Button) findViewById(R.id.ingresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ingNombre = nombre.getText().toString();
                String ingPassword = password.getText().toString();
                /*Buscar el password con el */
                String comprobar = "";

                if(ingPassword.equals(comprobar)){
                    Toast.makeText(MainActivity.this, password.getText(),Toast.LENGTH_SHORT).show(); // No seguro de si funciona
                    // si es correcto pasar al otro frame
                }else{
                    //informar de que se ingreso mal el texto
                }
            }
        });
    }

}