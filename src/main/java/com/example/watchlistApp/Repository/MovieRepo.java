package com.example.watchlistApp.Repository;

import com.example.watchlistApp.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer>
{

}
