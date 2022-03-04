package org.pg4200.ex04;

public class TriangleClassification {
    public enum Classification {NOT_A_TRIANGLE, ISOSCELES, SCALENE, EQUILATERAL}

    public static Classification classify(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0){
            return Classification.NOT_A_TRIANGLE;
        }

        if (a == b && b == c){
            return Classification.EQUILATERAL;
        }

        if (a == b || b == c || a == c){
            if (a*2 < b || b*2 < c || c * 2 < a){
                return Classification.NOT_A_TRIANGLE;
            }
            return Classification.ISOSCELES;
        }
        return null;
    }
}
