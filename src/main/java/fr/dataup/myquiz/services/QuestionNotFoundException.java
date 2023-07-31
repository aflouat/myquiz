package fr.dataup.myquiz.services;

public class QuestionNotFoundException extends RuntimeException  {
    public QuestionNotFoundException(Long id) {
        super("Could not find question " + id);
    }

    
}
