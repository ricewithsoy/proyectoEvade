package com.example.proyectoevade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Home extends AppCompatActivity {

    Button btnNoticias;
    Button btnImagenes;
    Button btnVideos;
    Button btnUsuarios;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btnNoticias = (Button) findViewById(R.id.btnNoticias);

        btnNoticias.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Noticias.class);
                startActivity(i);
            }
        });

        btnImagenes = (Button) findViewById(R.id.btnImagenes);

        btnImagenes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, AdaptadorDeImagenes.class);
                startActivity(i);
            }
        });

        btnVideos = (Button) findViewById(R.id.btnVideos);

        btnVideos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Videos.class);
                startActivity(i);
            }
        });

        btnUsuarios = (Button) findViewById(R.id.btnUsuarios);

        btnUsuarios.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Usuarios.class);
                startActivity(i);
            }
        });

    }}