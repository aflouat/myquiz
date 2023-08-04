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

import fr.dataup.myquiz.entities.Quiz;
import fr.dataup.myquiz.repositories.QuizRepository;
import fr.dataup.myquiz.services.QuizService;
@RestController
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getAllQuizzes() {
         return quizRepository.findAll();     
        
    }
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {

        return quizService.createQuizRequest(quiz);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        return quiz.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<Quiz> getQuizByTitle(@PathVariable String title) {
        Quiz quiz = quizRepository.getQuizFirstByTitle(title);
        return ResponseEntity.ok(quiz);
    }
    @PutMapping("/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long quizId, @RequestBody Quiz updatedQuiz) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            updatedQuiz.setId(quizId);
            return ResponseEntity.ok(quizRepository.save(updatedQuiz));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            quizRepository.deleteById(quizId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}

