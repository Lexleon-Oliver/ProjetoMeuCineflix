package com.lexdeveloper.meucineflix.service;

import com.lexdeveloper.meucineflix.dto.request.MovieDTO;
import com.lexdeveloper.meucineflix.dto.response.MessageResponseDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> listAll();

    MessageResponseDTO createMovie(MovieDTO movieDTO);

    MovieDTO findById(Long id);

    MessageResponseDTO deleteMovie(Long id);

    MessageResponseDTO updateMovie(Long id, MovieDTO movieDTO);

    List<MovieDTO> findByYear( int year);

    List<MovieDTO> findByGenre(String genre);

    List<MovieDTO> findByRecents();

    List<MovieDTO> findByClassics();
}
