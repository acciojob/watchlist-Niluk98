package com.driver;

public class Movie {
    public String name;
    public int durationInMinutes;
    double imdbRating;
    public Movie(){

    }

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }
}
