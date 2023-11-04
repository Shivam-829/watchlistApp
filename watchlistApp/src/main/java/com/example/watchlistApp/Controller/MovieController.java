package com.example.watchlistApp.Controller;

import com.example.watchlistApp.Entity.Movie;
import com.example.watchlistApp.Services.DatabaseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    DatabaseService databaseService;

    @GetMapping("/watchlistItemForm")
    public ModelAndView showwatchlistform(@RequestParam (required = false) Integer id)
    {
        String viewname="watchlistItemForm";
        Map<String,Object> model= new HashMap<>();
        if(id == null) {
            model.put("watchlistItem", new Movie());
        } else {
            model.put("watchlistItem", databaseService.getMovieById(id));
        }


        return new ModelAndView(viewname,model);
    }
    @PostMapping ("/watchlistItemForm")
    public ModelAndView submitwatchlistform(Movie movie)
    {
       databaseService.create(movie);
//        RedirectView rd=new RedirectView();
//         rd.setUrl("/watchlist");
//         return new ModelAndView(rd);
        return new ModelAndView("redirect:/watchlist");
    }

    @GetMapping("/watchlist")
    public ModelAndView getwatchlist(@RequestParam(required = false) Integer id)
    {
        String viewname = "watchlist";
        Map<String, Object> model = new HashMap<>();
        List<Movie> movieList = databaseService.getAllMovies();
            model.put("watchlistrows", movieList);
            model.put("noofmovies", movieList.size());
        return new ModelAndView(viewname, model);
    }

    @GetMapping("/deleteMovie")
    public ModelAndView deleteMovie(@RequestParam(required = true) Integer id) {
        databaseService.deleteMovieById(id);
        return new ModelAndView("redirect:/watchlist");
    }


}


