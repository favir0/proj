package com.fadee.proj.games.services;

import com.fadee.proj.games.models.Country;
import com.fadee.proj.games.repositories.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public ResponseEntity getById(Long id){
        return ResponseEntity.ok(this.countryRepository.findById(id).get());
    }

    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.countryRepository.findAll());
    }

    public ResponseEntity add(Country country){
        return ResponseEntity.status(201).body(this.countryRepository.save(country));
    }

    public ResponseEntity put(Long id, Country country){
        Country countryToUpdate = this.countryRepository.findById(id).get();
        countryToUpdate.setName(country.getName());
        countryToUpdate.setFlag_image(country.getFlag_image());
        return ResponseEntity.status(202).body(this.countryRepository.save(countryToUpdate));
    }

    public ResponseEntity delete(Long id){
        Country country = this.countryRepository.findById(id).get();
        this.countryRepository.deleteById(id);
        return ResponseEntity.status(203).body(country);
    }
}
