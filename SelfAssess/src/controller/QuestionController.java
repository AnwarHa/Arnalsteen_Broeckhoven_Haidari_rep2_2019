package controller;

import testDatabase.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionController {
    private DatabaseService dbService;

    public QuestionController() {
        dbService = new DatabaseService(new DatabaseContext(new InMemoryQuestionDatabase()));
    }

    public List<String> getShuffledStatements(){
        List<String>shuffled = dbService.getAll();
        Collections.shuffle(shuffled);
        return shuffled;
    }

    public List<String> getDescription(){
    return dbService.getCategoryNamen();
    }

}
