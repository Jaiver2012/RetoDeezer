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

public class AdaptePlayList extends BaseAdapter {
    private ArrayList<PlayList> list_Play;
    private  Bitmap bmp;
    public AdaptePlayList() {
        list_Play= new ArrayList<>();
    }
    public AdaptePlayList(ArrayList<PlayList> list_Play, Bitmap bmp) {
        this.list_Play = list_Play;
        this.bmp = bmp;
    }
    @Override
    public int getCount() {
        return list_Play.size();
    }
    @Override
    public Object getItem(int i) {
        return list_Play.get(i);
    }
    @Override
    public long getItemId(int i) {
        return list_Play.get(i).getId();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = inflater.inflate(R.layout.activity_item, null);
        ImageView rowImage = rowView.findViewById(R.id.img);
        TextView rowName = rowView.findViewById(R.id.nameList);
        TextView rowViews = rowView.findViewById(R.id.nameUser);
        TextView rowDesc = rowView.findViewById(R.id.numberItem);
        rowName.setText(list_Play.get(i).getTitle());
        rowViews.setText(list_Play.get(i).getUser().getName());
        rowDesc.setText(""+list_Play.get(i).getNb_tracks());
        Picasso.get().load(list_Play.get(i).getpicture_small()).into(rowImage);


        return rowView;

    }
    public  Bitmap image(String uri){
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

    public void setList_Play(ArrayList<PlayList> list_Play) {
        this.list_Play = list_Play;
        notifyDataSetChanged();
    }
}
