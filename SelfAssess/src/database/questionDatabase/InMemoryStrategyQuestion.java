package database.questionDatabase;

import database.DatabaseException;
import model.Question;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStrategyQuestion implements QuestionDatabaseStrategy {
    private List items = new ArrayList();

    public InMemoryStrategyQuestion() {
    }

    @Override
    public void writeData(List<Question> o) {
        if(o instanceof List){
            items = (List)o;
        }else{
            throw new DatabaseException("can not write data: Wrong object");
        }
    }

    @Override
    public List<Question> readData() {
        return items;
    }
}
