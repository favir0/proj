package com.fadee.proj.games.services;

import com.fadee.proj.games.models.Game;
import com.fadee.proj.games.repositories.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public ResponseEntity getById(Long id){
        return ResponseEntity.ok(this.gameRepository.findById(id).get());
    }

    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.gameRepository.findAll());
    }

    public ResponseEntity add(Game game){
        return ResponseEntity.status(201).body(this.gameRepository.save(game));
    }

    public ResponseEntity put(Long id, Game game){
        Game gameToUpdate = this.gameRepository.findById(id).get();
        gameToUpdate.setName(game.getName());
        gameToUpdate.setGenre(game.getGenre());
        gameToUpdate.setIs_multi_player(game.getIs_multi_player());
        gameToUpdate.setDescription(game.getDescription());
        gameToUpdate.setPrice(game.getPrice());
        gameToUpdate.setDate(game.getDate());
        gameToUpdate.setGame_image(game.getGame_image());
        gameToUpdate.setPublisher(game.getPublisher());
        gameToUpdate.setDeveloper(game.getDeveloper());
        return ResponseEntity.status(202).body(this.gameRepository.save(gameToUpdate));
    }

    public ResponseEntity delete(Long id){
        Game game = this.gameRepository.findById(id).get();
        this.gameRepository.deleteById(id);
        return ResponseEntity.status(203).body(game);
    }
}
