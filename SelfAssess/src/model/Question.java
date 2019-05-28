
package model;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Question implements Serializable {
    private String question, correctAnswer, category, feedback;
    private ObservableList<String> statements;

    public Question(String question, String category, ObservableList<String> statements, String feedback) {
        try
        {
        setStatements(statements);
        setCorrectAnswer();
        setQuestion(question);
        setCategory(category);
        setFeedback(feedback);
        }catch(Exception e) {
            throw new DomainException("can not create a new question: " + e.getMessage());
        }
    }

    public void setFeedback(String feedback) {
        if(question.trim().equals("")||question.trim().isEmpty()){
            throw new IllegalArgumentException("question phrase can't be empty");
        }else {
            this.feedback = feedback;
        }
    }

    public String getFeedback(){
        return  this.feedback;
    }

    public void setCorrectAnswer() {
        this.correctAnswer = this.statements.get(0);
    }

    public String getCorrectanswer() {
        return this.correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        if(question.trim().equals("")||question.trim().isEmpty()){
            throw new IllegalArgumentException("question phrase can't be empty");
        }else{
            this.question = question;
        }
    }

    public String getCategory() {
        return category;
    }

    public void addAnswers(List<String> answers) {
        this.statements.addAll(answers);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ObservableList<String> getStatements(){
        return this.statements;
    }

    public void setStatements(ObservableList<String> statements){
        if(statements.isEmpty()){
            throw new IllegalArgumentException("list of statements can't be empty");
        }else{
            this.statements = statements;
        }
    }
}

