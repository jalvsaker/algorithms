package org.pg4200.ex10;

public class RegexExampleImp implements RegexExample{
    @Override
    public String solutionA() {
        return "Exercise [0-9]+:\nFile: Ex[0-9]+\\.((java)|(txt))";
    }

    @Override
    public String solutionB() {
        return "@Bogdan: [a-zA-Z 0-9]+\\?";
    }
}
