package com.lexdeveloper.meucineflix.repository;

import com.lexdeveloper.meucineflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query( "SELECT m FROM Movie m WHERE m.year = ?1")
    List<Movie> findMoviesByYear(String year);

    @Query( "SELECT m FROM Movie m WHERE m.genre LIKE  %?1%")
    List<Movie> findByGenre(String genre);

}