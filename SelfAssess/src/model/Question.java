
package model;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.List;


public class Question implements Serializable,Observable {
    private String name, correctAnswer, category, feedback;
    private ObservableList<String> statements;

    public Question(String name, String category, ObservableList<String> statements, String feedback) {

        try
        {
        setStatements(statements);
        setCorrectAnswer();
        setQuestion(name);
        setCategory(category);
        setFeedback(feedback);
        }catch(Exception e) {
            throw new DomainException("can not create a new name: " + e.getMessage());
        }
    }


    private void setFeedback(String feedback) {
        if(name.trim().equals("")|| name.trim().isEmpty()){
            throw new IllegalArgumentException("name phrase can't be empty");
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

    public String getName() {
        return name;
    }


    public void setQuestion(String name) {
        if(name.trim().equals("")||name.trim().isEmpty()){
            throw new IllegalArgumentException("question phrase can't be empty");
        }else{
            this.name = name;
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

