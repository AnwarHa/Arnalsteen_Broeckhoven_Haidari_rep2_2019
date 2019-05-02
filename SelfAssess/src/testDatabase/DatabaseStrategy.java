package testDatabase;

public interface DatabaseStrategy {
    public void writeData(Object o, String path);
    public Object readData(String path);
}
