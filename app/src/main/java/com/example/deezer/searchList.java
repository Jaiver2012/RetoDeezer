package com.example.deezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.AutoText;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deezer.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class searchList extends AppCompatActivity {

    private ListView listView;
    private AdaptePlayList adaptePlayList;
    private ArrayList<PlayList> lit;
    private Button butBack;
    private  Button butSearch;
    private TextView respuesta;
    private PlayList option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        butBack=findViewById(R.id.butBack);
        respuesta=findViewById(R.id.searchs);

        lit= new ArrayList<>();

        adaptePlayList=new AdaptePlayList();
        listView= findViewById(R.id.listV);
        listView.setAdapter(adaptePlayList);

        butBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        butBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        butSearch=findViewById(R.id.butSearch);
        butSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Gson gson = new Gson();

                String re=respuesta.getText().toString();
                Toast.makeText(searchList.this,"Hol"+re,Toast.LENGTH_LONG).show();

                new Thread(()->{
                    try {

                        HTTPSWebUtilDomi utilDomi = new HTTPSWebUtilDomi();
                        String u= utilDomi.GETrequest("https://api.deezer.com/search/playlist?q="+re);

                        ItemData itemData= gson.fromJson(u,ItemData.class);
                        runOnUiThread(()->{
                            adaptePlayList.setList_Play(itemData.getData());
                        });

                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }).start();



            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Long id=adaptePlayList.getItemId(i);
                Intent in = new Intent(getApplicationContext(), seeList.class);

                String address="https://api.deezer.com/playlist/"+id;

                Gson gson = new Gson();
                new Thread(()->{
                    try {

                        HTTPSWebUtilDomi utilDomi = new HTTPSWebUtilDomi();
                        String u= utilDomi.GETrequest(address);


                        runOnUiThread(()->{

                            option= gson.fromJson(u,PlayList.class);
                            Toast.makeText(searchList.this,"Hola"+option.getTitle(),Toast.LENGTH_LONG).show();
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
}
