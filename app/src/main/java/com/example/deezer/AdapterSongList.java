package com.example.deezer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class AdapterSongList extends BaseAdapter {


    private ArrayList<track> songLists;

    private Bitmap bmp;

    public AdapterSongList() {
        songLists= new ArrayList<track>();
    }

    public AdapterSongList(ArrayList<track> songLists) {
        this.songLists = songLists;
    }

    @Override
    public int getCount() {
        return songLists.size();
    }

    @Override
    public Object getItem(int i) {
        return songLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return songLists.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = inflater.inflate(R.layout.item2, null);
        ImageView rowImage = rowView.findViewById(R.id.imagen2);
        TextView rowName = rowView.findViewById(R.id.nameSong);
        TextView rowViews = rowView.findViewById(R.id.nameArtist);
        TextView rowDesc = rowView.findViewById(R.id.year);
        rowName.setText(songLists.get(i).getTitle_short());
        rowViews.setText(songLists.get(i).getArtist().getName());
        Picasso.get().load(songLists.get(i).getAlbum().cover_small).into(rowImage);


        return rowView;

    }


    public ArrayList<track> getSongLists() {
        return songLists;
    }

    public void setSongLists(ArrayList<track> songLists) {
        this.songLists = songLists;
        notifyDataSetChanged();
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }
}
