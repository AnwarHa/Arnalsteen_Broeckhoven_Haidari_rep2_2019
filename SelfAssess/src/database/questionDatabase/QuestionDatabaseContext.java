package database.questionDatabase;

import database.questionDatabase.QuestionDatabaseStrategy;

import java.util.List;

public class QuestionDatabaseContext {
    private QuestionDatabaseStrategy dbStrategy;


    public QuestionDatabaseContext(QuestionDatabaseStrategy dbStrategy){
        setDbStrategy(dbStrategy);
    }

    private void setDbStrategy(QuestionDatabaseStrategy dbStrategy) {
        this.dbStrategy = dbStrategy;
    }

    public QuestionDatabaseStrategy getDbStrategy() {
        return dbStrategy;
    }

    public void writeData(Object data){
        dbStrategy.writeData(data);
    }

    public List<Object> readData(){
        return (List<Object>) dbStrategy.readData();
    }
}
