package fr.dataup.myquiz.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dataup.myquiz.entities.Answer;
import fr.dataup.myquiz.entities.Question;
import fr.dataup.myquiz.entities.Quiz;
import fr.dataup.myquiz.repositories.AnswerRepository;
import fr.dataup.myquiz.repositories.QuestionRepository;
import fr.dataup.myquiz.repositories.QuizRepository;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    //create a saveRequest method that takes a quiz as a pa rameter and returns a quiz
    public Quiz createQuizRequest(Quiz quiz) {
        
      Question[] questions = quiz.getQuestions();
        for (Question question : questions) {
        List<Answer> answersList= Arrays.asList( question.getAnswers() );
        answerRepository.saveAll(answersList);
        question.setAnswers(question.getAnswers());
        }
        List<Question> questionsList = Arrays.asList(questions);
        questionRepository.saveAll(questionsList);
        Quiz quizEntity = quizRepository.save(quiz);
        //this.writeQuizToFile(quizEntity);
        return quizEntity;

    /*    List<Question> questions = quiz.getQuestions();
    
    // Save questions and their associated answers
    for (Question question : questions) {
        List<Answer> answersList = question.getAnswers();
        answerRepository.saveAll(answersList);
        question.setAnswers(answersList); // Make sure setAnswers() method is available in the Question interface implementation
    }
    questionRepository.saveAll(questions);

    // Make sure Quiz, Question, and Answer classes are properly mapped with JPA annotations.
    // Ensure correct relationships are established between entities.
    
    return quizRepository.save(quiz);*/
    }


    
}
