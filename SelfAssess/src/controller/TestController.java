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

import java.util.HashMap;

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

            Question question = test.findNextQuestion();
            testPane.getQuestionField().setText(question.getQuestion());

            for (String answer : question.getStatements()) {
                testPane.getvBox().getChildren().addAll(createButton(answer, testPane.getStatementGroup()));
            }

            testPane.setProcessAnswerAction(new SubmitTest());
            stage.show();
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
            if(test.checkAnswer(toggleGroupValue) != true){
                Label label = new Label();
                label.setText(test.getCurrentQuestion().getFeedback());
                messagePane.add(label, 0, 0);
                stage.close();
            }
            else{
                stage.close();
            }

        }
    }

}
