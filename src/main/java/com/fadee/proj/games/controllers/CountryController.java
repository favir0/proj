package com.fadee.proj.games.controllers;

import com.fadee.proj.games.models.Country;
import com.fadee.proj.games.services.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "Country", description = "the country API")
@RequestMapping("/api/country")
@SecurityRequirement(name = "BasicAuth")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(summary = "Get all countries", description = "Returns list of countries")
    @GetMapping
    public ResponseEntity getAllCountries(){
        return countryService.getAll();
    }

    @Operation(summary = "Get a country by id", description = "Returns a country as per id")
    @GetMapping("{id}")
    public ResponseEntity getCountry(@PathVariable Long id){
        return countryService.getById(id);
    }

    @Operation(summary = "Create a country", description = "Returns created country")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added") })
    @PostMapping
    public ResponseEntity createCountry(@RequestBody Country country) {
        return countryService.add(country);
    }

    @Operation(summary = "Update a country by id", description = "Returns updated country")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Successfully changed") })
    @PutMapping("{id}")
    public ResponseEntity updateCountry(@PathVariable Long id, @RequestBody Country country){
        return countryService.put(id, country);
    }

    @Operation(summary = "Delete a country by id", description = "Returns deleted country")
    @ApiResponses(value = { @ApiResponse(responseCode = "203", description = "Successfully deleted") })
    @DeleteMapping("{id}")
    public ResponseEntity deleteCountry(@PathVariable Long id) {
        return countryService.delete(id);
    }
}
