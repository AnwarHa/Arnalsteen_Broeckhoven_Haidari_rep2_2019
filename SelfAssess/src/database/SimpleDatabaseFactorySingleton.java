package database;

import javafx.collections.ObservableList;
import model.Category;
import model.Observable;
import model.Question;

import java.util.ArrayList;
import java.util.List;

public class SimpleDatabaseFactorySingleton {
    private static SimpleDatabaseFactorySingleton uniqueInstance;
    private SimpleDatabaseFactorySingleton(){

    }
    public ObservableList<Observable> loadCategories(String strategy){
        ObservableList<Observable> categories;
        try {
            Class<?> strat = Class.forName("database." + strategy + "Category" );
            DatabaseStrategy o =(DatabaseStrategy)strat.getConstructor().newInstance();
            categories =  o.readData();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
        return categories;
    }

    public ObservableList<Observable> loadQuestions(String strategy){
        ObservableList<Observable> questions;
        try {
            Class<?> strat = Class.forName("database." + strategy + "Question" );
            DatabaseStrategy o =(DatabaseStrategy)strat.getConstructor().newInstance();
            questions =  o.readData();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
        return questions;
    }

    public void writeQuestions(ObservableList<Observable> items, String strategy){
        try {
            Class<?> strat = Class.forName("database." + strategy + "Question" );
            DatabaseStrategy o =(DatabaseStrategy)strat.getConstructor().newInstance();
            o.writeData(items);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
    }

    public void writeCategories(ObservableList<Observable> items, String strategy){
        try {
            Class<?> strat = Class.forName("database." + strategy + "Category" );
            DatabaseStrategy o =(DatabaseStrategy)strat.getConstructor().newInstance();
            o.writeData(items);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    public static SimpleDatabaseFactorySingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SimpleDatabaseFactorySingleton ();
        }
        return uniqueInstance;
    }


}
