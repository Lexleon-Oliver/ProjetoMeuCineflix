package com.lexdeveloper.meucineflix.service;

import com.lexdeveloper.meucineflix.dto.request.MovieDTO;
import com.lexdeveloper.meucineflix.dto.response.MessageResponseDTO;
import com.lexdeveloper.meucineflix.entity.Movie;
import com.lexdeveloper.meucineflix.exception.NotFoundException;
import com.lexdeveloper.meucineflix.mapper.MovieMapper;
import com.lexdeveloper.meucineflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieServiceImpl implements MovieService{

    private final MovieRepository repository;
    private final MovieMapper mapper = MovieMapper.INSTANCE;

    public List<MovieDTO> listAll() {
        List<Movie> movies= repository.findAll();
        return movies.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }


    public MessageResponseDTO createMovie(MovieDTO movieDTO) {
        Movie movieToSave = mapper.toModel(movieDTO);
        Movie savedMovie = repository.save(movieToSave);
        return createdMessageResponse(savedMovie.getId(), "Created movie with ID ");
    }

    public MovieDTO findById(Long id) {
        Movie movieFound = verifyIfExists(id);
        return mapper.toDTO(movieFound);
    }


    public MessageResponseDTO deleteMovie(Long id) {
        verifyIfExists(id);
        repository.deleteById(id);
        return createdMessageResponse(id,"Deleted movie with ID ");
    }


    public MessageResponseDTO updateMovie(Long id, MovieDTO movieDTO) {
        verifyIfExists(id);
        Movie movieToUpdate = mapper.toModel(movieDTO);
        Movie updatedMovie = repository.save(movieToUpdate);
        return createdMessageResponse(updatedMovie.getId(), "Updated movie with ID ");
    }

    @Override
    public List<MovieDTO> findByYear(int intYear) {
        String year = String.valueOf(intYear);
        List<Movie> movies= repository.findMoviesByYear(year);
        return repository.findMoviesByYear(year).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> findByGenre(String genre) {
        List<Movie> movies = repository.findByGenre(genre);
        return movies.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> findByRecents() {
        List<MovieDTO> movies = findByYear(setYear());
        if (movies.isEmpty()){
            movies = findByYear(setYear() -1);
        }
        return movies;
    }

    private int setYear() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }

    @Override
    public List<MovieDTO> findByClassics() {
        int year = setYear() - 15;
        List<Movie> movies= repository.findAll();
        return movies.stream()
                .filter(m -> Integer.parseInt(m.getYear()) <= year)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    private MessageResponseDTO createdMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message+id)
                .build();
    }

    private Movie verifyIfExists(Long id){
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
