package Task;

import java.util.stream.IntStream;

public class Validator {
    private static boolean isPowerOfFour(String number) {
        var length = number.length();
        return length == 1 || length % 4 == 0 &&
                IntStream.rangeClosed(0, length)
                        .anyMatch(i -> Math.pow(4, i) == length);

    }

    private static boolean isValid(String number) {
        return IntStream.range(0, number.length())
                .noneMatch(i -> number.charAt(i) != '1' && number.charAt(i) != '0');
    }
}
