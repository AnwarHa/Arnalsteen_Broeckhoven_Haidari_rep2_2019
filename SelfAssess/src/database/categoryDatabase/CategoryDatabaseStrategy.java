package database.categoryDatabase;

import model.Category;

import java.util.List;

public interface CategoryDatabaseStrategy {
    public void writeData(Object o);
    public List<Category> readData();
}
