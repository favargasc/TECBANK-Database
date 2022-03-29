package com.example.tecbankmovil;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;


/**
 * The type Seccion info.
 */
public class SeccionInfo extends AppCompatActivity {
    /**
     * The Servicio tipo cambio.
     */
    TipoCambio servicioTipoCambio = new TipoCambio(this);
    /**
     * The Async finished.
     */
    public Boolean asyncFinished = false;

    private int accountId;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountId = getIntent().getIntExtra("accountId",-1);

        servicioTipoCambio.execute("");
        //status si ya se completó el proceso de obtener el tipo de cambio
        AsyncTask.Status status = servicioTipoCambio.getStatus();


        //verifica si el status ya finalizó para actualizar layout
        while(servicioTipoCambio.getStatus()!=AsyncTask.Status.FINISHED) {
            if(servicioTipoCambio.isCancelled())
                break;
            continue;
        }



        setContentView(R.layout.seccion_info);

        //Textviews de los diferentes tipos de cambios, se cambia a tiempo real
        final TextView compraDolar = (TextView) findViewById(R.id.CompraDolar);
        final TextView compraEuro = (TextView) findViewById(R.id.CompraEuro);
        final TextView ventaDolar = (TextView) findViewById(R.id.ventaDolar);
        final TextView ventaEuro = (TextView) findViewById(R.id.ventaEuro);

        compraDolar.setText(servicioTipoCambio.cambioCompraDolar);
        compraEuro.setText(servicioTipoCambio.cambioCompraEuro);
        ventaDolar.setText(servicioTipoCambio.cambioVentaDolar);
        ventaEuro.setText(servicioTipoCambio.cambioVentaEuro);

        //Boton el cual redirige al mapa de sucursales
        Button btnSucursal = (Button) findViewById(R.id.btnSucursales);
        btnSucursal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(SeccionInfo.this,MapsActivity.class);  //Abre la pestaña en donde se observa las sucursales y horarios
                map.putExtra("accountId",accountId);
                startActivity(map);
            }
        });

        //boton que redirige a los beneficios de las tarjetas que ofrece TECBANK
        Button btnBeneficios = (Button) findViewById(R.id.btnTrajetas);
        btnBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tarjeta = new Intent(SeccionInfo.this,tarjetas.class);  //Clase de Tarjetas
                tarjeta.putExtra("accountId",accountId);
                startActivity(tarjeta);
            }
        });

    }

}
