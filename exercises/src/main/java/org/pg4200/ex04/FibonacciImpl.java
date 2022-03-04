package org.pg4200.ex04;

public class FibonacciImpl implements Fibonacci {
    /**
     * Compute the Fibonacci number f(n) = f(n-2) + f(n-1).
     *
     * @param n
     * @throws IllegalArgumentException if n is negative
     */
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

        return compute(n - 2) + compute(n -1);
    }
}
