package org.pg4200.ex04;

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

    @Test
    void allMinusOne(){
        assertEquals(TriangleClassification.classify(-1,-1,-1), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void allZeroOne(){
        assertEquals(TriangleClassification.classify(-1,-1,-1), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void allOnes(){
        assertEquals(TriangleClassification.classify(1,1,1), TriangleClassification.Classification.EQUILATERAL);
    }

    @Test
    void allMax(){
        assertEquals(TriangleClassification.classify(Integer.MAX_VALUE,Integer.MAX_VALUE, Integer.MAX_VALUE), TriangleClassification.Classification.EQUILATERAL);
    }

    @Test
    void isoA(){
        assertEquals(TriangleClassification.classify(1,2,2), TriangleClassification.Classification.ISOSCELES);
    }

    @Test
    void isoB(){
        assertEquals(TriangleClassification.classify(2,1,2), TriangleClassification.Classification.ISOSCELES);
    }

    @Test
    void isoC(){
        assertEquals(TriangleClassification.classify(2,2,1), TriangleClassification.Classification.ISOSCELES);
    }

    @Test
    void impossibleIsoA(){
        assertEquals(TriangleClassification.classify(5,2,2), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }
    @Test
    void impossibleIsoB(){
        assertEquals(TriangleClassification.classify(2,5,2), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }
    @Test
    void impossibleIsoC(){
        assertEquals(TriangleClassification.classify(2,2,5), TriangleClassification.Classification.NOT_A_TRIANGLE);
    }

    @Test
    void maxIsoA(){
        assertEquals(TriangleClassification.classify(Integer.MAX_VALUE -1, Integer.MAX_VALUE, Integer.MAX_VALUE), TriangleClassification.Classification.ISOSCELES);
    }@Test
    void maxIsoB(){
        assertEquals(TriangleClassification.classify(Integer.MAX_VALUE, Integer.MAX_VALUE -1, Integer.MAX_VALUE), TriangleClassification.Classification.ISOSCELES);
    }@Test
    void maxIsoC(){
        assertEquals(TriangleClassification.classify(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE -1), TriangleClassification.Classification.ISOSCELES);
    }

    @Test
    void scalene(){
        assertEquals(TriangleClassification.classify(2,3,4), TriangleClassification.Classification.SCALENE);
    }

    @Test
    void maxScalene(){
        assertEquals(TriangleClassification.classify(Integer.MAX_VALUE, Integer.MAX_VALUE-1, Integer.MAX_VALUE-2), TriangleClassification.Classification.SCALENE);
    }
}
