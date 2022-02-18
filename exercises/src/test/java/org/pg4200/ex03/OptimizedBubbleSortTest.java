package org.pg4200.ex03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;


public class OptimizedBubbleSortTest {

    String[] startArray = {"c", "b", "a", "d", "e", "f"};

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    @Test
    public void testIfSorted(){
        String[] array = startArray.clone();

        OptimizedBubbleSort sort = new OptimizedBubbleSort();

        sort.sort(array, new StringComparator(), false);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
        assertEquals("f", array[5]);
    }

    @Test
    public void testIfSortedOptimized(){
        String[] array = startArray.clone();

        OptimizedBubbleSort sort = new OptimizedBubbleSort();

        sort.sort(array, new StringComparator(), true);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
        assertEquals("f", array[5]);
    }

    @Test
    public void testIfOptimized(){
        String[] array = startArray.clone();

        OptimizedBubbleSort sort = new OptimizedBubbleSort();

        int unoptimized = sort.sort(array, new StringComparator(), false);

        String[] array2 = startArray.clone();

        int optimized = sort.sort(array2, new StringComparator(), true);


        System.out.println("opt: " + optimized + "  unopt: " + unoptimized);
        assertTrue(optimized <= unoptimized/2);
    }
}
