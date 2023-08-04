package fr.dataup.myquiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dataup.myquiz.entities.Game;
import fr.dataup.myquiz.entities.Player;
import fr.dataup.myquiz.repositories.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    //Game game = new Game(1L,null, null, 70, new java.util.Date());
    // given the player and the game so the score of the player is updated
    public void updateScore(Game game) {
        // get the player from the player repository
        // update the score of the player
        Player player = playerRepository.findById(game.getPlayer().getId()).get();
        player.setScore(player.getScore()+game.getScore());
        playerRepository.save(player);
        // save the player

    }
    
}
