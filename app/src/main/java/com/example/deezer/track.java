package com.example.deezer;

import java.io.Serializable;

public class track implements Serializable {

    private  int id;
    private String title_short;
    private Artist artist;
    private Album album;
    private int duration;
    private String link;
    private String preview;



    public track() {
    }

    public track(String title_short, Artist artist, Album album, int duration, String link) {
        this.title_short = title_short;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.link = link;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
