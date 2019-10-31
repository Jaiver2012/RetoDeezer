package com.example.deezer;

import java.util.ArrayList;

public class ItemData {

    private ArrayList<PlayList> data;

    public ItemData() {
    }

    public ItemData(ArrayList<PlayList> data) {
        this.data = data;
    }

    public ArrayList<PlayList> getData() {
        return data;
    }

    public void setData(ArrayList<PlayList> data) {
        this.data = data;
    }
}
