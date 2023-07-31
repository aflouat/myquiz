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
public class Quiz{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToMany
    private Question[] questions;
    private String title;
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Quiz)) {
            return false;
        }
        Quiz quiz = (Quiz) o;
        return id == quiz.id && java.util.Arrays.equals(questions, quiz.questions) && Objects.equals(title, quiz.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, java.util.Arrays.hashCode(questions), title);
    }

}