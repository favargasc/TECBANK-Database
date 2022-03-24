package com.example.tecbankmovil;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;





public class SeccionInfo extends AppCompatActivity {
    TipoCambio servicioTipoCambio = new TipoCambio(this);
    public Boolean asyncFinished = false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        servicioTipoCambio.execute("");

        AsyncTask.Status status = servicioTipoCambio.getStatus();



        while(servicioTipoCambio.getStatus()!=AsyncTask.Status.FINISHED) {
            if(servicioTipoCambio.isCancelled())
                break;
            continue;
        }



        setContentView(R.layout.seccion_info);

        final TextView compraDolar = (TextView) findViewById(R.id.CompraDolar);
        final TextView compraEuro = (TextView) findViewById(R.id.CompraEuro);
        final TextView ventaDolar = (TextView) findViewById(R.id.ventaDolar);
        final TextView ventaEuro = (TextView) findViewById(R.id.ventaEuro);

        compraDolar.setText(servicioTipoCambio.cambioCompraDolar);
        compraEuro.setText(servicioTipoCambio.cambioCompraEuro);
        ventaDolar.setText(servicioTipoCambio.cambioVentaDolar);
        ventaEuro.setText(servicioTipoCambio.cambioVentaEuro);

        Button btnSucursal = (Button) findViewById(R.id.btnSucursales);
        btnSucursal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeccionInfo.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        Button btnBeneficios = (Button) findViewById(R.id.btnTrajetas);
        btnBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeccionInfo.this,tarjetas.class);
                startActivity(intent);
            }
        });

    }

}
