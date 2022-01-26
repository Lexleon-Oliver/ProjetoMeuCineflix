package com.lexdeveloper.meucineflix.resource;

import com.lexdeveloper.meucineflix.dto.request.EpisodeDTO;
import com.lexdeveloper.meucineflix.dto.request.MovieDTO;
import com.lexdeveloper.meucineflix.dto.request.SeasonDTO;
import com.lexdeveloper.meucineflix.dto.request.SerieDTO;
import com.lexdeveloper.meucineflix.dto.response.MessageResponseDTO;
import com.lexdeveloper.meucineflix.service.SerieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/series")
public class SerieResource {
    private SerieService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<SerieDTO> allSeries(Pageable pageable) {
        return service.listAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createSerie(@RequestBody @Valid SerieDTO serieDTO){
        return service.createSerie(serieDTO);
    }

    @PostMapping("/seasons")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createSeason(@RequestBody @Valid SeasonDTO seasonDTO){
        return service.createSeason(seasonDTO);
    }

    @PostMapping("/seasons/episodes")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEpisode(@RequestBody @Valid EpisodeDTO episodeDTO){
        return service.createEpisode(episodeDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SerieDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/player/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void playById(@PathVariable Long id) {
        service.playById(id);
    }

}
