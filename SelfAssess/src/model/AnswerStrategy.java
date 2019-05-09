package model;

import java.util.List;

public interface AnswerStrategy {

    List<String> getStatements();
    String getRightStatement();
    void setStatements(List<String> statements);
    void setRightStatement(String answer);

}
