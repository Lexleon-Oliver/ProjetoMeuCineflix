package com.lexdeveloper.meucineflix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nameBr;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false, length = 700)
    private String description;

    @Column(nullable = false)
    private String thumbnail;

    @Column(nullable = false)
    private String storage;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private Integer rating;
}
