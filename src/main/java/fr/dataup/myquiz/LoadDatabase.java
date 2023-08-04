package fr.dataup.myquiz;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 
@Configuration

public class LoadDatabase {
 

 



//should be commented after the first run

  @Bean
  CommandLineRunner initDatabase() {


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
