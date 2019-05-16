package database.questionDatabase;

public interface QuestionDatabaseStrategy {
    public void writeData(Object o);
    public Object readData();
}
