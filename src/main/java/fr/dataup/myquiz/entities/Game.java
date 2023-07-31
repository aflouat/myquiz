package fr.dataup.myquiz.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Game {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Quiz quiz;
    @ManyToOne
    private Player player;
    private int score;
    private Date date;
        @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Game)) {
            return false;
        }
        Game game = (Game) o;
        return Objects.equals(id, game.id) && score == game.score && Objects.equals(date, game.date) && Objects.equals(player, game.player) && Objects.equals(quiz, game.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score, date, player, quiz);
    }


    
}
