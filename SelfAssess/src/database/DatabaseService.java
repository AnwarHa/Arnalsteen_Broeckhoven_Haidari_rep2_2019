package database;
import javafx.collections.ObservableList;
import model.Category;
import model.Observable;
import model.Question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseService {
    private DatabaseContext databaseContext;
    private String strategy;


    public DatabaseService(String strategy) {
        setStrategy(strategy);
        setDatabaseContext();
    }

    private void setStrategy(String strategy){
        if(DatabaseStrategies.containsClassname(strategy)){
            throw new IllegalArgumentException("can not set strategy: strategy not found");
        }else{
            this.strategy = strategy;
        }
    }

    public void changeStrategy(String strategy){
        setStrategy(strategy);
    }

    private void setDatabaseContext() {
        this.databaseContext = new DatabaseContext();
    }


    public ObservableList<Observable> readCategories() {
        return databaseContext.loadCategories(strategy);
    }

    public ObservableList<Observable> readQuestions() {
        return databaseContext.loadQuestions(strategy);
    }

    public void writeCategories(ObservableList<Observable> categories) {
        if (categories.isEmpty()) {
            throw new DatabaseException("can not set categories: list is empty");
        } else {
            databaseContext.writeCategories(categories,strategy);
        }

    }

<<<<<<< Updated upstream
    public void writeQuestions(List<Question> questions) {
=======
    public void writetQuestions(ObservableList<Observable> questions) {
>>>>>>> Stashed changes
        if (questions.isEmpty()) {
            throw new DatabaseException("can not set questions: list is empty");
        } else {
           databaseContext.writeQuestions(questions,strategy);
        }

    }

    public List<String> getCategoryDescriptions() {
        List<String> desc = new ArrayList<>();
        Iterator it = databaseContext.loadCategories(strategy).iterator();
        while(it.hasNext()){
            desc.add(((Category)it.next()).getDescription());
        }
        return desc;
    }

    public List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        Iterator it = databaseContext.loadCategories(strategy).iterator();
        while (it.hasNext()) {
            names.add(((Category)it.next()).getName());
        }
        return names;
    }

    public List<String> getQuestionStatements(Question q) {
        List<String> stat = new ArrayList<>();
        Iterator it = databaseContext.loadQuestions(strategy).iterator();
        while(it.hasNext()) {
            Question question = (Question) it.next();
            if (question.equals(q)) {
                stat = question.getStatements();
                break;
            }
        }
        return stat;
    }

    public ArrayList<String> getCategoryNamesWithoutDuplicates() {
        ArrayList<String> newList = new ArrayList<>();
        Iterator it = databaseContext.loadCategories(strategy).iterator();
        while (it.hasNext()) {
            Category c = (Category)it.next();
            if (!newList.contains(c.getName())) {
                newList.add(c.getName());
            }
        }
        return newList;
    }

    /*public Category getCategoryByDescription(String desc) {
        for(Category category: readCategories()){
            if(category.getDescription().equalsIgnoreCase(desc)){
                return category;
            }
        }
        return null;
    }*/
}



