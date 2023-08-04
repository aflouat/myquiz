package fr.dataup.myquiz.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dataup.myquiz.entities.Game;
import fr.dataup.myquiz.entities.Player;
import fr.dataup.myquiz.entities.Quiz;
import fr.dataup.myquiz.repositories.GameRepository;
import fr.dataup.myquiz.repositories.PlayerRepository;
import fr.dataup.myquiz.repositories.QuizRepository;
@Service
public class GameService {
     @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    //autowire the quiz repository
    @Autowired
    private QuizRepository quizRepository;

    private static final Logger logger = LogManager.getLogger(GameService.class);

    public Game createGameRequest(Game gameEntity) {
        
        //save the game from the gameDTO
        System.out.println("###########"+gameEntity);
        logger.info("This is a log message in JSON format");

        gameEntity = gameRepository.save(gameEntity);
        logger.debug("#######End of createGameRequest()#########");   
        return gameEntity; 
    }
  
    public Game getGameEntityFromDTO(GameDTO game) {
        Game gameEntity = new Game();
        gameEntity.setId(game.getId());
        gameEntity.setScore(game.getScore());
        gameEntity.setPlayer(new Player(game.getPlayerId(), game.getPlayerNickname(), false,game.getScore()));
        //save the quiz from the gameDTO
        //gameEntity.setQuiz(quizRepository.findById(game.getQuizId()).get());
        gameEntity.setQuiz(new Quiz(game.getQuizId(), null, game.getQuizTitle()));
        //set the date to the game
        gameEntity.setDate(game.getDate());
        return gameEntity;
    }
   
    public List<GameDTO> getAllGamesRequest() {
        //this method should return all games for all players, the json should look like this:
        //[ 
        //    {
        //        "id": 1,
        //        "quizId": 1,
        //        "quizTitle": "Java",
        //        "playerId": 1,
        //        "playerName": "John",
        //        "score": 2,
        //        "date": "2021-09-01"
        //    },
        //    {
        //        "id": 2,
        //        "quizId": 1,
        //        "quizTitle": "Java",
        //        "playerId": 2,
        //        "playerName": "Jack",
        //        "score": 1,
        //        "date": "2021-09-01"
        //    }
        //]
        List<Game> games = gameRepository.findAll();
    List<GameDTO> gameDtos = new ArrayList<>();

 
    for (Game game : games) {
        GameDTO gameDto = new GameDTO();
        gameDto.setId(game.getId());
        gameDto.setQuizId(game.getQuiz().getId());
        gameDto.setQuizTitle(game.getQuiz().getTitle());
        gameDto.setPlayerId(game.getPlayer().getId());
        gameDto.setPlayerNickname(game.getPlayer().getNickname());
        gameDto.setScore(game.getScore());
        gameDto.setDate(game.getDate());
        gameDtos.add(gameDto);
    }

    return gameDtos;

    }
    public Game setQuiz(Game gameEntity) {
        //get the quiz from the quiz repository
        Quiz quiz = quizRepository.findById(gameEntity.getQuiz().getId()).get();
        //get the player from the player repository
        //set the quiz to the game
        gameEntity.setQuiz(quiz);
        //set the player to the game
        return gameEntity;

    }

}
