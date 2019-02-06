package AddTwoNumbers.Solutions;

import AddTwoNumbers.Node;

public class LeetCodeSolution {
    public static Node addTwoNumbers(Node l1, Node l2) {
        var dummyHead = new Node(0);
        var cur = dummyHead;
        var carry = 0;
        while (l1 != null || l2 != null) {
            var x = l1 != null ? l1.val : 0;
            var y = l2 != null ? l2.val : 0;
            var sum = carry + x + y;
            carry = sum / 10;
            cur.next = new Node(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0)
            cur.next = new Node(carry);
        return dummyHead.next;
    }
}