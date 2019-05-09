package testDatabase;

public class DatabaseContext {
    private  DatabaseStrategy dbStrategy;

    public DatabaseContext(DatabaseStrategy dbStrategy){
        setDbStrategy(dbStrategy);
    }

    private void setDbStrategy(DatabaseStrategy dbStrategy) {
        this.dbStrategy = dbStrategy;
    }

    public DatabaseStrategy getDbStrategy() {
        return dbStrategy;
    }

    public void writeData(Object data){
        dbStrategy.writeData(data);
    }
}
