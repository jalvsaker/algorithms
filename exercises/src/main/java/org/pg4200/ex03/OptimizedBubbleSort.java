package org.pg4200.ex03;

import java.util.Comparator;

public class OptimizedBubbleSort {

    public <T> int sort(T[] array, Comparator<T> comparator,
                        boolean optimized){

        int numberOfCompares = 0;

        boolean swapped = true;

        if (!optimized) {
            while (swapped) {

                swapped = false;

                for (int i = 0; i < array.length - 1; i++) {
                    int j = i + 1;

                    numberOfCompares++;
                    if (comparator.compare(array[i], array[j]) > 0){
                        T tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                        swapped = true;
                    }
                }
            }
        } else{
                int lastSwap = array.length - 1;
                int limit;
            while (swapped) {

                limit = lastSwap;
                swapped = false;



                for (int i = 0; i < limit; i++) {
                    int j = i + 1;

                    numberOfCompares++;
                    if (comparator.compare(array[i], array[j]) > 0){
                        T tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                        swapped = true;
                        lastSwap = i;
                    }
                }
            }
        }


        return numberOfCompares;
    }
}
