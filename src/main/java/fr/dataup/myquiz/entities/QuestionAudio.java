package fr.dataup.myquiz.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Data @NoArgsConstructor @AllArgsConstructor

public class QuestionAudio extends Question{
    public QuestionAudio(Object object, String string, Answer[] answers, int i, Category animaux, Difficulty facile,
            String audioUrl2) {
    }
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String audioUrl;

}
