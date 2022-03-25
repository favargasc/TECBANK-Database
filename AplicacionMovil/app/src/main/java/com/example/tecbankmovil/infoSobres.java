package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class infoSobres extends AppCompatActivity {
    private String nombreUs;
    private int numCuenta;
    private EditText nomSobre;
    private EditText montoInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_sobres);

        nombreUs = getIntent().getStringExtra("NombreUs");
        numCuenta = getIntent().getIntExtra("NumCuenta");

        nomSobre = (EditText) findViewById(R.id.txtNombreSobre);
        montoInicial = (EditText) findViewById(R.id.txtMontoSobre);
    }

    public void crearSobre(View view){
        //crear un sobre aqui
    }

    // utilizacion del reciclerveiw
    // Unir a menuSobres cuando selecione una cuenta en el reciclerveiw
}