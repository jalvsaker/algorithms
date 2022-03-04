package org.pg4200.ex04;

public class FibonacciImplMemoized implements Fibonacci{
    /**
     * Compute the Fibonacci number f(n) = f(n-2) + f(n-1).
     *
     * @param n
     * @throws IllegalArgumentException if n is negative
     */

    int[] x = new int[100];

    @Override
    public int compute(int n) throws IllegalArgumentException {
        if (n < 0){
            throw new IllegalArgumentException("Negative n.");
        }

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        int nmin2;
        int nmin1;

        if (x[n-2] == 0){
            nmin2 = compute(n - 2);
            x[n-2] = nmin2;
        } else {
            nmin2 = x[n-2];
        }

        if (x[n-1] == 0){
            nmin1 = compute(n - 1);
            x[n-1] = nmin1;
        } else {
            nmin1 = x[n-1];
        }


        return nmin2 + nmin1;
    }
}
