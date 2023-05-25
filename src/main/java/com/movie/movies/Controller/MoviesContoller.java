package com.movie.movies.Controller;

import com.movie.movies.entity.Movies;
import com.movie.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesContoller {
    @Autowired
    private MovieService movieService;
    @GetMapping("/all")
    public ResponseEntity<List<Movies>> allMovies(){
        return new ResponseEntity<List<Movies>>(movieService.allMovies(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movies>> movieById(@PathVariable("id")ObjectId id){
        return new ResponseEntity<Optional<Movies>>(movieService.singleMovie(id),HttpStatus.OK);
    }
    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movies>> movieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(movieService.movieByImdbId(imdbId),HttpStatus.OK);
    }

}
