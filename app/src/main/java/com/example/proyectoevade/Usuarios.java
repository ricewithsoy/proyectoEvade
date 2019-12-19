package com.example.proyectoevade;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.proyectoevade.Modelos.Usuario;

import com.example.proyectoevade.Modelos.DatabaseHelper;
import com.example.proyectoevade.Utilidades.Utilidades;

import java.util.ArrayList;

public class Usuarios extends AppCompatActivity {

    ListView listViewUsuarios;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

    DatabaseHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        conn=new DatabaseHelper(getApplicationContext(), "ListaBD.db", null, 1);

        listViewUsuarios = (ListView) findViewById(R.id.listViewUsuarios);

        consultarListaUsuarios();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1, listaInformacion);
        listViewUsuarios.setAdapter(adaptador);

        listViewUsuarios.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion="id "; +listaUsuarios.get().getId+"\n";
                informacion+="Nombre: ";+listaUsuarios.get().getNombre+"\n";
                informacion+="Email: ";+listaUsuarios.get().getCorreo()+"\n";
                informacion+="Estado: ";+listaUsuarios.get().getEstado+"\n";

        }
    });
}
    private void consultarListaUsuarios(){
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();
        Cursor cursor=db.rawQuery("SELECT * FROM TABLA_USUARIO" + Utilidades.TABLA_USUARIO,null);
        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setCorreo(cursor.getString(2));
            usuario.setPsw(cursor.getString(3));



            listaUsuarios.add(usuario);

        }
        obtenerLista();
    }
    private void obtenerLista(){
        listaInformacion=new ArrayList<String>();

        for(int=0; i <listaUsuarios.size();i++);
        listaInformacion.add(listaUsuarios.get(i).getId()+ " - "
        +listaUsuarios.get(i).getNombre());

    }
}
