package TwoSum;

import java.util.Arrays;

public class Solution {
    private static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = 1;
        while (true) {
            if (numbers[i] + numbers[j] == target)
                return new int[]{i, j};
            if (j == numbers.length - 1) {
                j = ++i + 1;
                continue;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 3}, 5)));
    }
}