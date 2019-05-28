package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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
    private QuestionDetailPane questionDetailPane;
    private DatabaseService databaseService;
    private Stage stage;
    private List<Question> questions;

    private ObservableList<String> answers;
    private ObservableList<String> teVerwijderen;


    public QuestionController(QuestionOverviewPane questionOverviewPane) {
        this.questionOverviewPane = questionOverviewPane;
        this.questionOverviewPane.setNewAction(new OpenDetailPane());
        new AddStatementListener();
        new RemoveStatementListener();
        this.questionOverviewPane.setEditAction(new OpenDetailPaneEdit());
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
        return databaseService.readQuestions();
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
            while (it.hasNext()) {
                String word = it.next();
                if (word.equals(teVerwijderen.get(0))) {
                    it.remove();
                    break;
                }
            }
        }
    }

    class CancelQuestion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            stage.close();
        }
    }

    class SaveQuestion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String question = questionDetailPane.getQuestionField().getText();
            String category = questionDetailPane.getCategoryField().getValue().toString();
            String feedback = questionDetailPane.getFeedbackField().getText();
            Question questionObject = new Question(question, category, answers, feedback);
            questions = databaseService.readQuestions();
            questions.add(questionObject);
            databaseService.writeQuestions(questions);
            questionOverviewPane.getTable().getItems().addAll(questionObject);
            stage.close();

        }
    }
    class OpenDetailPaneEdit implements EventHandler<MouseEvent>{

            @Override
            public void handle(MouseEvent event) {
                stage = new Stage();
                questionDetailPane = new QuestionDetailPane();
                Question question = questionOverviewPane.getSelectedRow();
                questionDetailPane.setQuestionField(question.getQuestion());
                questionDetailPane.setStatementsArea(question.getStatements());
                questionDetailPane.setFeedbackField(question.getFeedback());
                questionDetailPane.getCategoryField().getItems().addAll(databaseService.getCategoryNamesWithoutDuplicates());
                questionDetailPane.setCategoryField(question.getCategory());
                Scene scene = new Scene(questionDetailPane);
                stage.setScene(scene);
                try {
                    questionDetailPane.getCategoryField().getItems().addAll(databaseService.getCategoryNamesWithoutDuplicates());
                }catch (NullPointerException e){
                    System.out.println("No Category names yet");
                }
                stage.show();

                questionDetailPane.setSaveAction(new editQuestion(question));
                questionDetailPane.getBtnAdd().setOnAction(new AddStatementListener());
                questionDetailPane.getBtnRemove().setOnAction(new RemoveStatementListener());
                questionDetailPane.getBtnCancel().setOnAction(new CancelQuestion());

            }
        }

        class editQuestion implements EventHandler<ActionEvent>{
            Question question;
            editQuestion(Question q){

                this.question = q;
            }
            @Override
            public void handle(ActionEvent event) {
                //String correctAnswer = answers.get(0);
                String qu = questionDetailPane.getQuestionField().getText();
                String category = questionDetailPane.getCategoryField().getValue().toString();
                String feedback = questionDetailPane.getFeedbackField().getText();
                System.out.println(qu);
                System.out.println(category);
                System.out.println(feedback);
                //question.setCorrectAnswer(correctAnswer);
                ObservableList<String>statements = questionDetailPane.getStatementsArea().getItems();
                question.setQuestion(qu);
                question.setCategory(category);
                question.setFeedback(feedback);
                question.setStatements(statements);
                questionOverviewPane.getTable().getItems().addAll(databaseService.getQuestionDatabaseContext());
                stage.close();
            }
        }
    }

