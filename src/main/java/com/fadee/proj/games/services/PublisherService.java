package com.fadee.proj.games.services;

import com.fadee.proj.games.models.Publisher;
import com.fadee.proj.games.repositories.PublisherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public ResponseEntity getById(Long id){
        return ResponseEntity.ok(this.publisherRepository.findById(id).get());
    }

    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.publisherRepository.findAll());
    }

    public ResponseEntity add(Publisher publisher){
        return ResponseEntity.status(201).body(this.publisherRepository.save(publisher));
    }

    public ResponseEntity put(Long id, Publisher publisher){
        Publisher publisherToUpdate = this.publisherRepository.findById(id).get();
        publisherToUpdate.setName(publisher.getName());
        publisherToUpdate.setDescription(publisher.getDescription());
        publisherToUpdate.setCountry(publisher.getCountry());
        return ResponseEntity.status(202).body(this.publisherRepository.save(publisherToUpdate));
    }

    public ResponseEntity delete(Long id){
        Publisher publisher = this.publisherRepository.findById(id).get();
        this.publisherRepository.deleteById(id);
        return ResponseEntity.status(203).body(publisher);
    }
}
