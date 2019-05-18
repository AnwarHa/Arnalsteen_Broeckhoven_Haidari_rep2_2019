package controller;

import database.categoryDatabase.CategoryDatabaseContext;
import database.categoryDatabase.InMemoryStrategyCategory;
import database.questionDatabase.InMemoryStrategyQuestion;
import database.questionDatabase.QuestionDatabaseContext;
import model.Question;
import database.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionController {
    private DatabaseService databaseService;

    public QuestionController() {
        databaseService = new DatabaseService(new QuestionDatabaseContext(new InMemoryStrategyQuestion()),new CategoryDatabaseContext(new InMemoryStrategyCategory()));
        // Question math1 = new Question("1 + 1 = ?", databaseService.getCategories().get(0),"2",new ArrayList<>());
    }

    public List<String> getShuffledStatements(Question question){

        List<String>shuffled = databaseService.getQuestionStatements(question);
        Collections.shuffle(shuffled);
        return shuffled;
    }

    public List<Question> getQuestions(){
        return databaseService.getQuestions();
    }

    public List<String> getDescription(){
    return databaseService.getCategoryDescriptions();
    }

}
