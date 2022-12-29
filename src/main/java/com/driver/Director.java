package com.driver;

public class Director {
    public String name;
    public int numberOfMovies;
    public double imdbRating;

    public Director() {
    }

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}
