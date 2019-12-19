package com.example.proyectoevade;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


    public class Videos extends Activity implements View.OnClickListener{
        private Button btnPlay;
        private Button btnPause;
        private Button btnStop;
        private VideoView video;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_videos);

            video=(VideoView) findViewById(R.id.videoView);
            String path = "android.resource://" + getPackageName(); //+ "/"/+ R.raw.martian_wrinkle;
            video.setVideoURI(Uri.parse(path));

            //Obtenemos los tres botones de la interfaz
            btnPlay= (Button)findViewById(R.id.btnPlay);
            btnStop= (Button)findViewById(R.id.btnStop);
            btnPause= (Button)findViewById(R.id.btnPause);

            //Y les asignamos el controlador de eventos
            btnPlay.setOnClickListener(this);
            btnStop.setOnClickListener(this);
            btnPause.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            //Comprobamos el identificador del boton que ha llamado al evento para ver
            //cual de los botones es y ejecutar la acción correspondiente
            switch(v.getId()){
                case R.id.btnPlay:
                    //Iniciamos el video
                    video.start();
                    break;
                case R.id.btnPause:
                    //Pausamos el video
                    video.pause();
                    break;
                case R.id.btnStop:
                    //Paramos el video y volvemos a inicializar

                    video.stopPlayback();
                    video.seekTo(0);


                    break;

            }
        }
    }

