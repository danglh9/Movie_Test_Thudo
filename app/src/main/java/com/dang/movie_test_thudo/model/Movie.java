package com.dang.movie_test_thudo.model;

public class Movie {
    private int id;
    private String title;
    private String thumbnail;

    private int viewType;



    public Movie(int id,  String title, String thumbnail, int viewType) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.viewType = viewType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
