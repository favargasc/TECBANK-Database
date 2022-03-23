package com.example.tecbankmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Transferencia extends AppCompatActivity {
    private String nombreUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);

        nombreUs = getIntent().getStringExtra("NombreUs");
    }

    public void trans(View view){

    }
}