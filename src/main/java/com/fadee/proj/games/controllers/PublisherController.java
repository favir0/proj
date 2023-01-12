package com.fadee.proj.games.controllers;

import com.fadee.proj.games.models.Publisher;
import com.fadee.proj.games.services.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "Publisher", description = "the publisher API")
@RequestMapping("/api/publisher")
@SecurityRequirement(name = "BasicAuth")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Operation(summary = "Get all publishers", description = "Returns list of publishers")
    @GetMapping
    public ResponseEntity getAllPublishers(){
        return publisherService.getAll();
    }

    @Operation(summary = "Get a publisher by id", description = "Returns a publisher as per id")
    @GetMapping("{id}")
    public ResponseEntity getPublisher(@PathVariable Long id){
        return publisherService.getById(id);
    }

    @Operation(summary = "Create a publisher", description = "Returns created publisher")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added") })
    @PostMapping
    public ResponseEntity createPublisher(@RequestBody Publisher publisher) {
        return publisherService.add(publisher);
    }

    @Operation(summary = "Update a publisher by id", description = "Returns updated publisher")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Successfully changed") })
    @PutMapping("{id}")
    public ResponseEntity updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher){
        return publisherService.put(id, publisher);
    }

    @Operation(summary = "Delete a publisher by id", description = "Returns deleted publisher")
    @ApiResponses(value = { @ApiResponse(responseCode = "203", description = "Successfully deleted") })
    @DeleteMapping("{id}")
    public ResponseEntity deletePublisher(@PathVariable Long id) {
        return publisherService.delete(id);
    }

}
