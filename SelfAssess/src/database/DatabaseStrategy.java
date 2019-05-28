package database;

import javafx.collections.ObservableList;
import model.Category;
import model.Observable;

import java.util.List;

public interface DatabaseStrategy {
    public List<Category> readData();
    public void writeData(List<Category> o);
}
