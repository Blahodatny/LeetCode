package ReverseInteger;

public class Solution {
    private static int reverse(int x) {
        try {
            return Integer.parseInt(
                    x < 0 ? "-" + new StringBuilder(Integer.toString(Math.abs(x))).reverse().toString()
                            : new StringBuilder(Integer.toString(x)).reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1200));
    }
}
