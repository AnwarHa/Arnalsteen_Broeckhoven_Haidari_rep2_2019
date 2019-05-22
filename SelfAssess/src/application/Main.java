package application;

import controller.CategoryController;
import controller.QuestionController;
import controller.TestController;
import database.DatabaseService;
import database.categoryDatabase.CategoryDatabaseContext;
import database.categoryDatabase.InMemoryStrategyCategory;
import database.questionDatabase.InMemoryStrategyQuestion;
import database.questionDatabase.QuestionDatabaseContext;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Category;
import model.CategoryModel;
import model.QuestionModel;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;
import view.panels.TestPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			DatabaseService databaseService = new DatabaseService(new QuestionDatabaseContext(new InMemoryStrategyQuestion()), new CategoryDatabaseContext(new InMemoryStrategyCategory()));

			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane();
			QuestionDetailPane questionDetailPane = new QuestionDetailPane();

			CategoryOverviewPane categoryOverviewPane = new CategoryOverviewPane();
			CategoryDetailPane categoryDetailPanel = new CategoryDetailPane();

			CategoryModel categoryModel = new CategoryModel();
            QuestionModel questionModel = new QuestionModel();
			CategoryController categoryController = new CategoryController(categoryOverviewPane, categoryModel);
			categoryController.setDatabaseService(databaseService);
            QuestionController questionController = new QuestionController(questionOverviewPane, questionModel);
            questionController.setDatabaseService(databaseService);

			TestPane testPane = new TestPane();
			MessagePane messagePane = new MessagePane();
            TestController testController = new TestController(messagePane);
            testController.setDatabaseService(databaseService);

			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);

			BorderPane borderPane = new AssesMainPane(messagePane, categoryOverviewPane, questionOverviewPane);
			borderPane.prefHeightProperty().bind(scene.heightProperty());
			borderPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(borderPane);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
