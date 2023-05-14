package com.example.restapihw;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MoviePersisted {
    private String name;
    private Genre genre;
    private int year;
    private String director;
    private long id;

    public MoviePersisted (String name, Genre genre, int year, String director, long id) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.director = director;
        this.id = id;
    }

    public Movie toMovie () {
        return new Movie(this.getName(), this.getGenre(), this.getYear(), this.getDirector());
    }
}
