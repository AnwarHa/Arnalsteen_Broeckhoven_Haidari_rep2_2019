package controller;

import testDatabase.DatabaseContext;
import testDatabase.DatabaseService;
import testDatabase.InMemoryCategoryDatabase;
import testDatabase.SerializableCategoryDatabase;

public class CategoryController {
    private DatabaseService databaseService;

    public CategoryController() {
        databaseService = new DatabaseService(new DatabaseContext(new InMemoryCategoryDatabase()));
    }
}
