package AddTwoNumbers;

import static AddTwoNumbers.Solutions.LeetCodeSolution.addTwoNumbers;

class Main {
    public static void main(String[] args) {
        var l1 = new ListNode(6);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(8);

        var l2 = new ListNode(5);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(2);

        var list = addTwoNumbers(l1, l2);
        while (list != null) {
            System.out.print(list.val);
            list = list.next;
        }

        System.out.println("\n");

        l1 = new ListNode(9);

        l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        list = addTwoNumbers(l1, l2);
        while (list != null) {
            System.out.print(list.val);
            list = list.next;
        }
    }
}