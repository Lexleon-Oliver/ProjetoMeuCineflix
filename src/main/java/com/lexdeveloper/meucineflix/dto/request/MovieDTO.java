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
public class MovieDTO {

    private Long id;

    @NotEmpty(message = "The name field can't be empty!")
    @Size(max = 255, message = "The name field must have until 255 characters")
    private String name;

    @NotEmpty(message = "The nameBr field can't be empty!")
    @Size(max = 255, message = "The nameBr field must have until 255 characters")
    private String nameBr;

    @NotEmpty(message = "The year field can't be empty!")
    @Size(min = 4,max = 4, message = "The year field must have just 4 characters")
    private String year;

    @NotEmpty(message = "The description field can't be empty!")
    @Size(max = 700, message = "The description field must have until 700 characters")
    private String description;

    @NotEmpty(message = "The thumbnail field can't be empty!")
    @Size(max = 255, message = "The thumbnail field must have until 255 characters")
    private String thumbnail;

    @NotEmpty(message = "The background field can't be empty!")
    @Size(max = 255, message = "The background field must have until 255 characters")
    private String background;

    @NotEmpty(message = "The storage field can't be empty!")
    @Size(max = 255, message = "The storage field must have until 255 characters")
    private String storage;

    @NotEmpty(message = "The genre field can't be empty!")
    @Size(max = 255, message = "The genre field must have until 255 characters")
    private String genre;

    @NotEmpty
    private int rating;
}

