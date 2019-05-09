package testDatabase;

import model.Category;
import model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseService {
    private DatabaseContext databaseContext;
    private List<Question> questions;
    private List<Category> categories;

    public DatabaseService(DatabaseContext databaseContext) {
        this.databaseContext = databaseContext;
        Category math = new Category("Math","Math again");
        categories.add(math);
        questions.add(new Question("1 + 1 = ?",math));
    }

    public List<String> getAll(){
        return databaseContext.readData();
    }

    
}
