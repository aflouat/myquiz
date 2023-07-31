package fr.dataup.myquiz.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name="player")
public class Player {
    @Id   @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nickname;

    
    
}
