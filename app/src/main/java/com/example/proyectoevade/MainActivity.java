package com.example.proyectoevade;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.proyectoevade.Modelos.DatabaseHelper;

//EDITAAAAAAAR

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private AdaptadorDeImagenes adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper conn=new DatabaseHelper(this, "bd usuarios", null,1);

        usarToolbar();

        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new AdaptadorDeImagenes(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(this);
    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Imagen item = (Imagen) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, ActivityDetalle.class);
        intent.putExtra(ActivityDetalle.EXTRA_PARAM_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this,
                            new Pair<View, String>(view.findViewById(R.id.imagen_imagen),
                                    ActivityDetalle.VIEW_NAME_HEADER_IMAGE)
                    );

            ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        } else
            startActivity(intent);
    }

}