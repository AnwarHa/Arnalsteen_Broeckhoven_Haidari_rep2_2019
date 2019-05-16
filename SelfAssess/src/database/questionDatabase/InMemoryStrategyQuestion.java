package database.questionDatabase;

import database.DatabaseException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStrategyQuestion implements QuestionDatabaseStrategy {
    private List items = new ArrayList();

    public InMemoryStrategyQuestion() {
    }

    @Override
    public void writeData(Object o) {
        if(o instanceof List){
            items = (List)o;
        }else{
            throw new DatabaseException("can not write data: Wrong object");
        }
    }

    @Override
    public Object readData() {
        return items;
    }
}
