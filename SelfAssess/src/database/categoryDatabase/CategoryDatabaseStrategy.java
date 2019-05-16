package database.categoryDatabase;

public interface CategoryDatabaseStrategy {
    public void writeData(Object o);
    public Object readData();
}
