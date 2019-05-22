package controller;

import database.DatabaseService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Question;
import view.panels.MessagePane;
import view.panels.TestPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestController {
    private ObservableList<Boolean> scores;
    private TestPane testPane;
    private MessagePane messagePane;
    private Stage stage;
    private DatabaseService databaseService;

    public TestController(MessagePane messagePane) {
        this.messagePane = messagePane;
        messagePane.getTestButton().setOnAction(new EvaluateTest());

    }

    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    class EvaluateTest implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            stage = new Stage();
            testPane = new TestPane();
            Scene scene = new Scene(testPane);
            stage.setScene(scene);

            testPane.setStatementGroup(new ToggleGroup());

            Question nextQuestion = databaseService.getQuestions().iterator().next();
            testPane.getQuestionField().setText(nextQuestion.getQuestion());
            for (String answer : nextQuestion.getAnswers()) {
                testPane.getvBox().getChildren().addAll(createButton(answer, testPane.getStatementGroup()));
            }

            stage.show();
        }
    }

    private RadioButton createButton(String text, ToggleGroup group) {
        RadioButton buttonPanelForSymbols = new RadioButton(text);
        buttonPanelForSymbols.setToggleGroup(group);
        return buttonPanelForSymbols;
    }


}
