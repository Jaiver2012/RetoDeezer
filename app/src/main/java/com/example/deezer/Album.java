package com.example.deezer;

import java.io.Serializable;

public class Album implements Serializable {

  String  id, title, link,  cover_small;


    public Album(String id, String title, String link, String cover_small) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.cover_small = cover_small;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCover_small() {
        return cover_small;
    }

    public void setCover_small(String cover_small) {
        this.cover_small = cover_small;
    }
}
