package model;

public class Question {
    private String question;
    private Category category;
    private AnswerStrategy answerStrategy;

    public Question(String question, Category category) {
        setQuestion(question);
        setCategory(category);
    }

    public String getQuestion() {
        return question;
    }

    private void setQuestion(String question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription(){
        return category.getDescription();
    }
}
