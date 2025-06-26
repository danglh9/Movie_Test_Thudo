package com.dang.movie_test_thudo.model;

import java.util.List;

public class Category {
    private String title;
    private int id;
    private int viewType;
    private List<Movie> movies;

    public Category( int id,int viewType, String title, List<Movie> movies) {
        this.title = title;
        this.id = id;
        this.viewType = viewType;
        this.movies = movies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
