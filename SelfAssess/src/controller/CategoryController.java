package controller;



import database.DatabaseService;
import database.categoryDatabase.CategoryDatabaseContext;
import database.categoryDatabase.InMemoryStrategyCategory;
import database.questionDatabase.InMemoryStrategyQuestion;
import database.questionDatabase.QuestionDatabaseContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Category;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;

import java.util.List;


public class CategoryController {
    private DatabaseService databaseService;
    private CategoryOverviewPane categoryOverviewPane;
    private CategoryDetailPane categoryDetailPane;

    public CategoryController() {
        databaseService = new DatabaseService(new QuestionDatabaseContext(new InMemoryStrategyQuestion()),new CategoryDatabaseContext(new InMemoryStrategyCategory()));
        Category math = new Category("Math", "Math again");
    }

    public List<Category> getAll(){
        return databaseService.getCategories();
    }

    public CategoryController(CategoryOverviewPane categoryOverviewPane, CategoryDetailPane categoryDetailPane) {
        this();
        setCategoryDetailPane(categoryDetailPane);
        setCategoryOverviewPane(categoryOverviewPane);
        // categoryOverviewPane.setNewAction();
    }
    public void saveCategories(List<Category> categories){
        databaseService.setCategories(categories);
    }

    public void setCategoryDetailPane(CategoryDetailPane categoryDetailPane) {
        this.categoryDetailPane = categoryDetailPane;
    }

    public void setCategoryOverviewPane(CategoryOverviewPane categoryOverviewPane) {
        this.categoryOverviewPane = categoryOverviewPane;
    }

    public CategoryOverviewPane getCategoryOverviewPane() {
        return categoryOverviewPane;
    }
}



/*
    categoryOverviewPane.setNewAction(new EventHandler<ActionEvent>()

    {
        @Override
        public void handle (ActionEvent event){
        Stage stage = new Stage();
        CategoryDetailPane categoryDetailPane = new CategoryDetailPane();
        Scene scene = new Scene(categoryDetailPane);
        stage.setScene(scene);
        stage.show();
    }
    });
}


    // btnOK.setOnAction(new EventHandler<ActionEvent>() {
    //            @Override
    //            public void handle(ActionEvent event) {
    //                String name = titleField.getText();
    //                String description = descriptionField.getText();
    //                Category category = new Category(name, description);
    //                databaseService.getCategories().add(category);
    //            }
    //        });


>>>>>>> master
}
*/