package com.example.restapihw;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieDao {
    private List<MoviePersisted> movies;

    public MovieDao() {
        this.movies = new ArrayList<>();
    }

    public Movie createMovie (Movie movie) {
        Genre genre = Genre.valueOf(movie.getGenre().toUpperCase());
        this.movies.add(new MoviePersisted(movie.getName(), genre, movie.getYear(), movie.getDirector(), Math.abs(new Random().nextLong())));
        return movie;
    }

    public List<MoviePersisted> getAllMovies () {
        return this.movies;
    }

    public Movie getMovie (long id) {
        for(MoviePersisted moviePersisted : this.movies) {
            if(moviePersisted.getId() == id) {
                return moviePersisted.toMovie();
            }
        }
        return null;
    }

    public Movie updateMovie (long id, Movie updatedMovie) {
        for(MoviePersisted moviePersisted : this.movies) {
            if(moviePersisted.getId() == id) {
                moviePersisted.setName(updatedMovie.getName());
                moviePersisted.setGenre(Genre.valueOf(updatedMovie.getGenre()));
                moviePersisted.setYear(updatedMovie.getYear());
                moviePersisted.setDirector(updatedMovie.getDirector());
            }
            return moviePersisted.toMovie();
        }
        return null;
    }

    public boolean deleteMovie (long id) {
        for(int i = 0; i < this.movies.size(); i++) {
            if(this.movies.get(i).getId() == id) {
                return this.movies.remove(this.movies.get(i));
            }
        }
        return false;
    }
}
