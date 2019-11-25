import java.util.ArrayList;

public class RemoveNthNodeFromEndOfList  {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2)
            .addNode(3)
            .addNode(4)
            .addNode(5);
        
        head = doublePointerMethod(head, 0);

        System.out.println(head.toString());
    }

    public static ListNode doublePointerMethod(ListNode head, int n) {
        // to properly remove at n i need prior and noddToDelete
        // remove from the end of the list n + 1
        // i need a gap of at least 1 node between 
        // which means i need at least 2 nodes for this algorithm to work
        // what does n mean 
        // valid n is within a length of the list
        // can you have negative n?
        // make this work with n = {positive values}

        // length of 0 valud n = 0
        // length of 1 valid n = 0, 1
        // length of 2 valud n = 0, 1, 2
        // length of N valid n = [0, N]
        /*
            length of 2 n = 2
        */

        if (head == null) {
            return null;
        }
        
        ListNode cursor = head;
        while (n > 0) {
            cursor = cursor.next;
            n--;
        }

        if (cursor == head) {
            return head;
        }
        
        ListNode prior = null;
        ListNode current = head;
        while (cursor != null) {
            cursor = cursor.next;
            prior = current;
            current = current.next;
        }

        
        if (prior == null) {
            head = head.next;
            System.out.println("i ran");
        } else {
            prior.next = prior.next.next;
        }
        return head;
    }

    public static ListNode cachingInArrayListMethod(ListNode head, int n) {
        ListNode cursor = head;
        ArrayList<ListNode> array = new ArrayList<>();
        
        while (cursor != null) {
            array.add(cursor);
        }

        if (array.size() - n - 1 < 1){
            head = head.next;
        } else {
            ListNode prior = array.get(array.size() - n - 1);
            prior.next = prior.next.next;
        }

        return head;
    }

    public static ListNode countingMethod(ListNode head, int n) {
        int count = 0;
        ListNode cursor = head;
        while (cursor != null) {
            count++;
        }

        cursor = head;
        int nth = count - n;
        
        while (nth > 0) {
            cursor = cursor.next;
            nth--;
        }

        return cursor;
    }
}