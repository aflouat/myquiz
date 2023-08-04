package fr.dataup.myquiz.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dataup.myquiz.entities.Game;

public class PlayerServiceTest {
    @Autowired
    private PlayerService playerService;
    @Test
    public void shouldReturnScoreOfPlayerWith150Points() {
        Game game = new Game(1L,null, null, 70, new Date());
        playerService.updateScore(game);
        assertEquals(70,game.getScore() , "updateScore is not implemented yet. Please implement this method.");
    }
}
