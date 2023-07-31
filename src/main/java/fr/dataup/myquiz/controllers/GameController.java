package fr.dataup.myquiz.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dataup.myquiz.entities.Game;
import fr.dataup.myquiz.repositories.GameRepository;
import fr.dataup.myquiz.services.GameDTO;
import fr.dataup.myquiz.services.GameService;
@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameDTO> getAllGames() {
         return gameService.getAllGamesRequest();  
        
    }
    @PostMapping
    public void createGame(@RequestBody GameDTO game) {
        Game gameEntity = gameService.getGameEntityFromDTO(game);

        gameService.createGameRequest(gameEntity);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        return game.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
     
    
  

    
}

