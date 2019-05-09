package testDatabase;

public interface DatabaseStrategy {
    public void writeData(Object o);
    public Object readData();
}
