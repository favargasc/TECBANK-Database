package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tecbankmovil.databinding.ActivityCuentasParaSobresBinding;

/**
 * The type Pantalla menu.
 */
public class PantallaMenu extends AppCompatActivity {
    private String nombreUs;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_menu);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }

    /**
     * Cuentas.
     *
     * @param view the view
     */
    public void cuentas(View view){
        Intent cuenta = new Intent(this, CuentasUsuario.class);
        cuenta.putExtra("NombreUs", nombreUs);
        startActivity(cuenta);
    }

    /**
     * Sobres.
     *
     * @param view the view
     */
    public void sobres(View view){
        Intent cSobre = new Intent(this, cuentasParaSobres.class);
        cSobre.putExtra("NombreUs", nombreUs);
        startActivity(cSobre);
    }

    /**
     * Informacion.
     *
     * @param view the view
     */
    public void informacion(View view){
        Intent informacion = new Intent(this, SeccionInfo.class);
        informacion.putExtra("NombreUs", nombreUs);
        startActivity(informacion);
    }

    /**
     * Cerrar sesion.
     *
     * @param view the view
     */
    public void cerrarSesion(View view){
        Intent cerSesion = new Intent(this, MainActivity.class);
        startActivity(cerSesion);
    }
}