package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

    int bubbleLimit;

    public MixedSort(){
        this(4);
    }

    public MixedSort(int bubbleLimit){
        this.bubbleLimit = bubbleLimit;
    }

    /**
     * Sort the input array in ascending order.
     * The array can be of any type, as long as such
     * type implements the interface java.land.Comparable
     * <p>
     * Note that Comparable use Generics, as it defines a method
     * (called compareTo) used to compare with other instances.
     * If you need to compare an object of (generic) type T with
     * another instance of same type T, then you need Comparable < T >.
     * So you want a class of type T that does implement the interface Comparable < T >.
     *
     * @param array
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null){
            return;
        }

        T[] buffer = (T[]) new Comparable[array.length];

        sort(array, 0, array.length -1, buffer);
    }

    private <T extends Comparable<T>> void sort(T[] array, int low, int high, T[] buffer){
        if (low >= high){
            return;
        }

        if (high - low < bubbleLimit){
            //bubble sort
            boolean swapped = true;

            while (swapped){
                swapped = false;

                for (int i = low; i < high; i++) {
                    int j = i+1;
                    if (array[i].compareTo(array[j]) > 0){
                        T tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                        swapped = true;
                    }
                }
            }


        } else {
            //merge sort
            int middle = low + (high - low) / 2;

            sort(array, low, middle, buffer);

            sort(array, middle+1, high, buffer);

            merge(array,low,middle,high,buffer);
        }

    }

    private <T extends Comparable<T>> void merge(T[] array, int low, int middle, int high, T[] buffer){
        for (int i = low; i <= high; i++){
            buffer[i] = array[i];
        }

        int i = low;
        int j = middle +1;

        for (int k = low; k <= high; k++){
            if (i > middle){
                array[k] = buffer[j++];
            } else if (j > high){
                array[k] = buffer[i++];
            } else if (buffer[j].compareTo(buffer[i]) < 0){
                array[k] = buffer[j++];
            } else {
                array[k] = buffer[i++];
            }
        }
    }
}
