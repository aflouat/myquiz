package fr.dataup.myquiz.controllers;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.log.Log;

import fr.dataup.myquiz.entities.Game;
import fr.dataup.myquiz.entities.Player;
import fr.dataup.myquiz.repositories.GameRepository;
import fr.dataup.myquiz.repositories.PlayerRepository;
import fr.dataup.myquiz.services.GameDTO;
import fr.dataup.myquiz.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    private static final Logger logger = LogManager.getLogger(GameController.class);

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<GameDTO> getAllGames() {
        return gameService.getAllGamesRequest();

    }

    @PostMapping
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO game) {
        // check if the player exists in the database by using the player nickname
        Player player = playerRepository.findByNickname(game.getPlayerNickname());
        
        if (player == null) {
            // If player does not exist, create a new player
            player = new Player(null, game.getPlayerNickname(), false, game.getScore());
            playerRepository.save(player);
        } else {
            // If player already exists, update the score of the player
            player.setScore(player.getScore() + game.getScore());
            playerRepository.save(player);
        }

        // Create the game entity and set the player to it
        Game gameEntity = gameService.getGameEntityFromDTO(game);
        gameEntity.setPlayer(player);
        gameEntity = gameService.createGameRequest(gameEntity);

        // Return the gameDTO with the updated information
        game.setPlayerId(player.getId());
        return ResponseEntity.ok(game);
    }
    private void updatePlayerScore(GameDTO game) {
        // if yes get it
        Player player = playerRepository.findByNickname(game.getPlayerNickname());
        // update the score of the player
        player.setScore(player.getScore() + game.getScore());
        // save the player
        playerRepository.save(player);
    }

    private void CreatePlayer(GameDTO game) {

        playerRepository.save(new Player(null, game.getPlayerNickname(), false, game.getScore()));
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        return game.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
