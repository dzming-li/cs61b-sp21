package IntList;

public class Primes {

    /**
     * This (complicated) algorithm returns True if its argument is prime,
     * otherwise False. When you're debugging, stepping into this function may
     * not be the best idea! Consider instead stepping *over* this function,
     * and ensuring that its return value makes sense.
     *
     * If you're curious, this algorithm uses Fermat's Little Theorem as a
     * primality test, and returns the correct answer w.h.p. (due to the presence)
     * of Carmichael numbers. If this makes no sense to you, good! It shouldn't.
     * The goal of this function is to make sure you learn to abstract away the inner
     * workings of a function and debug it as a black-box with the "Step Over" feature.
     *
     * @source: https://www.geeksforgeeks.org/primality-test-set-2-fermet-method/
     * @param n an arbitary integrer
     * @return True iff. the integer is prime
     */
    public static boolean isPrime(int n) {
            if (n < 2) return false; // 小于2的数不是素数
            if (n == 2) return true; // 2是素数
            if (n % 2 == 0) return false; // 偶数（除2外）都不是素数

            // 只需要检查到 sqrt(n)，减少计算量
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
    }



    /** Driver Code */
    public static void main(String[] args) {
        /* Print the first 20 primes */
        int primeCount = 0;
        int x = 2;

        while (primeCount < 20) {
            if (isPrime(x)) {
                System.out.println(x);
                primeCount++;
            }
            x++;
        }
    }
}
