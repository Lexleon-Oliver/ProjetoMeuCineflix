package com.lexdeveloper.meucineflix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String background;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private Integer rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serie")
    private List<Season> seasons;

}
