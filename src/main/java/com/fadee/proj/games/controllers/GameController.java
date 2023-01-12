package com.fadee.proj.games.controllers;

import com.fadee.proj.games.models.Game;
import com.fadee.proj.games.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Game", description = "the game API")
@RequestMapping("/api/game")
@SecurityRequirement(name = "BasicAuth")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Get all games", description = "Returns list of games")
    @GetMapping
    public ResponseEntity getAllGames(){
        return gameService.getAll();
    }

    @Operation(summary = "Get a game by id", description = "Returns a game as per id")
    @GetMapping("{id}")
    public ResponseEntity getGame(@PathVariable Long id){
        return gameService.getById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Create a game", description = "Returns created game")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully added") })
    @PostMapping
    public ResponseEntity createGame(@RequestBody Game game) {
        return gameService.add(game);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Update a game by id", description = "Returns updated game")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Successfully changed") })
    @PutMapping("{id}")
    public ResponseEntity updateGame(@PathVariable Long id, @RequestBody Game game){
        return gameService.put(id, game);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Delete a game by id", description = "Returns deleted game")
    @ApiResponses(value = { @ApiResponse(responseCode = "203", description = "Successfully deleted") })
    @DeleteMapping("{id}")
    public ResponseEntity deleteGame(@PathVariable Long id) {
        return gameService.delete(id);
    }

}
