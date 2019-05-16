package controller;

import model.Category;
import database.questionDatabase.QuestionDatabaseContext;
import database.DatabaseService;

import java.util.List;

public class CategoryController {
    private DatabaseService databaseService;

    public CategoryController() {
        databaseService = new DatabaseService(new QuestionDatabaseContext(new InMemoryCategoryQuestionDatabase()));
        Category math = new Category("Math", "Math again");
    }

    public List<Category> getAll(){
        return databaseService.getCategories();
    }


}
