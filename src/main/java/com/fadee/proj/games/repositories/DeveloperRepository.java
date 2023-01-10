package com.fadee.proj.games.repositories;

import com.fadee.proj.games.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
