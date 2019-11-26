public class ListNode {
    ListNode next;
    int value;

    ListNode(int value) {
        this.value = value;
    }

    public boolean equals(ListNode node) {
        ListNode cursor = this;
        
        while ( cursor != null && node != null ) {
            if (cursor.value != node.value) {
                return false;
            }
            cursor = cursor.next;
            node = node.next;
        }
        return true;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cursor = this;
        while (cursor != null) {
            sb.append(String.format("%d ", cursor.value));
            cursor = cursor.next;
        }
        return sb.toString();
    }

    public static ListNode createHead(int value) {
        return new ListNode(value);
    }

    public ListNode addNode(int value) {
        ListNode next = new ListNode(value);
        this.next = next;
        return next;
    }
}