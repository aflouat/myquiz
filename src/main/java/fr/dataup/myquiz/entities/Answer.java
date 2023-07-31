package fr.dataup.myquiz.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor

public class Answer {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String text;
    //add imageUrl
    private String imageUrl;
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) o;
        return id == answer.id && Objects.equals(text, answer.text) && Objects.equals(imageUrl, answer.imageUrl);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, text, imageUrl);
    }
}
