package testDatabase;

import java.util.List;

public class DatabaseService {
    private DatabaseContext databaseContext;

    public DatabaseService(DatabaseContext databaseContext) {
        this.databaseContext = databaseContext;
    }

    public List<String> getAll(){
        return databaseContext.readData();
    }
}
