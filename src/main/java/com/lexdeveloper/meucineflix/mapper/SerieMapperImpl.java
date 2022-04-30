package com.lexdeveloper.meucineflix.mapper;

import com.lexdeveloper.meucineflix.dto.request.EpisodeDTO;
import com.lexdeveloper.meucineflix.dto.request.SeasonDTO;
import com.lexdeveloper.meucineflix.dto.request.SerieDTO;
import com.lexdeveloper.meucineflix.entity.Episode;
import com.lexdeveloper.meucineflix.entity.Season;
import com.lexdeveloper.meucineflix.entity.Serie;

import java.util.ArrayList;
import java.util.List;

public class SerieMapperImpl implements SerieMapper{

    @Override
    public Serie toSerieModel (SerieDTO serieDTO) {
        if (serieDTO ==null){
            return null;
        }
        Serie serie= new Serie();
        serie.setId(serieDTO.getId());
        serie.setName(serieDTO.getName());
        serie.setNameBr(serieDTO.getNameBr());
        serie.setYear(serieDTO.getYear());
        serie.setDescription(serieDTO.getDescription());
        serie.setThumbnail(serieDTO.getThumbnail());
        serie.setBackground(serieDTO.getBackground());
        serie.setGenre(serieDTO.getGenre());
        serie.setRating(serieDTO.getRating());
        serie.setSeasons(toSeasonListModel(serieDTO.getSeason()));
        return serie;
    }

    @Override
    public SerieDTO toSerieDTO(Serie serie) {
        if (serie==null){
            return null;
        }
        SerieDTO serieDTO = new SerieDTO();
        serieDTO.setId(serie.getId());
        serieDTO.setName(serie.getName());
        serieDTO.setNameBr(serie.getNameBr());
        serieDTO.setYear(serie.getYear());
        serieDTO.setDescription(serie.getDescription());
        serieDTO.setThumbnail(serie.getThumbnail());
        serieDTO.setBackground(serie.getBackground());
        serieDTO.setGenre(serie.getGenre());
        serieDTO.setRating(serie.getRating());
        serieDTO.setSeason(toSeasonListDTO(serie.getSeasons()));
        return serieDTO;
    }

    @Override
    public Season toSeasonModel(SeasonDTO seasonDTO) {
        if(seasonDTO ==null){
            return null;
        }
        Season season = new Season();
        season.setId(seasonDTO.getId());
        season.setNumSeason(seasonDTO.getNumSeason());
        season.setSerie(seasonDTOToSerie(seasonDTO));
        season.setEpisodes(toEpisodeListModel(seasonDTO.getEpisode()));
        return season;
    }

    @Override
    public SeasonDTO toSeasonDTO(Season season) {
        if (season == null){
            return null;
        }
        SeasonDTO seasonDTO = new SeasonDTO();
        seasonDTO.setId(season.getId());
        seasonDTO.setNumSeason(season.getNumSeason());
        seasonDTO.setSerie(seasonToSerieID(season));
        seasonDTO.setSeasonBack(season.getSeasonBack());
        seasonDTO.setEpisode(toEpisodeListDTO(season.getEpisodes()));
        return seasonDTO;
    }

    protected Serie seasonDTOToSerie(SeasonDTO seasonDTO) {
        if (seasonDTO == null){
            return null;
        }
        Serie serie = new Serie();
        serie.setId(seasonDTO.getSerie());
        return serie;
    }

    private Long seasonToSerieID(Season season) {
        if (season == null){
            return null;
        }
        Serie serie = season.getSerie();
        if (serie == null){
            return null;
        }
        Long id = serie.getId();
        if (id==null){
            return null;
        }
        return id;
    }

    @Override
    public List<Season> toSeasonListModel(List<SeasonDTO> seasonDTOList){
        if (seasonDTOList == null){
            return null;
        }
        List<Season> seasons = new ArrayList<Season>(seasonDTOList.size());
        for (SeasonDTO seasonDTO:seasonDTOList){
            seasons.add(toSeasonModel(seasonDTO));
        }
        return seasons;
    }

    @Override
    public List<SeasonDTO> toSeasonListDTO(List<Season> seasonList){
        if (seasonList == null){
            return null;
        }
        List<SeasonDTO> dtoList = new ArrayList<SeasonDTO>(seasonList.size());
        for (Season season:seasonList){
            dtoList.add(toSeasonDTO(season));
        }
        return dtoList;
    }

    @Override
    public Episode toEpisodeModel(EpisodeDTO episodeDTO) {
        if (episodeDTO == null){
            return null;
        }
        Episode episode = new Episode();
        episode.setId(episodeDTO.getId());
        episode.setStorage(episodeDTO.getStorage());
        episode.setNameEpisode(episodeDTO.getNameEpisode());
        episode.setNumEpisode(episodeDTO.getNumEpisode());
        episode.setSeason(episodeDTOToSeason(episodeDTO));
        return episode;
    }

    @Override
    public EpisodeDTO toEpisodeDTO(Episode episode) {
        if (episode == null){
            return null;
        }
        EpisodeDTO episodeDTO = new EpisodeDTO();
        episodeDTO.setId(episode.getId());
        episodeDTO.setStorage(episode.getStorage());
        episodeDTO.setNameEpisode(episode.getNameEpisode());
        episodeDTO.setNumEpisode(episode.getNumEpisode());
        episodeDTO.setSeason(episodeToSeasonDTO(episode));
        return episodeDTO;
    }

    private Season episodeDTOToSeason(EpisodeDTO episodeDTO) {
        if (episodeDTO == null){
            return null;
        }
        Season season = new Season();
        season.setId(episodeDTO.getSeason());
        return season;
    }

    private Long episodeToSeasonDTO(Episode episode) {
        if (episode ==null){
            return null;
        }
        Season season= episode.getSeason();
        if (season ==null){
            return null;
        }
        Long id =season.getId();
        if (id==null){
            return null;
        }
        return id;
    }

    @Override
    public List<Episode> toEpisodeListModel(List<EpisodeDTO> episodeDTOList){
        if (episodeDTOList == null){
            return null;
        }
        List<Episode> episodes = new ArrayList<Episode>(episodeDTOList.size());
        for (EpisodeDTO episodeDTO:episodeDTOList){
            episodes.add(toEpisodeModel(episodeDTO));
        }
        return episodes;
    }

    public List<EpisodeDTO> toEpisodeListDTO(List<Episode> episodeList){
        if (episodeList==null){
            return null;
        }
        List<EpisodeDTO> episodeDTOList = new ArrayList<EpisodeDTO>(episodeList.size());
        for (Episode episode: episodeList){
            episodeDTOList.add(toEpisodeDTO(episode));
        }
        return episodeDTOList;
    }




}
