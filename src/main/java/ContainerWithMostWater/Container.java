package ContainerWithMostWater;

class Container {
    private static int maxArea(int[] height) {
        int length = height.length, area = 0;
        for (var i = 0; i < length - 1; i++)
            for (var j = i + 1; j < length; j++) {
                var temp = height[i] > height[j] ? height[j] * (j - i) :
                        height[i] * (j - i);
                if (temp > area)
                    area = temp;
            }
        return area;
    }

    private static int leetMaxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(leetMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}