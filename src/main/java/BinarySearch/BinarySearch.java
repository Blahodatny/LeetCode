package BinarySearch;

class BinarySearch {
    private static int search(int left, int right, int x, int[] arr) {
        if (left <= right) {
//            var middle = left + (right - left) / 2;
            var middle = left + right >>> 1;
            return arr[middle] == x
                    ? middle
                    : arr[middle] > x
                    ? search(left, middle - 1, x, arr)
                    : search(middle + 1, right, x, arr);
        }
        return -1;
    }

    public static void main(String... args) {
        System.out.println(search(0, 9, 7, new int[]{-1, 3, 7, 12, 34, 56, 67, 78, 89, 100}));
    }
}
