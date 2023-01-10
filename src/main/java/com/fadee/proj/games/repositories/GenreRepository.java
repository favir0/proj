package com.fadee.proj.games.repositories;

import com.fadee.proj.games.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
