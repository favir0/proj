package com.fadee.proj.games.controllers;

import com.fadee.proj.games.models.Genre;
import com.fadee.proj.games.services.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Genre", description = "the genre API")
@RequestMapping("/api/genre")
@SecurityRequirement(name = "BasicAuth")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @Operation(summary = "Get all genres", description = "Returns list of genres")
    @GetMapping
    public ResponseEntity getAllGenres(){
        return genreService.getAll();
    }

    @Operation(summary = "Get a genre by id", description = "Returns a genre as per id")
    @GetMapping("{id}")
    public ResponseEntity getGenre(@PathVariable Long id){
        return genreService.getById(id);
    }

    @Operation(summary = "Create a genre", description = "Returns created genre")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added") })
    @PostMapping
    public ResponseEntity createGenre(@RequestBody Genre genre) {
        return genreService.add(genre);
    }

    @Operation(summary = "Update a genre by id", description = "Returns updated genre")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Successfully changed") })
    @PutMapping("{id}")
    public ResponseEntity updateGenre(@PathVariable Long id, @RequestBody Genre genre){
        return genreService.put(id, genre);
    }

    @Operation(summary = "Delete a genre by id", description = "Returns deleted genre")
    @ApiResponses(value = { @ApiResponse(responseCode = "203", description = "Successfully deleted") })
    @DeleteMapping("{id}")
    public ResponseEntity deleteGenre(@PathVariable Long id) {
        return genreService.delete(id);
    }
}
