package org.pg4200.exam;

public class Ex01 {

    public String regexPartA(){
        return "/.+/test/.+Test\\.(java|cpp|kt)";
    }

    public String regexPartB(){
        return "@.+: .*((pg|PG).\\d{3,4}|programming|programmering).*\\?";
    }
}
