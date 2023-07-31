package fr.dataup.myquiz.services;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Long id;
    private Long quizId;
    private String quizTitle;
    private Long playerId;
    private String playerNickname;
    private int score;
    private Date date;
}

