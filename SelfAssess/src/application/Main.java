package application;

import controller.CategoryController;
import controller.QuestionController;
import controller.TestController;
import database.DatabaseService;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;
import view.panels.TestPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {/*
			BufferedReader reader = new BufferedReader(new FileReader("D:\\Informatica\\Fase 2\\OOO\\repository\\Groepsopdracht_OOO\\Arnalsteen_Broeckhoven_Haidari_rep2_2019\\SelfAssess\\src\\testDatabase\\categories.txt"));
			String         line = null;
			StringBuilder  stringBuilder = new StringBuilder();
			String         ls = System.getProperty("line.separator");

			try {
				while((line = reader.readLine()) != null) {
					stringBuilder.append(line);
					stringBuilder.append(ls);
				}

				System.out.println(stringBuilder.toString());
			} finally {
				reader.close();
			}*/
			//hier moet de strategy in komen via de properties file
			DatabaseService databaseService = new DatabaseService("TxtDatabase");

			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane();
			QuestionDetailPane questionDetailPane = new QuestionDetailPane();

			CategoryOverviewPane categoryOverviewPane = new CategoryOverviewPane();
			CategoryDetailPane categoryDetailPanel = new CategoryDetailPane();

			CategoryController categoryController = new CategoryController(categoryOverviewPane);
			categoryController.setDatabaseService(databaseService);
            QuestionController questionController = new QuestionController(questionOverviewPane);
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
