package database;
import model.Question;

import java.util.List;

public interface QuestionDatabaseStrategy {
    public List<Question> readData();
    public void writeData(List<Question> o);
}
