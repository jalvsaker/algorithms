package org.pg4200.ex01;

import org.junit.jupiter.api.Test;

import static org.pg4200.ex01.TriangleClassification.*;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleClassificationTest {

    @Test
    void testNegativeSides(){

        assertEquals(Classification.NOT_A_TRIANGLE ,
                TriangleClassification.classify(-1,-2,-3));
    }

    @Test
    void testEquilateral() {
        assertEquals(Classification.EQUILATERAL,
                classify(2,2,2));
    }

    @Test
    void testIsosceles() {
        assertEquals(Classification.ISOSCELES,
                classify(2,2,3));
        assertEquals(Classification.ISOSCELES,
                classify(3,2,2));
        assertEquals(Classification.ISOSCELES,
                classify(2,3,2));

    }

    @Test
    void testScalene() {
        assertEquals(Classification.SCALENE,
                classify(2,3,4));
    }

    @Test
    void testImpossibleTriangle() {
        assertEquals(Classification.NOT_A_TRIANGLE,
                classify(1,2,3));
    }
}
