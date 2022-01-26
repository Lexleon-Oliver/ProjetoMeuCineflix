package com.lexdeveloper.meucineflix.mapper;

import com.lexdeveloper.meucineflix.dto.request.MovieDTO;
import com.lexdeveloper.meucineflix.entity.Movie;

public class MovieMapperImpl implements MovieMapper{
    @Override
    public Movie toModel(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId( movieDTO.getId() );
        movie.setName( movieDTO.getName() );
        movie.setNameBr( movieDTO.getNameBr() );
        movie.setYear( movieDTO.getYear() );
        movie.setDescription( movieDTO.getDescription() );
        movie.setThumbnail( movieDTO.getThumbnail() );
        movie.setBackground( movieDTO.getBackground() );
        movie.setStorage( movieDTO.getStorage() );
        movie.setGenre( movieDTO.getGenre() );
        movie.setRating( movieDTO.getRating() );

        return movie;
    }

    @Override
    public MovieDTO toDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO.MovieDTOBuilder movieDTO = MovieDTO.builder();

        movieDTO.id( movie.getId() );
        movieDTO.name( movie.getName() );
        movieDTO.nameBr( movie.getNameBr() );
        movieDTO.year( movie.getYear() );
        movieDTO.description( movie.getDescription() );
        movieDTO.thumbnail( movie.getThumbnail() );
        movieDTO.background( movie.getBackground() );
        movieDTO.storage( movie.getStorage() );
        movieDTO.genre( movie.getGenre() );
        movieDTO.rating( movie.getRating() );

        return movieDTO.build();
    }
}
