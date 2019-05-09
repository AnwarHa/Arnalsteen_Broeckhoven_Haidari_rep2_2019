package controller;

import testDatabase.DatabaseContext;
import testDatabase.DatabaseService;
import testDatabase.SerializableCategoryDatabase;

public class CategoryController {
    private DatabaseService databaseService;

    public CategoryController() {
        databaseService = new DatabaseService(new DatabaseContext(new SerializableCategoryDatabase()));
    }
}
