package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button buttonProduct1 = findViewById(R.id.button_product1);
        Button buttonProduct2 = findViewById(R.id.button_product2);
        Button buttonProduct3 = findViewById(R.id.button_product3);
        Button buttonProduct4 = findViewById(R.id.button_product4);
        Button buttonProduct5 = findViewById(R.id.button_product5);
        // Configurar OnClickListener para el primer botón
        buttonProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad FORROS
                Intent intent = new Intent(MainActivity3.this, FORRO.class);
                startActivity(intent);
            }
        });
        buttonProduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad FORROS
                Intent intent = new Intent(MainActivity3.this, Audifonos.class);
                startActivity(intent);
            }
        });
        buttonProduct3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Iniciar la actividad FORROS
            Intent intent = new Intent(MainActivity3.this, Cargadores.class);
            startActivity(intent);
        }
    });
        buttonProduct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad FORROS
                Intent intent = new Intent(MainActivity3.this, Parlantes.class);
                startActivity(intent);
            }
        });
        buttonProduct5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad FORROS
                Intent intent = new Intent(MainActivity3.this, Reloj.class);
                startActivity(intent);
            }
        });
    }
}
