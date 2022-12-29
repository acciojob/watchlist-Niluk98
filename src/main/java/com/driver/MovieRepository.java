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
    HashMap<String, List<String>> pairDb=new HashMap<>();
    boolean addMovieTodb(Movie movie){
        movieDb.put(movie.name,movie);
        return true;
    }
    void addDirectorTodb(Director director){
        directorDb.put(director.name,director);
    }
    boolean addPairtoDb(String movieName,String directorName){
        if(movieDb.containsKey(movieName) && directorDb.containsKey(directorName)){
            if(!pairDb.containsKey(directorName)){
                List<String>li=new ArrayList<>();
                li.add(movieName);
                pairDb.put(directorName,li);

            }else{
                List<String> li=pairDb.get(directorName);
                li.add(movieName);
                pairDb.put(directorName, li);
            }
            return true;

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
    List<String> getMovies(String director){
        if(pairDb.containsKey(director)) return pairDb.get(director);
        return null;
    }
     List<String> getAllMovies(){
        List<String> li=new ArrayList<>();
        for(Movie movie:movieDb.values()){
            li.add(movie.name);
        }
        return li;
    }
    boolean deleteDirector(String directorName){
        if(directorDb.containsKey(directorName)){
            directorDb.remove(directorName);
            pairDb.remove(directorName);
            return true;
        }else return false;
    }
    boolean deleteAllDirector(){
        for(Map.Entry<String,List<String>> e:pairDb.entrySet()){
            for(String movie:pairDb.get(e.getKey())){
                movieDb.remove(movie);
            }
            pairDb.remove(e.getKey());
        }
        directorDb.clear();
        return true;
    }
}
