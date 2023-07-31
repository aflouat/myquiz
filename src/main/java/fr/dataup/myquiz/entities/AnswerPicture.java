package fr.dataup.myquiz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AnswerPicture extends Answer{
    public AnswerPicture(Object object, String string, String cheetahPictureUrl) {
    }
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String pictureUrl;

}
