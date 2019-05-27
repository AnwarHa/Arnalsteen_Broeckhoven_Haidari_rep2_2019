package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test {
    private List<Question> questions;
    private List<Question> askedQuestions;
    private List<String> feedback;
    private Question currentQuestion;
    private HashMap<String, Integer> score;

    public Test(List<Question> questions) {
        setQuestions(questions);
        this.askedQuestions = new ArrayList<>();
        this.feedback = new ArrayList<>();
        score = new HashMap<>();
        Collections.shuffle(questions);
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Question findNextQuestion() {
        for (Question question : questions) {
            if (!askedQuestions.contains(question)) {
                askedQuestions.add(question);
                currentQuestion = question;
                return question;
            }
        }
        return null;

    }

    public boolean checkAnswer(String answer) {
        String category = currentQuestion.getCategory();
        if (!score.containsKey(category)) {
            score.put(category, new Integer(0));
        }
        if (currentQuestion.getCorrectanswer().equalsIgnoreCase(answer)) {
            score.put(category, score.get(category) + 1);
            return true;
        } else {
            feedback.add(currentQuestion.getFeedback());
        }
        return false;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

}
