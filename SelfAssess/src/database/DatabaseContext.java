package database;

import javafx.collections.ObservableList;
import model.Observable;


public class DatabaseContext {

    public DatabaseContext(){

    }

    public ObservableList<Observable> loadCategories(String strategy){
       return  SimpleDatabaseFactorySingleton.getInstance().loadCategories(strategy);
    }

    public ObservableList<Observable> loadQuestions(String strategy){
        return  SimpleDatabaseFactorySingleton.getInstance().loadCategories(strategy);
    }

    public void writeCategories(ObservableList<Observable> items,String strategy){
        SimpleDatabaseFactorySingleton.getInstance().writeCategories(items,strategy);
    }

    public void writeQuestions(ObservableList<Observable> items,String strategy){
        SimpleDatabaseFactorySingleton.getInstance().writeQuestions(items, strategy);
    }
}
