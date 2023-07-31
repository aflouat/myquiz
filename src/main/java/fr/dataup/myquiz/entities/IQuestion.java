package fr.dataup.myquiz.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface IQuestion {
    public Long getId();
    public String getText();
    public Answer[] getAnswers();
    public int getCorrectAnswer();
    public Category getCategory();
    public Difficulty getDifficulty();

    
}
