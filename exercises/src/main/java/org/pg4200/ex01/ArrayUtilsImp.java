package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils{
    /**
     * @param array
     * @return the minimum value in the array
     * @throws IllegalArgumentException if input is null or empty
     */
    @Override
    public int min(int[] array) throws IllegalArgumentException {
        if (array == null||array.length == 0){
            throw new IllegalArgumentException();
        }

        int min = array[0];
        for (int x:
                array) {
            if (x < min){
                min = x;
            }
        }

        return min;
    }

    /**
     * @param array
     * @return the maximum value in the array
     * @throws IllegalArgumentException if input is null or empty
     */
    @Override
    public int max(int[] array) throws IllegalArgumentException {
        if (array == null||array.length == 0){
            throw new IllegalArgumentException();
        }

        int max = array[0];

        for (int x :
                array) {
            if (x > max) {
                max = x;
            }
        }

        return max;
    }

    /**
     * @param array
     * @return the arithmetic average of the values in the array
     * @throws IllegalArgumentException if input is null or empty
     */
    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        if (array == null||array.length == 0){
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (int x :
                array) {
            sum += x;
        }
        double mean = sum / array.length;

        return mean;
    }
}
