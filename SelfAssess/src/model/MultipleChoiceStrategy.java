package model;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceStrategy implements AnswerStrategy{
    private String rightStatement;
    private List<String> statements = new ArrayList<>();
    @Override
    public List<String> getStatements() {
        return statements;
    }

    @Override
    public String getRightStatement() {
        return rightStatement;
    }
}
