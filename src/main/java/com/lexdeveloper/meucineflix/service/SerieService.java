package com.lexdeveloper.meucineflix.service;

import com.lexdeveloper.meucineflix.dto.request.EpisodeDTO;
import com.lexdeveloper.meucineflix.dto.request.SeasonDTO;
import com.lexdeveloper.meucineflix.dto.request.SerieDTO;
import com.lexdeveloper.meucineflix.dto.response.MessageResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SerieService {
    List<SerieDTO> listAll(Pageable pageable);

    MessageResponseDTO createSerie(SerieDTO serieDTO);

    MessageResponseDTO createSeason(SeasonDTO seasonDTO);

    MessageResponseDTO createEpisode(EpisodeDTO episodeDTO);

    SerieDTO findById(Long id);

    void playById(Long id);

    MessageResponseDTO updateSerie(Long id, SerieDTO serieDTO);
}
