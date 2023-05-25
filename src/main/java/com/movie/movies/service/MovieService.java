package com.movie.movies.service;

import com.movie.movies.entity.Movies;
import com.movie.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movies> allMovies(){
        return movieRepository.findAll();
    }
    public Optional<Movies> singleMovie(ObjectId id){
        return movieRepository.findById(id);
    }
    public Optional<Movies> movieByImdbId(String imdbId){
        return  movieRepository.findMoviesByImdbId(imdbId);
    }

}
