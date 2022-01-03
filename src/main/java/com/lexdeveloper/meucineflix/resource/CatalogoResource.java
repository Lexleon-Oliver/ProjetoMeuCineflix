package com.lexdeveloper.meucineflix.resource;

import com.lexdeveloper.meucineflix.entity.Movie;
import com.lexdeveloper.meucineflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogoResource {

    private final MovieRepository repository;

    @GetMapping()
    public ModelAndView catalogo(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
