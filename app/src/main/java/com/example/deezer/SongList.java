package com.example.deezer;

public class SongList {

    private  String picture_small;
    private long id;
    private  String title;
    private  String description;
    private  int nb_tracks;
    private  int fans;
    private  User user;

    private String title_short;
    private Artist artist;
    //private timestamp time_add;


    public SongList(String picture_small, long id, String title, String description, int nb_tracks, int fans, User user, String title_short, Artist artist) {
        this.picture_small = picture_small;
        this.id = id;
        this.title = title;
        this.description = description;
        this.nb_tracks = nb_tracks;
        this.fans = fans;
        this.user = user;
        this.title_short = title_short;
        this.artist = artist;
    }

    public SongList() {
    }

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle_short() {
        return title_short;
    }

    public void setTitle_short(String title_short) {
        this.title_short = title_short;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
