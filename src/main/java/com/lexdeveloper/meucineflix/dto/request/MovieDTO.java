package com.lexdeveloper.meucineflix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String nameBr;

    @NotEmpty()
    private String year;

    @NotEmpty
    private String description;

    @NotEmpty
    private String thumbnail;

    private String background;

    @NotEmpty
    private String storage;

    @NotEmpty
    private String genre;

    private int rating;
}

