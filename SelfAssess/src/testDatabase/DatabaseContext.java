package testDatabase;

import java.util.List;

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

    public List<String> readData(){
        return (List<String>) dbStrategy.readData();
    }
}
