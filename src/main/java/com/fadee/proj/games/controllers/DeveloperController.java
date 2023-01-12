package com.fadee.proj.games.controllers;

import com.fadee.proj.games.models.Developer;
import com.fadee.proj.games.services.DeveloperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Developer", description = "the developer API")
@RequestMapping("/api/developer")
public class DeveloperController {
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @Operation(summary = "Get all developers", description = "Returns list of developers")
    @GetMapping
    public ResponseEntity getAllDevelopers(){
        return developerService.getAll();
    }

    @Operation(summary = "Get a developer by id", description = "Returns a developer as per id")
    @GetMapping("{id}")
    public ResponseEntity getDeveloper(@PathVariable Long id){
        return developerService.getById(id);
    }

    @Operation(summary = "Create a developer", description = "Returns created developer")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added") })
    @PostMapping
    public ResponseEntity createDeveloper(@RequestBody Developer developer) {
        return developerService.add(developer);
    }

    @Operation(summary = "Update a developer by id", description = "Returns updated developer")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Successfully changed") })
    @PutMapping("{id}")
    public ResponseEntity updateDeveloper(@PathVariable Long id, @RequestBody Developer developer){
        return developerService.put(id, developer);
    }

    @Operation(summary = "Delete a developer by id", description = "Returns deleted developer")
    @ApiResponses(value = { @ApiResponse(responseCode = "203", description = "Successfully deleted") })
    @DeleteMapping("{id}")
    public ResponseEntity deleteDeveloper(@PathVariable Long id) {
        return developerService.delete(id);
    }
}
