package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
     @Autowired
     MovieRepository movieRepository;
    public ResponseEntity<String> addMovie(Movie movie){
        if(movieRepository.addMovieTodb(movie)){
            return new ResponseEntity<>("Movie Added", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<String> addDirector(Director director){
        movieRepository.addDirectorTodb(director);
        return new ResponseEntity<>("Director added",HttpStatus.ACCEPTED);
    }
    public ResponseEntity<String> addMovieDirectorPair(String movieName,String directorName){
        if(movieRepository.addPairtoDb(movieName,directorName)){
            return new ResponseEntity<>("Pair Added",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Movie> getMovieByName(String movieName){
        Movie movie= movieRepository.getMovie(movieName);
        if(movie!=null){
            return new ResponseEntity<>(movie,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Director> getDirectorByName(String directorName){
        Director director= movieRepository.getDirector(directorName);
        if(director!=null){
            return new ResponseEntity<>(director,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<List<String>> getMoviesByDirectorName(String directorName){
        List<String> movies= movieRepository.getMovies(directorName);
        if(movies!=null){
            return new ResponseEntity<>(movies,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies= movieRepository.getAllMovies();
        if(movies!=null){
            return new ResponseEntity<>(movies,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<String> deleteDirectorByName(String director){
        if(movieRepository.deleteDirector(director)) return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
        else return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<String> deleteAllDirectors(){
        if(movieRepository.deleteAllDirector()) return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
        else return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
    }

}
