package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb=new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();
    HashMap<Director, List<Movie>> pairDb=new HashMap<>();
    boolean addMovieTodb(Movie movie){
        movieDb.put(movie.name,movie);
        return true;
    }
    void addDirectorTodb(Director director){
        directorDb.put(director.name,director);
    }
    boolean addPairtoDb(String movieName,String directorName){
        if(movieDb.containsKey(movieName) && directorDb.containsKey(directorName)){
            if(!pairDb.containsKey(directorDb.get(directorName))){
                List<Movie>li=new ArrayList<>();
                li.add(movieDb.get(movieName));
                pairDb.put(directorDb.get(directorName),li);
                return true;
            }else{
                List<Movie> li=pairDb.get(directorDb.get(directorName));
                li.add(movieDb.get(movieName));
                pairDb.put(directorDb.get(directorName), li);
            }

        }
        return false;
    }
    Movie getMovie(String movie){
        if(movieDb.containsKey(movie)) return movieDb.get(movie);
        return null;
    }
    Director getDirector(String director){
        if(directorDb.containsKey(director)) return directorDb.get(director);
        return null;
    }
    List<Movie> getMovies(String director){
        if(pairDb.containsKey(directorDb.get(director))) return pairDb.get(directorDb.get(director));
        return null;
    }
     List<Movie> getAllMovies(){
        List<Movie> li=new ArrayList<>();
        for(Movie movie:movieDb.values()){
            li.add(movie);
        }
        return li;
    }
    boolean deleteDirector(String directorName){
        if(directorDb.containsKey(directorName)){
            directorDb.remove(directorName);
            pairDb.remove(directorDb.get(directorName));
            return true;
        }else return false;
    }
    boolean deleteAllDirector(){
        for(Map.Entry<Director,List<Movie>> e:pairDb.entrySet()){
            for(Movie movie:pairDb.get(e.getKey())){
                movieDb.remove(movie);
            }
            pairDb.remove(e.getKey());
        }
        directorDb.clear();
        return true;
    }
}
