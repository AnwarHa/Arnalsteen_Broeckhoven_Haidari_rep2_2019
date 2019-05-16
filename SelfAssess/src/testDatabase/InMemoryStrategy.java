package testDatabase;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryStrategy implements DatabaseStrategy {
    private List items = new ArrayList();

    public InMemoryStrategy() {
    }

    @Override
    public void writeData(Object o) {
        if(o instanceof List){
            items = (List)o;
        }
    }

    @Override
    public Object readData() {
        return items;
    }
}
