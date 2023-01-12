package com.fadee.proj.games.services;

import com.fadee.proj.games.models.Developer;
import com.fadee.proj.games.repositories.DeveloperRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {
    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public ResponseEntity getById(Long id){
        return ResponseEntity.ok(this.developerRepository.findById(id).get());
    }

    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.developerRepository.findAll());
    }

    public ResponseEntity add(Developer developer){
        return ResponseEntity.status(201).body(this.developerRepository.save(developer));
    }

    public ResponseEntity put(Long id, Developer publisher){
        Developer developerToUpdate = this.developerRepository.findById(id).get();
        developerToUpdate.setName(publisher.getName());
        developerToUpdate.setDescription(publisher.getDescription());
        developerToUpdate.setCountry(publisher.getCountry());
        return ResponseEntity.status(202).body(this.developerRepository.save(developerToUpdate));
    }

    public ResponseEntity delete(Long id){
        Developer publisher = this.developerRepository.findById(id).get();
        this.developerRepository.deleteById(id);
        return ResponseEntity.status(203).body(publisher);
    }

}
