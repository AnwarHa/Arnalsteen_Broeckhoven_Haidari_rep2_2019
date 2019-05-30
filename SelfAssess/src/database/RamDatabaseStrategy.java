package database;
import model.ListItem;
import java.util.ArrayList;
import java.util.List;

public abstract class RamDatabaseStrategy implements DatabaseStrategy {
    private List<ListItem> items = new ArrayList<>();
    public RamDatabaseStrategy() {
    }

    @Override
    public List<ListItem> load() {
        return items;
    }

    @Override
    public void update(List<ListItem> o) {
        this.items.addAll(o);
    }
}
