package com.lexdeveloper.meucineflix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EpisodeDTO {
    private Long id;

    @NotEmpty(message = "The storage field can't be empty!")
    @Size(max = 255, message = "The storage field must have until 255 characters")
    private String storage;

    @NotEmpty(message = "The episode name field can't be empty!")
    @Size(max = 255, message = "The episode name field must have until 255 characters")
    private String nameEpisode;

    private int numEpisode;

    private Long season;
}
