package database.categoryDatabase;

import database.DatabaseException;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStrategyCategory implements CategoryDatabaseStrategy {
    private List items = new ArrayList();

    public InMemoryStrategyCategory() {
    }

    @Override
    public void writeData(Object o) {
        if(o instanceof List){
            items = (List)o;
        }else{
            throw new DatabaseException("can not write data: Wrong object");
        }
    }

    @Override
    public Object readData() {
        return items;
    }
}
