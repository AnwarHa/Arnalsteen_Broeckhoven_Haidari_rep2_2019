package database.questionDatabase;

import model.Question;

import java.util.List;

public interface QuestionDatabaseStrategy {
    public void writeData(List<Question> o);
    public List<Question> readData();
}
