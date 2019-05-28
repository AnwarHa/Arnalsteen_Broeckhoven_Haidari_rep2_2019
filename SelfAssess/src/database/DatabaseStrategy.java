package database;

import javafx.collections.ObservableList;
import model.Observable;

import java.util.List;

public interface DatabaseStrategy {
    public ObservableList<Observable> readData();
    public void writeData(ObservableList<Observable> o);
}
