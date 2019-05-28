package controller;

import database.DatabaseService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Question;
import model.Test;
import view.panels.MessagePane;
import view.panels.TestPane;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TestController {
    private TestPane testPane;
    private MessagePane messagePane;
    private Stage stage;
    private DatabaseService databaseService;
    private Test test;


    public TestController(MessagePane messagePane) {
        this.messagePane = messagePane;
        messagePane.getTestButton().setOnAction(new EvaluateTest());
    }

    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
        test = new Test(databaseService.readQuestions());
    }

    class EvaluateTest implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            stage = new Stage();
            testPane = new TestPane();
            Scene scene = new Scene(testPane);
            stage.setScene(scene);

            testPane.setStatementGroup(new ToggleGroup());

            try {
                Question question = test.findNextQuestion();

                testPane.getQuestionField().setText(question.getName());

                List<String> shuffledStatements = question.getStatements();
                Collections.shuffle(shuffledStatements);
                for (String answer : shuffledStatements) {
                    testPane.getvBox().getChildren().addAll(createButton(answer, testPane.getStatementGroup()));
                }

                testPane.setProcessAnswerAction(new SubmitTest());
                stage.show();
            } catch (NullPointerException e) {
                messagePane.getLabel().setText(test.printResults());

            }
        }
    }

    private RadioButton createButton(String text, ToggleGroup group) {
        RadioButton buttonPanelForSymbols = new RadioButton(text);
        buttonPanelForSymbols.setToggleGroup(group);
        return buttonPanelForSymbols;
    }

    class SubmitTest implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            RadioButton selectedRadioButton = (RadioButton) testPane.getStatementGroup().getSelectedToggle();
            String toggleGroupValue = selectedRadioButton.getText();
            if (test.checkAnswer(toggleGroupValue) != true) {
                messagePane.getLabel().setText(test.getCurrentQuestion().getFeedback());
                stage.close();
            } else {
                messagePane.getLabel().setText("Correct !");
                stage.close();
            }
            messagePane.getTestButton().fire();
        }
    }
}
