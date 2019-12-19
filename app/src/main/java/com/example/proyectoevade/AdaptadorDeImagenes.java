package com.example.proyectoevade;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


        public class AdaptadorDeImagenes extends BaseAdapter {
            private Context context;

            public AdaptadorDeImagenes(Context context) {
                this.context = context;
            }

            @Override
            public int getCount() {
                return Imagen.ITEMS.length;
            }

            @Override
            public Imagen getItem(int position) {
                return Imagen.ITEMS[position];
            }

            @Override
            public long getItemId(int position) {
                return getItem(position).getId();
            }

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {

                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.activity_imagenes, viewGroup, false);
                }

                ImageView imagenImagen = (ImageView) view.findViewById(R.id.imagen_imagen);
                TextView nombreImagen = (TextView) view.findViewById(R.id.nombre_imagen);

                final Imagen item = getItem(position);
                Glide.with(imagenImagen.getContext())
                        .load(item.getIdDrawable())
                        .into(imagenImagen);

                nombreImagen.setText(item.getNombre());

                return view;
            }
            }



