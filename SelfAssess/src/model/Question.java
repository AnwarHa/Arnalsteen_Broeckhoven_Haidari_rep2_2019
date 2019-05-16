package model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private Category category;
    private String correctanswer;
    private List<String> answers;

    public Question(String question, Category category, String correctanswer, List<String>answers) {
        answers = new ArrayList<>();
        setCorrectAnswer(correctanswer);
        setQuestion(question);
        setCategory(category);
    }

    private void setCorrectAnswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }
    private String getCorrectanswer(){
        return this.correctanswer;
    }

    public String getQuestion() {
        return question;
    }

    private void setQuestion(String question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getAnswers(){
        return this.answers;
    }

    public void addAnswers(List<String> answers){
        this.answers.addAll(answers); 
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription(){
        return category.getDescription();
    }
}
