package com.lexdeveloper.meucineflix.resource;

import com.lexdeveloper.meucineflix.dto.request.MovieDTO;
import com.lexdeveloper.meucineflix.dto.response.MessageResponseDTO;
import com.lexdeveloper.meucineflix.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/movies")
public class MovieResource {
    private MovieService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> allMovies() {
        return service.listAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createMovie(@Valid @RequestBody MovieDTO movieDTO){
        return service.createMovie(movieDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteMovie(@PathVariable Long id){
        return service.deleteMovie(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateMovie(@PathVariable Long id, @Valid @RequestBody MovieDTO movieDTO){
        return service.updateMovie(id,movieDTO);
    }
}
