package AddTwoNumbers.Solutions;

import AddTwoNumbers.ListNode;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var augend = new StringBuilder();
        var addend = new StringBuilder();
        while (l1 != null || l2 != null) {
            augend.insert(0, l1 != null ? l1.val : 0);
            addend.insert(0, l2 != null ? l2.val : 0);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        var sum = new StringBuilder();
        var summand = 0;
        for (var i = augend.length() - 1; i >= 0; i--) {
            var value =
                    Character.getNumericValue(augend.charAt(i))
                            + Character.getNumericValue(addend.charAt(i)) + summand;
            if (value >= 10) {
                if (i != 0) {
                    value -= 10;
                    summand = 1;
                }
            } else
                summand = 0;

            sum.insert(0, value);
        }

        var result = new ListNode(0);
        var list = result;
        for (var i = sum.length() - 1; i >= 0; i--) {
            result.next = new ListNode(Character.getNumericValue(sum.charAt(i)));
            result = result.next;
        }
        return list.next;
    }
}