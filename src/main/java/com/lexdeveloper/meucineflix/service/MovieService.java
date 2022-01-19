package com.lexdeveloper.meucineflix.service;

import com.lexdeveloper.meucineflix.dto.request.MovieDTO;
import com.lexdeveloper.meucineflix.dto.response.MessageResponseDTO;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    List<MovieDTO> listAll(Pageable pageable);

    MessageResponseDTO createMovie(MovieDTO movieDTO);

    MovieDTO findById(Long id);

    MessageResponseDTO deleteMovie(Long id);

    MessageResponseDTO updateMovie(Long id, MovieDTO movieDTO);

    List<MovieDTO> findByYear( int year, Pageable pageable);

    List<MovieDTO> findByGenre(String genre, Pageable pageable);

    List<MovieDTO> findByRecents(Pageable pageable);

    List<MovieDTO> findByClassics(Pageable pageable);

    void playById(Long id);
}
