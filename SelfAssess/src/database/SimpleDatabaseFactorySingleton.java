package database;
import model.ListItem;
import java.util.List;

public class SimpleDatabaseFactorySingleton {
    private static SimpleDatabaseFactorySingleton uniqueInstance;
    private SimpleDatabaseFactorySingleton(){

    }
    public List<ListItem> loadCategories(String strategy){
        List<ListItem> categories;
        try {
            Class<?> strat = Class.forName("database." + strategy + "Category" );
            DatabaseStrategy o =(DatabaseStrategy)strat.getConstructor().newInstance();
            categories =  o.readData();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
        return categories;
    }

    public List<ListItem> loadQuestions(String strategy){
        List<ListItem> questions;
        try {
            Class<?> strat = Class.forName("database." + strategy + "Question" );
            DatabaseStrategy o =(DatabaseStrategy)strat.getConstructor().newInstance();
            questions =  o.readData();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
        return questions;
    }

    public void writeQuestions(List<ListItem> items, String strategy){
        try {
            Class<?> strat = Class.forName("database." + strategy + "Question" );
            DatabaseStrategy o =(DatabaseStrategy)strat.getConstructor().newInstance();
            o.writeData(items);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
    }

    public void writeCategories(List<ListItem> items, String strategy){
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
