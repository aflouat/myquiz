package fr.dataup.myquiz.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dataup.myquiz.entities.Answer;
import fr.dataup.myquiz.repositories.AnswerRepository;
@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;
 

    @GetMapping
    public List<Answer> getAllAnswers() {
         return answerRepository.findAll();     
        
    }
    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {

        answerRepository.save(answer);
        return ResponseEntity.created(null).body(answer);
    }

    
    @PutMapping("/{answerId}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long answerId, @RequestBody Answer updatedAnswer) {
        Optional<Answer> answer = answerRepository.findById(answerId);
        if (answer.isPresent()) {
            updatedAnswer.setId(answerId);
            answerRepository.save(updatedAnswer);  
              }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long answerId) {
        Optional<Answer> answer = answerRepository.findById(answerId);
        if (answer.isPresent()) {
            answerRepository.deleteById(answerId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}

