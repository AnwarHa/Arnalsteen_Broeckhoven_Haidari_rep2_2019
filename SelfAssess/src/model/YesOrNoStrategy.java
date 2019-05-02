package model;

import java.util.ArrayList;
import java.util.List;

public class YesOrNoStrategy implements AnswerStrategy {
    private boolean rightStatement;
    public YesOrNoStrategy(String rightStatement) {
        setRightStatement(rightStatement);
    }

    private void setRightStatement(String rightStatement){
        this.rightStatement= Boolean.parseBoolean(rightStatement);
    }

    @Override
    public List<String> getStatements() {
        List<String> statements = new ArrayList<>();
        statements.add(Boolean.TRUE+"");
        statements.add(Boolean.FALSE+"");
        return statements;
    }

    @Override
    public String getRightStatement() {
        return this.rightStatement+"";
    }
}
