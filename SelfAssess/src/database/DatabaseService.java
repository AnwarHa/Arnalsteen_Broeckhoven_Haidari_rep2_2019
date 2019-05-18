package database;

import database.categoryDatabase.CategoryDatabaseContext;
import database.questionDatabase.QuestionDatabaseContext;
import model.Category;
import model.Question;

import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private QuestionDatabaseContext questionDatabaseContext;
    private CategoryDatabaseContext categoryDatabaseContext;
    private List<Question> questions;
    private List<Category> categories;

    public DatabaseService(QuestionDatabaseContext q, CategoryDatabaseContext c) {
        categories = new ArrayList<>();
        setCategoryDatabaseContext(c);
        setQuestionDatabaseContext(q);
        this.categoryDatabaseContext.readData();
    }

    private void setQuestionDatabaseContext(QuestionDatabaseContext questionDatabaseContext) {
        this.questionDatabaseContext = questionDatabaseContext;
    }

    private void setCategoryDatabaseContext(CategoryDatabaseContext categoryDatabaseContext) {
        this.categoryDatabaseContext = categoryDatabaseContext;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setCategories(List<Category> categories) {
        if (categories.isEmpty()) {
            throw new DatabaseException("can not set categories: list is empty");
        } else {
            this.categories = categories;
        }

    }

    public void setQuestions(List<Question> questions) {
        if (questions.isEmpty()) {
            throw new DatabaseException("can not set questions: list is empty");
        } else {
            this.questions = questions;
        }

    }

    public List<String> getCategoryDescriptions() {
        List<String> desc = new ArrayList<>();
        for (Category c : categories) {
            desc.add(c.getDescription());
        }
        return desc;
    }

    public List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        for (Category c : categories) {
            names.add(c.getName());
        }
        return names;
    }

    public List<String> getQuestionStatements(Question q) {
        List<String> stat = new ArrayList<>();
        for (Question c : questions) {
            if (c.equals(q)) {
                stat = c.getAnswers();
                break;
            }
        }
        return stat;
    }


    public List<Object> getAll() {
        return questionDatabaseContext.readData();
    }


    public ArrayList<String> getCategoryNamesWithoutDuplicates() {
        ArrayList<String> newList = new ArrayList<>();
        for (String s : getCategoryNames()) {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        return newList;
    }
}



