package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie ){
        return movieService.addMovie(movie);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        return movieService.addDirector(director);
    }
    @PutMapping("/add-movie-director/")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam() String MovieName, @RequestParam() String DirectorName){
        return movieService.addMovieDirectorPair(MovieName,DirectorName);
    }
    @GetMapping("/get-movie-by-name/{movie}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movie") String movieName){
        return movieService.getMovieByName(movieName);
    }
    @GetMapping("/get-director-by-name/{director}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("director") String directorName){
        return movieService.getDirectorByName(directorName);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
        return movieService.getMoviesByDirectorName(directorName);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>  findAllMovies(){
        return movieService.findAllMovies();
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(@RequestParam() String directorName){
        return movieService.deleteDirectorByName(directorName);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>  deleteAllDirectors(){
        return movieService.deleteAllDirectors();
    }
}
