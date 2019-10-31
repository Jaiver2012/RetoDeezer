package com.example.deezer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.deezer.util.HTTPSWebUtilDomi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.AutoText;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class seeList extends AppCompatActivity {


    //corregir
    private ListView listView;
    private AdapterSongList adapterSongList;

    private Button butBack;
    private  Button butMenu;
    private ImageView imagen;
    private TextView namePlayList;
    private TextView description;
    private TextView numberSongs;
    private TextView numberFans;

    private  Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_list);



            imagen=findViewById(R.id.imagen);
            butBack=findViewById(R.id.butBack);
            butMenu=findViewById(R.id.menu);
            namePlayList=findViewById(R.id.namePlayList);
            description=findViewById(R.id.description);
            numberSongs=findViewById(R.id.numberSongs);
            numberFans=findViewById(R.id.numberFans);

            butMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), searchList.class);
                    startActivity(i);
                    finish();
                }
            });

            adapterSongList=new AdapterSongList();
            listView= findViewById(R.id.listSongs);
            listView.setAdapter(adapterSongList);

            PlayList playList=null;
            Bundle parametros = this.getIntent().getExtras();
            if(parametros!=null){

                 playList= (PlayList) getIntent().getExtras().get("selected");


                PlayList finalPlayList = playList;
              /*
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        bmp=image(finalPlayList.getpicture_small());
                    }
                });
                t.start();
                try {
                    t.join();
                }catch (Exception e){
                }
                imagen.setImageBitmap(bmp);
                */
                Picasso.get().load(finalPlayList.getpicture_small()).into(imagen);

                namePlayList.setText(playList.getTitle());
                description.setText(playList.getDescription());
                numberSongs.setText("# de canciones: "+playList.getNb_tracks());
                numberFans.setText("# de fans: "+playList.getFans());

                new Thread(()->{

                    runOnUiThread(()->{

                        adapterSongList.setSongLists(finalPlayList.getTracks().getData());
                    });

                }).start();


            }


            butBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });



          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                  track song= (track) adapterSongList.getItem(i);
                  int id=song.getId();

                  Intent in= new Intent(getApplicationContext(), song.class);

                  String address="https://api.deezer.com/track/"+id;

                  Gson gson = new Gson();
                  new Thread(()->{
                      try {

                          HTTPSWebUtilDomi utilDomi = new HTTPSWebUtilDomi();
                          String u= utilDomi.GETrequest(address);


                          runOnUiThread(()->{

                             track option= gson.fromJson(u,track.class);
                              Toast.makeText(seeList.this,"Hola"+option.getTitle_short(),Toast.LENGTH_LONG).show();
                              in.putExtra("selected",option);
                              startActivity(in);
                          });

                      }catch (IOException ex){
                          ex.printStackTrace();
                      }
                  }).start();


              }
          });



        }

    public Bitmap image(String uri){
        Bitmap bmp=null;
        URL url = null;
        try {
            url = new URL(uri);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }

}
