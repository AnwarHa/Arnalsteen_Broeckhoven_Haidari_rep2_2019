package database;
import model.ListItem;
import java.util.List;

public interface DatabaseStrategy {
    public List<ListItem> readData();
    public void writeData(List<ListItem> o);
}
