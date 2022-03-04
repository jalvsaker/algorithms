package org.pg4200.ex04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassificationTest {

    @Test
    void negativeA(){
        assertEquals(TriangleClassification.classify(-1, 0, 0), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void negativeB(){
        assertEquals(TriangleClassification.classify(0,-1,0), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void negativeC(){
        assertEquals(TriangleClassification.classify(0,0,-1), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void zeroA(){
        assertEquals(TriangleClassification.classify(0,1,1), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void zeroB(){
        assertEquals(TriangleClassification.classify(1,0,1), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void zeroC(){
        assertEquals(TriangleClassification.classify(1,1,0), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }
}
