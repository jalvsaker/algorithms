package org.pg4200.ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;


public class MyArrayListIntegerTest {

    MyArrayListInteger list;

    @BeforeEach
    public void init(){
        list = new MyArrayListInteger(10);


    }


    @Test
    public void testEmpty(){
        assertEquals(0, list.size());
    }

    @Test
    public void testAddOneElement(){
        int n = list.size();

        list.add(42);

        assertEquals(list.size(), n+1);
    }

    @Test
    public void testAddAndRetrieveElement() {

        int value = 42;

        list.add(value);

        /*
            As the container is empty, I m expecting to have it in position 0
         */
        int res = list.get(0);

        assertEquals(value, res);
    }

    @Test
    public void testAdd5Elements(){

        assertEquals(0, list.size());
        int a = 123;
        int b = 456;
        int c = 789;

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(a);
        list.add(a);

        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
        assertEquals(a, list.get(3));
        assertEquals(a, list.get(4));
    }

    @Test
    public void testOutOfIndex(){

        assertNull(list.get(-5));
        assertNull(list.get(42));
    }
}
