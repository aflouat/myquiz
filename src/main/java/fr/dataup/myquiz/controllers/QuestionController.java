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

import fr.dataup.myquiz.entities.Question;
import fr.dataup.myquiz.repositories.QuestionRepository;
@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
 

    @GetMapping
    public List<Question> getAllQuestions() {
         return questionRepository.findAll();     
        
    }
    @PostMapping
    public Question createQuestion(@RequestBody Question Question) {

        return questionRepository.save(Question);
    }

    
    @PutMapping("/{QuestionId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long QuestionId, @RequestBody Question updatedQuestion)  {
        Optional<Question> Question = questionRepository.findById(QuestionId);
        System.out.println("******************before update question"+QuestionId);

        if (Question.isPresent()) {
               System.out.println("******************QuestionId"+QuestionId);
        
            updatedQuestion.setId(QuestionId);
            return ResponseEntity.ok(questionRepository.save(updatedQuestion));
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{QuestionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long QuestionId) {
        Optional<Question> Question = questionRepository.findById(QuestionId);
        if (Question.isPresent()) {
            questionRepository.deleteById(QuestionId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}

