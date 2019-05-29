package database;
import javafx.collections.FXCollections;
import model.DomainException;
import model.ListItem;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public abstract class TxtDatabaseStrategy implements DatabaseStrategy {
    protected String path;
    protected List<ListItem> objects;

    public TxtDatabaseStrategy(String path) {
        this.path = path;
    }

    public abstract List<ListItem> load();

    public abstract void update(List<ListItem> items);
}
