package com.example.proyectoevade;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoevade.Modelos.DatabaseHelper;
import com.example.proyectoevade.Utilidades.Utilidades;


public class Ingresar extends AppCompatActivity {

        EditText campoId, campoNombre, campoCorreo, campoPSW, campoEstado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ingresar);

            campoId=(EditText) findViewById(R.id.campoId);
            campoNombre=(EditText) findViewById(R.id.campoNombre);
            campoCorreo= (EditText) findViewById(R.id.campoCorreo);
            campoPSW= (EditText) findViewById(R.id.campoPSW);
            campoEstado= (EditText) findViewById(R.id.campoEstado);
        }
      public void onClick(View view) {
            ingresarUsuarios();
      }
      private void ingresarUsuarios(){
          DatabaseHelper conn=new DatabaseHelper(this, "bd usuarios", null,1);
          SQLiteDatabase db=conn.getWritableDatabase();

          ContentValues values=new ContentValues();
          values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
          values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
          values.put(Utilidades.CAMPO_CORREO, campoCorreo.getText().toString());
          values.put(Utilidades.CAMPO_PSW, campoPSW.getText().toString());
          values.put(Utilidades.CAMPO_ESTADO, campoEstado.getText().toString());

          Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

          Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();

          db.close();
        }
    }



