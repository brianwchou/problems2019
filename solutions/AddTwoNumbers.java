import java.util.Stack;

public class AddTwoNumbers{

    public static void main(String[] args) {

        // 342 actual
        // 243 actual
        ListNode l1 = new ListNode(2);
        l1.addNode(4).addNode(3);

        System.out.println(l1.toString());

        // 47465 actual
        // 56474
        ListNode l2 = new ListNode(5);
        l2.addNode(6).addNode(4).addNode(7).addNode(4);

        System.out.println(l2.toString());

        // 47807 actual
        // 70874
        ListNode answer = new ListNode(7);
        answer.addNode(0).addNode(8).addNode(7).addNode(4); 

        ListNode result = addTwoNumbers(l1, l2);

        assert answer.equals(result);
        System.out.println(result.toString());
    }

    // need to fit value into value for leetcode problem
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode solution = null;

        while (l1 != null && l2 != null) {
            int sum = l1.value + l2.value + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1; 
            }

            solution = addToTail(solution, sum);
        
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode listToEmpty = (l1 != null) ? l1 : l2;

        while (listToEmpty != null) {
            int sum = listToEmpty.value + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1; 
            }

            solution = addToTail(solution, sum);
            listToEmpty = listToEmpty.next;
        }

        if (carry > 0) {
            addToTail(solution, 1);
        }

        return solution;
    }

    public static ListNode addToTail(ListNode list, int value) {
        if (list == null) {
            return new ListNode(value);
        } else {
            list.next = addToTail(list.next, value);
            return list;
        }
    }

}