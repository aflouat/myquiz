package fr.dataup.myquiz.entities;

public interface IQuestion {
    public Long getId();
    public String getText();
    public Answer[] getAnswers();
    public int getCorrectAnswer();
    public Category getCategory();
    public Difficulty getDifficulty();

    
}
