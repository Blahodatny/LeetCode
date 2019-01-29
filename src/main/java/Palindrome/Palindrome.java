package Palindrome;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Palindrome {
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        var sqrtN = Math.sqrt(n) + 1;
        return IntStream
                .iterate(6, i -> i <= sqrtN, i -> i + 6)
                .noneMatch(i -> n % (i - 1) == 0 || n % (i + 1) == 0);
    }

    private static boolean isPalindrome(long n) {
        var str = Long.toString(n);
        return new StringBuffer(str).reverse().toString().equals(str);
    }

    private static long[] program() {
        var primeNumbers = IntStream
                .iterate(99999, i -> i >= 10000, i -> i - 1)
                .filter(Palindrome::isPrime)
                .boxed()
                .collect(Collectors.toList());

        var response = new long[3];
        while (primeNumbers.size() != 0) {
            var multiplier = primeNumbers.remove(0);
            for (short j = 0; j < primeNumbers.size(); j++) {
                var multiplicand = primeNumbers.get(j);
                var product = (long) multiplier * multiplicand;
                if (product < response[2]) break;
                if (isPalindrome(product)) {
                    response = new long[]{multiplier, multiplicand, product};
                    primeNumbers.subList(j + 1, primeNumbers.size()).clear();
                    break;
                }
            }
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(program()));
    }
}