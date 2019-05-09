package model;

import java.util.ArrayList;
import java.util.List;

public class YesOrNoStrategy implements AnswerStrategy {
    private boolean rightStatement;
    List<String> statements = new ArrayList<>();

    public YesOrNoStrategy(String rightStatement) {
        setRightStatement(rightStatement);
    }

    @Override
    public void setRightStatement(String rightStatement){
        this.rightStatement= Boolean.parseBoolean(rightStatement);
    }

    @Override
    public List<String> getStatements() {


        return statements;
    }

    @Override
    public String getRightStatement() {
        return this.rightStatement+"";
    }

    @Override
    public void setStatements(List<String> statements) {
        this.statements.add(Boolean.TRUE+"");
        this.statements.add(Boolean.FALSE+"");
    }
}
