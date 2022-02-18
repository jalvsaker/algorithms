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

    @Test
    public void testGameUserComparator(){

        GameUser gu6 = new GameUser("Id 62", 1);
        GameUser gu7 = new GameUser("Id 543", 12);
        GameUser gu2 = new GameUser("Id 6", 456);
        GameUser gu1 = new GameUser("Id 1", 500);
        GameUser gu5 = new GameUser("Id 12", 1000);
        GameUser gu4 = new GameUser("Id 89", 1000);
        GameUser gu3 = new GameUser("Id 2", 5000);

        GameUser[] GameUserArray = {gu1, gu2, gu3, gu4, gu5, gu6, gu7};

        OptimizedBubbleSort sorter = new OptimizedBubbleSort();
        sorter.sort(GameUserArray, new GameUserComparator(), false);

        for (GameUser gu :
                GameUserArray) {
            System.out.println(gu.getUserId() + " + " + gu.getPoints());
        }

        assertEquals(gu6, GameUserArray[0]);
        assertEquals(gu7, GameUserArray[1]);
        assertEquals(gu2, GameUserArray[2]);
        assertEquals(gu1, GameUserArray[3]);
        assertEquals(gu5, GameUserArray[4]);
        assertEquals(gu4, GameUserArray[5]);
        assertEquals(gu3, GameUserArray[6]);
    }
}
