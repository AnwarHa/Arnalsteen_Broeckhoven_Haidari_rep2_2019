package model;

import java.util.List;

public interface AnswerStrategy {
    public List<String> getStatements();
    public String getRightStatement();
}
