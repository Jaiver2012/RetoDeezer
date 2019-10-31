package com.example.deezer;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayList  implements Serializable {

    private  String picture_small;
    private long id;
    private  String title;
    private  User user;
    private  int nb_tracks;
    private  String description;
    private  int fans;


    private ItemData2 tracks;

    public PlayList(String picture_small, long id, String title, User user, int nb_tracks, String description, int fans) {
        this.picture_small = picture_small;
        this.id = id;
        this.title = title;
        this.user = user;
        this.nb_tracks = nb_tracks;
        this.description = description;
        this.fans = fans;
    }

    public PlayList(String picture_small, long id, String title, User user, int nb_tracks, String description, int fans, ItemData2 tracks) {
        this.picture_small = picture_small;
        this.id = id;
        this.title = title;
        this.user = user;
        this.nb_tracks = nb_tracks;
        this.description = description;
        this.fans = fans;
        this.tracks = tracks;
    }

    public ItemData2 getTracks() {
        return tracks;
    }

    public void setTracks(ItemData2 tracks) {
        this.tracks = tracks;
    }


    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }



    public String getpicture_small() {
        return picture_small;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public String getDescription() {
        return description;
    }

    public int getFans() {
        return fans;
    }

    public void setpicture_small(String picture) {
        this.picture_small = picture_small;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }
}
