package database;
import model.Question;
import java.util.*;

public class TxtDatabaseQuestion extends TxtDatabaseStrategy{

    public TxtDatabaseQuestion() {
        super(System.getProperty("user.dir") + "\\src\\testDatabase\\questions.txt");
    }

    @Override
    public HashMap<Integer,List<String>> objectToStringListInMap () {
        HashMap<Integer,List<String>> stringMap = new HashMap<>();
        int i = 0;
        for(Object q : this.objects){
            List<String> strings = new ArrayList<>();
            if(q instanceof Question){
                Question question = (Question) q;
                strings.add(question.getName());
                strings.add(question.getCategory());
                strings.add(question.getFeedback());
                strings.addAll(question.getStatements());
            }else{
                throw new ClassCastException("Wrong class type in list");
            }
            stringMap.put(i,strings);
            i++;
        }
        return stringMap;
    }



    @Override
    public void stringToObject(HashMap<Integer,List<String>> readedMap) {
        for(Map.Entry<Integer,List<String>> entry: readedMap.entrySet()){
            List<String> list = entry.getValue();
            List<String> answers = new ArrayList<>();

            for(int i = 3; i < list.size(); i++) answers.add(list.get(i));
            objects.add(new Question(list.get(0),list.get(1),answers,list.get(2)));
        }

    }
}
