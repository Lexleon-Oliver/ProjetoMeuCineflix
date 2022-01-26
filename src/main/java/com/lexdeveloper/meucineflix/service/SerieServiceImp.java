package com.lexdeveloper.meucineflix.service;

import com.lexdeveloper.meucineflix.dto.request.EpisodeDTO;
import com.lexdeveloper.meucineflix.dto.request.SeasonDTO;
import com.lexdeveloper.meucineflix.dto.request.SerieDTO;
import com.lexdeveloper.meucineflix.dto.response.MessageResponseDTO;
import com.lexdeveloper.meucineflix.entity.Episode;
import com.lexdeveloper.meucineflix.entity.Movie;
import com.lexdeveloper.meucineflix.entity.Season;
import com.lexdeveloper.meucineflix.entity.Serie;
import com.lexdeveloper.meucineflix.exception.NotFoundException;
import com.lexdeveloper.meucineflix.mapper.SerieMapper;
import com.lexdeveloper.meucineflix.repository.EpisodeRepository;
import com.lexdeveloper.meucineflix.repository.SeasonRepository;
import com.lexdeveloper.meucineflix.repository.SerieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SerieServiceImp implements SerieService {
    private final SerieRepository repository;
    private final SeasonRepository seasonRepo;
    private final EpisodeRepository episodeRepo;
    private final SerieMapper mapper = SerieMapper.INSTANCE;

    public List<SerieDTO> listAll(Pageable pageable) {
        Page<Serie> series= repository.findAll(pageable);
        return series.stream()
                .map(mapper::toSerieDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageResponseDTO createSerie(SerieDTO serieDTO) {
        Serie serieToSave = mapper.toSerieModel(serieDTO);
        Serie savedSerie = repository.save(serieToSave);
        return createdMessageResponse(savedSerie.getId(), "Created serie with ID ");
    }

    @Override
    public MessageResponseDTO createSeason(SeasonDTO seasonDTO) {
        Season seasonToSave = mapper.toSeasonModel(seasonDTO);
        Season savedSeason = seasonRepo.save(seasonToSave);
        return createdMessageResponse(savedSeason.getId(), "Created season with ID ");
    }

    @Override
    public MessageResponseDTO createEpisode(EpisodeDTO episodeDTO) {
        Episode episodeToSave = mapper.toEpisodeModel(episodeDTO);
        Episode savedEpisode = episodeRepo.save(episodeToSave);
        return createdMessageResponse(savedEpisode.getId(),"Created episode with ID ");
    }

    @Override
    public SerieDTO findById(Long id) {
        Serie serieFound = verifyIfExists(id);
        return mapper.toSerieDTO(serieFound);
    }

    @Override
    public void playById(Long id) {
        Episode episodeFound = verifyIfExistsEpisode(id);
        String path = episodeFound.getStorage();
        try {
//            Comando para abrir o filme com o player de video padrão
            String[] args = new String[] {"/bin/bash", "-c", "xdg-open "+path, "with", "args"};
            Process proc = new ProcessBuilder(args).start();
        } catch (Exception error){
            System.out.println("Erro ao abrir episódio: "+path+" Erro: "+error);
        }
    }

    private Serie verifyIfExists(Long id) {
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    private Episode verifyIfExistsEpisode(Long id) {
        return episodeRepo.findById(id)
                .orElseThrow(NotFoundException::new);
    }


    public MessageResponseDTO createdMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message+id)
                .build();
    }

}