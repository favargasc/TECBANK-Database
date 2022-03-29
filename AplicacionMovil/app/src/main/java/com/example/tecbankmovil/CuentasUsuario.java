package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * The type Cuentas usuario.
 */
public class CuentasUsuario extends AppCompatActivity {
    private String nombreUs;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas_usuario);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }


    // utilizacion del reciclerveiw
    // Unir a informacionCuenta cuando selecione una cuenta en el reciclerveiw
}