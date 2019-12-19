package com.example.proyectoevade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText txtPsw, txtCorreo;
    Button btnAcceder;
    SessionManager session;
    DialogManager cuadroDialogo = new DialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtPsw = (EditText) findViewById(R.id.txtPsw);

        Toast.makeText(getApplicationContext(), "Estado de identificación : " + session.isLogged(), Toast.LENGTH_SHORT).show();
        btnAcceder = (Button) findViewById(R.id.btnAcceder);
        btnAcceder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                String email = txtCorreo.getText().toString();
                String password = txtPsw.getText().toString();

                if (email.trim().length() > 0 && password.trim().length() > 0) {
                    if (email.equals("admin@evade.cl") && password.equals("evade")) {
                        session.createLoginSession("admin@evade.cl", "evade");

                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                        finish();

                    } else {
                        cuadroDialogo.showAlertDialog(Login.this, "Fallo", "Datos incorrectos", false);
                    }
                }else {
                    cuadroDialogo.showAlertDialog(Login.this, "Fallo", "Introducir los datos", false);

                }}
        });
    }
}

