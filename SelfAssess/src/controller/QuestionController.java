package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Question;
import database.*;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QuestionController {
    private QuestionOverviewPane questionOverviewPane;
    private QuestionModel questionModel;
    private QuestionDetailPane questionDetailPane;
    private DatabaseService databaseService;
    private Stage stage;

    private ObservableList<String> answers;
    private ObservableList<String> teVerwijderen;


    public QuestionController(QuestionOverviewPane questionOverviewPane, QuestionModel questionModel) {


        this.questionOverviewPane = questionOverviewPane;
        this.questionModel = questionModel;
        this.questionOverviewPane.setNewAction(new OpenDetailPane());
        new AddStatementListener();
        new RemoveStatementListener();
    }

    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<String> getShuffledStatements(Question question) {

        List<String> shuffled = databaseService.getQuestionStatements(question);
        Collections.shuffle(shuffled);
        return shuffled;
    }

    public List<Question> getQuestions() {
        return databaseService.getQuestions();
    }

    public List<String> getDescription() {
        return databaseService.getCategoryDescriptions();
    }

    class OpenDetailPane implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            teVerwijderen = FXCollections.observableArrayList();
            answers = FXCollections.observableArrayList();
            stage = new Stage();
            questionDetailPane = new QuestionDetailPane();
            Scene scene = new Scene(questionDetailPane);
            stage.setScene(scene);
            questionDetailPane.getCategoryField().getItems().addAll(databaseService.getCategoryNamesWithoutDuplicates());
            questionDetailPane.getBtnAdd().setOnAction(new AddStatementListener());
            questionDetailPane.getBtnRemove().setOnAction(new RemoveStatementListener());
            questionDetailPane.getBtnCancel().setOnAction(new CancelQuestion());
            questionDetailPane.setSaveAction(new SaveQuestion());
            stage.show();
        }
    }


    class AddStatementListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            answers.add(questionDetailPane.getStatementField().getText());
            questionDetailPane.getStatementsArea().setItems(answers);
            questionDetailPane.getStatementField().clear();
        }
    }

    class RemoveStatementListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Iterator<String> it = answers.iterator();
            teVerwijderen = questionDetailPane.getStatementsArea().getSelectionModel().getSelectedItems();
            System.out.println(teVerwijderen);
            while (it.hasNext()) {
                String word = it.next();
                if (word.equals(teVerwijderen.get(0))) {
                    it.remove();
                    break;
                }
            }
            System.out.println(answers);
        }
    }

    class CancelQuestion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            stage.close();
        }
    }

    class SaveQuestion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            String correctAnswer = answers.get(0);
            String question = questionDetailPane.getQuestionField().getText();
            String category = questionDetailPane.getCategoryField().getValue().toString();
            Question questionObject = new Question(question, category, correctAnswer, answers);
            databaseService.getQuestions().add(questionObject);
            questionOverviewPane.getTable().getItems().addAll(questionObject);
            stage.close();

        }
    }
}
