package org.pg4200.ex03;

import java.util.Comparator;

public class SortCheckerImp implements SortChecker{

    private class TComparator<T extends Comparable> implements Comparator<T>{

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@code sgn(compare(x, y)) ==
         * -sgn(compare(y, x))} for all {@code x} and {@code y}.  (This
         * implies that {@code compare(x, y)} must throw an exception if and only
         * if {@code compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x, y)==0}
         * implies that {@code sgn(compare(x, z))==sgn(compare(y, z))} for all
         * {@code z}.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."<p>
         * <p>
         * In the foregoing description, the notation
         * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(T o1, T o2) {
            if (o1 == null||o2 == null){
                return 0;
            }

            return o1.compareTo(o2);
        }
    }

    /**
     * Check if "sorted" is a sorted copy of the
     * "original" array.
     * <p>
     * Sorting is undefined for "null" elements.
     * Therefore, if any of the input array contains null values,
     * this method returns false.
     *
     * @param original
     * @param sorted
     */
    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {
        if (sorted == null && original == null) return true;
        else if (original == null||sorted == null) return false;
        else if (original.length != sorted.length) return false;

        for (int i = 0; i < sorted.length -1; i++) {
            if (sorted[i+1] == null) return false;
            if (sorted[i].compareTo(sorted[i+1]) > 0){
                return false;
            }
        }

        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        T[] newArray = original.clone();

        sorter.sort(newArray, new TComparator<>(), true);

        for (int i = 0; i < newArray.length; i++) {
            if(sorted[i] != newArray[i]){

                return false;
            }
        }

        return true;
    }
}
