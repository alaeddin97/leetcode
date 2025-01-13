
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        addTowNumbers();
    }

    public static void addTowNumbers() {
        // num1 = 99999
        ListNode num1Node5 = new ListNode(9);
        ListNode num1Node4 = new ListNode(9,num1Node5);
        ListNode num1Node3 = new ListNode(9,num1Node4);
        ListNode num1Node2 = new ListNode(9,num1Node3);
        ListNode num1 = new ListNode(9,num1Node2);

        // num2 = 9999
        ListNode num2Node4 = new ListNode(9);
        ListNode num2Node3 = new ListNode(9,num2Node4);
        ListNode num2Node2 = new ListNode(9,num2Node3);
        ListNode num2 = new ListNode(9,num2Node2);

        addTwoNumbers(num1, num2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0, null); // --> ref1
        ListNode temp = result; // --> ref1
        int last = 0;

        while(l1 != null || l2 != null || last > 0) {
            int sum = last;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            last = sum / 10;
            temp.next = new ListNode(sum % 10,null); // --> ref2
            temp = temp.next; // --> ref2
            // ref1 => ref2 (i=1)
        }

        return result.next;
    }
}