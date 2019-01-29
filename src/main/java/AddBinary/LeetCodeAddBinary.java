package AddBinary;

class LeetCodeAddBinary {
    private static String addBinary(String a, String b) {
        var sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            var sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.insert(0, carry);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
