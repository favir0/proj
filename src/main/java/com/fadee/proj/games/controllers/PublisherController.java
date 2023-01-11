package com.fadee.proj.games.controllers;

import com.fadee.proj.games.models.Publisher;
import com.fadee.proj.games.services.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    public final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity getAllPublishers(){
        return publisherService.getAll();
    }
    @GetMapping("{id}")
    public ResponseEntity getPublisher(@PathVariable Long id){
        return publisherService.getById(id);
    }

    @PostMapping
    public ResponseEntity createPublisher(@RequestBody Publisher publisher) {
        return publisherService.add(publisher);
    }

    @PutMapping("{id}")
    public ResponseEntity updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher){
        return publisherService.put(id, publisher);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePublisher(@PathVariable Long id) {
        return publisherService.delete(id);
    }

}
