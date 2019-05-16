package database.categoryDatabase;

import database.questionDatabase.QuestionDatabaseStrategy;

import java.util.List;

public class CategoryDatabaseContext {
    private CategoryDatabaseStrategy dbStrategy;


    public CategoryDatabaseContext(){

    }

    private void setCategoryDatabaseStrategy(CategoryDatabaseStrategy dbStrategy) {
        if(dbStrategy==null){
            throw new IllegalArgumentException("code method is empty");
        }else{
            this.dbStrategy = dbStrategy;
        }

    }

    public CategoryDatabaseStrategy getDbStrategy() {
        return dbStrategy;
    }

    public void writeData(Object data){
        dbStrategy.writeData(data);
    }

    public List<Object> readData(){
        return (List<Object>) dbStrategy.readData();
    }
}
