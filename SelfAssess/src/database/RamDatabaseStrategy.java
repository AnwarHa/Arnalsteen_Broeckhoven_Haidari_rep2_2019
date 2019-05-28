package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Category;
import model.Observable;
import model.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class RamDatabaseStrategy implements DatabaseStrategy {
    ObservableList<Observable> items = FXCollections.observableArrayList(new ArrayList<>());
    public RamDatabaseStrategy() {
    }

    @Override
    public ObservableList<Observable> readData() {
        return items;
    }

    @Override
    public void writeData(ObservableList<Observable> o) {
        this.items = o;
    }
}
