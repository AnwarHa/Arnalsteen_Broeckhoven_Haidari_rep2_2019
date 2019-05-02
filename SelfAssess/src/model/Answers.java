package model;

import java.util.ArrayList;
import java.util.List;

public enum Answers {
    YESORNO("Yes or no"),MULTIPLECHOICE("Multiple choice");
    private final String name;
    Answers(String name) {
        this.name = name;
    }

    public static List<String> getValueNames(){
        List<String> values = new ArrayList<>();
        for(Answers c : Answers.values()){
            values.add(c.name);
        }
        return values;
    }
}
