package model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    protected String name, description;

    public Category(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if(name.isEmpty()||name.equals("")){
            throw new DomainException("name can't be empty");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    //returns all questions of category
    public List<Question> getQuestions() {
        return null;
    }





}