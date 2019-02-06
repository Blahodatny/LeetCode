package AddTwoNumbers;

import static AddTwoNumbers.Solutions.Solution.addTwoNumbers;

class Main {
    public static void main(String[] args) {
        var l1 = new Node(6);
        l1.next = new Node(7);
        l1.next.next = new Node(8);

        var l2 = new Node(5);
        l2.next = new Node(4);
        l2.next.next = new Node(2);

        var list = addTwoNumbers(l1, l2);
        while (list != null) {
            System.out.print(list.val);
            list = list.next;
        }

        System.out.println("\n");

        l1 = new Node(9);

        l2 = new Node(1);
        l2.next = new Node(9);
        l2.next.next = new Node(9);
        l2.next.next.next = new Node(9);
        l2.next.next.next.next = new Node(9);
        l2.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next.next.next.next = new Node(9);

        list = addTwoNumbers(l1, l2);
        while (list != null) {
            System.out.print(list.val);
            list = list.next;
        }
    }
}