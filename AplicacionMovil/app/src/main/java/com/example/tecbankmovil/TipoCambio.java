package com.example.tecbankmovil;



import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.*;
import java.util.*;



public class TipoCambio extends AsyncTask<String, String, String> {

    private SeccionInfo mActivity;

    //Parametros que utiliza la pagina del BCCR para obetener el tipo de cambio
    private int indicador = 0; //317: Compra, 318: Venta
    private String tcFechaInicio;
    private String tcFechaFinal;
    public String cambioVentaDolar = "" ;
    public String cambioCompraDolar = "";
    public String cambioVentaEuro = "" ;
    public String cambioCompraEuro = "";
    private final String tcNombre = "Javier Rivera Madrigal";
    private final String tnSubNiveles = "N";
    private final String tcCorreoElectronico = "javirivera23@hotmail.es";
    private final String tcToken = "IAAVRR0I25";
    private final String HOST = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML";
    private String url;
    private final String VALUE_TAG = "NUM_VALOR";
    //gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML HTTP/1.1

    public TipoCambio(SeccionInfo mActivity){
        this.mActivity = mActivity;
        setFecha();
    }



    /**
     * Cuando se usa execute(), se corre este proceso automaticamente
     */
    @Override
    protected String doInBackground(String... strings) {

        //Se obtiene la compra del dolar
        getCompra();
        String value = getValue();
        cambioCompraDolar = value;

        //Se obtiene la venta del dolar
        getVenta();
        value = getValue();
        cambioVentaDolar = value;
        System.out.println(value);

        //Cambia la fecha inicial para obtener el euro, ya que no se actualiza todos los dias
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -3);  //3 dias de la fecha actual
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        tcFechaInicio = sdf.format(date);

        //Se obtiene el precio del euro con respecto al dolar
        getEuro();
        value = getValue();
        cambioVentaEuro = String.valueOf(Double.parseDouble(value) * Double.parseDouble(cambioVentaDolar));
        cambioCompraEuro = String.valueOf(Double.parseDouble(value) * Double.parseDouble(cambioCompraDolar));

        System.out.println(cambioVentaEuro);

        this.cancel(true); //Termina el proceso de AsyncTask<>


        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        mActivity.asyncFinished = true;
    } //Cuando finaliza el proceso el Task se da por finalizado.

    /**
     * Devuelve el valor de <strong>COMPRA</strong> USD del BCCR
     * @return <code>Double</code> con el valor del precio de compra.
     */
    public double getCompra(){
        setCompra();
        //double valor = Double.parseDouble();
        return 0;
    }

    /**
     * Devuelve el valor de <strong>VENTA</strong> USD del BCCR
     * @return <code>Double</code> con el valor del precio de venta.
     */
    public double getVenta(){
        setVenta();

        return 0;
    }

    public double getEuro(){
        setEuro();
        //double valor = Double.parseDouble();
        return 0;
    }


    /**
     * Obtiene el XML del WebService del BCCR y parsea el documento para obtener el valor (dado por VALUE_TAG)
     * @return String
     */
    private String getValue(){
        try {
            setUrl(); //Set del Url con los Parámetros

            //Obtiene y Parsea el XML
            String data = GetMethod.getHTML(url);
            XmlParser xml = new XmlParser(data);
            //Retorna el valor del tag
            return xml.getValue(VALUE_TAG);
        } catch (Exception e) {
            System.out.println("Error al obtener el valor del BCCR.");
            System.out.println(e);
            return "0";
        }
    }
    /**
    * Configura el url que se ingresará en la web para obtener los datos, concatena los valores ya definidos
    *
    * */
    private void setUrl(){
        String params = "Indicador="+indicador+"&FechaInicio="+tcFechaInicio+"&FechaFinal="+tcFechaFinal+"&Nombre="+tcNombre+"&SubNiveles="+tnSubNiveles+
                "&CorreoElectronico="+tcCorreoElectronico+"&Token="+tcToken;
        this.url = HOST+"?"+params;
    }
    /**
    * Asigna @tcFechaFinal y  @tcFechaInicio como la fecha actual
    * */
    private void setFecha(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        this.tcFechaInicio = sdf.format(date);
        this.tcFechaFinal = tcFechaInicio;
    }
    /**
     * Cambia el inidicador para obtener el precio de la compra del dolar
     */
    private void setCompra(){
        this.indicador = 317;
    }
    /**
     * Cambia el inidicador para obtener el precio de la venta del dolar
     */
    private void setVenta(){
        this.indicador = 318;
    }
    /**
     * Cambia el inidicador para obtener el precio del euro con respecto del dolar
     */
    private void setEuro(){
        this.indicador = 333;
    }
}
