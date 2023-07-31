package fr.dataup.myquiz.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.core.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import fr.dataup.myquiz.entities.Answer;
import fr.dataup.myquiz.entities.IQuestion;
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
    @Autowired
    private ResourceLoader resourceLoader;

    //create a saveRequest method that takes a quiz as a pa rameter and returns a quiz
    public Quiz createQuizRequest(Quiz quiz) {
        
        //TODO get the quiz questions and for each question get the answers and set the question to each answer 
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
    private void writeQuizToFile(Quiz quizEntity) {
           // Serialize Quiz object to JSON string
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonQuiz="";
    try {
        jsonQuiz = objectMapper.writeValueAsString(quizEntity);
    } catch (IOException e) {
        // Handle the exception appropriately (e.g., log or throw it)
    System.err.println("error json to string:"+e.getMessage());

     }
     Resource resource = resourceLoader.getResource("classpath:/"); // This points to the root of the "resources" directory
     //get the path of the root of the projec

     String resourcesPath="";
     try {
        System.out.println(resource.getFile().getAbsolutePath());
      resourcesPath = resource.getFile().getAbsolutePath();
        } catch (IOException e) {
            // Handle the exception appropriately (e.g., log or throw it)
            System.err.println("error get the path:"+e.getMessage());
        }


         // Store JSON data in the disk resource/json
    File jsonFile = new File(resourcesPath+"/json/quiz-"+quizEntity.getId()+".json");
//add log here

    try (FileWriter writer = new FileWriter(jsonFile)) {
        writer.write(jsonQuiz);
    } catch (IOException e) {
        // Handle the exception appropriately (e.g., log or throw it)
        //add log here
        System.err.println("error write the json file:"+e.getMessage());
        
     }

     
    }


    
}
