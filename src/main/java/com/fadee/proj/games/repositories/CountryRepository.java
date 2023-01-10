package com.fadee.proj.games.repositories;

import com.fadee.proj.games.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
