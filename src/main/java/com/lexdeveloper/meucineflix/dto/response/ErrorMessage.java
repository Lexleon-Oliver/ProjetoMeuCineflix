package com.lexdeveloper.meucineflix.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {

    private int status;

    private String message;

    private String title;

    private String type;
}
