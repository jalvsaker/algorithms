package org.pg4200.ex01;

import org.pg4200.les01.arraylist.MyArrayListString;

public class MyArrayListInteger {

    private Integer[] data;

    private int size = 0;

    MyArrayListInteger(int maxsize){
        data = new Integer[maxsize];
    }

    public Integer get(int index){
        if (index < 0||index >= size){
            return null;
        }
        return data[index];
    }


    public void add(Integer value){
        data[size] = value;
        size++;
    }


    public int size() {
        return size;
    }
}

