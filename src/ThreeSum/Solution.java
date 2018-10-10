package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int l = 0, r = nums.length - 1;
        while (l != nums.length - 1) {
            for (var k = l + 1; k < r; k++)
                if (nums[l] + nums[k] + nums[r] == 0)
                    list.add(new ArrayList<>(Arrays.asList(nums[l], nums[k], nums[r])));
            l++;
            r--;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}