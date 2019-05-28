package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Category;
import model.ListItem;
import java.util.*;

public class TxtDatabaseCategory extends TxtDatabaseStrategy {
    public TxtDatabaseCategory() {
        super(System.getProperty("user.dir") + "\\src\\testDatabase\\categories.txt");
    }

    @Override
    protected HashMap<Integer, List<String>> objectToStringListInMap() {
        HashMap<Integer,List<String>> stringMap = new HashMap<>();
        Iterator it = this.objects.iterator();
        int i = 0;
        while(it.hasNext()){
            List<String> strings = new ArrayList<>();
            ListItem listItem = (ListItem) it.next();
            if(listItem instanceof Category){
                Category category = (Category) listItem;
                List<String> temp = new ArrayList<>();
                temp.add(category.getName());
                temp.add(category.getDescription());
                if(!this.read().containsValue(temp)){
                    strings.addAll(temp);
                }
            }else{
                throw new ClassCastException("Wrong class type in list");
            }
            stringMap.put(i,strings);
            i++;
        }
        return stringMap;
    }



    @Override
    protected void stringToObject(HashMap<Integer, List<String>> readedMap) {
        ObservableList<Observable> categories = FXCollections.observableArrayList(new ArrayList<>());
        for(Map.Entry<Integer,List<String>> entry: readedMap.entrySet()) {
            List<String> list = entry.getValue();
            objects.add(new Category(list.get(0),list.get(1)));
        }
    }


}
