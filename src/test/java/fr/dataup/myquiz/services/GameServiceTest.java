package fr.dataup.myquiz.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import fr.dataup.myquiz.entities.Game;
import fr.dataup.myquiz.entities.Player;
import fr.dataup.myquiz.entities.Quiz;

public class GameServiceTest {
    @Test
    void shouldReturnGameEntityAttributesFromOneGameDTO() {
       
        Quiz quizEntity = new Quiz(1L, null, "quiz of history");
        Player playerEntity = new Player(1L, "Mohamed", false,10);
        Date date = new Date();
        Game gameEntity = new Game(1L, quizEntity, playerEntity, playerEntity.getScore(), date);
       
        GameDTO game = new GameDTO();
        game.setQuizId(1L);
        game.setScore(10);
        game.setPlayerId(1L);
        game.setDate(date);
        game.setQuizTitle("quiz of history");
        game.setPlayerNickname("Mohamed");
        game.setId(1L);
        GameService gameService = new GameService();

        assertEquals(gameEntity, gameService.getGameEntityFromDTO(game), "getGameEntityFromDTO is not implemented yet. Please implement this method.");

    }

    
}
