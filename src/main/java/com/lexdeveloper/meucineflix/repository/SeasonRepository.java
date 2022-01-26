package com.lexdeveloper.meucineflix.repository;

import com.lexdeveloper.meucineflix.entity.Season;
import com.lexdeveloper.meucineflix.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season,Long>{
}
