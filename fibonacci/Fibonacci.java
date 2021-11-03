package fibonacci;

import java.util.HashMap;

/**
 * A demonstration of speeding up functions using memoization/caching
 * for recursive functions, where results of previous function calls
 * are stored, so they don't have to be made again to compute
 * a result.
 *
 * @author Sidd Pai
 */
public class Fibonacci {

    /**
     * A purely recursive version of the fibonacci algorithm
     * with no additional steps.
     *
     * @param n the nth fibonacci term to get the value of
     * @return the nth fibonacci number
     */
    public static int fibUncached(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibUncached(n - 1) + fibUncached(n - 2);
        }
    }

    /**
     * Caches results of (what would be) the recursive fibonacci algorithm,
     * storing the results in an array.
     *
     * @param n the nth fibonacci term to get the value of
     * @return the nth fibonacci number
     */
    public static int fibCachedArray(int n) {
        // Array to store previous results.
        int[] fib = new int[n + 1];

        /*
         * Calculates the fibonacci number for every
         * term up to the nth term, storing the
         * results in an array.
         */
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                fib[i] = 0;
            } else if (i == 1) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n];
    }

    /**
     * Caches results of (what would be) the recursive fibonacci algorithm,
     * storing the results in a HashMap.
     *
     * @param n the nth fibonacci term to get the value of
     * @return the nth fibonacci number
     */
    public static int fibCachedHashMap(int n) {
        // HashMap to store previous results.
        HashMap<Integer, Integer> fib = new HashMap<>();

        /*
         * Calculates the fibonacci number for every
         * term up to the nth term, storing the
         * results in a HashMap.
         */
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                fib.put(i, 0);
            } else if (i == 1) {
                fib.put(i, 1);
            } else {
                fib.put(i, fib.get(i - 1) + fib.get(i - 2));
            }
        }
        return fib.get(n);
    }

    public static void main(String[] args) {

        /*
         * There should be a noticeable difference in performance when
         * comparing the uncached versions of these functions/methods
         * to the cached versions.
         *
         * Switch to BigInteger when testing for larger numbers.
         */

        int argument = 0;

        try {
            argument = Integer.parseInt(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            argument = 45;
        } finally {
            System.out.println();  // Blank line for formatting.

            System.out.println("Uncached results:");
            System.out.printf("%d\n", fibUncached(argument));

            System.out.println("Array caching results:");
            System.out.printf("%d\n", fibCachedArray(argument));

            System.out.println("HashMap caching results:");
            System.out.printf("%d\n", fibCachedHashMap(argument));
        }
    }
}
