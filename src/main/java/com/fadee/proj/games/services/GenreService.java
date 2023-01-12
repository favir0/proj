package com.fadee.proj.games.services;

import com.fadee.proj.games.models.Genre;
import com.fadee.proj.games.repositories.GenreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public ResponseEntity getById(Long id){
        return ResponseEntity.ok(this.genreRepository.findById(id).get());
    }

    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.genreRepository.findAll());
    }

    public ResponseEntity add(Genre genre){
        return ResponseEntity.status(201).body(this.genreRepository.save(genre));
    }

    public ResponseEntity put(Long id, Genre genre){
        Genre genreToUpdate = this.genreRepository.findById(id).get();
        genreToUpdate.setName(genre.getName());
        genreToUpdate.setDescription(genre.getDescription());
        return ResponseEntity.status(202).body(this.genreRepository.save(genreToUpdate));
    }

    public ResponseEntity delete(Long id){
        Genre genre = this.genreRepository.findById(id).get();
        this.genreRepository.deleteById(id);
        return ResponseEntity.status(203).body(genre);
    }
}
