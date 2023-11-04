package com.example.watchlistApp.Services;

import com.example.watchlistApp.Entity.Movie;
import com.example.watchlistApp.Repository.MovieRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    RatingServices ratingServices;

    public void create(Movie movie) {
        String car=movie.getTitle();
        System.out.println(car);
        String rating=ratingServices.getratingfromapi(movie.getTitle());
        if (rating != null) {
            try {
                movie.setRating(Float.parseFloat(rating));
            } catch (NumberFormatException e) {
                // Handle the case where the rating from the API is not a valid float.
                // You can set a default value or handle the error as needed.
            }
        } else {
            // Handle the case where the rating is null, e.g., the movie is not found in the database.
            // You can set a default value or handle the error as needed.
        }

        movieRepo.save(movie);
    }

    public List<Movie> getAllMovies() {
        // TODO Auto-generated method stub

        return movieRepo.findAll();
    }




    public Object getMovieById(Integer id) {
        return movieRepo.findById(id).get();
    }

    public void deleteMovieById(Integer id)
    {
        movieRepo.deleteById(id);
    }
}
