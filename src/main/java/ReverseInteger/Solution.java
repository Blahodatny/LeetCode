package ReverseInteger;

class Solution {
    private static int reverse(int x) {
        try {
            return Integer.parseInt(
                    new StringBuilder(
                            Integer.toString(x < 0 ? Math.abs(x) : x)
                    ).reverse()
                            .insert(0, x < 0 ? "-" : null)
                            .toString()
            );
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1200));
    }
}