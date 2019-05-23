package database.categoryDatabase;

import database.questionDatabase.QuestionDatabaseStrategy;
import model.Category;

import java.util.List;

public class CategoryDatabaseContext {
    private CategoryDatabaseStrategy dbStrategy;


    public CategoryDatabaseContext(CategoryDatabaseStrategy dbStrategy){
        setCategoryDatabaseStrategy(dbStrategy);
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

    public void writeData(List<Category> data){
        dbStrategy.writeData(data);
    }

    public List<Category> readData(){
        return dbStrategy.readData();
    }
}
