package com.example.restapihw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestMovieController {
    @Autowired
    private MovieDao movieDao;

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie (@RequestBody Movie movie) {
        return ResponseEntity.ok(this.movieDao.createMovie(movie));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MoviePersisted>> getMovie () {
        return ResponseEntity.ok(this.movieDao.getAllMovies());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<Movie> getMovieById (@PathVariable long movieId) {
        return ResponseEntity.ok(this.movieDao.getMovie(movieId));
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<Movie> updateMovie (@PathVariable long movieId, @RequestBody Movie updatedMovie) {
        return ResponseEntity.ok(this.movieDao.updateMovie(movieId, updatedMovie));
    }

    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Boolean> deleteMovie (@PathVariable long movieId) {
        return ResponseEntity.ok(this.movieDao.deleteMovie(movieId));
    }
}
