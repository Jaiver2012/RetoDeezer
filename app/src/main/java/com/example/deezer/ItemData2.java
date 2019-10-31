package com.example.deezer;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemData2 implements Serializable {


    private ArrayList<track> data;

    public ItemData2() {
    }

    public ItemData2(ArrayList<track> data) {
        this.data = data;
    }

    public ArrayList<track> getData() {
        return data;
    }

    public void setData(ArrayList<track> data) {
        this.data = data;
    }
}