package controller;

import database.questionDatabase.QuestionDatabaseContext;
import model.Question;
import database.*;
import java.util.Collections;
import java.util.List;

public class QuestionController {
    private DatabaseService dbService;

    public QuestionController() {
        dbService = new DatabaseService(new QuestionDatabaseContext(new InMemoryQuestionQuestionDatabase()));
        Question math1 = new Question("1 + 1 = ?", math);
    }

    public List<String> getShuffledStatements(){

        List<String>shuffled = dbService.getAll();
        Collections.shuffle(shuffled);
        return shuffled;
    }
}
