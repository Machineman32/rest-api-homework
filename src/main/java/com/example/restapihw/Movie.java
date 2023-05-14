package com.example.restapihw;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Movie {
    private String name;
    private Genre genre;
    private int year;
    private String director;

    public Movie (String name, Genre genre, int year, String director) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.director = director;
    }
}
