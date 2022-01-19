package com.lexdeveloper.meucineflix.resource;

import com.lexdeveloper.meucineflix.dto.request.MovieDTO;
import com.lexdeveloper.meucineflix.repository.MovieRepository;
import com.lexdeveloper.meucineflix.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.io.IOException;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogoResource {

    private final MovieRepository repository;
    private final MovieService service;

    @GetMapping()
    public ModelAndView catalogo(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/movie")
    public ModelAndView detailMovie() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("filme");
        return modelAndView;
    }
}
