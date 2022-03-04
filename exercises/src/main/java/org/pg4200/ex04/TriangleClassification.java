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

        int max = Math.max(a, Math.max(b, c));

        if ((max == a && max - b - c >= 0)
                ||(max == b && max - c - a >= 0)
                ||(max == c && max - a - b >= 0)){
            return Classification.NOT_A_TRIANGLE;
        }

        if (a == b || b == c || a == c) {
            return Classification.ISOSCELES;
        } else {
            return Classification.SCALENE;
        }
    }
}
