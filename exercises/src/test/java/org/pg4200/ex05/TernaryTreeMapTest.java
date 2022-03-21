package org.pg4200.ex05;

import org.junit.jupiter.api.Test;
import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class TernaryTreeMapTest extends MyMapTestTemplate {
    @Override
    protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
        return new TernaryTreeMap<>();
    }


    @Test
    void bestCaseDepth(){
        TernaryTreeMap<Integer, String> map = new TernaryTreeMap<>();

        map.put(1, "hei");
        map.put(5, "hallo");

        assertEquals(map.getMaxTreeDepth(), 1);
    }

    @Test
    void worstCaseDepth(){
        TernaryTreeMap<Integer, String> map = new TernaryTreeMap<>();

        map.put(10, "abcd");
        map.put(7, "efgh");
        map.put(3, "ijkl");

        assertEquals(map.getMaxTreeDepth(), 3);
        assertEquals(map.get(7), "efgh");
    }

    @Test
    void bestCase8(){
        TernaryTreeMap<Integer, String> map = new TernaryTreeMap<>();

        //root
        map.put(10, "");
        map.put(80, "");

        //left
        map.put(3, "");
        map.put(6, "");

        //middle
        map.put(40, "");
        map.put(60, "test");

        //right
        map.put(100, "");
        map.put(12345, "");

        assertEquals(map.getMaxTreeDepth(), 2);
        assertEquals(map.get(60), "test");

    }
}
