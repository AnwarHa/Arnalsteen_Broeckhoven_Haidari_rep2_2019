package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ListItem;
import java.util.ArrayList;
import java.util.List;

public abstract class RamDatabaseStrategy implements DatabaseStrategy {
    ObservableList<ListItem> items = FXCollections.observableArrayList(new ArrayList<>());
    public RamDatabaseStrategy() {
    }

    @Override
    public List<ListItem> readData() {
        return items;
    }

    @Override
    public void writeData(List<ListItem> o) {
        this.items.addAll(o);
    }
}
