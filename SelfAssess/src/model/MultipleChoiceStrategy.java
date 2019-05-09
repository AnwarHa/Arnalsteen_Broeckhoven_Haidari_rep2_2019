package model;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceStrategy implements AnswerStrategy{

        private String rightStatement;
        private List<String> statements = new ArrayList<>();


    public MultipleChoiceStrategy(List<String> statements,String rightStatement) {
        setStatements(statements);
        setRightStatement(rightStatement);
    }

    @Override
    public List<String> getStatements() {
        return statements;
    }

    @Override
    public String getRightStatement() {
        return rightStatement;
    }

    @Override
    public void setRightStatement(String answer) {
        if(answer.isEmpty()||answer.equals("")){
            throw new IllegalArgumentException("The right answer can't be empty");
        }else{
            this.rightStatement = answer;
        }
    }

    @Override
    public void setStatements(List<String> statements) {
        if(statements==null|| statements.isEmpty()){
            throw  new NullPointerException("Statements can't be empty");
        }else{
            this.statements = statements;
        }
    }
}
