package com.example.deezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.security.spec.ECParameterSpec;
import java.util.Date;

public class song extends AppCompatActivity {


    private ImageView imgTrack;
    private TextView txtNameSong;
    private TextView txtArtist;
    private TextView txtAlbum;
    private EditText edDuration;
    private Button butListen;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);


        imgTrack= findViewById(R.id.imgTrack);
        txtNameSong=findViewById(R.id.txtNametrack);
        txtArtist=findViewById(R.id.txtArtist);
        txtAlbum=findViewById(R.id.txtAlbum);
        edDuration=findViewById(R.id.txtDuration);
        butListen=findViewById(R.id.butEscuchar);

        track track=null;
        Bundle parametros = this.getIntent().getExtras();
        if(parametros!=null){

            track= (track) getIntent().getExtras().get("selected");

            Picasso.get().load(track.getAlbum().getCover_small()).into(imgTrack);
            txtNameSong.setText(track.getTitle_short());
            txtArtist.setText(track.getArtist().getName());
            txtAlbum.setText(track.getAlbum().getTitle());
            edDuration.setText(track.getDuration()+"");


        }


        butListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                track track= (track) getIntent().getExtras().get("selected");

                Uri uri = Uri.parse(track.getPreview());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


    }
}
