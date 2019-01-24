package AddBinary;

import java.util.Collections;

public class AddBinary {
    private static String addBinary(String a, String b) {
        var length = a.length() - b.length();
        var str = String.join("", Collections.nCopies(Math.abs(length), "0"));
        if (length != 0)
            if (length > 0)
                b = str + b;
            else
                a = str + a;

        var sum = new StringBuilder();
        var summand = 0;
        for (var i = a.length() - 1; i >= 0; i--) {
            var value = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + summand;
            summand = value / 2;
            sum.insert(0, value % 2);
        }
        if (summand > 0) sum.insert(0, summand);
        return sum.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}