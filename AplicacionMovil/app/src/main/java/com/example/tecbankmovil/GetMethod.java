package com.example.tecbankmovil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GetMethod {
    /**
     * Carga el url a tarves de una conexion htttp
     * @param urlToRead
     * @return String
     */
    protected static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);  //String to URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Conexion HTTP
        conn.setRequestMethod("GET");
        //Reader del url cargado
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        //Obtiene las lineas del documento
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
