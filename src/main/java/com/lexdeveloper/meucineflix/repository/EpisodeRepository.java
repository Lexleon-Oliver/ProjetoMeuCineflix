package com.lexdeveloper.meucineflix.repository;

import com.lexdeveloper.meucineflix.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode,Long> {
}
