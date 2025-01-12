
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
        List<ListNode> result = new ArrayList<>();
        int last = 0;
        while(l1 != null || l2 != null) {
            ListNode res = new ListNode();

            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + last;
            if (sum > 9) {
                res.val = sum % 10;
                last = sum / 10;
            } else {
                res.val = sum;
                last = 0;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            result.add(res);
        }

        if (last > 0) {
            result.add(new ListNode(last));
        }

        for (int i= (result.size()-2); i>=0; i--) {
            result.get(i).next = result.get(i+1);
        }

        return result.get(0);
    }
}