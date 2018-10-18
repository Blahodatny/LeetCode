package Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task {
    private static HashMap<String, String> values = new HashMap<>() {{
        put("0001", "1000");
        put("0010", "0001");
        put("0011", "0010");
        put("0100", "0000");
        put("0101", "0010");
        put("0110", "1011");
        put("0111", "1011");
        put("1000", "0100");
        put("1001", "0101");
        put("1010", "0111");
        put("1011", "1111");
        put("1100", "1101");
        put("1101", "1110");
        put("1110", "0111");
    }};

    private static List<String> encodePyramid(String number) {
        var reversedNumber = new StringBuffer(number).reverse().toString();
        List<String> pyramids = new ArrayList<>();
        var tier = 2;
        while (!reversedNumber.isEmpty()) {
            for (int i = 0, j = 0; i < tier && !reversedNumber.isEmpty(); i++) {
                if (i < tier / 2)
                    pyramids.add(i % 2 == 0 ? String.valueOf(reversedNumber.charAt(0)) : reversedNumber.substring(0, 3));
                else {
                    var index = pyramids.size() - i + j;
                    pyramids.set(index, i % 2 == 0 ?
                            new StringBuffer(reversedNumber.charAt(0) + pyramids.get(index)).reverse().toString() :
                            new StringBuffer(pyramids.get(index) + reversedNumber.substring(0, 3)).reverse().toString());
                    j += 2;
                }
                try {
                    reversedNumber = i % 2 == 0 ? reversedNumber.substring(1) : reversedNumber.substring(3);
                } catch (ArrayIndexOutOfBoundsException e) {
                    reversedNumber = "";
                }
            }
            tier += 4;
        }
        return pyramids;
    }

    private static boolean pass(List<String> pyramids) {
        var passed = false;
        for (var i = 0; i < pyramids.size(); i++) {
            var item = pyramids.get(i);
            if (values.containsKey(item)) {
                passed = true;
                pyramids.set(i, values.get(item));
            }
        }
        return passed;
    }

    private static String decodePyramid(List<String> pyramid) {
        var pyramidCopy = new ArrayList<>(pyramid);
        var decodedString = new StringBuilder();
        var tier = 2;
        while (!pyramidCopy.isEmpty()) {
            for (var i = 0; i < tier; i++)
                if (i < tier / 2)
                    decodedString.insert(0, i % 2 == 0 ? pyramidCopy.get(i).charAt(3) : pyramidCopy.get(i).substring(0, 3));
                else {
                    decodedString.insert(0, i % 2 == 0 ? pyramidCopy.get(0).charAt(3) : pyramidCopy.get(0).substring(0, 3));
                    pyramidCopy.remove(0);
                }
            tier += 4;
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        var pyramid = encodePyramid(args[0]);
        System.out.println(args[0]);
        var passed = true;
        while (passed) {
            passed = pass(pyramid);
            if (passed)
                System.out.println(decodePyramid(pyramid));
            else {
                var argument = new StringBuilder();
                pyramid.stream().map(s -> s.equals("0000") ? "0" : "1").forEach(s1 -> argument.insert(0, s1));
                System.out.println(argument.toString());
                pyramid = encodePyramid(argument.toString());
                passed = pyramid.get(0).length() != 1;
            }
        }
    }
}