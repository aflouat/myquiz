package fr.dataup.myquiz.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Question implements IQuestion {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String text;
    @OneToMany
    private Answer[] answers;
    private int correctAnswer;
    private Category category;
    private Difficulty difficulty;
    //add imageUrl
    private String imageUrl;
    //add audioUrl
    private String audioUrl;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Question)) {
            return false;
        }
        Question question = (Question) o;
        return id == question.id && java.util.Arrays.equals(answers, question.answers) && correctAnswer == question.correctAnswer && Objects.equals(text, question.text) && Objects.equals(category, question.category) && Objects.equals(difficulty, question.difficulty) && Objects.equals(imageUrl, question.imageUrl) && Objects.equals(audioUrl, question.audioUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, java.util.Arrays.hashCode(answers), correctAnswer, text, category, difficulty, imageUrl, audioUrl);
    }
}
