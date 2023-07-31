package fr.dataup.myquiz;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.dataup.myquiz.entities.Answer;
import fr.dataup.myquiz.entities.AnswerPicture;
import fr.dataup.myquiz.entities.Category;
import fr.dataup.myquiz.entities.Difficulty;
import fr.dataup.myquiz.entities.Question;
import fr.dataup.myquiz.entities.QuestionAudio;
import fr.dataup.myquiz.entities.Quiz;
import fr.dataup.myquiz.repositories.AnswerPictureRepository;
import fr.dataup.myquiz.repositories.AnswerRepository;
import fr.dataup.myquiz.repositories.QuestionAudioRepository;
import fr.dataup.myquiz.repositories.QuestionRepository;
import fr.dataup.myquiz.repositories.QuizRepository;

@Configuration

public class LoadDatabase {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    //auto-wired answerPictureRepository and questionaudioRepository
    @Autowired
    private AnswerPictureRepository answerPictureRepository;
    @Autowired
    private QuestionAudioRepository questionAudioRepository;


//should be commented after the first run

  @Bean
  CommandLineRunner initDatabase() {
    //create 4 answers instances and save them to the database
    //get a cheetah picture from the web as a string
    String cheetahPictureUrl = "https://img.freepik.com/photos-gratuite/gros-plan-guepard-marchant-plan-savane-nambie_181624-10595.jpg?size=626&ext=jpg&ga=GA1.2.2106707947.1622208000";
//create new answerPicture instance with the cheetah picture
    AnswerPicture answerPicture = new AnswerPicture(null, "Cheetah", cheetahPictureUrl);
    //save the answerPicture to the database
    //answerRepository.save(answerPicture);
    //create 3 other answerPicture instances with animals
    String lionPictureUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Lion_d%27Afrique.jpg/640px-Lion_d%27Afrique.jpg";
    AnswerPicture answerPicture2 = new AnswerPicture(null, "Lion", lionPictureUrl);
    //answerRepository.save(answerPicture2);
    String elephantPictureUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/African_Bush_Elephant.jpg/640px-African_Bush_Elephant.jpg";
    AnswerPicture answerPicture3 = new AnswerPicture(null, "Elephant", elephantPictureUrl);
    //answerRepository.save(answerPicture3);
    String giraffePictureUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Giraffe_Mikumi_National_Park.jpg/640px-Giraffe_Mikumi_National_Park.jpg";
    AnswerPicture answerPicture4 = new AnswerPicture(null, "Giraffe", giraffePictureUrl);
    //answerRepository.save(answerPicture4);
    //create an array of answers
    AnswerPicture[] answers = {answerPicture, answerPicture2, answerPicture3, answerPicture4};
    //answerPictureRepository.saveAll(Arrays.asList(answers));


//crreate a question instance with the answerPicture instance
/*String audioUrl = "https://on.soundcloud.com/dDLJU";
QuestionAudio question1 = new QuestionAudio(null, "Designez l'animal dans la photo?", answers,1, Category.Animaux, Difficulty.Facile, audioUrl); 
question1.setAnswers(Arrays.asList(answers));*/
//questionAudioRepository.save(question1);

    return args -> {


/*      //save answers, questions and quiz to the database
          List<Answer> answersList = Arrays.asList(answers);
        log.info("Preloading " + answerRepository.saveAll(answersList));
        //set answers to question1 question1.setAnswers(answers);
        
        List<Question> questionsList = Arrays.asList(questions);
        //for every question in the list of questions, set the answers that 
        //will be ok only for one question
        questionsList.stream().forEach(question -> question.setAnswers(answers));
        log.info("Preloading " + questionRepository.saveAll(questionsList));
        //set questions to quiz
        quiz.setQuestions(questions);
        log.info("Preloading " + quizRepository.save(quiz));
*/
    };
  }
    
}
