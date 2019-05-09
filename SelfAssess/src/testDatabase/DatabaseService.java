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
        categories = new ArrayList<>();
        questions = new ArrayList<>();
        this.databaseContext = databaseContext;
        Category math = new Category("Math", "Math again");
        categories.add(math);
        questions.add(new Question("1 + 1 = ?", math));
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<String> getCategoryNamen() {
        ArrayList<String> names = new ArrayList<>();
        for (Category c : categories) {
            if (c != null) {
                names.add(c.getName());
            }
        }
        return names;
    }

    public List<String> getAll() {
        return databaseContext.readData();
    }


}
